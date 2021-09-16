package logical;

import pojo.FirstFlight;
import pojo.Passenger;
import pojo.SecondFlight;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicalLayer {
    int firstTicketCharge;
    int secondTicketCharge;
    ArrayList<Integer> firstCancelTickets=new ArrayList<>();
    ArrayList<Integer> secondCancelTickets=new ArrayList<>();
    HashMap<Integer,Passenger> map=new HashMap<>();
    public Passenger bookFlight(FirstFlight first,String name, int age, int flightNumber,int firstSeatNumber) {
        int firstTotalSeats = first.getTotalSeats();
        int firstBookedSeats = first.getBookedSeats();
        firstTicketCharge = first.getTicketCharge();
        int mealCharge = first.getMealCharge();
//        System.out.println(firstTotalSeats);
//        System.out.println(ticketCharge);
//        System.out.println(mealCharge);
        if (firstTotalSeats == 0) {
            System.out.println("NoTickets Available");
            System.exit(0);
        }
        Passenger passenger = new Passenger();
        passenger.setName(name);
        passenger.setAge(age);
        passenger.setSeatNumber(firstSeatNumber);
        passenger.setCharge(firstTicketCharge + mealCharge);
        passenger.setFlightNumber(flightNumber);
        firstTotalSeats--;
        firstBookedSeats++;
        firstTicketCharge += 100;
        first.setMealCharge(mealCharge);
        first.setTicketCharge(firstTicketCharge);
        first.setBookedSeats(firstBookedSeats);
        first.setTotalSeats(firstTotalSeats);
        first.setPassengers(passenger);
        return passenger;
    }
    public Passenger bookFlight(SecondFlight second,String name, int age, int flightNumber,int secondSeatNumber)
    {
            int secondTotalSeats= second.getTotalSeats();
            int secondBookedSeats=second.getBookedSeats();
            secondTicketCharge=second.getTicketCharge();
            int mealCharge=second.getMealCharge();
            if(secondTotalSeats==0)
            {
                System.out.println("NoTickets Available");
            }

            Passenger passenger=new Passenger();
            passenger.setName(name);
            passenger.setAge(age);
            passenger.setSeatNumber(secondSeatNumber);
            passenger.setCharge(secondTicketCharge+mealCharge);
            passenger.setFlightNumber(flightNumber);
            secondTotalSeats--;
            secondBookedSeats++;
            secondTicketCharge+=150;
            second.setMealCharge(mealCharge);
            second.setTicketCharge(secondTicketCharge);
            second.setBookedSeats(secondBookedSeats);
            second.setTotalSeats(secondTotalSeats);
            second.setPassengers(passenger);
            return passenger;
    }
    public void storeIntoMap(ArrayList<Passenger> list)
    {
        for (Passenger passenger : list) {
            map.put(passenger.getSeatNumber(), passenger);
        }
    }
    public int cancelTicket(FirstFlight first,int flightNumber,int firstBookingId){
        int totalSeats=first.getTotalSeats();
        int bookedSeats=first.getBookedSeats();
        totalSeats++;
        bookedSeats--;
        firstTicketCharge-=100;
        first.setTotalSeats(totalSeats);
        first.setBookedSeats(bookedSeats);
        first.setTicketCharge(firstTicketCharge);
        Passenger passenger=map.get(firstBookingId);
        firstCancelTickets.add(firstBookingId);
        map.remove(firstBookingId);
        return passenger.getCharge();
    }
    public int cancelTicket(SecondFlight second,int flightNumber,int secondBookingId){
        int totalSeats=second.getTotalSeats();
        int bookedSeats=second.getBookedSeats();
        totalSeats++;
        bookedSeats--;
        secondTicketCharge-=150;
        second.setTotalSeats(totalSeats);
        second.setBookedSeats(bookedSeats);
        second.setTicketCharge(secondTicketCharge);
        Passenger passenger=map.get(secondBookingId);
        secondCancelTickets.add(secondBookingId);
        map.remove(secondBookingId);
        return passenger.getCharge();
    }
    public ArrayList<Integer> getFirstCancelTickets()
    {
        return firstCancelTickets;
    }
    public ArrayList<Integer> getSecondCancelTickets()
    {
        return secondCancelTickets;
    }
}
