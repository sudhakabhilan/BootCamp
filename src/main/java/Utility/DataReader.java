package Utility;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DataReader {

    @Test
    public void readEXcelData() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        //WorkBook
        File excelFileName = new File("C:\\Users\\Sudhakaran.V\\IdeaProjects\\SeleniumBootCamp\\src\\main\\java\\TestData\\TestData.xlsx");

        XSSFWorkbook wbook = new XSSFWorkbook(excelFileName);

        //SheetName
        XSSFSheet sheet;
        sheet = wbook.getSheet("testopp");

        //Row
        XSSFRow row = sheet.getRow(1);

        //cell
        XSSFCell cell = row.getCell(0);
    for (int i = 0;i <= cell.getRowIndex();i++ )
        System.out.println(cell);


    }



}
