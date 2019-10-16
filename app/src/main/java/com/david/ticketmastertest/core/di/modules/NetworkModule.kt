package com.david.ticketmastertest.core.di.modules

import LiveDataCallAdapterFactory
import com.david.ticketmastertest.BuildConfig
import com.david.ticketmastertest.network.TicketMasterApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesURL(): String {
        return BuildConfig.BASE_URL
    }

    @Singleton
    @Provides
    fun provideOkHttpUrlClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor {
            val originalRequest = it.request()

            val httpUrl = originalRequest.url()
            val newHttpUrl = httpUrl.newBuilder()
                .addQueryParameter("apikey", BuildConfig.API_KEY)
                .build()

            val requestBuilder = originalRequest.newBuilder().url(newHttpUrl)
            val request = requestBuilder.build()
            it.proceed(request)
        }
        return httpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Singleton
    @Provides
    fun provideTicketMasterApi(retrofit: Retrofit): TicketMasterApi {
        return retrofit.create(TicketMasterApi::class.java)
    }
}