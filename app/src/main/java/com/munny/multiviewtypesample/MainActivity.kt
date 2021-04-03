package com.munny.multiviewtypesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_view).adapter = MyAdapter()
            .apply {
                setItemList(
                    listOf(
                        MyItem.TextItem("Hello World"),
                        MyItem.NumberItem(30000),
                        MyItem.AndroidImageItem,
                        MyItem.NumberItem(23232),
                        MyItem.TextItem("Happy Coding"),
                        MyItem.AndroidImageItem
                    )
                )
            }
    }
}