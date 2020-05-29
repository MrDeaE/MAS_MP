import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Sportowy sportowy1 = new Sportowy("Toyota", "Supra", "s2", LocalDate.now());
            sportowy1.setCzyKabriolet(true);
            Miejski miejski1 = new Miejski("Ford", "Focus", "s1", LocalDate.now());
            miejski1.setKlasaPojazdu('a');


            Pracownik pracownik1 = new Pracownik("Wojciech", "Korfanty");
            pracownik1.setDataZatrudnienia(LocalDate.now());
            Pracownik pracownik2 = new Pracownik("Józef", "Piłsudski");
            pracownik2.setDataZatrudnienia(LocalDate.now());

            pracownik1.setSamochod(sportowy1);
            miejski1.addPracownik(pracownik2);


            session.save(pracownik1);
            session.save(pracownik2);
            session.save(sportowy1);
            session.save(miejski1);
            session.getTransaction().commit();

            // print
            session.beginTransaction();

            List<Samochod> samochody = session.createQuery("from Samochod").list();
            for (Samochod samochod : samochody) {
                System.out.println(samochod);
            }

            List<Pracownik> pracownicy = session.createQuery("from Pracownik").list();
            for (Pracownik pracownik : pracownicy) {
                System.out.println(pracownik);
            }

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }

        }
    }

}
