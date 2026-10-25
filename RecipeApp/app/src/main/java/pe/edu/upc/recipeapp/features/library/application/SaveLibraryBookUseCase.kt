package pe.edu.upc.recipeapp.features.library.application

import pe.edu.upc.recipeapp.features.library.domain.LibraryBook
import pe.edu.upc.recipeapp.features.library.domain.LibraryRepository
import javax.inject.Inject

class SaveLibraryBookUseCase @Inject constructor(private val repository: LibraryRepository) {

    suspend operator fun invoke(book: LibraryBook) {
        repository.saveBook(book)
    }
}
