import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Sportowy extends Samochod {

    private boolean czyKabriolet;

    public Sportowy() {}

    public Sportowy(String marka, String model, String nrSeryjny, LocalDate rokProdukcji) {
        this.setMarka(marka);
        this.setModel(model);
        this.setNrSeryjny(nrSeryjny);
        this.setRokProdukcji(rokProdukcji);
    }

    public boolean isCzyKabriolet() {
        return czyKabriolet;
    }

    public void setCzyKabriolet(boolean czyKabriolet) {
        this.czyKabriolet = czyKabriolet;
    }

    @Override
    public String toString() {
        return "Samochod sportowy{" +
                "id=" + this.getId() +
                ", marka='" + this.getMarka() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", nrSeryjny='" + this.getNrSeryjny() + '\'' +
                ", rokProdukcji=" + this.getRokProdukcji() +
                ", czyKabriolet=" + this.isCzyKabriolet() +
                '}';
    }
}
