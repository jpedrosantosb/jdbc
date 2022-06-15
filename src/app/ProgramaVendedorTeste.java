package app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class ProgramaVendedorTeste {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    VendedorDao vendedorDao = DaoFactory.createVendedorDao();

    System.out.println("=== TESTE 1: vendedor findById =====");
    Vendedor vendedor = vendedorDao.findById(3);
    System.out.println(vendedor);

    System.out.println("\n=== TESTE 2: vendedor findByDepartamento =====");
    Departamento departamento = new Departamento(2, null);
    List<Vendedor> list = vendedorDao.findByDepartamento(departamento);
    for (Vendedor obj : list) {
      System.out.println(obj);
    }

    System.out.println("\n=== TESTE 3: vendedor findAll =====");
    list = vendedorDao.findAll();
    for (Vendedor obj : list) {
      System.out.println(obj);
    }

    System.out.println("\n=== TESTE 4: vendedor insert =====");
    Vendedor newVendedor = new Vendedor(null, "Gregorio", "greg@gmail.com",
                                        new Date(), 4000.0, departamento);
    vendedorDao.insert(newVendedor);
    System.out.println("Vendedor inserido! id do novo vendedor = " + newVendedor.getId());

    System.out.println("\n=== TEST 5: vendedor update =====");
    vendedor = vendedorDao.findById(1);
    vendedor.setNome("Raphael Veiga");
    vendedor.setEmail("veiga@gmail.com");
    vendedorDao.update(vendedor);
    System.out.println("Atualização completa.");

    System.out.println("\n=== TESTE 6: vendedor delete =====");
    System.out.println("Digite o id para o teste de exclusão:");
    int id = sc.nextInt();
    vendedorDao.deleteById(id);
    System.out.println("Exclusão concluída.");

    sc.close();
  }

}
