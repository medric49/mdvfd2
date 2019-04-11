package com.med.mdvfd2;


public class DFSolver extends ASolver{

    @Override
    public Vectorizable solve(int n, Function g, Function f) throws MDVFException {

        if (n >0) {
            int iter = 1000;
            int k = 1;


            Pair[] pairs = DFSolver.getMaillage(n);
            Vector u = new Vector(n*n);
            double h2 = 1./(n+1);
            h2 *= h2;

            while (k<=iter) {
                for (int p=0; p<n*n; p++) {
                    Pair pair = pairs[p];
                    int i = p%n;
                    int j = (p-i)/n;

                    int i0 = i+1;
                    int j0 = j+1;

                    double d1;
                    double d2;
                    double d3;
                    double d4;


                    if (i0-1 == 0)
                        d1 = g.calcul(pairs[j0*(n+2)].x() ,pairs[j0*(n+2)].y() );
                    else
                        d1 = u.get(i-1+j*n);

                    if (j0-1 == 0)
                        d2 = g.calcul(pairs[i0].x(), pairs[i0].y() );
                    else
                        d2 = u.get(i+(j-1)*n);

                    if (i0+1 == n+1)
                        d3 = g.calcul(pairs[i0+1 +j0*(n+2)].x(), pairs[i0+1 +j0*(n+2)].y() );
                    else
                        d3 = u.get(i+1+j*n);

                    if (j0+1 == n+1)
                        d4 = g.calcul(pairs[i0+(j0+1)*(n+2)].x() ,pairs[i0+(j0+1)*(n+2)].y() );
                    else
                        d4 = u.get(i+(j+1)*n);

                    u.set(p, (f.calcul(pair.x(),pair.y())*h2 + d1+d2+d3+d4)/4 );

                }

                k++;
            }
            return u;
        }
        else
            throw new MDVFException("Le nombre n est négatif");
    }
}
