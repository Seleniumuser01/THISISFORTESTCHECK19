

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Excel {

    private static final String FILE_NAME = "D://VeraAutomation//Test Data.xlsx";

    public static void main(String[] args) {

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellType() == CellType.STRING) {
                      //  System.out.print(currentCell.getStringCellValue() + "--");
                        String str=currentCell.getStringCellValue();
                        System.out.println(str);
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                       // System.out.print(currentCell.getNumericCellValue() + "--");
                        int str1=(int) currentCell.getNumericCellValue();
                        System.out.println(str1);
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}