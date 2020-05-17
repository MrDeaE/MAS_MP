public class Mechanik {

    private Pracownik pracownik;

    public Mechanik(Pracownik pracownik) throws Exception {
        if(pracownik == null)
            throw new Exception("Część nie istnieje bez całości");
        this.pracownik=pracownik;
    }

}
