package com.example.udemy_firstcoroutine

import kotlinx.coroutines.*

class UserDataManager2 {

    suspend fun getTotalUserCount() : Int {

        var count = 0
        lateinit var deferredCount : Deferred<Int>

        coroutineScope{
            launch(Dispatchers.IO){
                delay(2000)
                count = 50
            }

            deferredCount = async(Dispatchers.IO) {
                delay(4000)
                return@async 70
            }
        }

        return count + deferredCount.await()

    }

}