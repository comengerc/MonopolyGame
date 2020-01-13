public class Tax extends Square {
		
	private	int taxValue;
	private	String name="Tax Square"; // Default square name
		
	public Tax(String name, int taxValue) { // Constructor with tax square name and tax value
		
		this.name=name;
		this.taxValue=taxValue;
	}
		
	public void landedOn(Player player, Square locationSquare, Board board) {
		
		if(player.getPiece().getLocationSquare().getName() == "Payroll Tax") { // paying tax
			locationSquare.givePayrollTax(player);	}
		if(player.getPiece().getLocationSquare().getName() == "Luxury Tax") { // paying tax
			locationSquare.giveLuxuryTax(player);
		}
	}

	public void setTaxValue(int taxValue) { // setting tax value
		this.taxValue = taxValue;
	}
	public int getTaxValue() {// getting tax value
		return taxValue;
	}
		
	public String getName() { // get name of tax square
		return name;
	}


	public void givePayrollTax(Player player) { // Players give tax payroll
		player.setBalance(player.getBalance()-getTaxValue());
		
		
	}
	public void giveLuxuryTax(Player player) {// Players give tax luxury
		player.setBalance(player.getBalance()-getTaxValue());
		
	}
}