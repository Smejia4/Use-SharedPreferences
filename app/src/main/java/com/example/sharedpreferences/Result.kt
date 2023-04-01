package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    var txtUser: TextView?=null
    var txtPassword: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val btnCloneResult:Button = findViewById(R.id.btnClose)
        btnCloneResult.setOnClickListener { onClickClose() }
        startComponents()
        loadData()
    }

    private fun startComponents() {
        txtUser=findViewById(R.id.txtUser)
        txtPassword=findViewById(R.id.txtPassword)
    }

    private fun loadData() {
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user: String? =preferences.getString("user","No existe la información")
        var password: String? =preferences.getString("password","No existe la información")

        txtUser?.text=user
        txtPassword?.text=password
    }

    private fun onClickClose(){
        finish()
    }
}

