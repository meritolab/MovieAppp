package com.example.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val email: String = email.text.toString()
            val password: String = password.text.toString()

            iniUi()
        }


    }

    private fun iniUi() {
            button.setOnClickListener {
            val email= email.text.toString()
            val password = password.text.toString()
            saveUser(email, password)
             navigateDetailActivity()

            Toast.makeText(this, "E-mail : $email Password: $password", Toast.LENGTH_LONG).show()

            Log.d("buttonCLick", "E-mail: $email Password $password")

        }
    }
 private fun navigateDetailActivity(){
     val detailIntent=Intent(this,MovieDetailActivity::class.java)
     startActivity(detailIntent)




 }

    private fun saveUser(email: String, password: String) {
        val preferences = getSharedPreferences("MovieApp", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
        val savedEmail = preferences.getString("email", "default text")
        Toast.makeText(this, "User saved: Email = $savedEmail", Toast.LENGTH_SHORT).show()

    }
}