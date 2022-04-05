package com.example.my_app_c5

import androidx.annotation.MainThread


class LoginContract {
    interface View{
        @MainThread
        fun setSuccess()
        @MainThread
        fun setError(error: String)
        @MainThread
        fun showProgress()
        @MainThread
        fun hideProgress()

    }

    interface Presenter{

        fun onAttach(view: View)
        fun onLogin(login: String, password:String)
        fun checkCredentials(login: String, password:String): Boolean
    }
}