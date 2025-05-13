package es3;

public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + titolare + " - Saldo: " + saldo +
                " - Num movimenti: " + nMovimenti +
                " - Max movimenti: " + maxMovimenti +
                " - Max prelievo: " + maxPrelievo);
    }

    @Override
    public void preleva(double x) throws BancaException {
        if (x > maxPrelievo) {
            throw new BancaException("Il prelievo non è disponibile");
        }
        super.preleva(x);
    }
}
