package Player;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

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
}
