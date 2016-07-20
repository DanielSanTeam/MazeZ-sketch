package MazeZ.Engine;

import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Eddy on 7/18/2016.
 */
public class Player extends Entity
{
	private Collection<Item> mItems;

	public Player(Position pos)
	{
		super('$', 15, pos);
		mItems = new ArrayList<>();
	}

	public void useItem(int itemID)
	{
	}

	@Override
	public void draw(RenderWindow target)
	{
		target.setChar(mPos.x, mPos.y, mSymbol);
	}
}
