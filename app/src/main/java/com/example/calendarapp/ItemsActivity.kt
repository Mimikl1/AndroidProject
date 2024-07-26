package com.example.calendarapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1,"dikmyata","ФЕСТИВАЛЬ 'ДИКАЯ МЯТА - 2024'" ,"Дата: с 14 по 16 июня. Местоположение: Тульская область, Россия","Справка: 'Дикая Мята' - это фестиваль для тех, кто ищет свободу, приключения и новые знакомства. Особенности: Фестиваль пропитан атмосферой свободы и авантюризма. Вдохновляющие концерты и активности на природе погружают гостей в атмосферу беззаветного веселья.", 4500))
        items.add(Item(2,"kardfest","ФЕСТИВАЛЬ 'КАРДИОГРАММА - 2024'","Дата: с 15 по 16 июня. Местоположение: Свердловская область, Россия","Справка: 'Кардиограмма' - это праздник, посвященный музыке и сильным эмоциям. Особенности: Фестиваль предлагает смесь стилей от рока до электроники. Гости могут насладиться музыкой в сопровождении завораживающих световых и видеоэффектов, создающих уникальную атмосферу.", 1500))
        items.add(Item(3,"stereoleto","ФЕСТИВАЛЬ 'STEREOLETO - 2024'","Дата: с 15 по 16 июня. Местоположение: Санкт-Петербург, Россия","Справка: 'StereoLeto' - это виртуозное слияние музыки и искусства в арт-столице России. Особенности: Фестиваль представляет современные музыкальные тренды и арт-инсталляции, даря всем гостям незабываемые впечатления. Преобразившийся город становится театром для выступлений музыкантов и художников.", 0))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        val button: Button = findViewById(R.id.button_profile)

        button.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

    }
}

