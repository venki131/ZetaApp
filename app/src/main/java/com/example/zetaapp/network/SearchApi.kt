package com.example.zetaapp.network

import com.example.zetaapp.models.SearchResult
import com.example.zetaapp.utils.UrlConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.reactivex.Flowable
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "AIzaSyAjTPFgulkdrELcWmo1jAa8wqtHLrztyKc"

//https://www.googleapis.com/customsearch/v1?
// q=harrypotter&cx=011476162607576381860:ra4vmliv9ti&key=AIzaSyAjTPFgulkdrELcWmo1jAa8wqtHLrztyKc
interface SearchApi {

    @GET(UrlConstants.CUSTOM_SEARCH)
    fun getSearchResults(
        @Query("q") search: String,
        @Query("cx") custom: String
    ): Flowable<SearchResult>


    companion object {
        operator fun invoke() : SearchApi {
            val requestInterceptor = Interceptor {

                val url = it.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("key",
                        API_KEY
                    )
                    .build()

                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(UrlConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SearchApi::class.java)
        }
    }

}