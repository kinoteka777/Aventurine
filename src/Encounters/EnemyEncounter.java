package Encounters;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Enemy.*;
import Player.Player;

public abstract class EnemyEncounter {
	private ArrayList<Enemy> enemies;
	private Player player;

	public EnemyEncounter(Player player, Enemy enemy, int numEnemies)
	{
		this.player = player;
		
		if (enemy.getSpeed() > player.getSpeed())
		{
			for (int i = 0; i < numEnemies; i++)
			{
				//does not append number if only one enemy present
				if (numEnemies == 1)
				{
					enemies.add(enemy);
				}
				//appends number next to enemy name for clarity
				enemy.setName(enemy.getName()+" "+i);
				enemies.add(enemy);
			}
		}
	}
	
	public void StartCombatLoop()
	{
		while (!player.isDead() || enemies.size() > 0)
		{
			System.out.println(player.getName()+"'s turn!");
			Enemy selectedEnemy = getPlayerAttackChoice();
			player.attack(selectedEnemy);
			
			for (Enemy enemy : enemies)
			{
				System.out.println(enemy.getName()+"'s turn!");
				enemy.attack(player);
				System.out.println(player.getName()+" health: "+player.getCurrentHealth());
			}
		}
	}
	
	private Enemy getPlayerAttackChoice()
	{
		Scanner scan = new Scanner(System.in);
		Enemy selectedEnemy = null;
		while (true)
		{
			System.out.println("Which enemy would you like to attack?");
			for (int i = 0; i < enemies.size()-1; i++)
			{
				System.out.println(i+1+") "+enemies.get(i).getName());
			}
			try {
				int userInput = scan.nextInt();
				if (userInput > 0 && userInput <= enemies.size())
				{
					selectedEnemy = enemies.get(userInput);
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
		return selectedEnemy;
		
	}
}