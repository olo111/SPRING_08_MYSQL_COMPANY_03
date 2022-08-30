package pl.olointeria.spring_08_mysql_company.prima;




public class SupClassification{
	
	private String classification;
	private int numberSuppliers;

	public SupClassification(String classification, int numberSuppliers) {
		this.classification = classification;
		this.numberSuppliers = numberSuppliers;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getNumberSuppliers() {
		return numberSuppliers;
	}

	public void setNumberSuppliers(int numberSuppliers) {
		this.numberSuppliers = numberSuppliers;
	}
}