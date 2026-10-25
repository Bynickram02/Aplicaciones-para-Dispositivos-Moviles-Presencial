package pe.edu.upc.recipeapp.features.books.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.recipeapp.features.books.application.GetBooksUseCase
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val getBooks: GetBooksUseCase) : ViewModel() {

    private val _state = MutableStateFlow(BooksUiState())
    val state: StateFlow<BooksUiState> = _state.asStateFlow()

    fun loadBooks() {

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(isLoading = true, errorMessage = null)
            }
            val result = getBooks()

            result.fold(
                onSuccess = { books ->
                    _state.update { currentState ->
                        currentState.copy(books = books, isLoading = false, errorMessage = null)
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

    init {
        loadBooks()
    }
}
