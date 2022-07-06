package io.github.redpanda1618.weightmanager

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

class AddDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
    }

    // saveボタン押下時
    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData(view: View) = runBlocking{
        // データを取得する
        val editTextWeight: EditText = findViewById<EditText>(R.id.editTextNumberDecimalWeight)
        val editTextMuscle: EditText = findViewById<EditText>(R.id.editTextNumberDecimalMuscle)
        val editTextFat: EditText = findViewById<EditText>(R.id.editTextNumberDecimalFat)

        var sWeight: String = editTextWeight.text.toString() ?: ""
        var sMuscleRate: String = editTextMuscle.text.toString() ?: ""
        var sFatRate: String = editTextFat.text.toString() ?: ""

        if (sWeight.isEmpty()){
            sWeight = "0"
        }
        if (sMuscleRate.isEmpty()){
            sMuscleRate = "0"
        }
        if (sFatRate.isEmpty()){
            sFatRate = "0"
        }
        Log.d("weight:", sWeight)
        Log.d("muscle_rate:", sMuscleRate)
        Log.d("fat_rate", sFatRate)
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

        launch {
            val dao: UserDao = MainActivity.dao
            dao.insert(User(0, date, weight, muscle, fat))
        }.join()
        finish()
    }
    private suspend fun insert(weight: Float, muscle: Float, fat: Float, date: String){
        MainActivity.dao.insert(User(0, date, weight, muscle, fat))
    }
}