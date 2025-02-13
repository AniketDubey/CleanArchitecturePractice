package com.example.cleanarchitecturepractice.di

import com.example.cleanarchitecturepractice.data.api.Api
import com.example.cleanarchitecturepractice.data.repository.NotificationRepositoryImpl
import com.example.cleanarchitecturepractice.data.source.RemoteDataSource
import com.example.cleanarchitecturepractice.data.source.RemoteDataSourceImpl
import com.example.cleanarchitecturepractice.domain.repository.NotificationRepository
import com.example.cleanarchitecturepractice.domain.usecase.NotificationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: NotificationRepository): NotificationUseCase {
        return NotificationUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: Api): RemoteDataSource {
        return RemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideNotificationRepository(remoteDataSource: RemoteDataSource): NotificationRepository {
        return NotificationRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        })
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        val okHttpClient = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
        okHttpClient.addInterceptor(httpLoggingInterceptor)

        return Retrofit.Builder()
            .baseUrl("http://34.93.189.73:9192/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }
}