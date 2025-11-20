import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HashTable {

    public static void main(String[] args) {

        String rutaEntrada = "C:meses.txt";
        String rutaSalida = "C:mesesHash.txt";

        try {
            // Leer datos desde el archivo
            HashMap<Integer, String> mapa = readHashFromFile(rutaEntrada);

            System.out.println("Tabla original:");
            System.out.println(mapa);

            // Ordenar por nombre (value)
            Map<Integer, String> ordenado = mapa.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));

            System.out.println("\nTabla ordenada por nombre:");
            System.out.println(ordenado);

            // Guardar archivo con datos ordenados
            saveHashToFile(ordenado, rutaSalida);

            System.out.println("\nArchivo generado en:");
            System.out.println(rutaSalida);

        } catch (IOException e) {
            System.out.println("Error al procesar archivo: " + e.getMessage());
        }
    }

    private static HashMap<Integer, String> readHashFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        HashMap<Integer, String> mapa = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.replace(",", " ");
            String[] parts = line.trim().split("\\s+");

            if (parts.length >= 2) {
                int key = Integer.parseInt(parts[0]);
                String value = parts[1];
                mapa.put(key, value);
            }
        }

        br.close();
        return mapa;
    }

    private static void saveHashToFile(Map<Integer, String> mapa, String path) throws IOException {
        FileWriter fw = new FileWriter(path);

        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            fw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        fw.close();
    }
}