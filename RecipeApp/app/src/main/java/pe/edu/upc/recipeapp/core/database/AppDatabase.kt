package pe.edu.upc.recipeapp.core.database

import androidx.room3.Database
import androidx.room3.RoomDatabase
import pe.edu.upc.recipeapp.features.library.infrastructure.LibraryBookDao
import pe.edu.upc.recipeapp.features.library.infrastructure.LibraryBookEntity

@Database(entities = [LibraryBookEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun libraryBookDao(): LibraryBookDao
}
