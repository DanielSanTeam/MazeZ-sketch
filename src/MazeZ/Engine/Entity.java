package MazeZ.Engine;

import MazeZ.Graphics.Drawable;
import MazeZ.Graphics.Position;

/**
 * Created by Eddy on 7/15/2016.
 */
public abstract class Entity extends GameObject implements Drawable
{
	protected int mHealth;
	protected char mSymbol;

	public Entity()
	{
		this('?', 100);
	}

	public Entity(char sym, int health)
	{
		this(sym, health, new Position());
	}

	public Entity(char sym, int health, Position pos)
	{
		super(pos);
		mSymbol = sym;
		mHealth = health;
	}

	public boolean isAlive()
	{
		if(mHealth >= 0)
			return true;
		return false;
	}

	public void setHealth(int health)
	{
		mHealth = health;
	}

	public int getHealth()
	{
		return mHealth;
	}

	public char getSymbol()
	{
		return mSymbol;
	}
}
