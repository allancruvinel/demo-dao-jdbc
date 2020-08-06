package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department;
		System.out.println("Test 1 Insert");
		department = new Department(null,"Manoninhas");
		
		departmentDao.insert(department);
		
		System.out.println("Test 2 Update");
		department = new Department(2,"amores");
		departmentDao.update(department);
		
		System.out.println("Test 3 Delete");
		departmentDao.deleteById(8);
		
		System.out.println("Test 4 FindById");
		department = departmentDao.findById(4);
		System.out.println(department);
		
		System.out.println("Test 5 FindAll");
		List<Department> list = departmentDao.findAll();
		
		for(Department depis : list) {
			System.out.println(depis);
		}
		
	}

}
