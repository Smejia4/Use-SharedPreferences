package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sharedpreferences.Result

class MainActivity : AppCompatActivity() {

    var User:EditText?=null
    var Password:EditText?=null
    var txtUser:TextView?=null
    var txtPassword:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startComponents()
    }

    private fun startComponents() {

        var btnSave:Button=findViewById(R.id.btnSave)
        btnSave.setOnClickListener { onShared(1) }

        var btnLoad:Button=findViewById(R.id.btnLoad)
        btnLoad.setOnClickListener { onShared(2) }

        User=findViewById(R.id.txtUser)
        Password=findViewById(R.id.txtPassword)
    }

    private fun onShared(btn:Int) {
        when(btn){
            1->{
                var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

                var user= User?.text.toString()
                var password= Password?.text.toString()

                var editor:SharedPreferences.Editor=preferences.edit()
                editor.putString("user",user)
                editor.putString("password",password)
                editor.commit()

                Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()
            }
            2->{
                var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

                var user: String? =preferences.getString("user","No existe la información")
                var pass: String? =preferences.getString("password","No existe la información")

                txtUser?.text=user
                txtPassword?.text=pass
                val intent = Intent(this, Result::class.java)
                startActivity(intent)
            }
        }
    }
}