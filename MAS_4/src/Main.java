import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        // atrybut: pracowniki jego premia
        // unique: nr seryjny samochodu musi byc unikalny
        // subset
        // ordered: lista samochodow w kolejnosci dodania
        // bag: pracownik moze byc przypisany jednej naprawie kilka razy
        // xor: pracownik moze byc albo mechanikiem albo kierownikiem zmiany
        // ograniczenie wlasne: sprawdzanie formatu numeru telefonu

        // zle: subset - brak
        // ordered: brak polaczenia zwrotnego - po prostu zapamietuje liste w pracowniku ale jeszcze powinienem w samochodzie
        // xor: zwykle dziedziczenie zamiast sie trudzic z enumami itd

        Calendar c = Calendar.getInstance();
        c.set(2016, 3, 11);

        // atrybut: premia pracownika
        System.out.println("\tAtrybut");
        try {
            Pracownik p1 = new Pracownik("Jan", "Kowalski", 3000, "123 123 123");
            p1.setPremia(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Pracownik p1 = new Pracownik("Jan", "Kowalski", 3000, "123 123 123");
            p1.setPremia(300);
            p1.setPremia(200);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // unique: samochod o unikalnym nr seryjnym
        System.out.println("\tUnique");
        try{
            Samochod s1 = new Samochod("Toyota", "Celica", "s1234", c);
            Samochod s2 = new Samochod("Toyota", "Celica", "s1234", c);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // subset: grupa pracownikow - jeden z nich jest kierownikiem
        System.out.println("\tSubset");

        // ordered: samochod - pracownik: naprawiane samochody w kolejnosci dodawania
        System.out.println("\tOrdered");

        try {
            Samochod s1 = new Samochod("Toyota", "Celica", "s1111", c);
            Samochod s2 = new Samochod("Toyota", "Supra", "s1112", c);
            Samochod s3 = new Samochod("Toyota", "Prius", "s1113", c);
            Pracownik p1 = new Pracownik("Jan", "Kowalski", 3000, "123-123-123");

            p1.addSamochod(s1);
            p1.addSamochod(s3);
            p1.addSamochod(s2);

            System.out.println(p1);
            for(Samochod s : p1.getSamochodyNaprawiane())
                System.out.println(s.getModel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // bag: PracownikNaprawa: polaczenie pracownika z naprawa, trzymajace date rozpoczecia
        // ponowne przydzielenie pracownika do tej samej naprawy ale z inna data
        System.out.println("\tBag");

        try {
            Pracownik p1 = new Pracownik("Jan", "Kowalski", 3000, "123-123-123");
            Pracownik p2 = new Pracownik("Janina", "Kowalski", 3000, "123-123-123");
            Naprawa n1 = new Naprawa(c);

            PracownikNaprawa pn1 = new PracownikNaprawa(p1, n1, c);
            c.set(2016, 8, 13);
            PracownikNaprawa pn2 = new PracownikNaprawa(p1, n1, c);
            System.out.println(pn1);
            System.out.println(pn2);
            System.out.println(p1);
            System.out.println(n1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // xor
        System.out.println("\tXor");

        try{
            Pracownik p1 = new Pracownik("Jan", "Kowalski", 3300, "111-111-111", PracownikType.MECHANIK);
            Pracownik p2 = new Pracownik("Janina", "Kowalska", 3300, "111-111-111", PracownikType.KIEROWNIKZMIANY);
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // ograniczenie wlasne
        System.out.println("\tOgraniczenie wlasne");

        try{
            Pracownik p2 = new Pracownik("Jan", "Kowalski", 3500, "123 456 789");
            System.out.println(p2);
            Pracownik p3 = new Pracownik("Jan", "Kowalski", 3500, "1aaa2322456789");
            System.out.println(p3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
