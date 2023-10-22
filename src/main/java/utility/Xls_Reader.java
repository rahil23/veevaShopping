package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	
	public void writeExcel(List<ArrayList<String>> recordsTOBeInserted) throws IOException
	{
		
		String[] row_heading = {"JacketTitle","Jacket Price","Sellers healines"};
		
		
		
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		XSSFSheet spreadSheet = workBook.createSheet("Item Details");
		XSSFRow headerRow = spreadSheet.createRow(0);
		
		//creating header
		for(int i=0;i<row_heading.length;i++)
		{
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(row_heading[i]);
		}
		
		//for creating data row for each record
		for(int i=0;i<recordsTOBeInserted.size();i++)
		{
			XSSFRow dataRow = spreadSheet.createRow(i+1);
			for(int j=0;j<recordsTOBeInserted.get(i).size();j++)
			{
				
				dataRow.createCell(j).setCellValue(recordsTOBeInserted.get(i).get(j));
			}
			
		}
		String fileName = System.getProperty("user.dir") + "//Data//WarriorResult.xlsx";
		
		File file  = new File(fileName);
		FileOutputStream fileoutStream = new FileOutputStream(file);
		workBook.write(fileoutStream);

		fileoutStream.close();
		
		
		
	}
}
