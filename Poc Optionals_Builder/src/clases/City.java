package clases;

public class City {
    private int id;
    private String name;

    public City() {
        id=0;
        name="";
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City setB(int id, String name){
        this.id=id;
        this.name = name;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " city: "+name+ "\n";
    }
}
