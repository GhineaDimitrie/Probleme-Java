class Parabola
{
    private final int a;
    private final int b;
    private final int c;

    public Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] varf()
    {
        double xv=-b/(2.0*a);
        double yv=(-(b*b)+4.0*a*c)/(4.0*a);

        return new double[] {xv,yv};
    }

    public double[] mijloc(Parabola p)
    {
        double[] v1=this.varf();
        double[] v2=p.varf();

        double xm=(v1[0]+v2[0])/2.0;
        double ym=(v1[1]+v2[1])/2.0;
        return new double[] {xm,ym};


    }



    public  String toString()
    {
        return "f(x)="+a+"x^2+"+b+"x"+"+c";
    }


}
