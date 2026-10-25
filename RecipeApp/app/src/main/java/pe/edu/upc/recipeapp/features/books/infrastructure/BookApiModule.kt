package pe.edu.upc.recipeapp.features.books.infrastructure

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  BookApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bookapp-gveteaa0dqf0eycn.eastus-01.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBookApi(retrofit: Retrofit): BookApi {
        return retrofit.create(BookApi::class.java)
    }
}
