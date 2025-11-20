import java.util.HashMap;
import java.util.stream.*;

public class HashTable {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Luis");
        mapa.put(2, "Andrea");
        mapa.put(3, "Fernando");
        mapa.put(4, "Carlos");

        mapa.entrySet()
             .stream()
             .sorted((a, b) -> a.getValue().compareTo(b.getValue()));

        // imprime original
        System.out.println("Ordenado (incorrecto): " + mapa);
    }
}