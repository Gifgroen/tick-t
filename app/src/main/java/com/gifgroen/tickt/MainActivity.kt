package com.gifgroen.tickt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    companion object {

        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        EventRepository.discovery().searchEvents("metallica")
                .subscribeOn(Schedulers.computation()).subscribe({ result ->
                    Log.e(TAG, result.embedded!!.events[0].embedded.toString())
                }, { t: Throwable ->
                    Log.e(TAG, t.toString())
                })
    }
}
