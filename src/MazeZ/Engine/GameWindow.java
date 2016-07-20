package MazeZ.Engine;

import MazeZ.Engine.Config;
import MazeZ.Engine.Map;
import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eddy on 7/15/2016.
 */

/*
Console Dimensions are 50x25
Font:	Courier New
Style:	Font.PLAIN
Size:	18
 */

public class GameWindow extends JPanel
{
	private final Dimension mControlPanelSize = new Dimension(600, 200); // Size of Control Section
	private JPanel mControlSection;

	private RenderWindow mRenderWindow;

	Controls controls;

	public GameWindow(RenderWindow rw)
	{
		super();

		// Grab reference
		mRenderWindow = rw;

		// Create Controls
		controls = new Controls();

		// Setup MazeZ.Engine UI
		this.setLayout(new BorderLayout());

		mControlSection = new JPanel();
		mControlSection.setPreferredSize(mControlPanelSize);
		this.add(mControlSection, BorderLayout.SOUTH);

		final int DISPLAY_MARGIN_LR = 14;
		final int DISPLAY_MARGIN_TB = 16;

		JPanel displayContainer = new JPanel();
		displayContainer.setLayout(new GridLayout(1,1));
		displayContainer.setBorder(new EmptyBorder(DISPLAY_MARGIN_TB, DISPLAY_MARGIN_LR, DISPLAY_MARGIN_TB, DISPLAY_MARGIN_LR));

		displayContainer.add(mRenderWindow);

		this.add(displayContainer, BorderLayout.CENTER);

		if(Config.getInstance().DEBUG)
		{
			JButton test = new JButton("TEST");
			mControlSection.add(test);

			test.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Map map = Config.getInstance().getMap(0);
					mRenderWindow.draw(map);
					mRenderWindow.display();
					map.move(new Position(1, 1));
				}
			});
		}
	}

	private class Controls extends JPanel
	{
		JButton mUp, mDown, mLeft, mRight;

		public Controls()
		{
			this.setLayout(new GridLayout(3, 3));

			mUp = new JButton("/\\");
			mLeft = new JButton("<");
			mRight = new JButton(">");
			mDown = new JButton(("\\/"));

			this.add(new JLabel());
			this.add(mUp);
			this.add(new JLabel());

			this.add(mLeft);
			this.add(new JLabel());
			this.add(mRight);

			this.add(new JLabel());
			this.add(mDown);
			this.add(new JLabel());
		}
	}

	//public void draw(Drawable drawable)
	//{
	//	mRenderWindow.draw(drawable);
	//}

	//public void display()
	//{
	//	mRenderWindow.display();
	//}
}
