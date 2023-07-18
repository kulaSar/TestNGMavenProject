package com.kula.generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	public static java.lang.String readData(java.lang.String filePath, java.lang.String sheet, int row, int cell) {
		java.lang.String value = null;
		
		try {
			Workbook wb= WorkbookFactory.create(new FileInputStream(new File(filePath)));
			//Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
			
			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
		

	}

}
