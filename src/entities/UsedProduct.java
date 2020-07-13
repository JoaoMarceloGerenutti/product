package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date dataFabricacao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public final String etiqueta() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome());
		sb.append(" (usado) $ ");
		sb.append(String.format("%.2f", super.getPreco()));
		sb.append(" (Data de fabricação: ");
		sb.append(sdf.format(dataFabricacao));
		sb.append(")");
		return sb.toString();
	}
	
}
