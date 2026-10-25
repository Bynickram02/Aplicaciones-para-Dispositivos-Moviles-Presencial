package pe.edu.upc.recipeapp.features.books.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import pe.edu.upc.recipeapp.features.books.domain.Book

@Composable
fun BookList(books: List<Book>, onBookClick: (Int) -> Unit) {
    LazyColumn {
        items(books) { book ->
            BookCard(
                cover = book.cover,
                title = book.title,
                author = book.author,
                year = book.year,
                onClick = { onBookClick(book.id) }
            )
        }
    }
}
