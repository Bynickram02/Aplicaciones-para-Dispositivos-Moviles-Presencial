package pe.edu.upc.recipeapp.features.library.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.recipeapp.features.library.application.GetLibraryBooksUseCase
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(private val getLibraryBooks: GetLibraryBooksUseCase) : ViewModel() {

    private val _state = MutableStateFlow(LibraryUiState())
    val state: StateFlow<LibraryUiState> = _state.asStateFlow()

    fun loadBooks() {
        viewModelScope.launch {
            getLibraryBooks().collect { books ->
                _state.update { currentState ->
                    currentState.copy(books = books)
                }
            }
        }
    }

    init {
        loadBooks()
    }
}
