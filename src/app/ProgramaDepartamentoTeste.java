package app;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class ProgramaDepartamentoTeste {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();

    System.out.println("=== TESTE 1: findById =======");
    Departamento dep = departamentoDao.findById(1);
    System.out.println(dep);

    System.out.println("\n=== TESTE 2: findAll =======");
    List<Departamento> list = departamentoDao.findAll();
    for (Departamento d : list) {
      System.out.println(d);
    }

    System.out.println("\n=== TESTE 3: insert =======");
    Departamento newDepartamento = new Departamento(null, "Musica");
    departamentoDao.insert(newDepartamento);
    System.out.println("Inserido! Novo id: " + newDepartamento.getId());

    System.out.println("\n=== TESTE 4: update =======");
    Departamento dep2 = departamentoDao.findById(1);
    dep2.setNome("Fast Food");
    departamentoDao.update(dep2);
    System.out.println("Update concluido.");

    System.out.println("\n=== TESTE 5: delete ======");
    System.out.print("Digite o id para o teste de exclusão:");
    int id = sc.nextInt();
    departamentoDao.deleteById(id);
    System.out.println("Delete concluido.");

    sc.close();

  }
}
