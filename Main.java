import java.util.*;
import property.*;

public class Main {
    static Hotel hotel = new Hotel("Amaris", 4, 5);
    
    public static void main(String[] args) {
        // attaching user to room
        hotel.attachUserToRoom("Express 1", new User("Tofik", 19), 4, 4);
        hotel.attachUserToRoom("Business 1", new User("Hidayat", 19), 1, 5);

        // make list array 
        ArrayList<Room> filledRoom = hotel.getFilledRoom();

        // filled
        System.out.println("========= Kamar yang sudah di isi ============\n");
        for(int i = 0; i < filledRoom.size(); i++) {
            Room currentRoom = filledRoom.get(i);
            System.out.println("Tamu berada di Lantai " + currentRoom.getFloor() + " Kamar " + currentRoom.getNumber() + " " + currentRoom.getName() + " atas nama "+ currentRoom.getUser().getName() +" Umur " +  currentRoom.getUser().getAge() + " tahun");
        }

        // available
        System.out.println("\n========= Kamar yang masih tersedia ============");
        System.out.print("\n");
        System.out.println("Sisa kamar yang tersedia adalah " + hotel.getAvailableRoom() + " Kamar");
        System.out.print("\n");

        System.out.println("========= Denah kamar ============");

        System.out.print("\n");
        // map
        hotel.printRoomMap();

    }
}