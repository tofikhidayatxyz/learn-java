package property;

import java.util.*;
import property.*;

public class Hotel {
    /**
     * initialize rooms and floors
     * [floor][user]
     */
    Room roomData[][];
    String name;

    public Hotel(String name, int totalFloor, int totalRoom) {
        this.name = name;
        this.setDefaultRoom(totalFloor, totalRoom);
    }

    private void setDefaultRoom(int totalFloor, int totalRoom) {
        this.roomData = new Room[totalFloor][totalRoom];
    }

    public void attachUserToRoom(String roomName, User user, int floor, int roomNo) {
        this.roomData[floor - 1][roomNo - 1] = new Room(roomName, user, floor - 1, roomNo - 1);
    }

    public ArrayList<Room> getFilledRoom() {
        ArrayList<Room> filedRoom = new ArrayList<Room>();
        for(int i = 0; i < this.roomData.length; i++) {
            for (int j = 0; j < this.roomData[i].length; j++) {
                if(this.roomData[i][j] != null) {
                    filedRoom.add(this.roomData[i][j]);
                }
            }
        }
        Collections.reverse(filedRoom);
        return filedRoom;
    }

    public int getAvailableRoom() {
        int availableRooms = 0;
        for(int i = 0; i < this.roomData.length; i++) {
            for (int j = 0; j < this.roomData[i].length; j++) {
                if(this.roomData[i][j] == null) {
                    availableRooms++;
                }
            }
        }
        return availableRooms;
    }

    public void printRoomMap() {
        for(int i = 0; i < this.roomData.length; i++) {
            for (int j = 0; j < this.roomData[i].length; j++) {
                System.out.print("-------");
            }
            System.out.print("\n");
            for (int j = 0; j < this.roomData[i].length; j++) {
                System.out.print("|  " + (this.roomData[i][j] == null ? "*" : "X" ) + "  |");
            }
            for (int j = 0; j < this.roomData[i].length; j++) {
                System.out.print((j == 0 ? "\n" : "") + "-------" + (j == this.roomData[i].length - 1 ? "\n" : ""));
            }
  
        }
    }
}
