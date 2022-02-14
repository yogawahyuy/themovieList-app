package com.snystudio.themovielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.snystudio.themovielist.databinding.ActivityMainBinding
import com.snystudio.themovielist.fragment.HomeFragment
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val navController=this.findNavController(R.id.mainNavHost)
        binding.mainBottomNavigation.setupWithNavController(navController)
        setupKoinFragmentFactory()
        //supportFragmentManager.beginTransaction().replace(R.id.mainNavHost,HomeFragment::class.java,null).commit()
    }
}