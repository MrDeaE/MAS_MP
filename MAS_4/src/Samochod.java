import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Samochod {

    String marka, model, nrSeryjny;
    Calendar rokProdukcji;

    private static Map<String, Samochod> samochody = new HashMap<String, Samochod>();

    public Samochod(String marka, String model, String nrSeryjny, Calendar rokProdukcji) throws Exception{
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        setNrSeryjny(nrSeryjny);
    }

    public String getModel() {
        return model;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(String nrSeryjny) throws Exception {
        if(samochody.containsKey(nrSeryjny)) {
            throw new Exception("Numer seryjny już zajęty");
        }
        this.nrSeryjny = nrSeryjny;
        samochody.put(nrSeryjny, this);
    }

    public String getRokProdukcji(){
        if (rokProdukcji==null){
            return "brak";
        } else{
//            return String.format("%1$te.%1$tm.%1$tY", this.rokProdukcji);
            return String.format("%1$tY", this.rokProdukcji);
        }
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", nrSeryjny='" + nrSeryjny + '\'' +
                ", rokProdukcji=" + getRokProdukcji() +
                '}';
    }
}
