package clases;

public class Event {
    private int id;
    private String name;
    private Location location;

    public Event() {
        id=0;
        name="";
        location=null;
    }

    public Event(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Event setB (int id, String name, Location location){
        this.id = id;
        this.name=name;
        this.location = location;
        return this;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId (){
        return id;
    }

    public String getName(){
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return " Id: "+ id +" name: " + name + location.toString() ;
    }
}
