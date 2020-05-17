public class KierownikZmiany {
    private Pracownik pracownik;

    public KierownikZmiany(Pracownik pracownik) throws Exception {
        if(pracownik == null)
            throw new Exception("Część nie istnieje bez całości");
        this.pracownik=pracownik;
    }

}
