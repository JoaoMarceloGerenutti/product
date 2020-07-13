package entities;

public class ImportedProduct extends Product {
	
	private Double taxaAlfandega;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	@Override
	public final String etiqueta() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getNome());
		sb.append(" $ ");
		sb.append(String.format("%.2f", precoTotal()));
		sb.append(" (Taxa da alfandega: $ ");
		sb.append(String.format("%.2f", taxaAlfandega));
		sb.append(")");
		return sb.toString();
	}
	
	public double precoTotal() {
		double soma = super.getPreco() + taxaAlfandega;
		return soma;
	}
}
