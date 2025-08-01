package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== TEST 1: Department findbyId ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n==== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}

		System.out.println("\n==== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: Department update ====");
		department = departmentDao.findById(6);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println("Update completed!");
		Department dep = departmentDao.findById(department.getId());
		System.out.println(dep);

		System.out.println("\n==== TEST 5: Department delete ====");
		System.out.println("Enter ID for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
