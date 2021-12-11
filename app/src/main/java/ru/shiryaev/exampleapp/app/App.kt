package ru.shiryaev.exampleapp.app

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object App {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://demo4547913.mockable.io/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
}