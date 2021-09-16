package pojo;


import java.util.ArrayList;

public class FirstFlight {
    private int totalSeats;
    private int bookedSeats;
    private int ticketCharge;
    private int mealCharge;
    private ArrayList<Passenger> passengers=new ArrayList<>();

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passenger) {
        passengers.add(passenger);
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getTicketCharge() {
        return ticketCharge;
    }

    public void setTicketCharge(int ticketCharge) {
        this.ticketCharge = ticketCharge;
    }

    public int getMealCharge() {
        return mealCharge;
    }

    public void setMealCharge(int mealCharge) {
        this.mealCharge = mealCharge;
    }

    @Override
    public String toString() {
        return "FirstFlight{" +
                "totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                ", ticketCharge=" + ticketCharge +
                ", mealCharge=" + mealCharge +
                '}';
    }
}
