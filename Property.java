public abstract class Property extends Square {
	private Player owner;
	private String name="Regular Property";
	private int rentPrice,price;
	
	public void landedOn(Player player, Square location, Board board) {	
	}
	public void setOwner(Player player) {
	}
	public String getName() {
		return name;
	}
	public int price() {
		return price;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner() {	
	}
	public int getPrice() {
		return price;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public abstract void setRentPrice();
}
