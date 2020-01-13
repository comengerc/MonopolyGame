public class RailRoad extends Property {

	private	String name; // Default square name
	private int price;
	private Player owner;
	private int rentPrice;
	
	public RailRoad(String name,int price) { // Constructor with tax square name and tax value
		this.price=price;
		this.name=name;
	
	}
	public void landedOn(Player player,Square locationSquare, Board board) {
		if(locationSquare.getOwner()==null ) {//IF there is no owner
			if((player.getBalance()*3/4) >= getPrice()) {
					setOwner(player);
					player.buyProperty(player,locationSquare );//add to arraylist
					player.setBalance(player.getBalance()-getPrice());//decrease money
					System.out.print(player.getName()+" purchased " + locationSquare.getName());
				}
		}
		else if(locationSquare.getOwner()!=player){//If there is owner pay rant
			int rentAmount = locationSquare.getRentPrice();
			player.rentProperty(rentAmount);
			getOwner().receiveRentPayment(rentAmount);
		}
	}
	
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player player) {
		owner=player;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	@Override
	public void setRentPrice() {
		// TODO Auto-generated method stub
		
	}
}
