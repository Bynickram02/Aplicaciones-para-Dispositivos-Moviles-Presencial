package pe.edu.upc.recipeapp.features.library.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pe.edu.upc.recipeapp.R
import pe.edu.upc.recipeapp.features.books.presentation.BookCard

@Composable
fun LibraryScreen(
    onBookClick: (Int) -> Unit,
    viewModel: LibraryViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.books.isEmpty()) {
            Text(
                text = stringResource(R.string.empty_library),
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn {
                items(state.books) { book ->
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
    }
}
