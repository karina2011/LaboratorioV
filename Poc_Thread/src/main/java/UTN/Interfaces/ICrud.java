package UTN.Interfaces;

public interface  ICrud <T> {
    void create(T palabra);
    T read();
    void update (T oldPalabra,T newPalabra);
    void delete (T palabra);
}
