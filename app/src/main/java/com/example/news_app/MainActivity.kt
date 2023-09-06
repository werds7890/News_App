package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.databinding.ActivityMainBinding
import com.example.news_app.databinding.FragmentTitleBinding
import com.example.news_app.databinding.TitleRecyclerviewBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        mainBinding.apply {
            setFragment(TitleFragment())
        }
    }

    private fun setFragment(frag:Fragment){
        supportFragmentManager.commit {
            replace(R.id.frameLayout,frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}