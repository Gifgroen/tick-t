package com.gifgroen.tickt

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gifgroen.base.model.data.Attraction
import com.gifgroen.base.model.data.Event
import kotlinx.android.synthetic.main.activity_discovery.*
import kotlinx.android.synthetic.main.holder_event.view.*
import org.threeten.bp.*
import org.threeten.bp.temporal.TemporalAdjusters

class DiscoveryActivity : AppCompatActivity() {

    private val TAG = DiscoveryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        rvEvents.layoutManager = LinearLayoutManager(this)
        rvEvents.setHasFixedSize(true)

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
        rvEvents.adapter = EventAdapter(this, events)
    }

    class EventAdapter(context: Context, private val events: List<Event>?) : RecyclerView.Adapter<EventViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EventViewHolder {
            return EventViewHolder(inflater.inflate(R.layout.holder_event, parent, false))
        }

        override fun onBindViewHolder(holder: EventViewHolder?, position: Int) {
            holder?.bind(events!![position])
        }

        override fun getItemCount(): Int = events?.size ?: 0
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {
            itemView.tvEventName.text = "[${adapterPosition}] ${event.name}"
        }
    }
}
