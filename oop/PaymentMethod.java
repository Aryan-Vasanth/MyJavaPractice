import java.util.*;
class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}
class Payment {
    void pay() {
        System.out.println("General Payment");
    }
}
class UPI extends Payment {
    void pay() {
        System.out.println("Payment Using UPI");
    }
}
class Card extends Payment {
    void pay() {
        System.out.println("Payment Using CARD");
    }
}
class Cash extends Payment {
    void pay() {
        System.out.println("Payment Using CASH");
    }
}
public class PaymentMethod {
    public static void main(String[] args) throws InvalidCardNumberException {
        Scanner in = new Scanner(System.in);
        Payment p;
        UPI p1 = new UPI();
        Card p2 = new Card();
        Cash p3 = new Cash();
        System.out.println("Enter the mode of payment: ");
        System.out.println("1. UPI" + "\n2. Cash" + "\n3. Card");
        int choice = in.nextInt();
        new Payment().pay();
        switch(choice) {
            case 1:
                p = p1;
                p.pay();
                System.out.println("Here! Your Scanner sir.");
                break;
            case 2:
                p = p3;
                p.pay();
                break;
            case 3:
                p = p2;
                p.pay();
                System.out.println("Please, Enter the card number sir.");
                String num = in.next();
                if(num.length() != 12) {
                    throw new InvalidCardNumberException("\nInvalid: Card Number Entered");
                }
                break;
            default:
                System.out.println("Sorry! We don't that kind of service" + "\nWe use Exo bar");
                break;
        }
        try {
            Thread.sleep(5000);
        }catch(Exception e) {
            System.out.println(e);
        }
        if((choice == 1 || choice == 3) && choice != 2) {
            System.out.println("\u001B[32m" + "Processing...." + "\u001B[0m");
            System.out.flush();
            for(int i = 0;i < 100;i++) {
                try {
                    Thread.sleep(10);
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Payment done");
        }
        System.out.println("Thank You!");
    }
}