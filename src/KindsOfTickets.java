public class KindsOfTickets {
    private String[] tickets = {"Pay-per-ride", "7-day", "30-day"};


    public String[] getTickets() {
        return tickets.clone();
    }
}
