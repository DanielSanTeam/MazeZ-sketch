package MazeZ.Engine;

import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Eddy on 7/18/2016.
 */
public class Player extends Entity
{
	private Collection<Item> mItems;

	private Game mGame;

	final ActionListener UP;
	final ActionListener DOWN;
	final ActionListener LEFT;
	final ActionListener RIGHT;

	enum Move {NONE, UP, LEFT, DOWN, RIGHT};
	Move movement;

	public Player(Game game, Position pos)
	{
		super('$', 15, pos);
		mItems = new ArrayList<>();

		mGame = game;

		movement = Move.NONE;

		UP = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.UP;
				mGame.update();
			}
		};

		DOWN = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.DOWN;
				mGame.update();
			}
		};

		LEFT = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.LEFT;
				mGame.update();
			}
		};

		RIGHT = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.RIGHT;
				mGame.update();
			}
		};
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
