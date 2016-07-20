package MazeZ.Engine;

import MazeZ.Graphics.Position;

/**
 * Created by Eddy on 7/15/2016.
 */
public abstract class GameObject
{
	protected Position mPos;

	public GameObject()
	{
		this.mPos = new Position();
	}

	public GameObject(Position pos)
	{
		this.mPos = pos;
	}

	public Position getPosition()
	{
		return mPos;
	}

	public void setPosition(Position pos)
	{
		mPos = pos;
	}

	public void move(Position pos)
	{
		mPos.add(pos);
	}
}
