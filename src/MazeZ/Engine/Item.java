package MazeZ.Engine;

/**
 * Created by Eddy on 7/18/2016.
 */
public abstract class Item extends GameObject
{
	private int mID;

	public abstract void use(Player p);

	public int getID()
	{
		return mID;
	}
}
