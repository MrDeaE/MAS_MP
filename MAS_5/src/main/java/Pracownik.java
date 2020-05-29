import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Pracownik")
public class Pracownik {

    private Long id;
    private String imie, nazwisko;
    private LocalDate dataZatrudnienia;

    private List<Samochod> samochody = new ArrayList<>();

    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Pracownik() {
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    @ManyToMany(mappedBy = "pracownicy", cascade = CascadeType.ALL)
    public List<Samochod> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochod> samochody) {
        this.samochody = samochody;
    }

    public void setSamochod(Samochod samochod) {
        if(!samochody.contains(samochod)) {
            samochody.add(samochod);
            samochod.addPracownik(this);
        } else {
            System.out.println("Person is already connected with this case!");
        }
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", samochody=" + getSamochody() +
                '}';
    }
}
