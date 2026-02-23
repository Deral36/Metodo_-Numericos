import java.util.Scanner;

public class Metodo_Secante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("Ing. En Sistemas Computacionales");
        System.out.println(" ");
        System.out.println("Perez Rojas Angel Eduardo");
        System.out.println("Método de la Secante. Raíces de una Ecuación");
        System.out.println("De 10:00 a 11:00 horas");
        System.out.println("---------------------------------------------------------");
        System.out.println("");
        System.out.println("Este programa ejecuta el proceso de calculo de Raices de una ecuacion utilizando el Método de la Secante.");
        System.out.println("");
        
        System.out.print("¿Cuál es la pregunta del problema?: ");
        String pre = sc.nextLine();
        System.out.print("¿Cuál es el Modelo matemático?: ");
        String mod = sc.nextLine();
        System.out.print("¿Cuál es la unidad de medida?: ");
        String unidad = sc.nextLine();

        System.out.print("Ingrese x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Ingrese x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Ingrese el Error: ");
        double error = sc.nextDouble();
        System.out.print("Ingrese total de cálculos: ");
        int tc = sc.nextInt();

        double fx1, fx2, x3 = 0, fx3 = 0;
        boolean solucion = false;

        System.out.println("\n                Instituto Tecnológico de Culiacán");
        System.out.println("                 Ing. En sistemas computacionales");
        System.out.println("\nPerez Rojas Angel Eduardo");
        System.out.println("Solución de Ecuaciones Algebraicas");
        System.out.println("Metodo de la Secante");
        System.out.println("De 10:00 a 11:00 horas");
        System.out.println("\nPregunta: " + pre);
        System.out.println("Modelo: " + mod);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n", "Nc", "x1", "x2", "f(x1)", "f(x2)", "x3", "f(x3)");
        System.out.println("--------------------------------------------------------------------------------------");

        for (int i = 1; i <= tc; i++) {
            fx1 = -0.000234 * Math.pow((x1 - 80), 2) + 1.5;
            fx2 = -0.000234 * Math.pow((x2 - 80), 2) + 1.5;

            x3 = x1 - (fx1 * (x1 - x2)) / (fx1 - fx2);
            fx3 = -0.000234 * Math.pow((x3 - 80), 2) + 1.5;

            System.out.printf("%-5d   %-10.6f   %-10.6f   %-10.6f   %-10.6f   %-10.6f   %-10.6f%n", i, x1, x2, fx1, fx2, x3 , fx3);

            if (Math.abs(fx3) <= error) {
                solucion = true;
                break;
            }
            x1 = x2;
            x2 = x3;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        if (solucion) {
            System.out.printf("La Solución al Problema = %.6f %s%n", x3, unidad);
        } else {
            System.out.println("No se encontró la Raíz en " + tc + " Cálculos.");
        }

        sc.close();
    }
}