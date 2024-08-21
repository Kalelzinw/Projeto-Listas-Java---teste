package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Quantos funcionarios vão ser cadastrados:");
		n = sc.nextInt();
		List<Funcionario> list = new ArrayList();
		
		for (int i = 0;i < n; i++) {
		System.out.printf("Funcionario #%d\n", i + 1);
		System.out.println("Digite o ID do funcionario:");
		int id = sc.nextInt();
		while (hasID(list,id)) {
			System.out.println("Este ID ja existe, tente novamente:");
			System.out.println("Digite o ID do funcionario:");
			id = sc.nextInt();
		}
		System.out.println("Digite o nome do funcionario:");
		sc.hasNextLine();
		String name = sc.next();
		System.out.println("Digite o salario do funcionario:");
		Double salary = sc.nextDouble();
		Funcionario func = new Funcionario(id, name, salary);
		list.add(func);
		}
		System.out.println("Digite o ID que deseja aumentar o salario: ");
		int id_salary = sc.nextInt();
		Funcionario pos = list.stream().filter(x -> x.getId() == id_salary).findFirst().orElse(null);
		if (pos == null) {
			System.out.println("Este id não existe");
		} else {
			System.out.println("Quanto deseja aumentar:");
			Double increasesalary = sc.nextDouble();
			pos.increaseSalary(increasesalary);
		}
		for (Funcionario x : list) {
			System.out.println(x);
		}
			
		sc.close();

	}
	public static boolean hasID(List<Funcionario> list, int id){
		Funcionario pos = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return pos != null;
	}
	
}
