package com.example.lab3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity()
{
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager2 = findViewById(R.id.viewpager)

        val adapter: ViewPagerAdapter = ViewPagerAdapter(this)

        val audioFragment = AudioFragment()
        val videoFragment = VideoFragment()

        adapter.addNewFragment(audioFragment)
        adapter.addNewFragment(videoFragment)

        viewPager.adapter = adapter

        val mediator: TabLayoutMediator = TabLayoutMediator(tabLayout, viewPager
        ) { tab, position -> // Styling each tab here
            tab.text = "Tab $position"
        }
        mediator.attach()
    }

    class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

        var fragments: MutableList<Fragment> = ArrayList<Fragment>()

        fun addNewFragment(newFragment: Fragment) {
            fragments.add(newFragment)
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments.get(position)
        }
    }

}