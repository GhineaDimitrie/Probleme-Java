import javax.swing.plaf.SeparatorUI;

public class SistemeCalc extends Echipament
{
    private TipMonitor tipMonitor;
    private int vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemeCalc(String denumire,int nr_inv,int pret,ZonaMag zonaMag,Stare stare,TipMonitor tipMonitor, int vit_proc, int c_hdd, SistemOperare sistemOperare)
    {
        super(denumire,nr_inv,zonaMag,stare,pret);
        this.tipMonitor = tipMonitor;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }


    public TipMonitor getTipMonitor() {
        return tipMonitor;
    }

    public void setTipMonitor(TipMonitor tipMonitor) {
        this.tipMonitor = tipMonitor;
    }

    public int getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(int vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }
}
