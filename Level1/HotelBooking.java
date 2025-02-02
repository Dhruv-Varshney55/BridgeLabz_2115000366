import java.util.Scanner;

class HotelBooking{

    String guestName;
    String roomType;
    int nights;

    HotelBooking(){
        this.guestName = "Dhruv Varshney";
        this.roomType = "Double";
        this.nights = 2;
    }

    HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking h){
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }

    void display(){
		System.out.println();
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();
        System.out.print("Enter room type: ");
        String roomType = sc.nextLine();
        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();
        HotelBooking hb1 = new HotelBooking();
        HotelBooking hb2 = new HotelBooking(name, roomType, nights);
        HotelBooking hb3 = new HotelBooking(hb2);
        hb1.display();
        hb2.display();
        hb3.display();
    }
}