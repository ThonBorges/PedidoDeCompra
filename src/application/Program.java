package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do cliente: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Data de aniversario (dd/MM/yyyy): ");
		Date dataAniversario = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataAniversario);
		
		System.out.println("Entre com os dados do Pedido: ");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens tem o pedido: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Digite o #" + i + " pedido: ");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();

			Produto produto = new Produto(nomeProduto, precoProduto);

			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();

			ItemPedido itensPedido = new ItemPedido(quantidade, precoProduto, produto); 

			pedido.addItem(itensPedido);
		}
		
		System.out.println();
		System.out.println("SUMARIO DO PEDIDO:");
		System.out.println(pedido);
		
		
		sc.close();
	}

}
