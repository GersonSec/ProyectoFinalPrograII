/**
 *
 * @author Gerson Sec
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Votaciones {
    public static void main(String[] args) {
        Map<String, Integer> candidatos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Agregar candidatos
        candidatos.put("Sandra Torres", 0);
        candidatos.put("Isaac Farchi", 0);
        candidatos.put("Zury Rios", 0);
        candidatos.put("Carlos Pineda", 0);
        candidatos.put("Geovany Reyes", 0);

        int totalVotos = 0;
        boolean votacionActiva = true;

        while (votacionActiva) {
            System.out.println("Ingresa el número del candidato al que deseas votar:");
            System.out.println("1 - Sandra Torres");
            System.out.println("2 - Isaac Farchi");
            System.out.println("3 - Zury Rios");
            System.out.println("4 - Carlos Pineda");
            System.out.println("5 - Geovany Reyes");
            System.out.println("0 - Finalizar votación");


            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    candidatos.put("Sandra Torres", candidatos.get("Sandra Torres") + 1);
                    totalVotos++;
                    break;
                case 2:
                    candidatos.put("Isaac Farchi", candidatos.get("Isaac Farchi") + 1);
                    totalVotos++;
                    break;
                case 3:
                    candidatos.put("Zury Rios", candidatos.get("Zury Rios") + 1);
                    totalVotos++;
                    break;
                case 4:
                    candidatos.put("Carlos Pineda", candidatos.get("Carlos Pineda") + 1);
                    totalVotos++;
                    break;
                case 5:
                    candidatos.put("Geovany Reyes", candidatos.get("Geovany Reyes") + 1);
                    totalVotos++;
                    break;
                case 0:
                    votacionActiva = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;

                    

            }
        }

        // Mostrar resultados
        System.out.println("Resultados de la votación:");
        for (Map.Entry<String, Integer> candidato : candidatos.entrySet()) {
            String nombreCandidato = candidato.getKey();
            int votosCandidato = candidato.getValue();
            double porcentajeVotos = (double) votosCandidato / totalVotos * 100;
            System.out.println(nombreCandidato + ": " + votosCandidato + " votos (" + porcentajeVotos + "%)");
        }
        System.out.println("Total de votos: " + totalVotos);
        scanner.close();

   
    }
}