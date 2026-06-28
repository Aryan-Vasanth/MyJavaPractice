package MyJavaPractice.oop;
import java.util.*;
public class Student {
    String name,rollno;
    String branch;
    int eligible = 0;
    Scanner in = new Scanner(System.in);
    public Student() {
        System.out.println("Enter your Name: ");
        name = in.nextLine();
        System.out.println("Enter your Roll No.: ");
        rollno = in.next();
        System.out.println("Enter your branch: ");
        branch = in.next();
    }
    double attandence(int present) {
        if(present <= 350) {
            return (present / 350.0) * 100;
        }else {
            return 0;
        }
    }
    void condonation() {
        System.out.println("Payment: 500/-");
        if(paid()) {
            eligible = 1;
            System.out.println("\rPayment Successful\n" + "\r\nNow,you are able to write Semester Exams" + "\r\nAll the Best");
        }else {
            System.out.println("Correct Payment Not Done.");
        }
    }
    boolean paid() {
        System.out.println("Enter the amount: ");      
        int amount = in.nextInt();
        if(amount < 500) {
            System.out.println("Insufficient Amount, You have paid");
        }if(amount > 500) {
            System.out.println("Sorry! You have entered over amount");
        }
        return amount == 500;
    }
    void EndExams() {
        if(eligible == 1) {
            System.out.println();
            System.out.println("Here your Hall Ticket");
            System.out.println("===  ===  ===  ===" + "\nIndian Institute Of Technology");
            System.out.println("B.Tech(" + branch + ") Year Semester");
            System.out.println("Name of the candidate: " + name);
            System.out.println("Roll No.: " + rollno);
            System.out.println("Month & Year: December 2025");
            System.out.println("Examinations: Regular");
            System.out.println("Controller of Examinations");
        }else {
            System.out.println("You are unable to write End Examinations");
        }
    }
}
class ManagementOfExaminations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice = "";
        do {
            Student s = new Student();
            double attend = 0;
            System.out.println("No. of Days which you are present: ");
            int a = in.nextInt();
            if(a > 350) {
                System.out.println("It's invalid, Enter the correct no. of days.");
                System.out.println("For Try Again, enter (Re-Enter)");
                choice = in.next();
            }else {
                attend = s.attandence(a);
                System.out.printf("Your Attendance: %.2f%%%n", attend);
                if(attend < 75 && attend > 50) {
                    s.condonation();
                }else if(attend <= 50) {
                    System.out.println("You are under detention");
                }else {
                    s.eligible = 1;
                }
                if(s.eligible == 1) {
                    s.EndExams();
                }
            }
        }while(choice == "Re-Enter");
        in.close();
    }
}