package com.luanabarbosa.network.retrofit

import com.luanabarbosa.network.config.ConfigApi.API_HOST
import com.luanabarbosa.network.config.ConfigApi.API_KEY
import com.luanabarbosa.network.config.ConfigApi.BASE_URL
import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInicialization {

    private var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .addInterceptor(providesSupportInterceptor())
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    private var retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(apiService: Class<T>) = retrofitBuilder.create(apiService)

    private fun interceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    fun providesSupportInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder().run {
                addHeader("X-RapidAPI-Host", API_HOST)
                addHeader("X-RapidAPI-Key", API_KEY)
                build()
            }
            chain.proceed(request)
        }
    }
}

