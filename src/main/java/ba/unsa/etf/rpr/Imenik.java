package ba.unsa.etf.rpr;

import java.util.*;

/**
 * Class representing a phonebook
 */
public class Imenik {

    private Map<String, TelefonskiBroj> brojevi;

    public Imenik() {
        this.brojevi = new HashMap<String, TelefonskiBroj>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        this.brojevi.put(ime, broj);
    }

    public String dajBroj(String ime) {
        TelefonskiBroj broj = this.brojevi.get(ime);
        return broj.ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getValue().ispisi().equals(broj.ispisi())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char s) {
        int i = 1;
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getKey().startsWith(String.valueOf(s))) {
                builder.append(i).append(". ").append(entry.getKey()).append(" - ").append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
                i++;
            }
        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> spisak = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                if (((FiksniBroj) entry.getValue()).getGrad().equals(g)) {
                    spisak.add(entry.getKey());
                }
            }
        }
        return spisak;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> spisak = new TreeSet<>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj t1, TelefonskiBroj t2) {
                return t1.ispisi().compareTo(t2.ispisi());
            }
        });
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                if (((FiksniBroj) entry.getValue()).getGrad().equals(g)) {
                    spisak.add(entry.getValue());
                }
            }
        }
        return spisak;
    }

    @Override
    public String toString(){
        int i = 1;
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            builder.append(i).append(". ").append(entry.getKey()).append(" - ").append(entry.getValue().ispisi())
                    .append(System.lineSeparator());
            i++;
        }
        return builder.toString();
    }
}
