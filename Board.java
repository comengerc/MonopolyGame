import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Board {
	int arrayListSize,payCount=1,luxCount=1,initialBalance,luxTax,payTax,startingMoney;
	
	//Cunstructor for MonopolyGameTest
	public Board(int arrayListSize) {
		this.arrayListSize=arrayListSize;
	}

	public Board(int arrayListSize,int initialBalance,int luxTax,int payTax,int startingMoney, ArrayList<ChanceCard> ChanceCards) { // Constructor with inputs
		this.arrayListSize=arrayListSize; 
		this.initialBalance=initialBalance;
		this.luxTax=luxTax;
		this.payTax=payTax;
		this.startingMoney=startingMoney;
		this.ChanceCards=ChanceCards;
	}
	//ArrayList of Players
	private ArrayList<Player> Players = new ArrayList<Player>(arrayListSize);
	String[] names={"Esra Nur","Harun","Ulker","Kubra","Numan","Osman","Murat","Gamze"};
	public Player getPlayer(int i) { return Players.get(i);}
	public int getPlayerArrayListSize() { return Players.size();}
	public void removePlayer(int i) { Players.remove(i);}
	public ArrayList<Player> getListP() {return Players;}
	public void createPlayers(int numberOfPlayers) { // Creating players
		if(numberOfPlayers<9 && numberOfPlayers>1) {
			for(int i=0;i<numberOfPlayers;i++) {
				Players.add(i, new Player(names[i],initialBalance)); // With initial balance and their names
			}
		}
		else {
			 System.out.println("Please enter number of Player between 2 and 8."); // wrong number of players
		}
	}
	
	//ArrayList of cards
	private ArrayList<ChanceCard> ChanceCards = new ArrayList<ChanceCard>(8);
	public ChanceCard getCardObject (int i) {	return ChanceCards.get(i);}
	public ArrayList<ChanceCard> getCardList(){return ChanceCards;}
	public int getChanceCardsListSize() {return ChanceCards.size();}
	public void createChanceCardList(ArrayList<ChanceCard> ChanceCards) {
		ChanceCards.add(0, new ChanceGoSquare("Move back three square", -3, true));//
		ChanceCards.add(1, new ChanceGoJail("Go to Jail without passing start point"));//
		ChanceCards.add(2, new ChanceGoSquare("Go to nearest Lot Square", 0,false));//
		ChanceCards.add(3, new ChanceGetMoney("Get double at train station"));
		ChanceCards.add(4, new ChanceGetMoney("Get 50$ from each player",50));//
		ChanceCards.add(5, new ChanceLoseMoney("Give 100$ to each player", 100));//
		ChanceCards.add(6, new ChanceGoSquare("Go to the Kadikoy", 31,false));//
		ChanceCards.add(7, new ChanceGetMoney("You rent a house"));
	}
	
	//Squares of board arraylist
	private ArrayList<Square> SquaresOfBoard = new ArrayList<Square>(40); 
	public Square getObject(int i) {return SquaresOfBoard.get(i);}
	public ArrayList<Square> getList() { return SquaresOfBoard;}
	public int getSquareArrayListSize() { return SquaresOfBoard.size();}
	public void createSquaresToBoard(ArrayList<Square> SquaresOfBoard) { // In this function, we create squares in board
		for(int i=0;i<40;i++) {
			if(i==0) {SquaresOfBoard.add(i, new StartingPoint(startingMoney,"Starting square"));}
			else if(i==1) {SquaresOfBoard.add(i, new City("Sultangazi", 60,"Brown"));}
			else if(i==2) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));			}
			else if(i==3) {SquaresOfBoard.add(i, new City("Bagcilar", 60,"Brown"));}
			else if(i==4) {SquaresOfBoard.add(i, new Tax("Payroll Tax", payTax));}
			else if(i==5) {SquaresOfBoard.add(i, new RailRoad("Ataturk Havalimani Metro",200));}
			else if(i==6) {SquaresOfBoard.add(i, new City("Eyup", 100,"Sky"));}
			else if(i==7) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));			}
			else if(i==8) {SquaresOfBoard.add(i, new City("Basaksehir", 100,"Sky"));}
			else if(i==9){SquaresOfBoard.add(i, new City("Beylikduzu", 120,"Sky"));}
			else if (i==10) { // Visiting jail square
				SquaresOfBoard.add(i, new RegularSquare()); 
				SquaresOfBoard.get(10).setName("Jail visitor");
			}
			else if(i==11) {SquaresOfBoard.add(i, new City("Sariyer", 140,"Pink"));}
			else if(i==12) {SquaresOfBoard.add(i, new Lot("BEDAS",150));}
			else if(i==13) {SquaresOfBoard.add(i, new City("Kartal", 140,"Pink"));}
			else if(i==14) {SquaresOfBoard.add(i, new City("Kavacik", 160,"Pink"));}
			else if(i==15) {SquaresOfBoard.add(i, new RailRoad("Kirazli Metro",200));}
			else if(i==16) {SquaresOfBoard.add(i, new City("Kagithane", 180,"Orange"));}
			else if(i==17) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));			}
			else if(i==18) {SquaresOfBoard.add(i, new City("Bakirkoy", 180,"Orange"));}
			else if(i==19) {SquaresOfBoard.add(i, new City("Gaziosmanpasa", 200,"Orange"));}
			else if(i==21) {SquaresOfBoard.add(i, new City("Umraniye", 220,"Red"));}
			else if(i==22) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));			}
			else if(i==23) {SquaresOfBoard.add(i, new City("Alemdag", 220,"Red"));}
			else if(i==24) {SquaresOfBoard.add(i, new City("Fatih", 240,"Red"));}
			else if(i==25) {SquaresOfBoard.add(i, new RailRoad("Taksim Metro",200));}
			else if(i==26) {SquaresOfBoard.add(i, new City("Avcilar", 260,"Yellow"));}
			else if(i==27) {SquaresOfBoard.add(i, new City("Sisli", 260,"Yellow"));}
			else if(i==28) {SquaresOfBoard.add(i, new Lot("Igdas",150));}
			else if(i==29) {SquaresOfBoard.add(i, new City("Uskudar", 280,"Yellow"));}
			else if(i==30) {SquaresOfBoard.add(i, new Jail());}
			else if(i==31) {SquaresOfBoard.add(i, new City("Kadikoy", 300,"Green"));}
			else if(i==32) {SquaresOfBoard.add(i, new City("Besiktas", 300,"Green"));}
			else if(i==33) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));}
			else if(i==34) {SquaresOfBoard.add(i, new City("Gungoren", 320,"Green"));}
			else if(i==35) {SquaresOfBoard.add(i, new RailRoad("T1 Kabatas Tramvay",200));}
			else if(i==36) {SquaresOfBoard.add(i, new ChanceSquare(ChanceCards));}
			else if(i==37) {SquaresOfBoard.add(i, new City("Bahcelievler", 350,"Blue"));}
			else if(i==38) {SquaresOfBoard.add(i, new Tax("Luxury Tax", luxTax));}
			else if(i==39) {SquaresOfBoard.add(i, new City("Bayrampasa", 400,"Blue"));}
			else {
				SquaresOfBoard.add(i, new RegularSquare()); 
			}
		}
	}
	
	//This method is arranging the city's rent price count of house and hotel. if players lose their city and lose their color make rent price default. 
	public void checkAndSetRent(Board board1) {
		ArrayList<String> defaultList= new ArrayList<String>(100);
		int houseCount;
		for (int i = 0; i < board1.getPlayerArrayListSize(); i++) { //for every player

			if(board1.getPlayer(i).getColorList().isEmpty()) {//if it is empty dont compare
				continue;
			}
			else {
				//compare players color and color of cities. And their buildings and set their rentprice
				for (int c=0; c<board1.SquaresOfBoard.size(); c++) {
					if(board1.getPlayer(i).getColorList().contains(board1.SquaresOfBoard.get(c).getColor())) {
						houseCount = board1.SquaresOfBoard.get(c).getBuildingList().size();
						if (board1.SquaresOfBoard.get(c).getBuildingList().isEmpty()){
							board1.SquaresOfBoard.get(c).setRentPrice(board1.SquaresOfBoard.get(c).getDefaultRentPrice()*2);
						} else {
							board1.SquaresOfBoard.get(c).setRentPrice(board1.SquaresOfBoard.get(c).getDefaultRentPrice()*((houseCount+1)*2));
						}
					}
				}
			}
			defaultList.addAll(board1.getPlayer(i).getColorList());
		}
		//default list if sold their city and colors are gone make default rent price
		Set<String> uniqueColor = new HashSet<String>(defaultList);
		for (int c=0; c<board1.SquaresOfBoard.size(); c++) {
			if(!uniqueColor.contains(board1.SquaresOfBoard.get(c).getColor())) {
				board1.SquaresOfBoard.get(c).setRentPrice(board1.SquaresOfBoard.get(c).getDefaultRentPrice());
			}
		}
	}
}
