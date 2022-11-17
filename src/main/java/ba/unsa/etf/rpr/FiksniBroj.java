package ba.unsa.etf.rpr;

import java.util.Objects;

/**
 * One of the classes inheriting the abstract TelefonskiBroj class.
 * Allows the registration of fixed telephone numbers from any of the cantons throughout Bosnia and Herzegovina.
 */

enum Grad{SARAJEVO, ZENICA, TRAVNIK, TUZLA, ORASJE, LIVNO, MOSTAR, BIHAC, GORAZDE, SIROKI_BRIJEG, BRCKO}

public class FiksniBroj extends TelefonskiBroj{
    private String broj;
    private String pozivniBroj;

    private Grad grad;

    public Grad getGrad(){
        return this.grad;
    }

    FiksniBroj(Grad grad, String broj){
        this.broj=broj;
        this.grad=grad;
        switch(grad) {
            case SARAJEVO:
                pozivniBroj="033";
            case ZENICA:
                pozivniBroj="032";
            case TRAVNIK:
                pozivniBroj="030";
            case TUZLA:
                pozivniBroj="035";
            case ORASJE:
                pozivniBroj="031";
            case LIVNO:
                pozivniBroj="034";
            case MOSTAR:
                pozivniBroj="036";
            case BIHAC:
                pozivniBroj="037";
            case GORAZDE:
                pozivniBroj="038";
            case SIROKI_BRIJEG:
                pozivniBroj="039";
            case BRCKO:
                pozivniBroj="049";
        }
    }
    @Override
    public String ispisi(){
        StringBuilder sb = new StringBuilder(pozivniBroj);
        sb.append("/");
        sb.append(broj);
        return sb.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(broj, pozivniBroj);
    }
}
