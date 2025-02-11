import java.util.Scanner;

class Ticket{
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime){
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation{
    private Ticket last;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime){
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if(last == null){
            last = newTicket;
            last.next = last;
        }
		else{
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
    }

    public void removeTicket(int ticketId){
        if(last == null){
            System.out.println("No tickets booked");
            return;
        }

        Ticket current = last.next, prev = last;
        do{
            if(current.ticketId == ticketId){
                if(current==last && current.next==last){
                    last = null;
                }
				else{
                    prev.next = current.next;
                    if(current == last){
                        last = prev;
                    }
                }
                System.out.println("Ticket " + ticketId + " cancelled");
                return;
            }
            prev = current;
            current = current.next;
        }while(current != last.next);

        System.out.println("Ticket ID not found");
    }

    public void displayTickets(){
        if(last == null){
            System.out.println("No tickets booked");
            return;
        }
        Ticket temp = last.next;
        do{
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        }while(temp != last.next);
    }

    public void searchTicket(String query){
        if(last == null){
            System.out.println("No tickets booked");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do{
            if(temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)){
                System.out.println("Ticket Found - ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        }while(temp != last.next);
        
        if(!found){
            System.out.println("No tickets found for query: " + query);
        }
    }

    public void countTickets(){
        if(last == null){
            System.out.println("No tickets booked");
            return;
        }
        int count = 0;
        Ticket temp = last.next;
        do{
            count++;
            temp = temp.next;
        }while(temp != last.next);
        System.out.println("Total booked tickets: " + count);
    }
}

public class TicketReservationSystem{
    public static void main(String[] args){
        TicketReservation system = new TicketReservation();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. Display Tickets\n4. Search Ticket\n5. Count Tickets\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch(choice){
                case 1:
                    System.out.print("Enter Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time: ");
                    system.addTicket(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    system.removeTicket(sc.nextInt());
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    system.searchTicket(sc.next());
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}