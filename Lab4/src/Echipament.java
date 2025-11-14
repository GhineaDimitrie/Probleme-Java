public class Echipament
{
    private String denumire;
    private int nr_inv;
    private int pret;
    private ZonaMag zona;
    private Stare stare;


    public Echipament(String denumire, int nr_inv, ZonaMag zona, Stare stare, int pret) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.zona = zona;
        this.stare = stare;
        this.pret = pret;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public void setNr_inv(int nr_inv) {
        this.nr_inv = nr_inv;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    public ZonaMag getZona() {
        return zona;
    }

    public void setZona(ZonaMag zona) {
        this.zona = zona;
    }
}
