package com.example.calendarapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Profile : AppCompatActivity() {
    @SuppressLint("Recycle", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val dbHelper = DbHelper(this, factory = null)
        val db = dbHelper.readableDatabase

        val cursor = db.rawQuery("SELECT login, email FROM app", null)
        if (cursor.moveToFirst()) {
            do {
                val login = cursor.getString(cursor.getColumnIndex("login"))
                val email = cursor.getString(cursor.getColumnIndex("email"))

                val loginView = findViewById<TextView>(R.id.login_profile)
                loginView.text = login
                val emailView = findViewById<TextView>(R.id.mail_profile)
                emailView.text = email

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

    }
}

