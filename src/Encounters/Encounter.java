package Encounters;
import java.util.ArrayList;
import Enemy.*;
import Player.Player;

public abstract class Encounter {
	private ArrayList<Enemy> participants;
	private Player player;

	public Encounter(Player player, Enemy enemy, int numEnemies)
	{
		this.player = player;
		if (enemy.getSpeed() > player.getSpeed())
		{
			for (int i = 0; i < numEnemies; i++)
			{
				//does not append number if only one enemy present
				if (numEnemies == 1)
				{
					participants.add(enemy);
				}
				//appends number next to enemy name for clarity
				enemy.setName(enemy.getName()+" "+i);
				participants.add(enemy);
			}
			participants.add(player);
		} else {
			participants.add(player);
			for (int i = 0; i < numEnemies; i++)
			{
				//does not append number if only one enemy present
				if (numEnemies == 1)
				{
					participants.add(enemy);
				}
				//appends number next to enemy name for clarity
				enemy.setName(enemy.getName()+" "+i);
				participants.add(enemy);
			}
		}
	}
	
	public void StartCombatLoop()
	{
		while (!player.isDead() || participants.size() > 1)
		{
			for (Enemy participant : participants)
			{
				if (participant instanceof Player)
				{
					System.out.println(participant.getName()+"'s turn!");
					//add line reader shiz here
					Enemy selectedEnemy;
					participant.attack(selectedEnemy);
				}
				else 
				{
					System.out.println(participant.getName()+"'s turn!");
					participant.attack(player);
					System.out.println(player.getName()+" health: "+player.getCurrentHealth());
				}
			}
		}
	}
}
