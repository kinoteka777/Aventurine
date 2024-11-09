package Enemy;

import java.util.HashMap;

abstract class Enemy {
	private int maxHealth;
	private int currentHealth;
	private int attack;
	private int speed;
	private int defense;
	private HashMap<String, Attack> abilities;
	
	public Enemy (int health, int attack, int speed, int defense)
	{
		this.maxHealth = health;
		this.setCurrentHealth(health);
		this.attack = attack;
		this.speed = speed;
		this.defense = defense;
		this.abilities = new HashMap<String, Attack>();
		
	}
	
	public boolean isDead()
	{
		if (currentHealth <= 0)
		{
			return true;
		}
		return false;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
}
