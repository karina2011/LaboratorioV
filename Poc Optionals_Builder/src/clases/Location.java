package clases;

public class Location {
    private int id;
    private String name;
    private City city;

    public Location() {
        id=0;
        name="";
        city=null;
    }

    public Location(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Location setB(int id, String name, City city){
        this.id = id;
        this.name = name;
        this.city = city;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return " location: "+name+ city.toString();
    }
}
