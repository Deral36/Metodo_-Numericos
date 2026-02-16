import java.util.Scanner;

public class Metodo_Newton_Raphson{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("           INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("           Ing. En Sistemas Computacionales");
        System.out.println("           Método de Newton Raphson.");
        System.out.println("           Horario: 10:00 a 11:00");
        System.out.println("---------------------------------------------------------");

        
        System.out.print("¿Cual es la pregunta del problema?: ");
        String pre = sc.nextLine();
        System.out.print("¿Cual es el Modelo matemático?: ");
        String mod = sc.nextLine();
        System.out.print("¿Cual es la unidad de medida?: ");
        String unidad = sc.nextLine();

        
        System.out.print("Ingrese x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Ingrese el Error: ");
        double error = sc.nextDouble();
        System.out.print("Ingrese total de calculos: ");
        int tc = sc.nextInt();

    
        double fx1, f1dx1, x2 = x1, fx2 = 0;
        boolean enco = false;
        System.out.println("Instituto Tecnológico de Culiacán");
        System.out.println("Ing. En sistemas computacionales");
        System.out.println("\n--- Informe del diseño ---");
        System.out.println("Pregunta: " + pre);
        System.out.println("Modelo: " + mod);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-10s | %-10s%n", "Nc", "x1", "f(x1)", "f'(X1)", "x2", "f(x2)");
        System.out.println("--------------------------------------------------------------------------------------");

        for (int i = 1; i <= tc; i++) {
            
            fx1 = -0.000234 * ((x1-80)*(x1-80)) + 1.5;
            f1dx1 = -0.000468 * (x1 - 80);
            x2 = x1 - (fx1 / f1dx1);
            fx2 = -0.000234 * ((x2-80)*(x2-80)) + 1.5;
            System.out.printf("%-5d | %-10.6f | %-10.6f | %-10.6f | %-10.6f | %-10.6f%n", i, x1, fx1, f1dx1, x2, fx2);
            
            if (Math.abs(fx2) <= error) {
                enco = true;
                break; 
            }
            x1 = x2;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        if (enco) {
            System.out.printf("La Solución al Problema = %.6f %s%n", x2, unidad);
        } else {
            System.out.println("No se encontró la Raíz en " + tc + " Cálculos.");
        }

        sc.close();
    }
}