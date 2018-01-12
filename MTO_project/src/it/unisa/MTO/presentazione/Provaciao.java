package it.unisa.MTO.presentazione;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Provaciao {

	public static void main(String[] args) throws ParseException {
		
		String date = "10-02-2011";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed = format.parse(date);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		
		System.out.println(sql);
		
	    }

	

}
