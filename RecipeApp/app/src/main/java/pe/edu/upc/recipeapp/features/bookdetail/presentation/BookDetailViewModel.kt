package pe.edu.upc.recipeapp.features.bookdetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.recipeapp.features.books.application.GetBookByIdUseCase
import pe.edu.upc.recipeapp.features.library.application.DeleteLibraryBookUseCase
import pe.edu.upc.recipeapp.features.library.application.GetLibraryBookByIdUseCase
import pe.edu.upc.recipeapp.features.library.application.SaveLibraryBookUseCase
import pe.edu.upc.recipeapp.features.library.domain.LibraryBook
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val getBookById: GetBookByIdUseCase,
    private val getLibraryBookById: GetLibraryBookByIdUseCase,
    private val saveLibraryBook: SaveLibraryBookUseCase,
    private val deleteLibraryBook: DeleteLibraryBookUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(BookDetailUiState())
    val state: StateFlow<BookDetailUiState> = _state.asStateFlow()

    fun loadBook(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(isLoading = true, errorMessage = null)
            }
            val libraryBook = getLibraryBookById(id)
            val result = getBookById(id)

            result.fold(
                onSuccess = { book ->
                    _state.update { currentState ->
                        currentState.copy(
                            book = book,
                            isRead = libraryBook != null,
                            readDate = libraryBook?.readDate,
                            isLoading = false,
                            errorMessage = null
                        )
                    }
                },
                onFailure = { exception ->
                    _state.update { currentState ->
                        currentState.copy(isLoading = false, errorMessage = exception.message)
                    }
                }
            )
        }
    }

    fun toggleRead() {
        val book = _state.value.book ?: return

        viewModelScope.launch(Dispatchers.IO) {
            if (_state.value.isRead) {
                deleteLibraryBook(book.id)
                _state.update { currentState ->
                    currentState.copy(isRead = false, readDate = null)
                }
            } else {
                val readDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                saveLibraryBook(
                    LibraryBook(
                        id = book.id,
                        title = book.title,
                        author = book.author,
                        cover = book.cover,
                        year = book.year,
                        readDate = readDate
                    )
                )
                _state.update { currentState ->
                    currentState.copy(isRead = true, readDate = readDate)
                }
            }
        }
    }
}
