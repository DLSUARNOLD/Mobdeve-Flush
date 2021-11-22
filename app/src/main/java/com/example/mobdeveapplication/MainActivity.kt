package com.example.mobdeveapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser


import com.google.firebase.auth.ktx.auth
import kotlinx.android.synthetic.main.loginform.*
import kotlinx.android.synthetic.main.registerform.*
import kotlinx.android.synthetic.main.registerform.Errordisplay
import kotlinx.android.synthetic.main.registerform.Passwordbox
import kotlinx.android.synthetic.main.registerform.Usernamebox


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?)
    {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registerform)

        LoginRedirect.setOnClickListener {
            val intent = Intent(this, Loginform::class.java)
            startActivity(intent)
            finish()
             }


        Submitbutt.setOnClickListener{
            //val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (Usernamebox.text.toString().isEmpty() || Passwordbox.text.toString()
                    .isEmpty())
                Errordisplay.text = "Email Address or Password is not provided"
            else {
                    auth.createUserWithEmailAndPassword(Usernamebox.text.toString(), Passwordbox.text.toString()).addOnCompleteListener(this)
                    { task ->

                            if (task.isSuccessful) {
                                Errordisplay.text = "Sign Up successfull. Email and Password created"
                                val user = auth.currentUser
                                updateUI(user)
                            } else
                            {
                                if(Passwordbox.length()<6)
                                {
                                    Errordisplay.text = "Sign Up Error: Password must be atleast 6 characters"
                                }
                                else Errordisplay.text = "Sign Up Error: Please chose a different Email"
                            }
                    }
                }
        }
    }
    fun updateUI(currentUser: FirebaseUser?) {
    }
}
