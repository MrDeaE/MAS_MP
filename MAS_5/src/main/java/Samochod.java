import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Samochod")
@Inheritance(strategy = InheritanceType.JOINED)
public class Samochod {

    private Long id;
    private String marka, model, nrSeryjny;
    private LocalDate rokProdukcji;

    private List<Pracownik> pracownicy = new ArrayList<>();

    public Samochod() {
    }

    public Samochod(String marka, String model, String nrSeryjny, LocalDate rokProdukcji) {
        this.marka = marka;
        this.model = model;
        this.nrSeryjny = nrSeryjny;
        this.rokProdukcji = rokProdukcji;
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
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Basic
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(String nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }

    @Basic(optional = true)
    public LocalDate getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(LocalDate rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public void addPracownik(Pracownik pracownik) {
        if(!pracownicy.contains(pracownik)) {
            pracownicy.add(pracownik);
            pracownik.setSamochod(this);
        } else {
            System.out.println("CriminalCase is already in use!");
        }
    }



    @Override
    public String toString() {
        return "Samochod{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", nrSeryjny='" + nrSeryjny + '\'' +
                ", rokProdukcji=" + rokProdukcji +
                '}';
    }
}
