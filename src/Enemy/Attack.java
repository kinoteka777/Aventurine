package Enemy;

public abstract class Attack {
	private String name;
	private float attackDmg;
	private int numAttacks;
	
	public Attack(String name, float multiplier, int numAttacks, int attack)
	{
		this.name = name;
		this.attackDmg = attack*multiplier;
		this.numAttacks = numAttacks;
	}
	
	@Override
	public String toString() 
	{
		String str = name + " used! Attacking "+numAttacks+" times for a total of "+attackDmg*numAttacks+" damage!";
		return str;
	}
	
	public int getDamage() 
	{
		return this.getDamage();
	}
}
