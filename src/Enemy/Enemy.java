package Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Player.Player;

public abstract class Enemy {
	protected int maxHealth;
	protected int currentHealth;
	protected int attack;
	protected int speed;
	protected int defense;
	protected int expReward;
	protected String name;

	protected ArrayList<Attack> abilities;
	
	public Enemy (int health, int attack, int speed, int defense, int expReward, String name)
	{
		this.maxHealth = health;
		this.setCurrentHealth(health);
		this.attack = attack;
		this.speed = speed;
		this.defense = defense;
		this.name = name;
		this.expReward = expReward;
		this.abilities = new ArrayList<Attack>();
		
	}
	
	/**
	 * Randomly picks an attack from the ability list, and uses it against player
	 * @param player player to attack
	 */
	public void attack(Enemy enemy)
	{
		Random rand = new Random();
		int attackChoice = rand.nextInt(abilities.size()-1);
		Attack attack = abilities.get(attackChoice);
		System.out.println(attack);
		enemy.setCurrentHealth(attack.getDamage());
	}
	
	public ArrayList<Attack> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<Attack> abilities) {
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
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
	
	public void reduceHealth(int damage)
	{
		this.currentHealth -= damage;
	}

	public int getExpReward() {
		return expReward;
	}

}
