import java.util.Scanner;
 
public class Trapecios {
 
    public static void main(String[] args) {
 
        // ─── Pantalla de inicio ────────────────────────────────────────────────
        System.out.println("=======================================================");
        System.out.println("                     INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("                     Ingeniería en Sistemas");
        System.out.println();
        System.out.println("Përez Rojas Angel Eduardo");
        System.out.println("Integración Numérica. Método de los Trapecios.");
        System.out.println("10:00 - 11:00 horas.");
        System.out.println("=======================================================");
        System.out.println();
 
       
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Cuál es la pregunta del problema: ");
        String pregunta = sc.nextLine();
 
        System.out.print("Valor real: ");
        double Vreal = sc.nextDouble();
 
        System.out.print("Unidad de medida: ");
        String unidad = sc.next();
        sc.nextLine();
        System.out.println("Datos adicionales del proceso");
        System.out.print("Valor de a: ");
        double a = sc.nextDouble();
 
        System.out.print("Valor de b: ");
        double b = sc.nextDouble();
 
        System.out.print("Número de trapecios inicial: ");
        int n = sc.nextInt();
        System.out.println();
        System.out.println("Como es el proceso de aproximaciones");
        System.out.print("Error tolerado: ");
        double Error = sc.nextDouble();
 
        System.out.print("Total de procesos(Tp): ");
        int Tp = sc.nextInt();
 
        System.out.println();
        int    Np     = 0;         
        double ca     = a;
        
         System.out.println("=======================================================");
        System.out.println("                     INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("                     Ingeniería en Sistemas Computacionales");
        System.out.println();
        System.out.println("Përez Rojas Angel Eduardo");
        System.out.println("Integración Numérica. Método de los Trapecios.");
        System.out.println("10:00 - 11:00 horas.");
        System.out.println();
        System.out.println("PREGUNTA: " + pregunta);
        System.out.printf("%-10s %-14s %-14s %-14s %-14s %-14s%n","Trapecio", "a", "a+h", "f(a)", "f(a+h)", "Área");
        System.out.println("-------------------------------------------------------");

 
        double Vcalc  = 0.0;
        double ErrorP = 0.0;
 
        do {
            Np++;
            Vcalc = 0.0;
            double h = (b - a) / n;
 
            a = ca;   
            for (int x = 1; x <= n; x++) {
                double ai  = a;
                double ah  = a + h;
                double fa  = (0.03 * (ai * ai)) + 1.5;
                double fah = (0.03 * (ah * ah)) + 1.5;
                double Area = (h / 2.0) * (fa + fah);
 
                Vcalc += Area;
 
                System.out.printf("%-10d %-14.6f %-14.6f %-14.6f %-14.6f %-14.6f%n",
                        x, ai, ah, fa, fah, Area);
 
                a = ah;   
            }
 
        
            ErrorP = Math.abs(Vreal - Vcalc);
 
            System.out.println("-------------------------------------------------------");
            System.out.printf("  Vr= %.6f metros%n", Vreal);
            System.out.printf("  Vc= %.6f metros%n", Vcalc);
            System.out.printf("  Error= %.6f metros%n", ErrorP);
            System.out.println("-------------------------------------------------------");
            a  = ca;
            n  = n * 2;
 
        } while (!(ErrorP <= Error) && Np < Tp);
 
     
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("              RESULTADOS FINALES");
        System.out.println("=======================================================");
        System.out.printf("  No. de procesos= %d%n", Np);
        System.out.printf("  No. de trapecios= %d%n", n / 2);
        System.out.printf("  Valor Real de la Integral= %.6f %s%n", Vreal, unidad);
        System.out.printf("  Valor Calculado= %.6f %s%n", Vcalc, unidad);
        System.out.printf("  Error del Problema= %.6f %s%n", Error, unidad);
        System.out.printf("  Error del Método= %.6f %s%n", ErrorP, unidad);
        System.out.println("=======================================================");
    }
}