import java.util.*;
import java.util.stream.*;

public class HashTable {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Luis");
        mapa.put(2, "Andrea");
        mapa.put(3, "Fernando");
        mapa.put(4, "Carlos");

        Map<Integer,String> ordenado = mapa.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                e -> 1, // <- ERROR: todas las llaves son 1
                e -> e.getValue(),
                (a, b) -> a,
                LinkedHashMap::new
            ));

        System.out.println("Ordenado (incorrecto): " + ordenado);
    }
}