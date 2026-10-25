package pe.edu.upc.recipeapp.features.books.application

import pe.edu.upc.recipeapp.features.books.domain.Book
import pe.edu.upc.recipeapp.features.books.domain.BookRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val repository: BookRepository) {

    suspend operator fun invoke(): Result<List<Book>> {
        return repository.getBooks()
    }
}
