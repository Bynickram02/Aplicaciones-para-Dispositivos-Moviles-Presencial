package pe.edu.upc.recipeapp.features.books.infrastructure

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApi {

    @GET("books")
    suspend fun getBooks(): Response<BooksResponseDto>

    @GET("books/{id}")
    suspend fun getBookById(@Path("id") id: Int): Response<BookDto>
}
