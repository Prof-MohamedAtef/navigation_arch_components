package mo.ed.aad.navigationcomponents.feed;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

import mo.ed.aad.navigationcomponents.R;

public class Boat {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    int ID, Picture;
    String Name,Location, Price;
    private static List<Boat> BOATS;

    public Boat(int id, String name,String location, int picture, String price ){
        this.ID=id;
        this.Picture=picture;
        this.Name=name;
        this.Location=location;
        this.Price=price;
    }

    public static Boat getBoat(int id){
        Boat boat1=new Boat(1,"Canoe","Tenerife", R.drawable.speed_boat_blue, "45 EUR");
        Boat boat2=new Boat(2,"Sailboat","Costa Brava", R.drawable.speed_boat_blue, "99 EUR");
        Boat boat3=new Boat(3,"Kayak","Mallorca", R.drawable.speed_boat_blue, "120 EUR");
        BOATS=new ArrayList<>();
        BOATS.add(boat1);
        BOATS.add(boat2);
        BOATS.add(boat3);
        return BOATS.get(id);
    }

    public static List<Boat> getBoats(){
        Boat boat1=new Boat(1,"Canoe","Tenerife", R.drawable.speed_boat_blue, "45 EUR");
        Boat boat2=new Boat(2,"Sailboat","Costa Brava", R.drawable.speed_boat_blue, "99 EUR");
        Boat boat3=new Boat(3,"Kayak","Mallorca", R.drawable.speed_boat_blue, "120 EUR");
        BOATS=new ArrayList<>();
        BOATS.add(boat1);
        BOATS.add(boat2);
        BOATS.add(boat3);
        return BOATS;
    }

}
