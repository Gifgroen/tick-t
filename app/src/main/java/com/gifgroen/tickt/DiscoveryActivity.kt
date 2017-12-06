package com.gifgroen.tickt

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.data.Event
import org.threeten.bp.*
import org.threeten.bp.temporal.TemporalAdjusters

class DiscoveryActivity : AppCompatActivity() {

    private val TAG = DiscoveryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)


        val viewModel = ViewModelProviders.of(this).get(DiscoveryViewModel::class.java)

        LocalDate.now().atStartOfDay(ZoneOffset.systemDefault()).also { today ->
                Log.e(TAG, "Show remainder of week")
                val laterDate = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY))

                Log.e(TAG, "Duration between $today and $laterDate: ${Duration.between(today, laterDate)}")
                // Load events from now until sunday.
                viewModel.eventsByDateRange(today.toInstant(), laterDate.toInstant())
                        .subscribe(::onEvents, ::onSearchError)
            }
    }

    private fun onAttractions(attractions: List<Attraction>?) {
        attractions?.forEachIndexed { i, attraction ->
            Log.e(TAG, "Attraction[$i] = ${attraction.name} with id = ${attraction.id}")
        }
    }

    private fun onSearchError(t: Throwable) {
        t.printStackTrace()
        Log.e(TAG, "Err: ${t.localizedMessage}")
    }

    private fun onEvents(events: List<Event>? ) {
        events?.forEachIndexed { i, event ->
            Log.e(TAG, "Event[$i] = ${event.name} (${event.type}) in ${event.embedded!!.venues[0].name}")
        }
    }
}
