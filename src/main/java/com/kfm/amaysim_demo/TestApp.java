package com.kfm.amaysim_demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestApp
{
    public static void main(String[] args)
    {
        BufferedWriter out = null;
        try {

            // Read File Contents - score
//            BufferedReader br = new BufferedReader(new FileReader("c:\\a.txt"));
//            String storedScore="0";
//            int storedScoreNumber = 0;
//            while ((storedScore = br.readLine()) != null) {
//                storedScoreNumber=(Integer.parseInt(storedScore==null?"0":storedScore));
//            }

            // Write File Contents - incremented socre
            out = new BufferedWriter(new FileWriter("C:\\Users\\kurtmartinez\\Documents\\a.txt", false));
            for(int x = 1000001; x <= 1100000; x++)
            {
                out.write(String.valueOf("P"+x + ",12121212"));
                out.newLine();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
