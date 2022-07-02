package io.github.redpanda1618.weightmanager

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.annotation.RequiresApi
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

class AddDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
    }

    // saveボタン押下時
    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData(){
        // データを取得する
        val editTextWeight: EditText = findViewById(R.id.editTextNumberDecimalWeight) as EditText
        val editTextMuscle: EditText = findViewById(R.id.editTextNumberDecimalMuscle) as EditText
        val editTextFat: EditText = findViewById(R.id.editTextNumberDecimalFat) as EditText

        val sWeight: String = editTextWeight.toString() ?: "0"
        val sMuscleRate: String = editTextMuscle.toString() ?: "0"
        val sFatRate: String = editTextFat.toString() ?: "0"

        val weight: Float = sWeight.toFloat()
        val muscleRate: Float = sMuscleRate.toFloat()
        val fatRate: Float = sFatRate.toFloat()

        val muscle: Float = weight * muscleRate * 100
        val fat: Float = weight * fatRate * 100

        val localDateTime = LocalDateTime.now()
        val setDateTime = localDateTime.minusHours(3)
        val year: String = setDateTime.year.toString()
        val month: String = setDateTime.month.toString()
        val day: String = setDateTime.dayOfMonth.toString()
        val date: String = year + month + day

        runBlocking {
            insert(weight, muscle, fat, date)
        }
        finish()
    }
    private suspend fun insert(weight: Float, muscle: Float, fat: Float, date: String){
        MainActivity.dao.insert(User(0, date, weight, muscle, fat))
    }
}