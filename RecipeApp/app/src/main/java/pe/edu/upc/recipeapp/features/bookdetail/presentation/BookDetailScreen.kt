package pe.edu.upc.recipeapp.features.bookdetail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import pe.edu.upc.recipeapp.R

@Composable
fun BookDetailScreen(
    bookId: Int,
    viewModel: BookDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(bookId) {
        viewModel.loadBook(bookId)
    }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                state.errorMessage != null -> {
                    Text(text = state.errorMessage)
                }

                state.book != null -> {
                    val book = state.book
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        AsyncImage(
                            model = book.cover,
                            contentDescription = book.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(350.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = book.title,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = stringResource(R.string.author, book.author))
                            Text(text = stringResource(R.string.publisher, book.publisher))
                            Text(text = stringResource(R.string.genre, book.genre))
                            Text(text = stringResource(R.string.rating, book.rating.toString()))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = book.overview,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            if (state.isRead) {
                                OutlinedButton(
                                    onClick = { viewModel.toggleRead() },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = stringResource(R.string.unmark_as_read))
                                }
                                Text(
                                    text = stringResource(R.string.read_date, state.readDate ?: ""),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            } else {
                                Button(
                                    onClick = { viewModel.toggleRead() },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = stringResource(R.string.mark_as_read))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
