package pe.edu.upc.recipeapp.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.recipeapp.features.books.presentation.BooksScreen
import pe.edu.upc.recipeapp.features.library.presentation.LibraryScreen

@Composable
fun MainScreen(onBookClick: (Int) -> Unit) {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.entries.first().route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<BooksRoute> {
                BooksScreen(onBookClick = onBookClick)
            }
            composable<LibraryRoute> {
                LibraryScreen(onBookClick = onBookClick)
            }
        }

    }
}
