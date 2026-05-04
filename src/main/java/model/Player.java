package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private String color;
	private int remainingArmiesToPlace;
	private List<Territory> controlledTerritories;

	public Player(int id, String name, String color, int remainingArmiesToPlace, List<Territory> controlledTerritories) {
		setId(id);
		setName(name);
		setColor(color);
		setRemainingArmiesToPlace(remainingArmiesToPlace);
		setControlledTerritories(controlledTerritories);
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

	public List<Territory> getControlledTerritories() {
		return controlledTerritories;
	}

	public void setControlledTerritories(List<Territory> territories) {
		if (territories == null) {
			this.controlledTerritories = new ArrayList<>();
		} else {
			this.controlledTerritories = new ArrayList<>(territories);
		}
	}

	public int getControlledTerritoryCount() {
		return controlledTerritories.size();
	}

	public void addControlledTerritory(Territory territory) {
		if (territory != null && !controlledTerritories.contains(territory)) {
			controlledTerritories.add(territory);
		}
	}

	
}
