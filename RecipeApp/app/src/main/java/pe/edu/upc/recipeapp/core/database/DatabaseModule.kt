package pe.edu.upc.recipeapp.core.database

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.recipeapp.features.library.infrastructure.LibraryBookDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "recipeapp.db")
            .setDriver(AndroidSQLiteDriver())
            .build()
    }

    @Provides
    @Singleton
    fun provideLibraryBookDao(database: AppDatabase): LibraryBookDao {
        return database.libraryBookDao()
    }
}
