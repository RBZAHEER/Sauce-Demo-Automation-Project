package org.example.utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenshotUtil {


    public static void takeScreenshot(
            WebDriver driver,
            String testName
    ){


        try{


            if(driver == null){

                System.out.println(
                        "Driver is null. Screenshot skipped"
                );

                return;
            }


            TakesScreenshot ts =
                    (TakesScreenshot) driver;



            File source =
                    ts.getScreenshotAs(OutputType.FILE);



            File folder =
                    new File("screenshots");


            if(!folder.exists()){

                folder.mkdir();

            }

            //Create Timestamp

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File destination =
                    new File(
                            folder + "/"
                                    + testName + "_" + timeStamp
                                    + ".png"
                    );



            Files.copy(
                    source.toPath(),
                    destination.toPath()
            );


            System.out.println(
                    "Screenshot captured: "
                            + testName
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}