package com.example.mobdeveapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.homepage.*


class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
        val intent = intent
        val receivedEmail = intent.getStringExtra("emailAddress")
        textViewWelcome.text="Welcome "+receivedEmail
    }
}
