package practise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class CSVTextRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path="D:\\Users\\asanth\\Desktop\\EODReport.txt";
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line;
		int sCount=0;
		int rCount=0;
		while((line=br.readLine())!=null)
		{
			try
			{
			String[]result=line.split(Pattern.quote("|"));
		if(result[3].equalsIgnoreCase("S"))
		{
			sCount++;
		}
		if(result[3].equalsIgnoreCase("R"))
		{
			rCount++;
		}
			}
			catch(Exception e)
			{
				//System.out.println("Array Index out of  bound Exception");
			}
		}
		System.out.println("The number of succesful transactions are "+sCount);
		System.out.println("The number of Rejected transactions are "+rCount);
		br.close();

	}

}
