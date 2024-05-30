package utils;

import pages.AddEmployeePage;

public class PageInitializer {

    public static AddEmployeePage addEmployeePage;


    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();

    }

}
