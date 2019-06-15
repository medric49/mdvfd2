package com.med.test;

import com.med.mdvfd2.*;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mdalsoft.test.DefaultTestLogger.logTest;

public class VFTestRunner {

    public static void main(String[] args) {
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<String> scenarii = new ArrayList<>();
        ArrayList<Double> times = new ArrayList<>();

        ArrayList<Pair<Character, Character>> testClasses = Functions.getTestClasses();
        File logFile = Functions.createLogFile(Functions.FINITE_VOLUME_LOG_FOLDER);


        Date start = new Date();
        try {
            String classeATester = "com.med.mdvfd2.VFSolver";
            String methodToTest = "VFSolver.solve";
            String testFileLogger = "com.mdalsoft.test.FileTestLogger";
            for (int i = 0; i < testClasses.size(); i++) {
                Pair<Character, Character> classe = testClasses.get(i);

                String scenario = null;
                Function f = null;
                Function g = null;
                Function u = null;
                double tol = 0;
                int n = 0;
                TestFunction testFunction = null;
                Vector ra = null;
                Mesure mesure = null;


                testFunction = new TestFunction() {
                    @Override
                    public Vectorizable getRO(Solver f, De de) {
                        if (de.getN() > 0) {
                            try {
                                return f.solve(de.getN(), de.getG(), de.getF(), false);
                            } catch (Exception e) {
                                return null;
                            }
                        } else {
                            try {
                                f.solve(de.getN(), de.getG(), de.getF(), false);
                                return new Vector(1);
                            } catch (MDVFException e) {
                                return null;
                            } catch (Exception e) {
                                return new Vector(1);
                            }
                        }
                    }
                };


                switch (classe.getValue()) {
                    case 'a':
                        n = -3;
                        mesure = new Mesure() {
                            @Override
                            public double getError(Vectorizable v1, Vectorizable v2) {
                                if (v1 == v2)
                                    return 0;
                                return 10;
                            }
                        };
                        tol = 10e-10;
                        break;

                    case 'b':
                        n = 0;
                        mesure = new Mesure() {
                            @Override
                            public double getError(Vectorizable v1, Vectorizable v2) {
                                if (v1 == v2)
                                    return 0;
                                return 10;
                            }
                        };
                        tol = 10e-10;
                        break;

                    case 'c':
                        n = 1;
                        mesure = new Mesure() {
                            @Override
                            public double getError(Vectorizable v1, Vectorizable v2) {
                                if (v1 != null) {
                                    if (v1.size() == v2.size()) {
                                        double s = 0;
                                        double s0 = 0;
                                        double tmp = 0;
                                        for (int i = 0; i < v1.size(); i++) {
                                            s0 += v2.get(i)*v2.get(i);
                                            tmp = v1.get(i) - v2.get(i);
                                            s += tmp * tmp;
                                        }

                                        s0 = Math.sqrt(s0);
                                        if (s0 == 0)
                                            return Math.sqrt(s);
                                        else
                                            return Math.sqrt(s) / s0;
                                    }
                                }
                                return 10;
                            }
                        };
                        tol = 10e-8;
                        break;

                    case 'd':
                        n = 2;
                        mesure = new Mesure() {
                            @Override
                            public double getError(Vectorizable v1, Vectorizable v2) {
                                if (v1 != null) {
                                    if (v1.size() == v2.size()) {
                                        double s = 0;
                                        double s0 = 0;
                                        double tmp = 0;
                                        for (int i = 0; i < v1.size(); i++) {
                                            s0 += v2.get(i)*v2.get(i);
                                            tmp = v1.get(i) - v2.get(i);
                                            s += tmp * tmp;
                                        }

                                        s0 = Math.sqrt(s0);
                                        if (s0 == 0)
                                            return Math.sqrt(s);
                                        else
                                            return Math.sqrt(s) / s0;
                                    }
                                }
                                return 10;
                            }
                        };
                        tol = 10e-8;
                        break;

                    case 'e':
                        n = 100;
                        mesure = new Mesure() {
                            @Override
                            public double getError(Vectorizable v1, Vectorizable v2) {
                                if (v1 != null) {
                                    if (v1.size() == v2.size()) {
                                        double s = 0;
                                        double s0 = 0;
                                        double tmp = 0;
                                        for (int i = 0; i < v1.size(); i++) {
                                            s0 += v2.get(i)*v2.get(i);
                                            tmp = v1.get(i) - v2.get(i);
                                            s += tmp * tmp;
                                        }

                                        s0 = Math.sqrt(s0);
                                        if (s0 == 0)
                                            return Math.sqrt(s);
                                        else
                                            return Math.sqrt(s) / s0;
                                    }
                                }
                                return 10;
                            }
                        };
                        tol = 10e-8;
                        break;
                }

                switch (classe.getKey()) {
                    case 'a':
                        scenario = "Fonction nulle";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };

                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };


                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }

                        break;

                    case 'b':
                        scenario = "Fonction constante non nulle";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 9;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 9;
                            }
                        };

                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }

                        break;

                    case 'c':
                        scenario = "Fonction linéaire en x";
                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*x+3;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*x+3;
                            }
                        };

                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }


                        break;

                    case 'd':
                        scenario = "Fonction linéaire en y";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 4*y+5;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 4*y+5;
                            }
                        };

                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }


                        break;

                    case 'e':
                        scenario = "Fonction avec produit xy";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 0;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return x+4*x*y+y;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return x+4*x*y+y;
                            }
                        };

                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }


                        break;

                    case 'f':
                        scenario = "Fonction de degré 2 en x";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return -2;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return x*x+2*x+y+5;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return x*x+2*x+y+5;
                            }
                        };


                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }

                        break;

                    case 'g':
                        scenario = "Fonction de degré 2 en y";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return -4;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*y*y+3*x+10*y+5;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*y*y+3*x+10*y+5;
                            }
                        };

                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }


                        break;

                    case 'h':
                        scenario = "Fonction de degré 2 en x et y";

                        f = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return -6;
                            }
                        };
                        g = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*x*x+y*y+3*x*y+4*x+5*y+2;
                            }
                        };

                        u = new Function() {
                            @Override
                            public double calcul(double x, double y) {
                                return 2*x*x+y*y+3*x*y+4*x+5*y+2;
                            }
                        };


                        if (n > 0) {
                            ra = Functions.constructRAforVF(u, n);
                        }
                        break;
                }


                if (n < 0)
                    scenario += " avec n négatif";
                else if (n == 0)
                    scenario += " avec n nul";
                else if (n == 1)
                    scenario += " avec n valant 1";
                else if (n == 2)
                    scenario += " avec n valant 2";
                else
                    scenario += " avec n très grand";

                TestData testData = new TestData(
                        new DFSolver(), scenario, new De(n, g, f), testFunction, ra, mesure, tol
                );

                Map parTest = new HashMap();
                parTest.put("file",Functions.FINITE_VOLUME_LOG_FOLDER+"/finite_volume.log");
                Date d1 = new Date();

                parTest.put("classtotest", classeATester);
                parTest.put("testreference", methodToTest);
                parTest.put("teststarttime", "" + d1.getTime());
                parTest.put("testLogger0", testFileLogger);

                logTest(parTest, "start", false);
                parTest.put("testcase", scenario);

                boolean result = testData.result();
                parTest.put("testresult", result);

                Date d2 = new Date();

                parTest.put("testendtime", "" + d2.getTime());
                logTest(parTest, "end", false);

                results.add(result ? 1 : 0);
                scenarii.add(scenario);
                times.add((d2.getTime() - d1.getTime()) / 1000.);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Date end = new Date();

        try {

            double s = 0;

            for (int i = 0; i < results.size(); i++) {
                s += results.get(i);
            }
            s /= results.size();
            System.out.println("Taux de reussite : " + (s * 100)+"%");


            FileOutputStream io = new FileOutputStream(logFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(io));

            writer.write("==========   Résultat du test de la librairie des volumes finis   ==========\n\n");
            writer.newLine();

            writer.write("Date de début : " + Functions.FORMATTER.format(start));
            writer.newLine();
            writer.write("Date de fin : " + Functions.FORMATTER.format(end));
            writer.newLine();
            writer.write("Durée du test : " + ((end.getTime() - start.getTime()) / 1000.) + " secondes");
            writer.newLine();
            writer.write("Résultat du test : " + (int) (s * results.size()) + "/" + results.size());
            writer.newLine();
            writer.write("Pourcentage de réussite : " + (s * 100) + " %");
            writer.write("\n");
            writer.newLine();

            writer.write("****** Détails ******\n");
            writer.newLine();
            for (int i = 0; i < results.size(); i++) {
                writer.write("Scénario du cas de test : " + scenarii.get(i));
                writer.newLine();
                writer.write("Résultat du cas de test : " + (results.get(i) == 1 ? "Succès" : "Echec"));
                writer.newLine();
                writer.write("Durée d'exécution du cas de test : " + times.get(i) + " secondes\n");
                writer.newLine();
            }


            writer.close();
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

