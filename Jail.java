public class Jail extends Square {
	private String name="Jail Square";
	public Jail() {
	}

	public String getName() { 
		return name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public void landedOn(Player player,Square location, Board board) {
		
		if (player.isInJail(player)) {// Enter the jail
			System.out.println("Your new location is goToJAIL... JAILED\n");
			player.setJail(true); // Jail count is true
			player.getPiece().setlocation(10);
		}	
	}
}