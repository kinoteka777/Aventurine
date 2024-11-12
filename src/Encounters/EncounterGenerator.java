package Encounters;
import Enemy.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EncounterGenerator {
	private int enemyChance;
	private int neutralChance;
	private int friendlyChance;
	private Player player;
	private String currentBiome;
	
	//Maps potential enemies based on biome
	private HashMap<String, ArrayList<Enemy>> enemyEncounters;
	//private ArrayList<Encounter> neutralEncounters;
	//private ArrayList<Encounter> friendlyEncounters;
	
	/**
	 * determines odds of each encounter type
	 * recommended that sum value of these is 100 for clarity
	 * @param enemy int determining likelihood of enemy encounter
	 * @param neutral int determining likelihood of neutral encounter
	 * @param friendly int determining likelihood of friendly encounter
	 */
	public EncounterGenerator(int enemy, int neutral, int friendly, String currentBiome, Player player,
			HashMap<String, ArrayList<Enemy>> enemyEncounters) 
			//ArrayList<Encounter> neutralEncounters, 
			//ArrayList<Encounter> friendlyEncounters)
	{
		this.enemyChance = enemy;
		this.neutralChance = neutral;
		this.friendlyChance = friendly;
		this.currentBiome = currentBiome;
		this.player = player;
		this.enemyEncounters = enemyEncounters;
		//this.neutralEncounters = neutralEncounters;
		//this.friendlyEncounters = friendlyEncounters;
	}
	
	
	/**
	 * Gets the sum of all encounter type chances
	 * @return sum of chance types
	 */
	public int getSumChance()
	{
		return enemyChance + neutralChance + friendlyChance;
	}
	
	public void generateEncounter(int playerLevel)
	{
		// generates a random number between 0 and sum of all chance types (enemy + neutral + friendly)
		Random rand = new Random();
		int encounterChance = rand.nextInt(getSumChance());
		
		/*
		 * Encounter type is determined as such:
		 * Example: enemy chance = 70, neutral = 20, passive = 10;
		 * Sum of chances is 100
		 * if encounterChance is > 90 (70 + 20), it will be a passive encounter,
		 * else if 90 > encounterChance > 70, it will be a neutral encounter
		 * lower than 70 will result in an enemy encounter. 
		 */
		if (encounterChance > (getEnemyChance() + getNeutralChance()))
		{
			
		} 
		else if (encounterChance > getEnemyChance())
		{
			
		} 
		else
		{
			generateEnemyEncounter();
		}
	}
	
	private void generateEnemyEncounter()
	{
		ArrayList<Enemy> potentialEnemies = enemyEncounters.get(currentBiome);
		Random rand = new Random();
		int enemyChoice = rand.nextInt(potentialEnemies.size()-1);
		Enemy enemy = potentialEnemies.get(enemyChoice);
		
		int enemyStrength = enemy.getAttack() * enemy.getCurrentHealth() / 100;
		int enemyCount = (int) Math.floor(player.getLevel() / enemyStrength);
		
		EnemyEncounter encounter = new EnemyEncounter(player, enemy, enemyCount);
		encounter.StartCombatLoop();
		
	}
	
	public int getFriendlyChance() {
		return friendlyChance;
	}

	public void setFriendlyChance(int friendlyEncounterChance) {
		this.friendlyChance = friendlyEncounterChance;
	}

	public int getNeutralChance() {
		return neutralChance;
	}

	public void setNeutralChance(int neutralEncounterChance) {
		this.neutralChance = neutralEncounterChance;
	}

	public int getEnemyChance() {
		return enemyChance;
	}

	public void setEnemyChance(int enemyEncounterChance) {
		this.enemyChance = enemyEncounterChance;
	}
	
}
