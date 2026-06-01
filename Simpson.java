import java.util.Scanner;

public class Simpson {

    static Scanner sc = new Scanner(System.in);

    
    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("        Instituto Tecnologico de Culiacan");
        System.out.println("        Ing. en Sistemas Computacionales");
        System.out.println("        Perez Rojas Angel Eduardo");
        System.out.println("        Metodo de Simpson");
        System.out.println("        De 10:00 a 11:00 horas.");
        System.out.println();
        System.out.println("  Este programa ejecuta el proceso de calculo sobre el tema");
        System.out.println("  de derivacion e integracion numerica utilizando las 4 reglas de Simpson.");
         System.out.print("Cual es la pregunta del Problema: ");
        String pregunta = sc.nextLine();

        System.out.print("Valor Real de la Integral: ");
        double Vreal = sc.nextDouble();

        System.out.print("Valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Valor de b: ");
        double b = sc.nextDouble();

        sc.nextLine();
        System.out.print("Unidad: ");
        String unidad = sc.nextLine();


        int N3 = 0;
    do {
    System.out.print("Capture el Numero de Divisiones para la regla 3: ");
    N3 = sc.nextInt();
    } while (!(N3 > 2 && N3 % 2 == 0));

    int N4 = 0;
    do {
    System.out.print("Capture el Numero de Divisiones para la regla 4: ");
    N4 = sc.nextInt();
    } while (!(N4 > 3 && N4 % 2 != 0 && N4 % 3 == 0));

        System.out.println("============================================================");
        System.out.println();
        System.out.println("Metodo de las Reglas de Simpson");
        System.out.println("  * Regla 1 : n=2");
        System.out.println("  * Regla 2 : n=3");
        System.out.println("  * Regla 3 : n>2 y n=par");
        System.out.println("  * Regla 4 : n>3, n=impar y n=multiplo de 3");
        System.out.println();

       
        int n1 = 2;
        double h, fa, fb, x1, x2, fx1, fx2, Vcalc, Error;

        h     = (b - a) / n1;
        fa    = 40 + 8 * Math.sqrt(a);
        x1    = a + h;
        fx1   = 40 + 8 * Math.sqrt(x1);
        fb    = 40 + 8 * Math.sqrt(b);
        Vcalc = ((1.0 * h) / 3) * (fa + (4 * fx1) + fb);
        Error = Math.abs(Vreal - Vcalc);

