import java.util.Scanner;

public class Metodo_Newton_Raphson_For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- ENCABEZADO INSTITUCIONAL  ---
        System.out.println("---------------------------------------------------------");
        System.out.println("           INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("           Ing. En Sistemas Computacionales");
        System.out.println("      Método de Newton Raphson. Raíces de una Ecuación.");
        System.out.println("                 Horario: 10:00 a 11:00");
        System.out.println("---------------------------------------------------------");

        // --- CAPTURA DE DATOS DESCRIPTIVOS [cite: 38, 39, 47] ---
        System.out.print("¿Cuál es la pregunta del Problema?: ");
        String pregunta = sc.nextLine();
        System.out.print("¿Cuál es el Modelo Matemático?: ");
        String modelo = sc.nextLine();
        System.out.print("¿Cuál es la Unidad de medida?: ");
        String unidad = sc.nextLine();

        // --- DATOS NUMÉRICOS [cite: 14, 15, 16] ---
        System.out.print("Ingrese x1 (Referencia 500): ");
        double x1 = sc.nextDouble();
        System.out.print("Ingrese el Error (Referencia 0.00001): ");
        double error = sc.nextDouble();
        System.out.print("Ingrese Total de Cálculos (Tc): ");
        int tc = sc.nextInt();

        // --- VARIABLES DE CÁLCULO ---
        double fx1, f1dx1, x2 = x1, fx2 = 0;
        boolean encontrado = false;

        // --- ENCABEZADO DEL INFORME [cite: 45, 62, 69] ---
        System.out.println("\n--- INFORME DEL DISEÑO DE PROGRAMACIÓN ---");
        System.out.println("Pregunta: " + pregunta);
        System.out.println("Modelo: " + modelo);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-10s | %-10s%n", "Nc", "X1", "F(X1)", "F'(X1)", "X2", "F(X2)");
        System.out.println("--------------------------------------------------------------------------------------");

        // --- CICLO FOR (Controlado por Nc y Tc) [cite: 48, 52] ---
        for (int nc = 1; nc <= tc; nc++) {
            // f(x) = -0.000234(x - 80)^2 + 1.5 [cite: 6]
            fx1 = -0.000234 * Math.pow(x1 - 80, 2) + 1.5;
            
            // f'(x) = -0.000468(x - 80)
            f1dx1 = -0.000468 * (x1 - 80);
            
            // Fórmula de Newton-Raphson [cite: 50]
            x2 = x1 - (fx1 / f1dx1);
            
            // Evaluación de x2 para verificar error [cite: 50]
            fx2 = -0.000234 * Math.pow(x2 - 80, 2) + 1.5;

            // Imprimir fila de la tabla con 6 decimales [cite: 17, 69]
            System.out.printf("%-5d | %-10.6f | %-10.6f | %-10.6f | %-10.6f | %-10.6f%n", 
                              nc, x1, fx1, f1dx1, x2, fx2);

            // Condición de paro por convergencia 
            if (Math.abs(fx2) <= error) {
                encontrado = true;
                break; 
            }

            // Actualización para la siguiente iteración [cite: 59]
            x1 = x2;
        }

        // --- RESULTADO FINAL [cite: 57, 60, 70] ---
        System.out.println("--------------------------------------------------------------------------------------");
        if (encontrado) {
            System.out.printf("La Solución al Problema = %.6f %s%n", x2, unidad);
        } else {
            System.out.println("No se encontró la Raíz en " + tc + " Cálculos.");
        }

        sc.close();
    }
}