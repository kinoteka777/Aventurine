package Biomes;

public class Quest {
	private int killsNeeded;
	private int currentKills;
	private String targetName;
	private int expReward;
	
	public Quest(int killsNeeded, int currentKills, int expReward, String targetName)
	{
		this.killsNeeded = killsNeeded;
		this.currentKills = currentKills;
		this.targetName = targetName;
		this.expReward = expReward;
	}
	
	/**
	 * 
	 * @param enemyName Name of monster that was killed, to compare to target monster
	 * @return exp reward, 0 if quest not complete.
	 */
	public int updateQuest(String enemyName) 
	{
		if (enemyName.equals(targetName))
		{
			currentKills++;
			System.out.println(targetName+" slain! "+this.currentKills+"/"+this.killsNeeded);
		}
		
		if ( currentKills >= killsNeeded)
		{
			System.out.println("Well done! You have slain "+this.killsNeeded+" "+
					this.targetName+"/s. You have received "+this.expReward+" exp as a reward.");
			return this.expReward;
		}
		return 0;
	}
}
