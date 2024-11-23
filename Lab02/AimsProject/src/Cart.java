
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc [MAX_NUMBERS_ORDERED];
	
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == dvd) {
            	for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
            	--qtyOrdered;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("dvd" + (i+1) + " has been removed");
                break;
            }
        }
    }
    
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            	total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
