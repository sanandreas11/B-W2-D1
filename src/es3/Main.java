package es3;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ContoCorrente conto1 = new ContoCorrente("Mario", 100.0);
        ContoOnLine conto2 = new ContoOnLine("Luigi", 200.0, 70.0);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Quanto vuoi prelevare da Mario? ");
                double x = scanner.nextDouble();
                conto1.preleva(x);
                System.out.println("Saldo Mario: " + conto1.restituisciSaldo());
            } catch (BancaException e) {
                logger.error("Errore conto Mario", e);
                System.out.println("Errore: " + e.getMessage());
            }
        }

        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Quanto vuoi prelevare da Luigi? ");
                double x = scanner.nextDouble();
                conto2.preleva(x);
                conto2.stampaSaldo();
            } catch (BancaException e) {
                logger.error("Errore conto Luigi", e);
                System.out.println("Errore: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
