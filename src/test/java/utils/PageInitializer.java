package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {

    public static AddEmployeePage addEmployeePage;
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;


    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        employeeSearchPage = new EmployeeSearchPage();
    }

}