        System.out.println("============================================================");
        System.out.println("        Instituto Tecnologico de Culiacan");
        System.out.println("        Ing. en Sistemas Computacionales");
        System.out.println("        Perez Rojas Angel Eduardo");
        System.out.println("        Metodo de Simpson.");
        System.out.println("        Regla aplicada para Simpson de 1/3 para n=2.");
        System.out.println("        De 10:00 a 11:00 horas.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Pregunta: " + pregunta);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %10s %12s %8s %15s%n", "Pxy", "x", "f(x)", "Factor", "f(x)*Factor");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 1, a,  fa,  1, 1 * fa);
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 2, x1, fx1, 4, 4 * fx1);
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 3, b,  fb,  1, 1 * fb);
        System.out.println("------------------------------------------------------------");
        System.out.printf("Area Simpson 1/3= %.5f%n", Vcalc);
        System.out.printf("No. de Divisiones= %d%n", n1);
        System.out.printf("Valor Real de la Integral= %.5f %s%n", Vreal, unidad);
        System.out.printf("Valor por el Metodo      = %.5f %s%n", Vcalc, unidad);
        System.out.printf("Error del Metodo         = %.5f %s%n", Error, unidad);

        int n2 = 3;

        h     = (b - a) / n2;
        fa    = 40 + 8 * Math.sqrt(a);
        x1    = a + (1 * h);
        x2    = a + (2 * h);
        fx1   = 40 + 8 * Math.sqrt(x1);
        fx2   = 40 + 8 * Math.sqrt(x2);
        fb    = 40 + 8 * Math.sqrt(b);
        Vcalc = ((3.0 * h) / 8) * (fa + (3 * fx1) + (3 * fx2) + fb);
        Error = Math.abs(Vreal - Vcalc);

        System.out.println("============================================================");
        System.out.println("        Instituto Tecnologico de Culiacan");
        System.out.println("        Ing. en Sistemas Computacionales");
        System.out.println("        Perez Rojas Angel Eduardo");
        System.out.println("         Metodo de Simpson.");
        System.out.println("        Regla aplicada para Simpson de 3/8 para n=3.");
        System.out.println("        De 10:00 a 11:00 horas.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Pregunta: " + pregunta);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %10s %12s %8s %15s%n", "Pxy", "x", "f(x)", "Factor", "f(x)*Factor");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 1, a,  fa,  1, 1 * fa);
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 2, x1, fx1, 3, 3 * fx1);
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 3, x2, fx2, 3, 3 * fx2);
        System.out.printf("%-6d %10.5f %12.5f %8d %15.5f%n", 4, b,  fb,  1, 1 * fb);
        System.out.println("------------------------------------------------------------");
        System.out.printf("Area Simpson 3/8= %.5f%n", Vcalc);
        System.out.printf("No. de Divisiones= %d%n", n2);
        System.out.printf("Valor Real de la Integral= %.5f %s%n", Vreal, unidad);
        System.out.printf("Valor por el Metodo      = %.5f %s%n", Vcalc, unidad);
        System.out.printf("Error del Metodo         = %.5f %s%n", Error, unidad);

        Vcalc = 0;
        h = (b - a) / N3;
        double ca = a;
        double cb = b;

        System.out.println("============================================================");
        System.out.println("        Instituto Tecnologico de Culiacan");
        System.out.println("        Ing. en Sistemas Computacionales");
        System.out.println("        Perez Rojas Angel Eduardo");
        System.out.println("         Metodo de Simpson.");
        System.out.println("        Regla aplicada para Simpson de 1/3 formula compleja, n=" + N3 + ".");
        System.out.println("        De 10:00 a 11:00 horas.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Pregunta: " + pregunta);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %10s %12s %8s %15s%n", "Pxy", "x", "f(x)", "Factor", "f(x)*Factor");
        System.out.println("------------------------------------------------------------");

        for (int x = 1; x <= N3 + 1; x++) {
            double factor, pto, fpto, valor;

            if (x == 1) {
                factor = 1;
                pto    = ca;
                fpto   = 40 + 8 * Math.sqrt(pto);
                valor  = factor * fpto;
                Vcalc  = Vcalc + valor;
                System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", x, pto, fpto, factor, valor);

            } else if (x == N3 + 1) {
                factor = 1;
                pto    = cb;
                fpto   = 40 + 8 * Math.sqrt(pto);
                valor  = factor * fpto;
                Vcalc  = Vcalc + valor;
                System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", x, pto, fpto, factor, valor);

            } else {
                int pos = x - 1;
                int res = pos % 2;

                if (res != 0) {
                    factor = 4;
                    pto    = ca + (pos * h);
                    fpto   = 40 + 8 * Math.sqrt(pto);
                    valor  = factor * fpto;
                    Vcalc  = Vcalc + valor;
                    System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", x, pto, fpto, factor, valor);
                } else {
                    factor = 2;
                    pto    = ca + (pos * h);
                    fpto   = 40 + 8 * Math.sqrt(pto);
                    valor  = factor * fpto;
                    Vcalc  = Vcalc + valor;
                    System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", x, pto, fpto, factor, valor);
                }
            }
        }

        Vcalc = (1.0 * h / 3) * Vcalc;
        Error = Math.abs(Vreal - Vcalc);

        System.out.println("------------------------------------------------------------");
        System.out.printf("Area Simpson 1/3 compleja= %.5f%n", Vcalc);
        System.out.printf("No. de Divisiones= %d%n", N3);
        System.out.printf("Valor Real de la Integral= %.5f %s%n", Vreal, unidad);
        System.out.printf("Valor por el Metodo      = %.5f %s%n", Vcalc, unidad);
        System.out.printf("Error del Metodo         = %.5f %s%n", Error, unidad);   

        Vcalc = 0;
        h  = (b - a) / N4;
        ca = a;
        cb = b;

        System.out.println("============================================================");
        System.out.println("        Instituto Tecnologico de Culiacan");
        System.out.println("        Ing. en Sistemas Computacionales");
        System.out.println("        Perez Rojas Angel Eduardo");
        System.out.println("         Metodo de Simpson.");
        System.out.println("        Regla aplicada para Simpson de 3/8 formula compleja, n=" + N4 + ".");
        System.out.println("        De 10:00 a 11:00 horas.");
        System.out.println("------------------------------------------------------------");
        System.out.println("Pregunta: " + pregunta);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %10s %12s %8s %15s%n", "Pxy", "x", "f(x)", "Factor", "f(x)*Factor");
        System.out.println("------------------------------------------------------------");

        for (int xx = 1; xx <= N4 + 1; xx++) {
            double factor, pto, fpto, valor;

            if (xx == 1) {
                factor = 1;
                pto    = ca;
                fpto   = 40 + 8 * Math.sqrt(pto);
                valor  = factor * fpto;
                Vcalc  = Vcalc + valor;
                System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", xx, pto, fpto, factor, valor);

            } else if (xx == N4 + 1) {
                factor = 1;
                pto    = cb;
                fpto   = 40 + 8 * Math.sqrt(pto);
                valor  = factor * fpto;
                Vcalc  = Vcalc + valor;
                System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", xx, pto, fpto, factor, valor);

            } else {
                int pos = xx - 1;
                int res = (xx - 1) % 3;

                if (res == 0) {
                    factor = 2;
                    pto    = ca + (pos * h);
                    fpto   = 40 + 8 * Math.sqrt(pto);
                    valor  = factor * fpto;
                    Vcalc  = Vcalc + valor;
                    System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", xx, pto, fpto, factor, valor);
                } else {
                    factor = 3;
                    pto    = ca + (pos * h);
                    fpto   = 40 + 8 * Math.sqrt(pto);
                    valor  = factor * fpto;
                    Vcalc  = Vcalc + valor;
                    System.out.printf("%-6d %10.5f %12.5f %8.0f %15.5f%n", xx, pto, fpto, factor, valor);
                }
            }
        }

        Vcalc = (3.0 * h / 8) * Vcalc;
        Error = Math.abs(Vreal - Vcalc);

        System.out.println("------------------------------------------------------------");
        System.out.printf("Area Simpson 3/8 compleja= %.5f%n", Vcalc);
        System.out.printf("No. de Divisiones= %d%n", N4);
        System.out.printf("Valor Real de la Integral= %.5f %s%n", Vreal, unidad);
        System.out.printf("Valor por el Metodo      = %.5f %s%n", Vcalc, unidad);
        System.out.printf("Error del Metodo         = %.5f %s%n", Error, unidad);

        System.out.println();
    }
}
