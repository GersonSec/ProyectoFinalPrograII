import java.util.HashMap;
import java.util.Map;

public class Votaciones {
    public static void main(String[] args) {
        // Creamos un HashMap .
        Map<String, Map<String, Map<String, Map<String, Integer>>>> resultados = new HashMap<>();

        // El ultmo valor es el unico que se presentara en la terminal
        registrarVotos(resultados, "Sacatepequez", "Antigua Guatemala",   "Mesa1", "Geovany Reyes", 10);
        registrarVotos(resultados, "Sacatepequez", "Antigua Guatemala",   "Mesa2", "Zury Rios",     50);
        registrarVotos(resultados, "Sacatepequez", "Antigua Guatemala",   "Mesa2", "Geovany Reyes", 80);
        registrarVotos(resultados, "Sacatepequez", "Antigua Guatemala",   "Mesa2", "Zury Rios",     10);
        registrarVotos(resultados, "Sacatepequez", "Sumpango",            "Mesa1", "Geovany Reyes", 60);
        registrarVotos(resultados, "Sacatepequez", "Sumpango",            "Mesa1", "Zury Rios",     220);
        registrarVotos(resultados, "Sacatepequez", "Sumpango",            "Mesa2", "Geovany Reyes", 90);
        registrarVotos(resultados, "Guatemala",    "Sta Catarina Pinula", "Mesa1", "Geovany Reyes", 200);
        registrarVotos(resultados, "Guatemala",    "Sta Catarina Pinula", "Mesa1", "Zury Rios",     600);

        mostrarResultados(resultados);
    }

     // El metodo que utilizamos
    public static void registrarVotos(Map<String, Map<String, Map<String, Map<String, Integer>>>> resultados, String departamento,
            String municipio, String mesa, String candidato, int votos) {
        if (!resultados.containsKey(departamento)) {
            resultados.put(departamento, new HashMap<>());
        }

        // Aca empezamos a mapear
        Map<String, Map<String, Map<String, Integer>>> municipios = resultados.get(departamento);

        if (!municipios.containsKey(municipio)) {
            municipios.put(municipio, new HashMap<>());
        }

        Map<String, Map<String, Integer>> mesas = municipios.get(municipio);
        if (!mesas.containsKey(mesa)) {
            mesas.put(mesa, new HashMap<>());
        }

        Map<String, Integer> candidatos = mesas.get(mesa);
        if (candidatos.containsKey(candidato)) {
            int votosAnteriores = candidatos.get(candidato);
            candidatos.put(candidato, votosAnteriores + votos);

        } else {
            candidatos.put(candidato, votos);
        }
    }

    public static void mostrarResultados(Map<String, Map<String, Map<String, Map<String, Integer>>>> resultados) {
        for (String departamento : resultados.keySet()) {
            System.out.println("Departamento: " + departamento);

            Map<String, Map<String, Map<String, Integer>>> municipios = resultados.get(departamento);

            for (String municipio : municipios.keySet()) {
                System.out.println("  Municipio: " + municipio);

                Map<String, Map<String, Integer>> mesas = municipios.get(municipio);

                for (String mesa : mesas.keySet()) {
                    System.out.println("    Mesa: " + mesa);

                    Map<String, Integer> candidatos = mesas.get(mesa);

                    for (String candidato : candidatos.keySet()) {
                        int votos = candidatos.get(candidato);
                        System.out.println("      Candidato: " + candidato + " - Votos: " + votos);
                    }
                }
            }

            System.out.println();
        }
    }
}
