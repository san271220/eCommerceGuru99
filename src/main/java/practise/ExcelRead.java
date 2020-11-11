package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelRead {
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
	   File f=new File("D:\\Users\\asanth\\workspace\\RestPractise\\src\\main\\resources\\testdata\\OSS_Samples.xlsx");
	   FileInputStream fi=new FileInputStream(f);
	   Workbook workbook=WorkbookFactory.create(fi);
	   Sheet sheet0=workbook.getSheetAt(0);
	   for(Row row:sheet0)
	   {
		   for(Cell cell:row)
		   {
			   
			   switch(cell.getCellType())
			   {
			   
			   case Cell.CELL_TYPE_STRING:

				   System.out.println(cell.getStringCellValue()+"\t");
				   break;
			   case Cell.CELL_TYPE_NUMERIC:

				   System.out.println(cell.getNumericCellValue()+"\t");
				   break;
	
			   }
		   }
	   }
	}

}
