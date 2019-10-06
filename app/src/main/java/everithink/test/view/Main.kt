package everithink.test.view

import everithink.test.models.User

interface Main {

    fun onGetUsers(users: ArrayList<User>)

    fun showError(message: String)

    fun showProgress()

    fun hideProgress()

}