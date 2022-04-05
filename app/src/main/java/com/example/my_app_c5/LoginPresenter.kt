package com.example.my_app_c5

class LoginPresenter: LoginContract.Presenter{
    private var view:LoginContract.View? = null


    override fun onAttach(view: LoginContract.View) {
        this.view = view
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        Thread {
            Thread.sleep(3_000)
            view?.hideProgress()
            if (checkCredentials(login,password)){
                view?.setSuccess()
            } else {
                view?.setError("Неверный пароль")
            }
        }.start()
    }

    override fun checkCredentials(login: String, password: String): Boolean {
        return login == password
    }

}