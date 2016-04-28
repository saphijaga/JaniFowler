/**
 * Created by jega on 28.04.16.
 */
abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}