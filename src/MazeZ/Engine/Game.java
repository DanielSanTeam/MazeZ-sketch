package MazeZ.Engine;

import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;
import javafx.geometry.Pos;

import javax.swing.*;

import static MazeZ.Engine.Player.*;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Game extends JFrame
{
	private GameWindow mGameWindow;
	private RenderWindow mRenderWindow;
	private Player mPlayer;
	private Map mCurrentMap;
	private Map mCanvas;

	public Game()
	{
		// Create game window
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 800);
		this.setLocation(100, 100);
		this.setVisible(true);

		// Create Render Window
		mRenderWindow = new RenderWindow(50, 25);

		mGameWindow = new GameWindow(mRenderWindow);
		this.add(mGameWindow);
	}

	private void init()
	{
		// Get Map
		mCurrentMap = Config.getInstance().getMap();

		// Setup Canvas
		mCanvas = new Map(mCurrentMap);

		// Create Player in center of window
		mPlayer = new Player(this, mCurrentMap.getStart());

		// Attach Controls
		mGameWindow.controls.attach(mPlayer);
	}

	public void run()
	{
		init();
		update();
	}

	void update()
	{
		mCanvas = new Map(mCurrentMap);
		Position lastPlayerPosition = new Position(mPlayer.getPosition());
		Position lastMapPosition = new Position(mCanvas.getPosition());
		switch(mPlayer.movement)
		{
			case NONE:
				break;
			case UP:
			{
				mPlayer.move(new Position(0, -1));
				//mCanvas.move(new Position(0, -1));
			}break;
			case LEFT:
			{
				mPlayer.move(new Position(-1, 0));
				//mCanvas.move(new Position(-1, 0));
			}break;
			case DOWN:
			{
				mPlayer.move(new Position(0, 1));
				//mCanvas.move(new Position(0, 1));
			}break;
			case RIGHT:
			{
				mPlayer.move(new Position(1, 0));
				//mCanvas.move(new Position(1, 0));
			}break;
		}
		char charAtPlayersPosition = mCurrentMap.getChar(mPlayer.getPosition().x, mPlayer.getPosition().y);
		if(charAtPlayersPosition == '@')
		{
			mPlayer.setPosition(lastPlayerPosition);
			mCanvas.setPosition(new Position(0,0));
		}
		else if(charAtPlayersPosition == mCurrentMap.END_CHAR)
		{
			Config.getInstance().nextLevel();
			run();
			return;
		}
		mCanvas.setPosition(Position.subtract(mPlayer.getPosition(), new Position(mRenderWindow.getRenderWidth() / 2, mRenderWindow.getRenderHeight() / 2)));

		// Reset Player Movement
		mPlayer.movement = Move.NONE;

		// Draw scene
		mCanvas.setChar(mPlayer.getPosition().x, mPlayer.getPosition().y, mPlayer.getSymbol());
		draw();
	}

	private void draw()
	{
		mRenderWindow.draw(mCanvas);
		mRenderWindow.display();
	}
}
