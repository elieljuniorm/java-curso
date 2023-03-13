package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

  public static void main(String[] args) {

    System.out.println("===== TESTE 1: seller findById =====");
    System.out.println();
    SellerDao sellerDao = DaoFactory.createSellerDao(); //fabrica de dao implementa o jdbc sem o sistema ter acesso ao arquivo que de fato implementa o jdbc
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);
    System.out.println();

    System.out.println("===== TESTE 2: seller findByDepartment =====");
    System.out.println();
    Department department = new Department(1, null);
    List<Seller> list = sellerDao.findByDepartment(department);
    for (Seller obj : list) {
      System.out.println(obj);
    }
    System.out.println();

    System.out.println("===== TESTE 3: seller findAll =====");
    System.out.println();
    list = sellerDao.findAll();
    for (Seller obj : list) {
      System.out.println(obj);
    }
    System.out.println();
  }
}
