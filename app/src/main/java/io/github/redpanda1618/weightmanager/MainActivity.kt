package io.github.redpanda1618.weightmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private var size: Int = 10
    private companion object {
        lateinit var db : UserRoomDatabase
        lateinit var dao: UserDao
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate()")
        setContentView(R.layout.activity_main)

        //DB関連のインスタンス取得
        db = UserRoomDatabase.getDatabase(this)
        dao = db.userDao()
    }

    override fun onStart() {
        super.onStart()
        Log.d("FUN", "onStart()")
        showData()
    }

    // 追加ボタン押下時
    fun addData(view: View) {
        val intent: Intent = Intent(this@MainActivity,
            AddDataActivity::class.java)
        startActivity(intent)
        overridePendingTransition(
            android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    fun editData(view: View) {
        val intent: Intent = Intent(this@MainActivity,
            EditActivity::class.java)
        startActivity(intent)
        overridePendingTransition(
            android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }


    private fun showData() {
        var data: ArrayList<User> = ArrayList()
        runBlocking{
            data = getData()
        }

        if(data.size == 0){
            Log.d("DAO", "No Data")
            return
        }
        Log.d("DAO", data.size.toString())
        val entriesWeight = ArrayList<Entry>()
        val entriesMuscle = ArrayList<Entry>()
        val entriesFat = ArrayList<Entry>()
        val lastInd = data.size - 1
        for(i in 0..lastInd){
            val weight = data.get(i).weight
            var muscle = data.get(i).muscle
            var fat = data.get(i).fat
            if (muscle > 10000) {
                muscle = muscle / 10000
                fat = fat / 10000
            }
            entriesWeight.add(Entry(i.toFloat(), weight))
            entriesMuscle.add(Entry(i.toFloat(), muscle))
            entriesFat.add(Entry(i.toFloat(), fat))
        }
        //表示するデータをDataSetに追加
        val dataSetWeight = LineDataSet(entriesWeight, "体重")
        val dataSetMuscle = LineDataSet(entriesMuscle, "骨格筋")
        val dataSetFat = LineDataSet(entriesFat, "脂肪")
        dataSetWeight.color = Color.WHITE
        dataSetMuscle.color = Color.WHITE
        dataSetFat.color = Color.WHITE

        //DataSetをDataに追加
        val dataWeight = LineData(dataSetWeight)
        val dataMuscle = LineData(dataSetMuscle)
        val dataFat = LineData(dataSetFat)

        //ビューを取得
        val chartWeight = findViewById<LineChart>(R.id.chartWeight)
        val chartMuscle = findViewById<LineChart>(R.id.chartMuscle)
        val chartFat = findViewById<LineChart>(R.id.chartFat)

        //ChartにDataを追加
        chartWeight.data = dataWeight
        chartMuscle.data = dataMuscle
        chartFat.data = dataFat

        // Chartにデザインを追加


        chartWeight.legend.isEnabled = false
        chartMuscle.legend.isEnabled = false
        chartFat.legend.isEnabled = false

        chartWeight.description.text = ""
        chartMuscle.description.text = ""
        chartFat.description.text = ""

        chartWeight.setTouchEnabled(false)
        chartMuscle.setTouchEnabled(false)
        chartFat.setTouchEnabled(false)

        chartWeight.axisLeft.textColor = Color.WHITE
        chartMuscle.axisLeft.textColor = Color.WHITE
        chartFat.axisLeft.textColor = Color.WHITE

        chartWeight.axisRight.isEnabled = false
        chartMuscle.axisRight.isEnabled = false
        chartFat.axisRight.isEnabled = false

        chartWeight.xAxis.textColor = Color.WHITE
        chartMuscle.xAxis.textColor = Color.WHITE
        chartFat.xAxis.textColor = Color.WHITE

        //チャートを更新
        chartWeight.invalidate()
        chartMuscle.invalidate()
        chartFat.invalidate()

    }

    @SuppressLint("CheckResult")
    private fun getData(): ArrayList<User>{
        var data: ArrayList<User> = ArrayList()
        Log.d("DAO", dao.size().toString())
        val users = dao.get(size)
        users.forEach { user ->
                data.add(user)
            }
            Log.d("FUN", "forEach()")
        Log.d("FUN", "add()")
        return data

    }

    fun getDao(): UserDao{
        return dao
    }
}