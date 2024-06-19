package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private StatusPedido status;
	private Cliente cliente;
	
	List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
		
	}
	
	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.status = status;
		this.momento = momento;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(ItemPedido itensIn) {
		itens.add(itensIn);
	}
	
	public void removeItem(ItemPedido itensIn) {
		itens.remove(itensIn);
	}
	
	public double total() {
		double sum = 0;
		for(ItemPedido itensIn : itens) {
			sum += itensIn.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do Pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido: \n");
		for (ItemPedido itensIn : itens) {
			sb.append(itensIn + "\n");
		}
		sb.append("Preço Total: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
}
