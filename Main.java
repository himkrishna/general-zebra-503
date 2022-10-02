package usecases;

import java.util.Scanner;

import Bean.Employee;
import Dao.EmployeeDao;
import Dao.EmployeeDaoInt;

public class Main {

	public static void main(String[] args) {
        String name;
        int id;
        String emails;
        String pass;
        String dept;
        
        EmployeeDaoInt dao=new EmployeeDao();
        System.out.println("Welcome to Employee management application");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the employee\n");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID : ");
                     id=sc.nextInt();
                    System.out.println("Enter name ");
                     name=sc.next();
                     System.out.println("Enter email ");
                     emails=sc.next();
                     System.out.println("Enter password ");
                     pass=sc.next();
                     System.out.println("Enter department ");
                     dept=sc.next();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setEmail(emails);
                    emp.setPassword(pass);
                    emp.setDepartment(dept);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");
                    int empid=sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name");
                     name=sc.next();
                    dao.updateEmployee(empid1,name);
                    break;
              

                case 5:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);

    }
}
