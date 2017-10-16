package com.gifgroen.tickt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gifgroen.tickt.model.base.Result
import com.gifgroen.tickt.model.embedded.EventSearch
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        EventRepository.discovery().searchEvents("metallica")
                .subscribeOn(Schedulers.computation()).subscribe(this::onSearch, ::onSearchError)
    }

    private fun onSearchError(t: Throwable?) {
        Log.e(TAG, t.toString())
    }

    private fun onSearch(result: Result<EventSearch>?) {
        result?.embedded!!.events.forEachIndexed { i, event ->
            Log.e(TAG, "[$i] = ${event.name} (${event.type}) in ${event.embedded!!.venues[0].name}")
        }
    }
}
