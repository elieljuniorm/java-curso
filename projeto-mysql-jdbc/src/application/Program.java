package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    System.out.println("\n=== TEST 4: seller insert =====");
    Seller newSeller = new Seller(
      null,
      "Greg",
      "greg@gmail.com",
      new Date(),
      4000.0,
      department
    );
    sellerDao.insert(newSeller); //sellerDao é aproveitamento de variavel acima
    System.out.println("Inserido! Novo id = " + newSeller.getId());
    System.out.println();

    System.out.println("===== TESTE 5: seller update =====");
    System.out.println();
    seller = sellerDao.findById(7);
    seller.setName("Jonas Esticado");
    sellerDao.update(seller);
    System.out.println("Atualização Concluida");
    System.out.println();

    System.out.println("===== TESTE 6: seller delete =====");
    System.out.println("Entre com o Id para ser deletado: ");
    int id = sc.nextInt();
    sellerDao.deleteById(id);
    System.out.println("Dado pagado com sucesso!");
    System.out.println();
    sc.close();
  }
}
