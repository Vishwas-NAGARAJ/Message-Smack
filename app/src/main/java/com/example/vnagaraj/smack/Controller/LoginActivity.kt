package com.example.vnagaraj.smack.Controller

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.vnagaraj.smack.R
import com.example.vnagaraj.smack.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginSpinner.visibility = View.INVISIBLE
    }

    fun loginLoginButClicked(view: View){
        enableSpinner(true)
        val email = loginEmailText.text.toString()
        val password = loginPasswordText.text.toString()
        hideKeyboard()
        if (email.isNotEmpty() && password.isNotEmpty()){
            AuthService.loginUser(email , password) { loginSuccess ->
                if (loginSuccess){
                    AuthService.findUserByEmail(this) { findSuccess ->
                        if (findSuccess){
                            enableSpinner(false)
                            finish()
                        }else{
                            errorToast()
                        }
                    }
                }else{
                    errorToast()
                }
            }
        }else{
            Toast.makeText(this , "Please fill in both email and password." , Toast.LENGTH_LONG).show()
            enableSpinner(false)
        }
    }


    fun loginCreateUserButClicked(view: View){
        val createUserIntent = Intent(this , CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }

    fun errorToast(){
        Toast.makeText(this , "Something went wrong, please try again." , Toast.LENGTH_LONG).show()
        enableSpinner(false)
    }

    fun enableSpinner(enable: Boolean){
        if (enable){
            loginSpinner.visibility = View.VISIBLE
        } else{
            loginSpinner.visibility = View.INVISIBLE
        }
        loginLoginBut.isEnabled = !enable
        loginCreateUserBut.isEnabled = !enable
    }

    fun hideKeyboard(){
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputManager.isAcceptingText){
            inputManager.hideSoftInputFromWindow(currentFocus.windowToken , 0)
        }
    }
}
