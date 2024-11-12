package Enemy;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Enemy {
	private HashMap<String, Object> inventory;
	private int level;
	private int nextLevelThreshold;
	private int currentExp;
	
	public Player(int health, int attack, int speed, int defense, String name) {
		super(health, attack, speed, defense, 0, name);
		this.inventory = new HashMap<String, Object>();
		this.level = 1;
		this.nextLevelThreshold = 100;
		this.currentExp = 0;
	}
	
	public void addExp(int exp)
	{
		//ensures negative numbers cannot be passed to function
		if (exp > 0)
		{
			System.out.println("Gained "+exp+" exp.");
			currentExp += exp;
			//loops incase several levels of exp are earned at once
			while (currentExp >= nextLevelThreshold)
			{
				levelUp();
			}
		}
	}
	
	/**
	 * increments level and stats
	 * resets currentExp and increases threshold for next level
	 * also restores player health to full
	 */
	private void levelUp()
	{
		level++;
		currentExp -= nextLevelThreshold;
		nextLevelThreshold *= 1.15; // increases threshold for next level by 15%
		System.out.println("Levelled up! "+name+" is now level "+level);
		
		maxHealth += 10;
		currentHealth = maxHealth;
		attack += 5;
		defense += 2;
		speed += 2;
		
		System.out.println("Health increased to: "+maxHealth);
		System.out.println("Attack increased to: "+attack);
		System.out.println("Defense increased to: "+defense);
		System.out.println("Speed increased to: "+speed);
		System.out.println("Health restored to max!");
	}
	
	@Override
	public void attack(Enemy enemy)
	{
		
		Scanner scan = new Scanner(System.in);
		Attack selectedAttack = null;
		//loops until valid input is entered
		while (true)
		{
			//prompts for user attack choice
			System.out.println("What attack would you like to use?");
			for (int i = 0; i < getAbilities().size()-1; i++)
			{
				System.out.println(i+1+") "+getAbilities().get(i).getName());
			}
			try {
				int userInput = scan.nextInt();
				if (userInput > 0 && userInput <= getAbilities().size())
				{
					selectedAttack = getAbilities().get(--userInput); //user input is decremented to account for 0 indexing
					break;
				} else {
					System.out.println("Please pick one of numbers presented.");
				}
			} catch (InputMismatchException e)
			{
	            System.out.println("Invalid input. Please enter a number.");
				scan.next();
			}
		}
		scan.close();
		
		if (selectedAttack != null)
		{
			System.out.println(selectedAttack);
			enemy.reduceHealth(selectedAttack.getDamage());
		} else {
			System.out.println("Whoops! Something went wrong. Src: Player.attack()");
		}
	}
	
	public int getLevel() {
		return level;
	}

}
