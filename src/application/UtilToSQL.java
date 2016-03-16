
package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class UtilToSQL {
    
    
    
    public static String convertUtilToSql(java.util.Date uDate){
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
        return df.format(sDate);
    }

    public static void main(String[] args){
      
        System.out.println(convertUtilToSql(new java.util.Date()));
    }
}
