package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> lista = new ArrayList<>();
		
		System.out.print("Digite o número de produtos: ");
		int numeroProdutos = sc.nextInt();
		
		for (int i=1; i<=numeroProdutos; i++) {
			System.out.println("---------------------------------------");
			System.out.println("Dados do produto #" + i);
			
			System.out.print("Comum, usado ou importado (C/U/I)? ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if (tipo == 'I') {
				System.out.print("Taxa da alfandega: ");
				double taxaAlfandega = sc.nextDouble();
				lista.add(new ImportedProduct(nome, preco, taxaAlfandega));
			} else if(tipo == 'U') {
				System.out.print("Data de fabricação (DD/MM/AAAA): ");
				sc.nextLine();
				String data = sc.nextLine();
				Date dataFabricacao = sdf.parse(data);
				lista.add(new UsedProduct(nome, preco, dataFabricacao));
			} else {
				lista.add(new Product(nome, preco));
			}
		}
		System.out.println();
		
		System.out.println("ETIQUETAS DOS PRODUTOS");
		for (Product produto : lista) {
			System.out.println(produto.etiqueta());
		}
		
		sc.close();
	}

}
