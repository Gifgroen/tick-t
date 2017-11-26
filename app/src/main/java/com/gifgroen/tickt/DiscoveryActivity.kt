package com.gifgroen.tickt

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.data.Event
import com.gifgroen.base.model.embedded.EventSearch

class DiscoveryActivity : AppCompatActivity() {

    private val TAG = DiscoveryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        val viewModel = ViewModelProviders.of(this).get(DiscoveryViewModel::class.java)
        viewModel.search("in flames")
                .subscribe(this::onEvent, this::onSearchError)

        viewModel.search("kfjdslah")
                .subscribe(this::onEvent, this::onSearchError)

        viewModel.search("metallica")
                .subscribe(this::onEvent, this::onSearchError)

        viewModel.search("bullshit")
                .subscribe(this::onEvent, this::onSearchError)

        viewModel.search("five finger")
                .subscribe(this::onEvent, this::onSearchError)
    }

    private fun onSearchError(t: Throwable) {
        Log.e(TAG, "Err: ${t.localizedMessage}")
    }

    private fun onEvent(events: List<Event>? ) {
        events?.forEachIndexed { i, event ->
            Log.e(TAG, "[$i] = ${event.name} (${event.type}) in ${event.embedded!!.venues[0].name}")
        }
    }
}
