package everithink.test.api

import everithink.test.Response.Results
import everithink.test.models.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("api/?results=20")
    fun users(): Call<Results>

}