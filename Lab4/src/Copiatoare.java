public class Copiatoare extends Echipament
{
    private int p_ton;
    private FormatCopiere format;

    public Copiatoare(String denumire,int nr_inv,int pret,ZonaMag zonaMag,Stare stare,FormatCopiere format, int p_ton)
    {
        super(denumire,nr_inv,zonaMag,stare,pret);
        this.format = format;
        this.p_ton = p_ton;
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public FormatCopiere getFormat() {
        return format;
    }

    public void setFormat(FormatCopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString()+"Copiatoare{" + "p_ton=" + p_ton + ", format=" + format + '}';

    }
}