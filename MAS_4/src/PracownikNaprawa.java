import java.util.*;

public class PracownikNaprawa {

    Calendar dataPrzydzielenia;
    Pracownik pracownik;
    Naprawa naprawa;

    private static List<PracownikNaprawa> pracownicyWNaprawie = new ArrayList<PracownikNaprawa>();

    public PracownikNaprawa(Pracownik pracownik, Naprawa naprawa) {
        this.pracownik=pracownik;
        this.naprawa=naprawa;
        pracownik.addPracownikWNaprawie(this);
        naprawa.addPracownikWNaprawie(this);
    }

    public PracownikNaprawa(Pracownik pracownik, Naprawa naprawa, Calendar dataPrzydzielenia) {
        this.pracownik=pracownik;
        this.naprawa=naprawa;
        this.dataPrzydzielenia = dataPrzydzielenia;
        pracownik.addPracownikWNaprawie(this);
        naprawa.addPracownikWNaprawie(this);
    }

    public static List<PracownikNaprawa> getPracownicyWNaprawie() {
        return pracownicyWNaprawie;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Naprawa getNaprawa() {
        return naprawa;
    }

    public String getDataPrzydzielenia(){
        if (dataPrzydzielenia==null){
            return "brak";
        } else{
            return String.format("%1$te.%1$tm.%1$tY", this.dataPrzydzielenia);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownikNaprawa pracownikNaprawa = (PracownikNaprawa) o;

        if (!Objects.equals(naprawa, pracownikNaprawa.naprawa)) return false;
        if (!Objects.equals(pracownik, pracownikNaprawa.pracownik)) return false;

        return Objects.equals(dataPrzydzielenia, pracownikNaprawa.dataPrzydzielenia);
    }

    @Override
    public String toString() {
        return "PracownikNaprawa{" +
                "dataPrzydzielenia=" + getDataPrzydzielenia() +
                ", pracownik=" + pracownik +
                ", naprawa=" + naprawa +
                '}';
    }
}
