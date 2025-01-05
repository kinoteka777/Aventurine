package Encounters;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Enemy.*;

public class EnemyEncounter {
	private ArrayList<Enemy> enemies;
	private Player player;

	public EnemyEncounter(Player player, Enemy enemy, int numEnemies)
	{
		this.player = player;
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
	
	/**
	 * Core functionality of this class. Loops with Player attacking first, then enemy/ies attacking.
	 * When no enemies are left in list, loop is finished and exp is rewarded
	 * If player dies during loop, game ends
	 */
	public void StartCombatLoop()
	{
		int expEarned = 0;
		while (enemies.size() > 0)
		{
			System.out.println(player.getName()+"'s turn!");
			Enemy selectedEnemy = getPlayerAttackChoice();
			player.attack(selectedEnemy);
			if (selectedEnemy.isDead())
			{
				System.out.println(selectedEnemy.getName()+" died!");
				expEarned += selectedEnemy.getExpReward();
				player.updateQuests(selectedEnemy.getName());
				enemies.remove(selectedEnemy);
			}
			
			for (Enemy enemy : enemies)
			{
				System.out.println(enemy.getName()+"'s turn!");
				enemy.attack(player);
				//if player dies, terminate program
				if (player.isDead())
				{
					System.out.println("You died! Thanks for participating in the wonderful world of Adventurine!!!");
					try {
						Thread.sleep(5000);
						System.exit(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(player.getName()+" health: "+player.getCurrentHealth());
			}
		}
		System.out.println("[ALL ENEMIES SLAIN]");
		player.addExp(expEarned);
	}
	
	/**
	 * prompts for user input on which enemy to attack
	 * @return selected Enemy to attack
	 */
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
