package org.example.utils;


// Apache POI classes to work with Excel
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;


public class ExcelReader {


    // Method which reads Excel and returns data in 2D Object array
    // filePath  -> Excel file location
    // sheetName -> Which sheet we want to read

    public static Object[][] readExcel(
            String filePath,
            String sheetName
    ){

        // Empty 2D array initially
        // Later we store Excel data here
        Object[][] data = null;



        try {


            // Opens Excel file from given location
            FileInputStream fis =
                    new FileInputStream(filePath);



            // Creates Workbook object
            // Workbook means entire Excel file
            Workbook workbook =
                    WorkbookFactory.create(fis);



            // Select specific sheet from Excel
            // Example: Login sheet
            Sheet sheet =
                    workbook.getSheet(sheetName);



            // Count total rows present in sheet
            //
            // Example:
            //
            // username password
            // user1    pass1
            // user2    pass2
            //
            // rows = 3

            int rows =
                    sheet.getPhysicalNumberOfRows();




            // Count columns from first row
            //
            // username password
            //
            // cols = 2

            int cols =
                    sheet
                            .getRow(0)
                            .getPhysicalNumberOfCells();


            DataFormatter formatter =
                    new DataFormatter();


            // Create Object array size
            //
            // rows-1 because we skip header
            //
            // Example:
            //
            // Excel rows = 4
            // columns = 2
            //
            // Object[3][2]

            data =
                    new Object[rows-1][cols];





            // Start from i=1
            // because row 0 contains headings
            // username,password

            for(int i=1; i<rows; i++){



                // Get current row

                Row row =
                        sheet.getRow(i);




                // Loop through every column

                for(int j=0; j<cols; j++){



                    // Get current cell value

                    Cell cell =
                            row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);




                    // Store Excel value into Object array
                    //
                    // i-1 because array starts from 0
                    //
                    // Excel row 1 becomes
                    // data row 0


                    data[i-1][j] =
                            formatter.formatCellValue(cell).trim();

                }

            }




            // Close Excel file

            workbook.close();


        }

        catch(Exception e){


            // Print error if Excel reading fails

            e.printStackTrace();

        }



        // Return data to DataProvider

        return data;

    }

}