package pe.edu.upc.recipeapp.features.library.domain

import kotlinx.coroutines.flow.Flow

interface LibraryRepository {

    fun getBooks(): Flow<List<LibraryBook>>

    suspend fun getBookById(id: Int): LibraryBook?

    suspend fun saveBook(book: LibraryBook)

    suspend fun deleteBook(id: Int)
}
