package com.example.projettdm

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*

class ParkingViewModel: ViewModel() {
    var data = mutableListOf<ParkingModel>()
    fun getParkings(){
        val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("222    "+throwable.localizedMessage)

        }
        CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response = Endpoint.createEndpoint().getParkings()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful && response.body() != null)  {
                    data = response.body() as ArrayList<ParkingModel>
                    print(data)

                } else
                {



                }
            }
        }
    }

}