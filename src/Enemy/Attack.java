package Enemy;

public abstract class Attack {
	private String name;
	private float multiplier;
	private int numAttacks;
	
	public Attack(String name, float multiplier, int numAttacks)
	{
		this.name = name;
		this.multiplier = multiplier;
		this.numAttacks = numAttacks;
	}
	
}
