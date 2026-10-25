package pe.edu.upc.recipeapp.features.library.infrastructure

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.edu.upc.recipeapp.features.library.domain.LibraryBook
import pe.edu.upc.recipeapp.features.library.domain.LibraryRepository
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(private val dao: LibraryBookDao) : LibraryRepository {

    override fun getBooks(): Flow<List<LibraryBook>> {
        return dao.getAll().map { entities ->
            entities.map { entity ->
                entity.toDomain()
            }
        }
    }

    override suspend fun getBookById(id: Int): LibraryBook? {
        return dao.getById(id)?.toDomain()
    }

    override suspend fun saveBook(book: LibraryBook) {
        dao.insert(book.toEntity())
    }

    override suspend fun deleteBook(id: Int) {
        dao.deleteById(id)
    }
}
