package MazeZ.Engine;

import MazeZ.Graphics.GameWindow;

import javax.swing.*;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Game extends JFrame
{
	private GameWindow mGameWindow;

	public Game()
	{
		// Create game window
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 800);
		this.setLocation(100, 100);

		mGameWindow = new GameWindow();
		this.add(mGameWindow);
	}



	public void run()
	{
		this.setVisible(true);
	}
}
