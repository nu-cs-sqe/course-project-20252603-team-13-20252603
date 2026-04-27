package model;

public class Player {

	private int id;
	private String name;
	private String color;
	private int remainingArmiesToPlace;

	public Player() {
	}

	public Player(int id, String name, String color, int remainingArmiesToPlace) {
		setId(id);
		setName(name);
		setColor(color);
		setRemainingArmiesToPlace(remainingArmiesToPlace);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("id cannot be negative");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or blank");
		}
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color == null || color.trim().isEmpty()) {
			throw new IllegalArgumentException("color cannot be null or blank");
		}
		this.color = color;
	}

	public int getRemainingArmiesToPlace() {
		return remainingArmiesToPlace;
	}

	public void setRemainingArmiesToPlace(int remainingArmiesToPlace) {
		if (remainingArmiesToPlace < 0) {
			throw new IllegalArgumentException("remainingArmiesToPlace cannot be negative");
		}
		this.remainingArmiesToPlace = remainingArmiesToPlace;
	}
}
