package io.github.redpanda1618.weightmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class MainActivity : AppCompatActivity() {
//    companion object {
//        lateinit var editTextName: EditText
//        lateinit var buttonUpdate: Button
//        lateinit var listViewNames: ListView
//        lateinit var db : UserRoomDatabase
//        lateinit var dao : UserDao
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //グラフに表示するためのデータを格納
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f,1f))
        entries.add(Entry(2f,2f))
        entries.add(Entry(3f,3f))
        entries.add(Entry(4f,4f))
        entries.add(Entry(5f,5f))

        //表示するデータをDataSetに追加
        val dataSet = LineDataSet(entries, "Label")

        //DataSetをDataに追加
        val data = LineData(dataSet)

        //ビューを取得
        val chart = findViewById<LineChart>(R.id.chartWeight)

        //ChartにDataを追加
        chart.data = data

        //チャートを更新
        chart.invalidate()

//        //コンポーネント取得
//        editTextName = findViewById(R.id.editTextName)
//        buttonUpdate = findViewById(R.id.buttonUpdate)
//        listViewNames = findViewById(R.id.ListViewNames)
//
//        //DB関連のインスタンス取得
//        db = UserRoomDatabase.getDatabase(this)
//        dao = db.userDao()
//
//        //リストの初期表示
//        getAllUser(this)
//
//        //ボタンのリスナーを設定
//        buttonUpdate.setOnClickListener {
//            //入力内容の登録
//            insUser(editTextName.text.toString())
//            editTextName.text.clear()
//            //リストの再取得
//            getAllUser(this)
//        }
    }

//    //ListViewにデータを表示する
//    private fun getAllUser(context : Context) {
//        //ioスレッド：DBからデータ取得
//        //mainスレッド：取得結果をUIに表示
//        dao.getAll()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    //データ取得完了時の処理
//                    val data = ArrayList<User>()
//                    it.forEach { user -> data.add(user) }
//                    //リスト項目とListViewを対応付けるArrayAdapterを用意する
//                    //リストで使用するlayout（simple_list_item_1）を指定する
//                    val adapter = ArrayAdapter(
//                        context, android.R.layout.simple_list_item_1, data)
//                    listViewNames.adapter = adapter
//                }
//                , {
//                    //エラー処理
//                }
//            )
//    }
//
//    //入力内容をDBに登録する
//    private fun insUser(name : String) {
//        Completable.fromAction { dao.insertAll(User(0, name)) }
//            .subscribeOn(Schedulers.io())
//            .subscribe()
//    }
}