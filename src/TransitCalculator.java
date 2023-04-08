import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TransitCalculator {
    public int numberOfDays;
    public int transCount;

    static KindsOfTickets kindsOfTickets = new KindsOfTickets();
    String[] tickets = kindsOfTickets.getTickets();
    TicketPrice ticketPrice = new TicketPrice();
    double[] cost = ticketPrice.getCost();

    public TransitCalculator(int numberOfDays, int transCount) {
         this.numberOfDays = numberOfDays;
         this.transCount = transCount;
    }

    public double unlimited7Price(){
        int weekCount = numberOfDays/7;
        if (numberOfDays%7>0){
            weekCount+=1;
        }
        return weekCount * cost[1];
    }

    public double[] getRidePrices(){
        double price1 = (cost[0]*transCount) / numberOfDays;
        double price2 = unlimited7Price() / transCount;
        double price3 = cost[2] / transCount;

        return new double[]{price1, price2, price3};
    }

    public String getBestFare(){
        int num = 0;
        for (int i = 0; i < getRidePrices().length; i++) {
            if(getRidePrices()[i] < getRidePrices()[num]){
                num=i;

            }
        }
        return "You should get the " + tickets[num] + " Unlimited option at " + (getRidePrices()[num]= Math.round(getRidePrices()[num]* 100.0) / 100.0) + " per ride.";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean rightAnswer = false;

        System.out.println("Welcome to the public transportation calculator.");
        System.out.println("We have prepared three ticket options for you.");
        System.out.println(Arrays.toString(kindsOfTickets.getTickets()));

        System.out.println("Please indicate how many days you have come to us and how often you will travel.");
        System.out.println("We will help you choose the best ticket.");

        while (!rightAnswer) {
            try {
                System.out.print("Please enter the number of days (from 1 to 30): ");
                int number1 = sc.nextInt();
                if (number1 <= 30 && number1 > 0) {
                    boolean rightAnswerTwo = false;
                    while (!rightAnswerTwo) {
                        try {
                            System.out.print("Please enter the number of rides: ");

                            int number2 = sc.nextInt();
                            TransitCalculator newPassenger = new TransitCalculator(number1, number2);
                            System.out.println(newPassenger.getBestFare());

                            System.out.println("---------------------------------------------------");
                            System.out.print("Do you have a citizen card? (ride yes or no): ");

                            String question = sc.next().toLowerCase();
                            citizen local = new citizen(question);
                            local.card();

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter an integer.");
                            sc.next();
                        } break;
                    }
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();
            }
            break;
        }
    }
}
