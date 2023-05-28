package com.example.drinkrecipes.di

import android.content.Context
import androidx.room.Room
import com.example.drinkrecipes.data.local.db.DrinksDatabase
import com.example.drinkrecipes.data.remote.DrinksApi
import com.example.drinkrecipes.data.remote.service.NetworkServiceImpl
import com.example.drinkrecipes.data.repository.DrinksRepositoryImpl
import com.example.drinkrecipes.domain.repository.DrinksRepository
import com.example.drinkrecipes.domain.service.NetworkService
import com.example.drinkrecipes.util.Constants.BASE_URL
import com.example.drinkrecipes.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): DrinksApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DrinksApi::class.java)

    @Provides
    @Singleton
    fun provideNetworkService(api: DrinksApi): NetworkService = NetworkServiceImpl(api)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): DrinksDatabase =
        Room.databaseBuilder(
            applicationContext,
            DrinksDatabase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDrinksRepository(
        networkService: NetworkService,
        database: DrinksDatabase
    ): DrinksRepository {
        return DrinksRepositoryImpl(networkService, database)
    }
}
