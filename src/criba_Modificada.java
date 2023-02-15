import java.util.Scanner;

public class criba_Modificada {

    public static int[] generarPrimos(int max) {
        int i = 0;
        int j = 0;

        if (max >= 2) {
            int dim = max + 1;

            boolean[] esPrimo = new boolean[dim];

            for (i = 0; i < dim; i++){
                esPrimo[i] = true;}
            esPrimo[0] = esPrimo[1] = false;

            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    for (j = 2 * i; j < dim; j += i){
                        esPrimo[j] = false;}
                }
            }

            int cuenta = 0;

            for (i = 0; i < dim; i++) {
                if (esPrimo[i]){
                    cuenta++;}
            }

            int[] primos = new int[cuenta];

            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i]){
                    primos[j++] = i;}
            }
            return primos;
        } else {
            return new int[0];

        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número para la criba de Erastótenes:");

        int dato = teclado.nextInt();
        int vector[] = new int[dato];

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        System.out.println("");
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta " + dato + " son: ");
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}
