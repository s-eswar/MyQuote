package com.example.vishwa.myquote

import retrofit2.Call
import retrofit2.http.GET

interface Quote {
  @GET("./?method=getQuote&key=457653&format=json&lang=en")
    fun getQuote():Call<MyQuote>
}