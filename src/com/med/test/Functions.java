package com.med.test;

import javafx.util.Pair;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Functions {
    public static final String FINITE_DIFFERENCE_LOG_FOLDER = "logs/finite_difference";
    public static final String FINITE_VOLUME_LOG_FOLDER = "logs/finite_volume";
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");

    private static final SimpleDateFormat FILE_FORMATTER = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");

    public static File createLogFile(String folder) {
        Date date = new Date();

        String fileName = folder+"/test_"+ FILE_FORMATTER.format(date) +".log";
        File file = new File(fileName);
        try {
            FileOutputStream io = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(io));
            writer.close();
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static ArrayList<Pair<Character, Character>> getTestClasses() {
        ArrayList<Pair<Character, Character>> result = new ArrayList<>();
        String s = null;
        try {

            Process p = null;

            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                p = Runtime.getRuntime().exec("./jenny.exe 10 5");
            }
            else if (os.contains("nix") || os.contains("nux") || os.indexOf("aix") > 0) {
                p = Runtime.getRuntime().exec("./jenny.sh 10 5");
            }

            assert p != null;
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((s = stdInput.readLine()) != null) {
                String[] strings = s.split(",");
                result.add(new Pair<Character, Character>(strings[0].charAt(1), strings[1].charAt(1)));
            }
            stdInput.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
            return result;
    }


    public static double[] getMaillage(int n) {
        double[] result = new double[n];
        double s = 0.;
        for (int i=0; i < n; i++ ) {
            s += 1./(n+1);
            result[i] = s;
        }
        return result;
    }

    public static Pair<double[],double[]> getVolume(int n) {
        double[] v = new double[n+1];
        double[] u = new double[n+2];
        double s = 0.;
        v[0] = 0;
        v[n] = 1;
        u[0] = 0;
        u[n+1] = 1;
        for (int i=1; i < n; i++ ) {
            s += 1./n;
            v[i] = s;
        }

        for (int i = 0; i<v.length-1; i++) {
            u[i+1] = (v[i]+v[i+1])/2;
        }
        return new Pair<>(v,u);
    }
}
