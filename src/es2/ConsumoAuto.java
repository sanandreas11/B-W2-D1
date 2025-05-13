package es2;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumoAuto {
    private static final Logger logger = LoggerFactory.getLogger(ConsumoAuto.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inserisci km percorsi: ");
            double km = scanner.nextDouble();

            System.out.print("Inserisci litri consumati: ");
            double litri = scanner.nextDouble();

            if (litri == 0) {
                throw new ArithmeticException("Divisione per zero non ammessa.");
            }

            double consumo = km / litri;
            System.out.printf("Consumo: %.2f km/litro%n", consumo);

        } catch (ArithmeticException e) {
            logger.error("Errore: divisione per zero", e);
            System.out.println("Errore: hai inserito 0 come litri consumati.");
        } catch (Exception e) {
            logger.error("Errore generico", e);
            System.out.println("Errore: input non valido.");
        }

        scanner.close();
    }
}