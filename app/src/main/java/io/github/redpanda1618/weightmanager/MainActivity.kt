package io.github.redpanda1618.weightmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity(){
    companion object {
        lateinit var editTextName: EditText
        lateinit var buttonUpdate: Button
        lateinit var listViewNames: ListView
        lateinit var db : UserRoomDatabase
        lateinit var dao : UserDao
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //DB関連のインスタンス取得
        db = UserRoomDatabase.getDatabase(this)
        dao = db.userDao()
        val size = 10
        runBlocking {
            showData(size)
        }
    }

    private suspend fun showData(size: Int) {

        val weight = dao.getWeight(size)
        val muscle = dao.getMuscle(size)
        val fat = dao.getFat(size)
        val date = dao.getDate(size)

        val entriesWeight = ArrayList<Entry>()
        val entriesMuscle = ArrayList<Entry>()
        val entriesFat = ArrayList<Entry>()
        for(i in weight.indices){
            entriesWeight.add(Entry(i.toFloat(), weight[i]))
            entriesMuscle.add(Entry(i.toFloat(), muscle[i]))
            entriesFat.add(Entry(i.toFloat(), fat[i]))
        }
        //表示するデータをDataSetに追加
        val dataSetWeight = LineDataSet(entriesWeight, "体重")
        val dataSetMuscle = LineDataSet(entriesMuscle, "骨格筋")
        val dataSetFat = LineDataSet(entriesFat, "脂肪")

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

        //チャートを更新
        chartWeight.invalidate()
        chartMuscle.invalidate()
        chartFat.invalidate()
    }
}