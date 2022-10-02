package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Bean.Employee;
import utility.DBConnection;

public class EmployeeDao implements EmployeeDaoInt{
	
	Connection con;

    @Override
    public void createEmployee(Employee emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into employee values(?,?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setInt(1,emp.getId());
           pstm.setString(2,emp.getName());
           pstm.setString(3,emp.getEmail());
           pstm.setString(4,emp.getPassword());
           pstm.setString(5,emp.getDepartment());
           
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Employee Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="select * from employee";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\n","ID","Name","Email","password","department");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where id="+id;
        try{
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update employee set name=? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

   

}
