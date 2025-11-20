import java.util.HashMap;

public class HashTable {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Luis");
        mapa.put(2, "Andrea");
        mapa.put(3, "Fernando");
        mapa.put(4, "Carlos");

        mapa.entrySet().stream().sorted();

        System.out.println("Ordenado: " + mapa);
    }
}