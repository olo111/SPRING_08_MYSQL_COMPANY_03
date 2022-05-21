package pl.olointeria.spring_08_mysql_company.prima;




public class SupClassification{
	
	private String classification;
	private int NumberSuppliers;
	
	
	public String getClassification() {
		return classification;
	}


	public void setClassification(String classification) {
		this.classification = classification;
	}


	public int getNumberSuppliers() {
		return NumberSuppliers;
	}


	public void setNumberSuppliers(int numberSuppliers) {
		NumberSuppliers = numberSuppliers;
	}


	public SupClassification(String classification, int numberSuppliers) {
		super();
		this.classification = classification;
		NumberSuppliers = numberSuppliers;
	}
	
	
	
}