package pe.edu.upc.recipeapp.features.library.application

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.recipeapp.features.library.domain.LibraryBook
import pe.edu.upc.recipeapp.features.library.domain.LibraryRepository
import javax.inject.Inject

class GetLibraryBooksUseCase @Inject constructor(private val repository: LibraryRepository) {

    operator fun invoke(): Flow<List<LibraryBook>> {
        return repository.getBooks()
    }
}
