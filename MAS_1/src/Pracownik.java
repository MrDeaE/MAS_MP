import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// atr pochodny(wyliczalny) nie powinien miec zadeklarowanej zmiennej
// premie to art prosty i nie powinien byc jako opcjonalny - zrobic przyklad na dacie zwolnienia gdzie bedzie defaultowo null a nie 0
// zrobic 'ciekawa biznesowo' metode klasowa a nie po prostu wyswietlanie ekstensji

class Pracownik implements Serializable {

    static int numberOfrecords = 0;
    int id = 0; // unikalne id
    String imie, nazwisko, nrTelefonu;
    static int pensja = 4000; // atr. klasowy, podana brutto
    static Double podatek = 0.3; // atr. klasowy
    int premia; // atr. opcjonalny
    Date dataZatrudnienia;
    Date dataZwolnienia; // atr. opcjonalny
    Double pensjaNetto; // atr. pochodny

    private static ArrayList<Pracownik> ekstensja = new ArrayList<>(); // ekstensja

    public static List<Uprawnienia> uprawnienia = new ArrayList<>(); // atr. powtarzalny

    public Pracownik(String imie, String nazwisko, Date dataZatrudnienia){
        id = ++numberOfrecords;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataZatrudnienia=dataZatrudnienia;
        dodajPracownika(this);
    }

    public Pracownik(String imie, String nazwisko, Date dataZatrudnienia, String nrTelefonu){
        id = ++numberOfrecords;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataZatrudnienia=dataZatrudnienia;
        this.nrTelefonu=nrTelefonu;
        dodajPracownika(this);
    }

    private void dodajPracownika(Pracownik pracownik){
        ekstensja.add(pracownik);
    }

    private void usunPracownika(Pracownik pracownik){
        ekstensja.remove(pracownik);
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException
    {
        stream.writeObject(ekstensja);
    }

    public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException
    {
        ekstensja = (ArrayList) stream.readObject();
    }

    // metoda klasowa
    public static void pokazEkstensje() {
        System.out.println("Ekstensja klasy: " + Pracownik.class.getName());
        for (Pracownik pracownik : ekstensja) {
            System.out.println(pracownik);
        }
    }

    public static ArrayList<Pracownik> getList(){
        return ekstensja;
    }

    public static Pracownik getByIndex(int index){
        return ekstensja.get(index);
    }

    // atr. pochodny
    public Double getPensjaNetto(){
        pensjaNetto = pensja*(1-podatek);
        return pensjaNetto;
    }

    @Override
    public String toString(){
        return "Pracownik: " + id+ ": " + imie + " " + nazwisko + " - data zatrudnienia: " + dataZatrudnienia + ", nr telefonu: " + nrTelefonu + ", pensja: " + pensja + ", data zwolnienia: "+dataZwolnienia;
    }

}

class Uprawnienia{
    int id;
    String nazwa;
    public Uprawnienia(int id, String nazwa){
        this.id=id;
        this.nazwa=nazwa;
    }
    @Override
    public String toString(){
        return id + ": "+nazwa;
    }
}

class KierownikZmiany extends Pracownik{

    static int pensja = 6000;

    public KierownikZmiany(String imie, String nazwisko, Date dataZatrudnienia, String nrTelefonu){
        super(imie, nazwisko, dataZatrudnienia, nrTelefonu);
    }

    @Override
    public String toString(){
        return "Kierownik zmiany: " + id + ": " + imie + " " + nazwisko + " - data zatrudnienia: " + dataZatrudnienia + ", nr telefonu: " + nrTelefonu + ", pensja: " + pensja + ", data zwolnienia: "+dataZwolnienia;
    }

}
