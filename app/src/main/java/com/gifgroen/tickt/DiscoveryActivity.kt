package com.gifgroen.tickt

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gifgroen.base.model.data.Event
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneOffset

class DiscoveryActivity : AppCompatActivity() {

    private val TAG = DiscoveryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        val viewModel = ViewModelProviders.of(this).get(DiscoveryViewModel::class.java)

        viewModel.eventsByKeyword("In flames").subscribe(::onEvents, ::onSearchError)

        LocalDate.now().atStartOfDay(ZoneOffset.systemDefault())
                .also { today ->
                    val end = today.plusDays(1)
                    viewModel.eventsByDateRange(today.toInstant(), end.toInstant())
                            .subscribe(::onEvents, ::onSearchError)
                }
    }

    private fun onSearchError(t: Throwable) {
        t.printStackTrace()
        Log.e(TAG, "Err: ${t.localizedMessage}")
    }

    private fun onEvents(events: List<Event>? ) {
        events?.forEachIndexed { i, event ->
            Log.e(TAG, "[$i] = ${event.name} (${event.type}) in ${event.embedded!!.venues[0].name}")
        }
    }
}
