package Dao;

import Bean.Employee;

public interface EmployeeDaoInt {
	
	public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnID(int id);
    //update employee
    public void updateEmployee(int id,String name);

}
