package pe.edu.upc.recipeapp.features.books.infrastructure

import pe.edu.upc.recipeapp.features.books.domain.Book
import pe.edu.upc.recipeapp.features.books.domain.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val api: BookApi) : BookRepository {
    override suspend fun getBooks(): Result<List<Book>> {
        try {
            val response = api.getBooks()

            if (response.isSuccessful) {
                response.body()?.let { booksResponseDto ->
                    val books = booksResponseDto.results.map { bookDto ->
                        bookDto.toDomain()
                    }
                    return Result.success(books)
                }

            }
            return Result.failure(Exception("Error fetching books: ${response.code()}"))

        } catch (exception: Exception) {
            return Result.failure(exception)
        }
    }

    override suspend fun getBookById(id: Int): Result<Book> {
        try {
            val response = api.getBookById(id)

            if (response.isSuccessful) {
                response.body()?.let { bookDto ->
                    return Result.success(bookDto.toDomain())
                }

            }
            return Result.failure(Exception("Error fetching book: ${response.code()}"))

        } catch (exception: Exception) {
            return Result.failure(exception)
        }
    }
}
