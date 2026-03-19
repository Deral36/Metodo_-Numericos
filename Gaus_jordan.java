import java.util.Scanner;
public class Gaus_jordan {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
       System.out.println("---------------------------------------------------------");
        System.out.println("\t\t   "+"INSTITUTO TECNOLÓGICO DE CULIACÁN");
        System.out.println("\t\t   "+"Ing. En Sistemas Computacionales");
        System.out.println(" ");       
         System.out.println("Perez Rojas Angel Eduardo");
        System.out.println("Solución de Sistemas de Ecuaciones. Método de Gauss-Jordan");
        System.out.println("De 10:00 a 11:00 horas.");
        System.out.println("---------------------------------------------------------");
       
       System.out.println("\nEste programa esta diseñado para el proceso de calculo de la población de cada especie de peces que habita el lago considerando que todo el alimento diario se consume, utilizando el Método de Gauss-Jordan.");
       System.out.println("¿Cual es la pregunta del problema? ");
       String pregunta= leer.nextLine();
       System.out.println();


        int orden = 4;
        String[] especies = {"Pez Hacha", "Pez Gato", "Pez Mono", "Pez Lagarto"};

        double[][] matrizA = {
            {20, 10,  9,  9, 12500},
            { 8, 18,  6, 14, 13600},
            { 8,  8,  9, 24, 13300},
            { 8,  8, 16, 12, 14400}
        };

        // IMPRESIÓN DEL ENCABEZADO
        System.out.println("\t\t" + "Instituto Tecnológico de Culiacán");
        System.out.println("\t\t   " + "Ing. En Sistemas Computacionales");
        System.out.println("\n" + "Ing. Pérez Rojas Angel Eduardo");
        System.out.println("Solución de Sistemas de Ecuaciones");
        System.out.println("DE 10:00 A 11:00 Horas.");
        System.out.println("\nPregunta: " + pregunta);

        
        System.out.println("\nMatriz de Datos:");
        imprimirFormato(matrizA);

       
        for (int k = 0; k < orden - 1; k++) {
            double piv = matrizA[k][k];
            for (int f = k + 1; f < orden; f++) {
                double eCero = matrizA[f][k];
                for (int c = k; c < orden + 1; c++) {
                    matrizA[f][c] = (piv * matrizA[f][c]) - (eCero * matrizA[k][c]);
                }
            }
        }

        
        for (int k = orden - 1; k >= 1; k--) {
            double piv = matrizA[k][k];
            for (int f = 0; f < k; f++) {
                double factor = matrizA[f][k] / piv;
                for (int c = k; c < orden + 1; c++) {
                    matrizA[f][c] = matrizA[f][c] - (factor * matrizA[k][c]);
                }
            }
        }

        System.out.println("\nMatriz ceros abajo y arriba de la diagonal:");
        imprimirFormato(matrizA);

        
        for (int f = 0; f < orden; f++) {
            matrizA[f][orden] = matrizA[f][orden] / matrizA[f][f];
            matrizA[f][f] = 1.0; 
        }

    
        System.out.println("\nMatriz Identidad:");
        imprimirFormato(matrizA);

        System.out.println("\nResultados:");
        for (int f = 0; f < orden; f++) {
            System.out.printf("%-12s = %.0f peces.\n", especies[f], matrizA[f][orden]);
        }
    }

    public static void imprimirFormato(double[][] m) {
        // Línea más larga para cubrir el ancho de los números grandes
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (double[] fila : m) {
            for (double valor : fila) {
    
                if (Math.abs(valor) < 0.001) valor = 0.0;
                System.out.printf("%20.2f ", valor);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}