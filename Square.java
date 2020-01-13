import java.util.ArrayList;

public abstract class Square { // Square is an abstract class
	
	private String name="Regular Square"; // Before override all square names are regular square
	private int taxValue,startingPointPayment;
	private int price;
	private Player owner;
	private int rentPrice;
	private int defaultRentPrice;
	private String color=" ";
	private ArrayList<Building> buildingList = new ArrayList<Building>(5);
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;	}
	
	public int getTaxValue() { return taxValue;}
	public void setTaxValue(int taxValue) {	} 
	
	public int getStartingPointPayment() { return startingPointPayment;}
	public void setStartingPointPayment(int startingPointPayment) { }
	
	public void givePayrollTax(Player player) {} 
	public void giveLuxuryTax(Player player) {} 
	
	public int getPrice() {	return price;}
	
	public Player getOwner() {return owner;}
	public void setOwner(Player player) {owner=player;}
	
	public int getRentPrice() {return rentPrice;}
	public void setRentPrice(int rentPrice) {this.rentPrice = rentPrice;}
	public int getDefaultRentPrice() {	return defaultRentPrice;}
	
	public String getColor() {return color;}
	
	public ArrayList<Building> getBuildingList() {	return buildingList;}
	public void setBuildingList(ArrayList<Building> buildingList) {	this.buildingList = buildingList;}
	
	public void landedOn(Player player,Square location,Board board1) {}
	
}

