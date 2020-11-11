package utilities;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;

import org.testng.annotations.Test;

public class Practise {
  @Test
  public void f() throws ParseException {
	  
	Boolean bool=Util.isFileDownloaded("D:\\Users\\asanth\\Documents\\IMP Documents\\New Format", "Santhosh_Resume.doc");
	  System.out.println("Has the file been downloaded? "+bool);
	  //System.out.println(Util.getLatestFilefromDir("D:\\Users\\asanth\\Documents\\IMP Documents\\New Format"));
	  File f=Util.getLatestFilefromDir("D:\\Users\\asanth\\Documents\\IMP Documents\\New Format");
	  String lStr =Util.getLatestModifiedFileName(f);
	  System.out.println("The name of last modified file is " +lStr);
  }
}
