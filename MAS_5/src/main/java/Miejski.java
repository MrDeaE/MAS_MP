import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Miejski extends Samochod {

    private char klasaPojazdu;

    public Miejski() {}

    public Miejski(String marka, String model, String nrSeryjny, LocalDate rokProdukcji) {
         this.setMarka(marka);
         this.setModel(model);
         this.setNrSeryjny(nrSeryjny);
         this.setRokProdukcji(rokProdukcji);
    }

    public char getKlasaPojazdu() {
        return klasaPojazdu;
    }

    public void setKlasaPojazdu(char klasaPojazdu) {
        this.klasaPojazdu = klasaPojazdu;
    }

    @Override
    public String toString() {
        return "Samochod miejski{" +
                "id=" + this.getId() +
                ", marka='" + this.getMarka() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", nrSeryjny='" + this.getNrSeryjny() + '\'' +
                ", rokProdukcji=" + this.getRokProdukcji() +
                ", klasaPojazdu=" + this.getKlasaPojazdu() +
                '}';
    }
}
