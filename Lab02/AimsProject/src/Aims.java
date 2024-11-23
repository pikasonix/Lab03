
public class Aims {
	
	public static void main(String[] args) {
		//Create a new cart 
		Cart anOrder = new Cart(); 
		//Create new DVD objects and add them to the cart 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		anOrder. addDigitalVideoDisc(dvd1); 
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f); 
		anOrder. addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); 
		anOrder. addDigitalVideoDisc(dvd3); 
		
		// test remove
		anOrder.removeDigitalVideoDisc(dvd2);

		//print total cost of the items in the cart 
		System.out.println("Total Cost is: ");
		System.out.printf("%.2f", anOrder.totalCost()); 
	}
}
