package io.github.redpanda1618.weightmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var db : UserRoomDatabase
        lateinit var dao: UserDao
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
    // 追加ボタン押下時
    fun addData(view: View) {
        val intent: Intent = Intent(this@MainActivity,
            AddDataActivity::class.java)
        startActivity(intent)
    }

    private suspend fun showData(size: Int) {

        val data: ArrayList<User>? = null
        dao.get(size)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    //データ取得完了時の処理
                    val data = ArrayList<User>()
                    it.forEach { user -> data.add(user) }
                }
                , {
                    //エラー処理
                })
        if(data == null){
            return
        }
        val entriesWeight = ArrayList<Entry>()
        val entriesMuscle = ArrayList<Entry>()
        val entriesFat = ArrayList<Entry>()
        for(i in 0..data.size){
            entriesWeight.add(Entry(i.toFloat(), data[i].weight))
            entriesMuscle.add(Entry(i.toFloat(), data[i].muscle))
            entriesFat.add(Entry(i.toFloat(), data[i].fat))
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
        fun getDao(): UserDao{
            return dao
        }
}