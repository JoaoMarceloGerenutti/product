package entities;

public class Product {
	
	private String nome;
	private Double preco;
	
	public Product() {
	}

	public Product(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String etiqueta() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(" $ ");
		sb.append(String.format("%.2f", preco));
		return sb.toString();
	}
}
