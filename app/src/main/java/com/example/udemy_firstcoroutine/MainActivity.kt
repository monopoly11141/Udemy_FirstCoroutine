package com.example.udemy_firstcoroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.udemy_firstcoroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0
    val TAG = this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        binding.btnCountHere.setOnClickListener {
//            count++
//            binding.tvCountValue.text = "$count"
//        }
//
        binding.btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {

                //binding.tvUserData.text = "${UserDataManager1().getTotalUserCount()}"
                binding.tvUserData.text = "${UserDataManager2().getTotalUserCount()}"

            }

        }

//        CoroutineScope(Dispatchers.IO).launch {
//            Log.i(TAG, "Calculation started...")
//
//            val stock1 = async {
//                getStock1()
//            }
//            val stock2 = async{
//                getStock2()
//            }
//            val stock3 = async{
//                getStock3()
//            }
//            val stock4 = async{
//                getStock4()
//            }
//
//            val total = stock1.await() + stock2.await() + stock3.await() + stock4.await()
//
//            Log.i(TAG, "Total is $total")
//        }

//        CoroutineScope(Dispatchers.Main).launch {
//            val stock1 = async {
//                getStock1()
//            }
//            val stock2 = async {
//                getStock2()
//            }
//            val stock3 = async {
//                getStock3()
//            }
//            val stock4 = async {
//                getStock4()
//            }
//            val total = stock1.await() + stock2.await() + stock3.await() + stock4.await()
//
//            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_SHORT).show()
//        }

    }

    private suspend fun downloadUserData() {
        for (i in 0..200000) {
            withContext(Dispatchers.Main) {
                val tvUserDataText = "Downloading user $i in ${Thread.currentThread().name}"
                binding.tvUserData.text = tvUserDataText
            }
        }
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.d(TAG, "Stock 1 returned")
        return 1111
    }

    private suspend fun getStock2(): Int {
        delay(3000)
        Log.d(TAG, "Stock 2 returned")
        return 2222
    }

    private suspend fun getStock3(): Int {
        delay(5000)
        Log.d(TAG, "Stock 3 returned")
        return 3333
    }

    private suspend fun getStock4(): Int {
        delay(7000)
        Log.d(TAG, "Stock 4 returned")
        return 4444
    }


}