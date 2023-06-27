package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Readtestdata {


@DataProvider(name="testdata")
	
	public String[][] readdata(Method m) throws EncryptedDocumentException, IOException {

		String excelsheetname=m.getName();

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fir = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fir);

		Sheet sheet = wb.getSheet(excelsheetname);

		int totalrows = sheet.getLastRowNum();
		System.out.println(totalrows);
		int totalcolumns = sheet.getRow(0).getLastCellNum();
		System.out.println(totalcolumns);
		DataFormatter format = new DataFormatter();

		String testdata[][] = new String[totalrows][totalcolumns];
		for (int i = 1; i <= totalrows; i++) {

			for (int j = 0; j < totalcolumns; j++) {

				testdata[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(testdata[i - 1][j]);

			}

		}

		return testdata;
	}
	
}



