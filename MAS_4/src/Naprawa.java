import java.util.*;

public class Naprawa {

    Calendar dataRozpoczecia;

    private List<PracownikNaprawa> pracownicyWNaprawie;

    public Naprawa(Calendar dataRozpoczecia){
        this.dataRozpoczecia=dataRozpoczecia;
        pracownicyWNaprawie = new ArrayList<PracownikNaprawa>();
    }

    public String getDataRozpoczecia(){
        if (dataRozpoczecia==null){
            return "brak";
        } else{
            return String.format("%1$te.%1$tm.%1$tY", this.dataRozpoczecia);
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
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (PracownikNaprawa pracownikNaprawa: pracownicyWNaprawie) {
            sb.append(
                    pracownikNaprawa.getPracownik().getImie())
                    .append(" ")
                    .append(pracownikNaprawa.getPracownik().getNazwisko())
                    .append(", data przydzielenia: ")
                    .append(pracownikNaprawa.getDataPrzydzielenia())
                    .append(", ");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Naprawa{" +
                "dataRozpoczecia=" + getDataRozpoczecia() +
                ", pracownicyWNaprawie=" + getPracownicyWNaprawie() +
                '}';
    }
}
