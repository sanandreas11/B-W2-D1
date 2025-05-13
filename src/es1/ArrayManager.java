package es1;

import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayManager {
    private static final Logger logger = LoggerFactory.getLogger(ArrayManager.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int[] array = new int[5];

        // Inizializzazione array
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10) + 1;
        }

        printArray(array);

        while (true) {
            try {
                System.out.print("Inserisci un numero (0 per uscire): ");
                int value = scanner.nextInt();
                if (value == 0) break;

                System.out.print("Inserisci la posizione (0-4): ");
                int pos = scanner.nextInt();

                array[pos] = value;
                printArray(array);

            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("Indice fuori dai limiti!", e);
                System.out.println("Errore: posizione non valida.");
            } catch (Exception e) {
                logger.error("Errore generico", e);
                System.out.println("Errore generico: " + e.getMessage());
                scanner.next(); // evita loop infinito
            }
        }

        scanner.close();
    }

    private static void printArray(int[] arr) {
        System.out.print("Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}