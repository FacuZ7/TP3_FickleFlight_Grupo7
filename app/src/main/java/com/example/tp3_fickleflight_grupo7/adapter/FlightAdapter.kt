import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.FlightItemAdapter
import com.example.tp3_fickleflight_grupo7.entities.BestFlight

class FlightAdapter(private val bestFlights: MutableList<BestFlight>) : RecyclerView.Adapter<FlightAdapter.BestFlightHolder>() {

    inner class BestFlightHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flightsRecyclerView: RecyclerView = view.findViewById(R.id.recycler_flights_result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestFlightHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_flight_item, parent, false)
        return BestFlightHolder(view)
    }

    override fun onBindViewHolder(holder: BestFlightHolder, position: Int) {
        val bestFlight = bestFlights[position]
        holder.flightsRecyclerView.layoutManager = LinearLayoutManager(holder.flightsRecyclerView.context)
        holder.flightsRecyclerView.adapter = FlightItemAdapter(bestFlight.flights)
    }

    override fun getItemCount(): Int = bestFlights.size
}
