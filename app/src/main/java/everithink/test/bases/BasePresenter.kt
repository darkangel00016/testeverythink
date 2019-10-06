package everithink.test.bases

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BasePresenter {

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}