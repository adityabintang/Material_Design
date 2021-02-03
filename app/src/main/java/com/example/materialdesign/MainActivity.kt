package com.example.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.materialdesign.fragment.FavoritesFragment
import com.example.materialdesign.fragment.HomeFragment
import com.example.materialdesign.fragment.StoreFragment
import com.example.materialdesign.fragment.adapters.AccountFragment
import com.example.materialdesign.fragment.adapters.SettingsFragment
import com.example.materialdesign.fragment.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Material Design "
        val accountFragment = AccountFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(accountFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_account -> makeCurrentFragment(accountFragment)
                R.id.ic_Setting -> makeCurrentFragment(settingsFragment)
            }
            true
        }

        setUpTabs()
    }
    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(StoreFragment(), "Store")
        adapter.addFragment(FavoritesFragment(), "Favorite")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_store_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_favorite_24)

    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fi_wrapper, fragment)
            commit()
        }

}