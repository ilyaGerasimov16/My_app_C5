package com.example.my_app_c5


class LoginContract {
    interface View{
        fun setSuccess()
        fun setError(error: String)
        fun showProgress()
        fun hideProgress()

    }

    interface Presenter{

        fun onAttach(view: View)
        fun onLogin(login: String, password:String)
        fun checkCredentials(login: String, password:String): Boolean
    }
}