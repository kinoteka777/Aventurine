package Player;

import java.util.HashMap;
import Enemy.*;

public class Player extends Enemy {
	private HashMap<String, Object> inventory;
	public Player(int health, int attack, int speed, int defense, String name) {
		super(health, attack, speed, defense, name);
		this.inventory = new HashMap<String, Object>();
	}
	
	@Override
	public void attack(Enemy enemy)
	{
		
	}
}
