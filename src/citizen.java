import java.util.Scanner;

public class citizen {
    public String veryfication;
    TicketPrice ticketPrice = new TicketPrice();
    double[] cost = ticketPrice.getCost();


    public citizen(String veryfication) {
        this.veryfication = veryfication;
    }

    public void card() {
        boolean rightAnswer = false;
        Scanner sc = new Scanner(System.in);

        while (!rightAnswer) {
            if (veryfication.equals("no")) {
                System.out.println("Unfortunately, you are not entitled to a discount.");
                break;
            } else if (veryfication.equals("yes")) {

                boolean correctValue = false;
                while (!correctValue) {
                    try {
                        System.out.print("Enter the card number(A1111-A9999): ");
                        String char1 = sc.next();
                        int cardNumber = Integer.parseInt(char1.substring(1, 5));

                        if (char1.toUpperCase().charAt(0) == 'A' && (char1.length() == 5) && (cardNumber >= 1111) && (cardNumber <= 9999)) {

                            System.out.println("You have a resident's discount of 10%.");
                            for (int i = 0; i < cost.length; i++) {
                                cost[i] /= 1.1;
                                cost[i] = Math.round(cost[i] * 100.0) / 100.0;
                            }
                            System.out.println("Pay-per-ride: " + cost[0]);
                            System.out.println("7-day: " + cost[1]);
                            System.out.println("30-day: " + cost[2]);
                            break;
                        }
                    } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Wrong card number!");
                        System.out.println("Please enter the number again.");
                    }
                }
            } else {
                System.out.println("Wrong answer!");

                System.out.println("Please answer again.");
                System.out.print("Do you have a citizen card? (ride yes or no): ");
                String question = sc.next().toLowerCase();
                citizen local = new citizen(question);
                local.card();
            }
            break;
        }
    }
}
