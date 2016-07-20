package MazeZ.Engine;

import MazeZ.Graphics.GameWindow;
import MazeZ.Graphics.RenderWindow;

import javax.swing.*;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Game extends JFrame
{
	private GameWindow mGameWindow;
	private RenderWindow mRenderWindow;

	public Game()
	{
		// Create game window
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 800);
		this.setLocation(100, 100);

		// Create Render Window
		mRenderWindow = new RenderWindow(50, 25);

		mGameWindow = new GameWindow(mRenderWindow);
		this.add(mGameWindow);
	}



	public void run()
	{
		this.setVisible(true);
	}
}
