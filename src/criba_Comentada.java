import java.util.Scanner;

public class criba_Comentada {

    /**
     * Este programa contiene una clase para generar todos los números primos de 1 hasta un número
     * máximo especificado por el usuario. El algoritmo es simple: Dado un vector de enteros
     * empezando en 2, se tachan todos los múltiplos de 2. A continuación, se encuentra el siguiente
     * entero no tachado y se tachan todos sus múltiplos. El proceso se repite hasta que se pasa de la
     * raíz cuadrada del valor máximo. Todos los números que queden sin tachar son números primos
     * @param max aquí introduciremos el numero al que queremos averiguar cuantos numeros primos tiene
     * @return Devolvera dos cosas, una todos los numeros que recorra empezando por el 1 hasta el numero que
     * hayamos puesto. la segunda aparece los numeros primo de dicho numero.
     */
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
