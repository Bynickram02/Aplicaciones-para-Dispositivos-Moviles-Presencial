package pe.edu.upc.recipeapp.features.books.domain

interface BookRepository {

    suspend fun getBooks(): Result<List<Book>>

    suspend fun getBookById(id: Int): Result<Book>
}
