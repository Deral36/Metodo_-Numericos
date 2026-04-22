import java.util.Scanner;

public class MetodoJacobi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Instituto Tecnológico de Culiacán");
        System.out.println("Ing. En Sistemas computacionales");
        System.out.println("Angel Eduardo Perez Rojas");
        System.out.println("Solución de Sistema de Ecuaciones");
        System.out.println("Metodo de Jacobi");
        System.out.println("Horario: 10:00 a 11:00 Horas");


         System.out.println("\n");
         System.out.println("Cual es la Pregunta del Problema: ");
        
        
        int orden = 4; 
        double[][] matriz = {
            {80, 30, 220, 80, 80100},   
            {20, 135, 50, 50, 51250},  
            {210, 50, 80, 60, 86200},  
            {40, 90, 50, 200, 86300}  
        };

        double[][] mD = {
            {210, 50, 80, 60, 86200},   
            {20, 135, 50, 50, 51250},  
            {80, 30, 220, 80, 80100}, 
            {40, 90, 50, 200, 86300}   
        };

        double[] vant = new double[orden];
        double[] vact = new double[orden];
        
       
        for (int i = 0; i < orden; i++) {
            vant[i] = 100.0;
        }

        System.out.print("Ingrese el error permitido (ej. 0.5): ");
        double errorDeseado = sc.nextDouble();
        System.out.print("Ingrese el número máximo de iteraciones: ");
        int tc = sc.nextInt();

        double errorTotal;
        int nc = 0;

        System.out.printf("\n%-5s | %-10s | %-10s | %-10s | %-10s | %-10s\n", 
                          "Iter", "X1", "X2", "X3", "X4", "Error");
        System.out.println("---------------------------------------------------------------------------");
        do {
         errorTotal = 0;
            for (int f = 0; f < orden; f++) {
                double suma = mD[f][orden]; 
                double coef = mD[f][f];    

                for (int c = 0; c < orden; c++) {
                    if (f != c) {
                        suma -= mD[f][c] * vant[c];
                    }
                }
                vact[f] = suma / coef;
            }        
            for (int p = 0; p < orden; p++) {
                errorTotal += Math.abs(vact[p] - vant[p]);
            }
        nc++;
            System.out.printf("%-5d | %-10.4f | %-10.4f | %-10.4f | %-10.4f | %-10.4f\n", 
                              nc, vact[0], vact[1], vact[2], vact[3], errorTotal);

           
            for (int p = 0; p < orden; p++) {
                vant[p] = vact[p];
            }

        } while (errorTotal > errorDeseado && nc < tc);

        if (errorTotal <= errorDeseado) {
            System.out.println("\n--- RESULTADOS FINALES ---");
            for (int i = 0; i < orden; i++) {
                System.out.printf("Precio Carrito Tipo %d = $%.2f\n", (i + 1), vact[i]);
            }
        } else {
            System.out.println("\nEl proceso superó el máximo de cálculos sin converger.");
        }
    }
}