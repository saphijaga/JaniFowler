
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    ;

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    ;

    public String getName() {
        return name;
    }

    ;

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            // add frequent renter points
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }


}
    