import java.util.ArrayList;

public class City extends Property{
	
	private	String name;
	private int price;
	private Player owner;
	private int rentPrice;
	private String color;
	private int defaultRentPrice;
	private ArrayList<Building> buildingList;

	
	public City(String name,int price,String color) { // Constructor with tax square name and tax value
		this.setColor(color);
		this.name=name;
		this.price=price;
		setRentPrice(price/10);
		setDefaultRentPrice(rentPrice);
		buildingList = new ArrayList<Building>(5);
	}
	public void landedOn(Player player,Square locationSquare, Board board) {
			if(locationSquare.getOwner()==null &&!(player.getPiece().getlocation()==20)) {//IF there is no owner
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
			else if(locationSquare.getOwner()==player) {//if there is player's city
				if(player.getColorList().contains(locationSquare.getColor())) {
					if(locationSquare.getBuildingList().size()<4 && player.getBalance()>200) {
						locationSquare.getBuildingList().add(new House());
						player.setBalance(player.getBalance()-locationSquare.getBuildingList().get(0).getBuildPrice());
						System.out.println("The House is builded.");
					}else if (locationSquare.getBuildingList().size()==4&& player.getBalance()>300) {
						locationSquare.getBuildingList().add(new Hotel());
						player.setBalance(player.getBalance()-locationSquare.getBuildingList().get(0).getBuildPrice());
						System.out.println("The Hotel is builded.");
					}
		
				}
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
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	@Override
	public void setRentPrice() {
		// TODO Auto-generated method stub
		
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public ArrayList<Building> getBuildingList() {
		return buildingList;
	}
	public void setBuildingList(ArrayList<Building> buildingList) {
		this.buildingList = buildingList;
	}
	public int getDefaultRentPrice() {
		return defaultRentPrice;
	}
	public void setDefaultRentPrice(int defaultRentPrice) {
		this.defaultRentPrice = defaultRentPrice;
	}
}