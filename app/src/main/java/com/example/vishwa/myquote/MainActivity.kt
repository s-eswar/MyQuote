package com.example.vishwa.myquote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature( Window.FEATURE_NO_TITLE )
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN )
        setContentView(R.layout.activity_main)
        getQuote()
        quote_cardview.setOnClickListener {
            getQuote()
        }
    }
//    http://api.forismatic.com/api/1.0/?
    private fun getQuote(){
    val retrofit = Retrofit.Builder()
            .baseUrl("   http://api.forismatic.com/api/1.0/")
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    val api = retrofit.create(Quote::class.java)

//        Call<List<Marvel>> call = api.getHeroes();
//        Call<List<Example>> call = api.getBooks();
    val call = api.getQuote()
    call.enqueue(object :Callback<MyQuote>{
        override fun onFailure(call: Call<MyQuote>, t: Throwable) {
            Toast.makeText(applicationContext, "failure", Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<MyQuote>, response: Response<MyQuote>) {
            val quote_text=findViewById<TextView>(R.id.quote_text)
            val author_text=findViewById<TextView>(R.id.quote_author)
            quote_text.text=response.body()?.getQuoteText()
            author_text.text= response.body()?.getQuoteAuthor()
        }

    })

}
}
