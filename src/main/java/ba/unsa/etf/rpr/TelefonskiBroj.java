package ba.unsa.etf.rpr;

import java.util.Objects;

abstract public class TelefonskiBroj {
    private String ime;
    public abstract String ispisi();
    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
