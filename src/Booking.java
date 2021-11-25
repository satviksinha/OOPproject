import java.util.*;
public class Booking {
    private Flight FlightDetails;
    public static ArrayList<Customer> Customers = new ArrayList<Customer>();

    public Booking(Flight FlightDetails){
        this.FlightDetails = FlightDetails;
    }

    

    public void getFlightDetails() {
        System.out.println("Flight name: " + FlightDetails.getName());
        System.out.println("Destination City: " + FlightDetails.getDestinationCity().getName());
        System.out.println("Source City: " + FlightDetails.getSourceCity().getName());
        System.out.println("Departure Time: " + FlightDetails.getDepartureTime());
        System.out.println("Arrival Time: " + FlightDetails.getArrivalTime());
    }
}
