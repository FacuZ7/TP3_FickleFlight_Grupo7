
data class Flight(
    val departure_airport: Airport,
    val arrival_airport: Airport,
    val duration: Int,
    val airplane: String,
    val airline: String,
    val airline_logo: String,
    val travel_class: String,
    val flight_number: String,
    val legroom: String,
    val extensions: List<String>,
    val overnight: Boolean
)