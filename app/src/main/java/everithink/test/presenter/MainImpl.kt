package everithink.test.presenter

import everithink.test.Response.Results
import everithink.test.api.Api
import everithink.test.bases.BasePresenter
import everithink.test.view.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainImpl constructor(private val view: Main): BasePresenter() {

    fun getUsers() {
        val api: Api = retrofit.create(Api::class.java)
        val users = api.users()
        view.showProgress()
        users.enqueue(object: Callback<Results> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<Results>, t: Throwable) {
                view.hideProgress()
                t.printStackTrace()
                val message = t.message
                if (message != null) {
                    view.showError(message)
                }
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                view.hideProgress()
                val result: Results? = response.body()
                if (response.isSuccessful && result != null) {
                    view.onGetUsers(result.results)
                }
            }

        })
    }

}