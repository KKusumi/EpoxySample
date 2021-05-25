package com.example.epoxysample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxysample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val controller = SampleController(
        onClickItem = { name ->
            Log.d("MainActivity onClick: ", name)
        }
    )

    // 本当はViewModelのLiveDataをobserveした値を使います
    private val data = listOf(
        Person(name = "Sato", imageResId = R.drawable.droidkun),
        Person(name = "Suzuki", imageResId = R.drawable.droidkun),
        Person(name = "Takahashi", imageResId = R.drawable.droidkun),
        Person(name = "Tanaka", imageResId = R.drawable.droidkun),
        Person(name = "Ito", imageResId = R.drawable.droidkun),
        Person(name = "Watanabe", imageResId = R.drawable.droidkun),
        Person(name = "Yamamoto", imageResId = R.drawable.droidkun),
        Person(name = "Nakamura", imageResId = R.drawable.droidkun),
        Person(name = "Kobayashi", imageResId = R.drawable.droidkun),
        Person(name = "Kato", imageResId = R.drawable.droidkun),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.setController(controller)

        // 見辛かったのでDivider入れてるだけです！Epoxyとは関係なし
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                RecyclerView.VERTICAL
            )
        )

        // setDataを呼ぶことでデータが更新される
        controller.setData(data)
    }
}