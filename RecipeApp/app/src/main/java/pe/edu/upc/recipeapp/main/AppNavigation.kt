package pe.edu.upc.recipeapp.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import pe.edu.upc.recipeapp.features.bookdetail.presentation.BookDetailScreen
import pe.edu.upc.recipeapp.features.onboarding.presentation.OnboardingScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = OnboardingRoute
    ) {
        composable<OnboardingRoute> {
            OnboardingScreen(
                onContinue = {
                    navController.navigate(MainRoute) {
                        popUpTo(OnboardingRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<MainRoute> {
            MainScreen(
                onBookClick = { bookId ->
                    navController.navigate(BookDetailRoute(bookId))
                }
            )
        }
        composable<BookDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<BookDetailRoute>()
            BookDetailScreen(bookId = route.bookId)
        }
    }
}
