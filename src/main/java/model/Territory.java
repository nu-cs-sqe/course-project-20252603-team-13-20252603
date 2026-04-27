package model;

public class Territory {
	private String name;
	private Player owner;
	private int armyCount;
	private Continent continent;

	public Territory() {
	}

	public Territory(String name, Player owner, int armyCount, Continent continent) {
		setName(name);
		setOwner(owner);
		setArmyCount(armyCount);
		setContinent(continent);
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

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getArmyCount() {
		return armyCount;
	}

	public void setArmyCount(int armyCount) {
		if (armyCount < 0) {
			throw new IllegalArgumentException("armyCount cannot be negative");
		}
		this.armyCount = armyCount;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		if (continent == null) {
			throw new IllegalArgumentException("continent cannot be null");
		}
		this.continent = continent;
	}
}
