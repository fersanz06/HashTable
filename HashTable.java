import java.util.*;
import java.util.stream.*;

public class HashTable {
    public static void main(String[] args) {

        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Luis");
        mapa.put(2, "Andrea");
        mapa.put(3, "Fernando");
        mapa.put(4, "Carlos");

        System.out.println("Tabla original:");
        System.out.println(mapa);

        Map<Integer, String> ordenado = mapa.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue()) // se ordena por nombre
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a, b) -> a,
                LinkedHashMap::new   // mantiene orden
            ));

        System.out.println("\nTabla ordenada por nombre:");
        System.out.println(ordenado);
    }
}