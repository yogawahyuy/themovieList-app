package com.snystudio.themovielist.config

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.snystudio.themovielist.fragment.HomeFragment
import com.snystudio.themovielist.viewmodel.MovieViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    fragment { HomeFragment() }
}
val repoModule= module {
    single { MovieRepo(get()) }
}
val apiModule= module {
    fun provideUseApi(retrofit: Retrofit):ApiInterface{return retrofit.create(ApiInterface::class.java)}
    single { provideUseApi(get()) }
}
val retrofitModule= module {
    fun provideGson() :Gson{
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }
    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }
    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(),get()) }

}

