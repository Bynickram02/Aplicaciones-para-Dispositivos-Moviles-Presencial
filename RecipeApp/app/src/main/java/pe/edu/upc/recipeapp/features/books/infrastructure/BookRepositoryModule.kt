package pe.edu.upc.recipeapp.features.books.infrastructure

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.recipeapp.features.books.domain.BookRepository

@Module
@InstallIn(SingletonComponent::class)
interface BookRepositoryModule {

    @Binds
    fun provideBookRepository(impl: BookRepositoryImpl): BookRepository
}
