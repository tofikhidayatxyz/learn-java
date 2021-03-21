package property;

import property.*;

public class Room {

    String name;
    User user;
    int floor;
    int number;

    public Room(String name, User user, int floor, int number) {
        this.name = name;
        this.user = user;
        this.floor = floor;
        this.number = number;
    }

    public int getFloor() {
        return this.floor + 1;
    }

    public int getNumber() {
        return this.number + 1;
    }

    public User getUser() {
        return this.user;
    } 

    public String getName() {
        return this.name;
    }
}
