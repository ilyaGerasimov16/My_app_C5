package com.example.my_app_c5

import android.os.Handler
import android.os.Looper

class LoginPresenter: LoginContract.Presenter{
    private var view:LoginContract.View? = null
    private val uiHandler = Handler(Looper.getMainLooper())


    override fun onAttach(view: LoginContract.View) {
        this.view = view
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        uiHandler.post{
            Thread.sleep(3_000)
            view?.hideProgress()
            if (checkCredentials(login,password)){
                view?.setSuccess()
            } else {
                view?.setError("Неверный пароль")
            }
        }
    }

    override fun checkCredentials(login: String, password: String): Boolean {
        return login == password
    }

}