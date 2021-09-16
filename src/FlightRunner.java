import logical.LogicalLayer;
import pojo.FirstFlight;
import pojo.Passenger;
import pojo.SecondFlight;

import java.util.ArrayList;
import java.util.Scanner;

public class FlightRunner {
    static Scanner scan = new Scanner(System.in);
    static int firstSeatNumber=1;
    static int secondSeatNumber=1;
    public static void main(String[] args)
    {
        LogicalLayer logical=new LogicalLayer();
        FirstFlight first=setFirstFlight();
        SecondFlight second=setSecondFlight();
        int option;
        do {
            System.out.println("Enter an option");
            System.out.println("1.Book a seat\n2.Cancel a seat\n3.ShowFlightData");
            option=scan.nextInt();
            switch (option)
            {
                case 1:
                {
                    ArrayList<Passenger> passengers= new ArrayList<>();
                    System.out.println("Enter the no.of.tickets:");
                    int n= scan.nextInt();
                    for (int i = 0; i <n ; i++) {
                        System.out.println("Enter name");
                        String name=scan.next();
                        System.out.println("Enter age");
                        int age=scan.nextInt();
                        System.out.println("Enter flightNumber");
                        int flightNumber=scan.nextInt();
                        Passenger passenger;
                        ArrayList<Integer>firstCancelTickets= logical.getFirstCancelTickets();
                        ArrayList<Integer>secondCancelTickets=logical.getSecondCancelTickets();
                        if(flightNumber==101)
                        {
                            if(!(firstCancelTickets.isEmpty())) {
                                passenger=logical.bookFlight(first,name,age,flightNumber,firstCancelTickets.get(0));
                                firstCancelTickets.remove(0);
                            }
                            else {
                                passenger = logical.bookFlight(first, name, age, flightNumber, firstSeatNumber);
                                firstSeatNumber++;
                            }
                        }
                        else
                        {
                            if(!(secondCancelTickets.isEmpty())) {
                                passenger=logical.bookFlight(second,name,age,flightNumber,secondCancelTickets.get(0));
                                secondCancelTickets.remove(0);
                            }
                            else
                            {
                                passenger = logical.bookFlight(second, name, age, flightNumber, secondSeatNumber);
                                secondSeatNumber++;
                            }
                        }
                        passengers.add(passenger);
                        System.out.println("Seat Number:"+passenger.getSeatNumber());
                    }
                    logical.storeIntoMap(passengers);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter your flightNumber:");
                    int flightNumber= scan.nextInt();
                    System.out.println("Enter the seatNumber you want to cancel");
                    int seatNumber= scan.nextInt();
                    int refund;
                    if(flightNumber==101)
                    {
                        refund=logical.cancelTicket(first,flightNumber,seatNumber);
                    }
                    else
                    {
                        refund=logical.cancelTicket(second,flightNumber,seatNumber);
                    }
                    System.out.println(refund+" is refunded");
                    break;
                }
                case 3:
                {
                    System.out.println(first);
                    System.out.println(second);
                    break;
                }
            }
        }while (option<4);
    }
    public static FirstFlight setFirstFlight()
    {
        FirstFlight first= new FirstFlight();
        System.out.println("Enter total seats");
        int totalSeats= scan.nextInt();
        int bookedSeats=0;
        System.out.println("Enter ticket charge");
        int ticketCharge= scan.nextInt();
        System.out.println("Enter meal charge");
        int mealCharge= scan.nextInt();
        first.setTotalSeats(totalSeats);
        first.setBookedSeats(bookedSeats);
        first.setTicketCharge(ticketCharge);
        first.setMealCharge(mealCharge);
        return first;
    }
    public static SecondFlight setSecondFlight()
    {
        SecondFlight second= new SecondFlight();
        System.out.println("Enter total seats");
        int totalSeats= scan.nextInt();
        int bookedSeats=0;
        System.out.println("Enter ticket charge");
        int ticketCharge= scan.nextInt();
        System.out.println("Enter meal charge");
        int mealCharge= scan.nextInt();
        second.setTotalSeats(totalSeats);
        second.setBookedSeats(bookedSeats);
        second.setTicketCharge(ticketCharge);
        second.setMealCharge(mealCharge);
        return second;
    }
}
