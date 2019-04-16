package com.med.mdvfd2;

public class VFSolver extends ASolver {


    @Override
    public Vectorizable solve(int n, Function g, Function f, boolean multiThreading) throws MDVFException {
        if (n>0) {
            int iter = 5000;
            final int th_pas = 100;
            int k = 0;

            final double h = 1./(n+1);

            Pair[] volumes = ASolver.getVolumes(n);
            Pair[] volumesPoints = ASolver.getVolumesPoints(n);

            Vector u = new Vector((n+1)*(n+1));
            while (k<iter) {
                if (multiThreading) {
                    (new Thread() {
                        @Override
                        public void run() {
                            for (int i = 0; i<th_pas; i++)
                                apply(volumesPoints, volumes, n, h, u, g, f);
                        }
                    }).start();
                    k+=th_pas;

                }
                else {
                    apply(volumesPoints, volumes, n, h, u, g, f);
                    k++;
                }
            }
            return u;
        }
        else
            throw new MDVFException("Le nombre n est négatif");
    }

    private void apply(Pair[] volumesPoints, Pair[] volumes, int n,double h, Vectorizable u, Function g, Function f) {
        for (int p = 0; p<u.size(); p++) {
            int i = p%(n+1);
            int j = (p-i)/(n+1);

            int i0 = i+1;
            int j0 = j+1;

            //System.out.println( volumes[i0-1+(j0-1)*(n+2)].x()+";"+volumes[i0-1+(j0-1)*(n+2)].y() + " --- "+ volumes[i0+(j0-1)*(n+2)].x()+";"+volumes[i0+(j0-1)*(n+2)].y()  +" --- "+volumes[i0+(j0)*(n+2)].x()+";"+volumes[i0+(j0)*(n+2)].y() +" --- "+volumes[i0-1+(j0)*(n+2)].x()+";"+volumes[i0-1+(j0)*(n+2)].y() );

            double d1;
            double d2;
            double d3;
            double d4;

            double h1;
            double h2;
            double h3;
            double h4;
            double h0;
            if (i0-1 == 0)
                d1 = g.calcul(volumesPoints[j0*(n+3)].x() ,volumesPoints[j0*(n+3)].y());
            else
                d1 = u.get(i-1+j*(n+1));
            h1 = volumesPoints[i0+j0*(n+3)].x() - volumesPoints[i0-1+j0*(n+3)].x();
            d1 /= h1;

            if (j0-1 == 0)
                d2 = g.calcul(volumesPoints[i0].x(), volumesPoints[i0].y() );
            else
                d2 = u.get(i+(j-1)*(n+1));
            h2 = volumesPoints[i0+j0*(n+3)].y() - volumesPoints[i0+(j0-1)*(n+3)].y();
            d2 /= h2;


            if (i0+1 == n+2)
                d3 = g.calcul(volumesPoints[i0+1+j0*(n+3)].x(), volumesPoints[i0+1+j0*(n+3)].y() );
            else
                d3 = u.get(i+1+j*(n+1));
            h3 = volumesPoints[i0+1+j0*(n+3)].x() - volumesPoints[i0+j0*(n+3)].x();
            d3 /= h3;

            if (j0+1 == n+2)
                d4 = g.calcul(volumesPoints[i0+(j0+1)*(n+3)].x() ,volumesPoints[i0+(j0+1)*(n+3)].y() );
            else
                d4 = u.get(i+(j+1)*(n+1));
            h4 = volumesPoints[i0+(j0+1)*(n+3)].y() - volumesPoints[i0+j0*(n+3)].y();
            d4 /= h4;

            //System.out.println(d1+" "+d2+" "+d3+" "+d4);

            h0 = (1/h1+1/h2+1/h3+1/h4);

            u.set(p, (integrate(f, volumes[i0-1 + (j0-1)*(n+2)], volumes[i0 + (j0-1)*(n+2)], volumes[i0-1+ j0*(n+2)])/h + d1 + d2 + d3 + d4)/h0 );
        }
    }
    private boolean evaluate(Vector u, Pair[] volumesPoints, Pair[] volumes, double h, int n, Function g, Function f) {
        double s = 0;

        for (int p=0; p<u.size(); p++) {
            int i = p%(n+1);
            int j = (p-i)/(n+1);

            int i0 = i+1;
            int j0 = j+1;

            double d1;
            double d2;
            double d3;
            double d4;

            double h1;
            double h2;
            double h3;
            double h4;
            double h0;
            if (i0-1 == 0)
                d1 = g.calcul(volumesPoints[j0*(n+3)].x() ,volumesPoints[j0*(n+3)].y());
            else
                d1 = u.get(i-1+j*(n+1));
            h1 = volumesPoints[i0+j0*(n+3)].x() - volumesPoints[i0-1+j0*(n+3)].x();
            d1 /= h1;

            if (j0-1 == 0)
                d2 = g.calcul(volumesPoints[i0].x(), volumesPoints[i0].y() );
            else
                d2 = u.get(i+(j-1)*(n+1));
            h2 = volumesPoints[i0+j0*(n+3)].y() - volumesPoints[i0+(j0-1)*(n+3)].y();
            d2 /= h2;


            if (i0+1 == n+2)
                d3 = g.calcul(volumesPoints[i0+1+j0*(n+3)].x(), volumesPoints[i0+1+j0*(n+3)].y() );
            else
                d3 = u.get(i+1+j*(n+1));
            h3 = volumesPoints[i0+1+j0*(n+3)].x() - volumesPoints[i0+j0*(n+3)].x();
            d3 /= h3;

            if (j0+1 == n+2)
                d4 = g.calcul(volumesPoints[i0+(j0+1)*(n+3)].x() ,volumesPoints[i0+(j0+1)*(n+3)].y() );
            else
                d4 = u.get(i+(j+1)*(n+1));
            h4 = volumesPoints[i0+(j0+1)*(n+3)].y() - volumesPoints[i0+j0*(n+3)].y();
            d4 /= h4;

            h0 = (1/h1+1/h2+1/h3+1/h4);

            double tmp = h0*u.get(p)-d1-d2-d3-d4-integrate(f, volumes[i0-1 + (j0-1)*(n+2)], volumes[i0 + (j0-1)*(n+2)], volumes[i0-1+ j0*(n+2)])/h;
            tmp*=tmp;

            s+= tmp;
        }
        return Math.sqrt(s) > 10e-10;
    }
    private double integrate(Function f, Pair a, Pair b, Pair d) {
        double h1 = (b.x()-a.x())/2;
        double k1 = (d.y()-a.y())/2;
        double h2 = (b.x() + a.x())/2.;
        double k2 = (d.y() + a.y())/2.;

        //System.out.println( a.x()+";"+a.y()+" --- "+ b.x()+";"+ b.y()+" --- " +d.x() +";"+ d.y());

        double coef = h1*k1;

        double p = Math.sqrt(1./3);

        double s = 0;
        s += f.calcul( -h1*p+h2, -k1*p+k2);
        s += f.calcul( -h1*p+h2, k1*p+k2);
        s += f.calcul( h1*p+h2, -k1*p+k2);
        s += f.calcul( h1*p+h2, k1*p+k2);
        return s*coef;
    }
}
