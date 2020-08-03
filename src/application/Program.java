package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		

		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller finById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller finByDepartment ====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert ====");
		Seller newseller = new Seller(null,"Guregi","gure@gmail.com",new Date(),4000.2,department);
		sellerDao.insert(newseller);
		System.out.println("Inserted! New Id = "+ newseller.getId());
		
		System.out.println("\n=== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed ====");
		
		System.out.println("\n=== TEST 6: seller delete ====");
		sellerDao.deleteById(1);
		System.out.println("\nDELETED");
	}

}
