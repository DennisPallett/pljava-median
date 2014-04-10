package nl.pallett.pljavamedian;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PLJavaMedian {
    
    public static String transfer_double (String aggState, double nextDouble) throws SQLException{   
        if (Double.isNaN(nextDouble)) {
            return aggState;
        }
        
        if (aggState == null) {
            aggState = String.valueOf(nextDouble);
        } else {
            aggState += "," + Double.valueOf(nextDouble);
        }
        
        return aggState;
    }
    
    public static double final_double (String aggState) throws SQLException {
       
        String[] stringList = aggState.split(",");
        
        double[] elements = new double[stringList.length];
        for(int i=0; i < stringList.length; i++) {
            if (stringList[i].isEmpty() == false) {
                elements[i] = Double.parseDouble(stringList[i]);
            }
        }
        
        // sort collected elements
        Arrays.sort(elements);
        
        // calculate median
        double median = 0;
        if (elements.length % 2 == 0) {
            int index1 = (int) (elements.length / 2) - 1;
            int index2 = index1 + 1;
            
            median = (elements[index1] + elements[index2]) / 2;
        } else {
            int index = (int) Math.ceil(elements.length / 2) - 1;
            median = elements[index];
        }
                        
        return median;
    }
    
    private static void log (String msg) {
        Logger.getAnonymousLogger().info(msg);
    }
    

}