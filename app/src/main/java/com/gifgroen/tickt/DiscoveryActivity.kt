package com.gifgroen.tickt

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gifgroen.base.model.base.Result
import com.gifgroen.base.model.embedded.EventSearch

class DiscoveryActivity : AppCompatActivity() {

    private val TAG: String = DiscoveryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        val viewModel = ViewModelProviders.of(this).get(DiscoveryViewModel::class.java)
        val keyword = "metallica"
        viewModel.search(keyword).subscribe(this::onSearch, ::onSearchError)
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
