
package com.dsney.excelreader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReusableXcel1 {

	XSSFWorkbook wb;

	XSSFSheet paper;

	public ReusableXcel1(String Filepath)

	{

		try {

			FileInputStream fis = new FileInputStream(Filepath);

			wb = new XSSFWorkbook(fis);

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	public String readsell(String sheet, int row, int cell)

	{

		paper = wb.getSheet(sheet);

		String value = paper.getRow(row).getCell(cell).getStringCellValue();

		return value;

	}

	public int rowcount(String Sheetname)

	{

		paper = wb.getSheet(Sheetname);

		// return value;

		int x = wb.getSheet(Sheetname).getLastRowNum();

		x = x + 1;

		return x;

	}

}