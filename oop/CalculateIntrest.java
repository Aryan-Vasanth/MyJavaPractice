import java.util.*;
abstract class Loan {
    abstract double getIntrestRate(double principal);
}
class EducationLoan extends Loan {
    int time;
    double getIntrestRate(double principal) {
        System.out.println("You get an Intrest @ 6%");
        if(principal <= 100000) {
            time = 5;
        }else if(principal <= 500000 && principal >= 100000) {
            time = 10;
        }else if(principal <= 1000000 && principal >= 500000) {
            time = 20;
        }else {
            time = 30;
        }
        double emi = (principal * 6 * time) / 100;
        return emi;
    }
}
class HomeLoan extends Loan {
    int time;
    double getIntrestRate(double principal) {
        System.out.println("You get an Intrest @ 8%");
        if(principal <= 100000) {
            time = 5;
        }else if(principal <= 500000 && principal >= 100000) {
            time = 10;
        }else if(principal <= 1000000 && principal >= 500000) {
            time = 20;
        }else {
            time = 30;
        }
        double emi = (principal * 8 * time) / 100;
        return emi;
    }
}
class CalculateIntrest {
    static String description,enter,choice;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Magadha Bank");
        System.out.println("Need a Loan? State (yes/no)");
        String yes = in.next();
        if(yes.toLowerCase().equals("yes")) {
            System.out.println("Which type of loan do you require?");
            System.out.println("1. Home Loan");
            System.out.println("2. Education Loan");
            in.nextLine();
            byte choice = in.nextByte();
            if(choice == 1 || choice == 2) {
                System.out.println("Enter the amount you needed?");
                double p = in.nextDouble();
                if(choice == 1) {
                    Loan hl = new HomeLoan();
                    System.out.println(hl.getIntrestRate(p));
                }else {
                    Loan el = new EducationLoan();
                    System.out.println(el.getIntrestRate(p));
                }
                System.out.println("Congratulations! You have recieved your loan");
            }else {
                System.out.println("Enter the correct number");
            }
        }else {
            System.out.println("Then convey your message in the description");
            in.nextLine();
            description = in.nextLine();
            System.out.println("Enter \"submit\" to submit the description");
            enter = in.nextLine();
            if(enter.toLowerCase().equals("submit")) {
                System.out.println("Successfully Submitted");
            }else {
                System.out.println("Cannot be submit");
            }
        }
        in.close();
    }
}