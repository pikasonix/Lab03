package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public Media() {
			
	}
    
    public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
	
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
    
	public void play() {
        System.out.println("Playing media");
    }
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Media media) {
            return media.title.equals(this.title);
        }
        return false;
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().equals(title);
    }

    public boolean isMatch(int id) {
        return this.getId()==id;
    }

}
