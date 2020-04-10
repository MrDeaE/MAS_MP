import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    static File file = new File("./src/data/extent.data");

    public static void main(String[] args) {

        if(!file.exists()) {
            new Pracownik("Jan", "Kowalski", new Date(2000, 12, 11));
            new Pracownik("Adam", "Kowalski", new Date(2001, 11, 1), "123 123 123");
            new Pracownik("Michał", "Kowalski", new Date(2002, 3, 20));
            new Pracownik("Mieczysław", "Kowalski", new Date(2010, 1, 30), "123 123 123");

            new KierownikZmiany("Stanisław", "Mazur", new Date(2010, 10, 5), "321321321");
            new KierownikZmiany("Wojciech", "Kulesza", new Date(2011, 1, 15), "321321321");

        } else {
           // odczyt z pliku
            try{
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(file));

            Pracownik.odczytajEkstensje(objectInputStream);

            objectInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // wyswietlanie calej ekstensji
        Pracownik.pokazEkstensje();

        System.out.println("\nPensja brutto pracownika: "+ Pracownik.pensja);
        System.out.println("Wyliczenie pensji netto pracownika: " + Pracownik.getByIndex(0).getPensjaNetto());

        System.out.println("Premia dla Adama Kowalskiego: " + Pracownik.getByIndex(1).premia);
        Pracownik.getByIndex(0).premia = 100;
        System.out.println("Premia dla Jana Kowalskiego: " + Pracownik.getByIndex(0).premia);

        // przyznanie uprawnien pracownikowi
        Uprawnienia u1 = new Uprawnienia(1, "Spreżarka");
        Uprawnienia u2 = new Uprawnienia(2, "Ciężkie maszyny");
        ArrayList<Uprawnienia> uprawnienia = new ArrayList<>();
        uprawnienia.add(u1);
        uprawnienia.add(u2);
        Pracownik.getByIndex(0).uprawnienia = uprawnienia;
        System.out.println("Uprawnienia Jana Kowalskiego: "+Pracownik.getByIndex(0).uprawnienia);


        // zapisywanie do pliku
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(file));
            Pracownik.zapiszEkstensje(objectOutputStream);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
