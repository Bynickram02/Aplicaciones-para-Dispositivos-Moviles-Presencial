package pe.edu.upc.recipeapp.features.library.infrastructure

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LibraryBookDao {

    @Query("SELECT * FROM library_books")
    fun getAll(): Flow<List<LibraryBookEntity>>

    @Query("SELECT * FROM library_books WHERE id = :id")
    suspend fun getById(id: Int): LibraryBookEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: LibraryBookEntity)

    @Query("DELETE FROM library_books WHERE id = :id")
    suspend fun deleteById(id: Int)
}
