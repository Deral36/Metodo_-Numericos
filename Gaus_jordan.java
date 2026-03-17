public class Gaus_jordan {

    public static void main(String[] args) {
        // --- DATOS DEL ENCABEZADO ---
        String institucion = "Instituto Tecnológico de Culiacán";
        String carrera = "Ing. En Sistemas";
        String alumno = "Pérez Soto José"; 
        String materia = "Solución de Sistemas de Ecuaciones";
        String horario = "De 10:00 a 11:00 horas.";
        String pregunta = "¿Cuál es la población de cada especie de peces habita el Lago considerando que todo el Alimento Diario se consume?";

        int orden = 4;
        String[] especies = {"Pez Hacha", "Pez Gato", "Pez Mono", "Pez Lagarto"};

        double[][] matrizA = {
            {20, 10,  9,  9, 12500},
            { 8, 18,  6, 14, 13600},
            { 8,  8,  9, 24, 13300},
            { 8,  8, 16, 12, 14400}
        };

        // IMPRESIÓN DEL ENCABEZADO
        System.out.println("\t\t" + institucion);
        System.out.println("\t\t   " + carrera);
        System.out.println("\n" + alumno);
        System.out.println(materia);
        System.out.println(horario);
        System.out.println("\nPregunta: " + pregunta);

        // 1. MATRIZ DE DATOS
        System.out.println("\nMatriz de Datos:");
        imprimirFormato(matrizA);

        // --- PROCESO: CEROS ABAJO ---
        for (int k = 0; k < orden - 1; k++) {
            double piv = matrizA[k][k];
            for (int f = k + 1; f < orden; f++) {
                double eCero = matrizA[f][k];
                for (int c = k; c < orden + 1; c++) {
                    matrizA[f][c] = (piv * matrizA[f][c]) - (eCero * matrizA[k][c]);
                }
            }
        }

        // --- PROCESO: CEROS ARRIBA ---
        for (int k = orden - 1; k >= 1; k--) {
            double piv = matrizA[k][k];
            for (int f = 0; f < k; f++) {
                double factor = matrizA[f][k] / piv;
                for (int c = k; c < orden + 1; c++) {
                    matrizA[f][c] = matrizA[f][c] - (factor * matrizA[k][c]);
                }
            }
        }

        // 2. MATRIZ CON CEROS (LA QUE SE VEÍA DESACOMODADA)
        System.out.println("\nMatriz ceros abajo y arriba de la diagonal:");
        imprimirFormato(matrizA);

        // --- PROCESO: MATRIZ IDENTIDAD ---
        for (int f = 0; f < orden; f++) {
            matrizA[f][orden] = matrizA[f][orden] / matrizA[f][f];
            matrizA[f][f] = 1.0; 
        }

        // 3. MATRIZ IDENTIDAD
        System.out.println("\nMatriz Identidad:");
        imprimirFormato(matrizA);

        // --- RESULTADOS ---
        System.out.println("\nResultados:");
        for (int f = 0; f < orden; f++) {
            System.out.printf("%-12s = %.0f individuos.\n", especies[f], matrizA[f][orden]);
        }
    }

    // EL CAMBIO ESTÁ AQUÍ: Método para que todo quede derecho
    public static void imprimirFormato(double[][] m) {
        // Línea más larga para cubrir el ancho de los números grandes
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (double[] fila : m) {
            for (double valor : fila) {
                // Si el valor es muy cercano a cero (ej. -0.00), lo imprimimos como 0.00 positivo
                if (Math.abs(valor) < 0.001) valor = 0.0;
                
                // %20.2f reserva 20 espacios, suficiente para los -112,000,000,000.00
                System.out.printf("%20.2f ", valor);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}