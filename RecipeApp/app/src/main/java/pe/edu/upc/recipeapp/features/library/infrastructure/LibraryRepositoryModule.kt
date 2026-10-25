package pe.edu.upc.recipeapp.features.library.infrastructure

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.recipeapp.features.library.domain.LibraryRepository

@Module
@InstallIn(SingletonComponent::class)
interface LibraryRepositoryModule {

    @Binds
    fun provideLibraryRepository(impl: LibraryRepositoryImpl): LibraryRepository
}
