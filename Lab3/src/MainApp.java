import javax.naming.PartialResultException;
import java.util.List;

public class MainApp
{
    public static void main(String[] args)
    {
        Parabola p1= new Parabola(1,2,3);
        Parabola p2= new Parabola(2,3,4);

        double[] v1 = p1.varf();
        System.out.printf("Vârful lui p1: (%.2f, %.2f)%n", v1[0], v1[1]);
        double[] v2 = p2.varf();
        System.out.printf("Vârful lui p2: (%.2f, %.2f)%n", v2[0], v2[1]);

        double[] m12=p1.mijloc(p2);
        System.out.printf("Mijloc(p1, p2): (%.2f, %.2f)%n", m12[0], m12[1]);







    }
}
