public class Imprimante extends Echipament
{
    private int ppm;
    private int rezolutie;
    private int p_car;
    private ModTiparire tiparire;


    public Imprimante(String denumire, int nr_inv, int pret, ZonaMag zonaMag, Stare stare, int ppm, String rezolutie, int nr_pag, ModTiparire tiparire)
    {
        super(denumire,nr_inv,zonaMag,stare,pret);
        this.ppm = ppm;

        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public int getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(int rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getTiparire() {
        return tiparire;
    }

    public void setTiparire(ModTiparire tiparire) {
        this.tiparire = tiparire;
    }

    @Override
    public String toString() {
        return super.toString()+"Imprimante{"+
                "ppm=" + ppm +
                ", rezolutie=" + rezolutie +
                ", p_car=" + p_car +
                ", tiparire=" + tiparire +
                '}';
    }
}