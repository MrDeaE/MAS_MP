import java.util.*;

public class Pracownik {

    private int pensja, premia;

    private String imie, nazwisko, nrTelefonu;
    private KierownikZmiany kierownikZmiany;
    private Mechanik mechanik;

    private List<PracownikNaprawa> pracownicyWNaprawie;

    private LinkedHashSet<Samochod> samochodyNaprawiane;

    private static final String phoneRegex = "\\(?([0-9]{3})\\)?[- ]?([0-9]{3})[- ]?([0-9]{3})$";

    public Pracownik(String imie, String nazwisko, int pensja, String nrTelefonu) throws Exception {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.pensja=pensja;
        this.premia=0;
        setNrTelefonu(nrTelefonu);
        this.samochodyNaprawiane = new LinkedHashSet<Samochod>();
        pracownicyWNaprawie = new ArrayList<PracownikNaprawa>();
    }
    public Pracownik(String imie, String nazwisko, int pensja, String nrTelefonu, PracownikType pracownikType) throws Exception {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.pensja=pensja;
        this.premia=0;
        setNrTelefonu(nrTelefonu);
        this.samochodyNaprawiane = new LinkedHashSet<Samochod>();
        if(pracownikType == PracownikType.MECHANIK){
            this.mechanik = new Mechanik(this);
            this.kierownikZmiany = null;
        }
        else if(pracownikType == PracownikType.KIEROWNIKZMIANY){
            this.mechanik = null;
            this.kierownikZmiany = new KierownikZmiany(this);
        }
    }

    // ograniczenie wlasne
    public void setNrTelefonu(String nrTelefonu) throws Exception {
        if(!nrTelefonu.matches(phoneRegex)) {
            throw new Exception("Zły format numeru telefonu - poprawny format: XXX-XXX-XXX lub XXX XXX XXX");
        }
            this.nrTelefonu = nrTelefonu;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getPremia() {
        return premia;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    // atrybut
    public void setPremia(int newPremia) throws Exception {
        if(newPremia > (pensja * maxPremiaChangePercentage/100)){
            throw new Exception("Premia nie może być większa niż "+maxPremiaChangePercentage+"% pensji");
        }
            this.premia = newPremia;
    }

    public final static int maxPremiaChangePercentage = 10;

    public LinkedHashSet<Samochod> getSamochodyNaprawiane(){
        return this.samochodyNaprawiane;
    }

    public void addSamochod(Samochod samochod){
        samochodyNaprawiane.add(samochod);
    }

    public String getPracownikType(){
        if(this.mechanik == null){
            return "mechanik";
        }else{
            return "kierownik zmiany";
        }
    }

    // bag
    public void addPracownikWNaprawie(PracownikNaprawa pracownikNaprawa) {
        if (pracownicyWNaprawie.contains(pracownikNaprawa)) {
            return;
        }
        pracownicyWNaprawie.add(pracownikNaprawa);
    }

    private String getPracownicyWNaprawie() {
        if (pracownicyWNaprawie == null){
            return "brak";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("{naprawa: ");
            for (PracownikNaprawa pracownikNaprawa : pracownicyWNaprawie) {
                sb.append(
                        pracownikNaprawa.getNaprawa().getDataRozpoczecia())
                        .append(", ");
            }
            sb.append(" }");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "pensja=" + pensja +
                ", premia=" + premia +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", pracownikType='" + getPracownikType() + '\'' +
                ", pracownicyWNaprawie=" + getPracownicyWNaprawie() +
                ", samochodyNaprawiane=" + samochodyNaprawiane +
                '}';
    }
}
