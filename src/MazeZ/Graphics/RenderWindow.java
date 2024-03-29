package MazeZ.Graphics;

import MazeZ.Engine.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Eddy on 7/15/2016.
 */
public class RenderWindow extends JTextArea
{
	private char mRenderSpace[][];
	private int mWidth;
	private int mHeight;

	public RenderWindow(int width, int height)
	{
		super();
		mWidth = width;
		mHeight = height;

		mRenderSpace = new char[mWidth][mHeight];

		for(int u = 0; u < mHeight; ++u)
		{
			for(int v = 0; v < mWidth; ++v)
			{
				mRenderSpace[v][u] = ' ';
			}
		}

		final int DISPLAY_PADDING_LR = 8;
		final int DISPLAY_PADDING_TB = 8;

		this.setBackground(Color.BLACK);
		this.setForeground(Color.GREEN);
		this.setBorder(new EmptyBorder(DISPLAY_PADDING_TB, DISPLAY_PADDING_LR, DISPLAY_PADDING_TB, DISPLAY_PADDING_LR));
		this.setEditable(false);
		this.setFont(new Font("Courier New", Font.PLAIN, 18));
	}

	public int getRenderWidth()
	{
		return mWidth;
	}

	public int getRenderHeight()
	{
		return mHeight;
	}

	public char getChar(int x, int y)
	{
		try
		{
			return mRenderSpace[x][y];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return '?';
		}
	}

	public void setChar(int x, int y, char c)
	{
		if(x < mWidth && y < mHeight)
		{
			mRenderSpace[x][y] = c;
		}
		else
		{
			System.err.printf("RenderWindow|\tX:%s,Y:%s is not a valid position.%n",x, y);
		}
	}

	public void draw(Drawable drawable)
	{
		drawable.draw(this);
	}

	public void display()
	{
		this.setText(null);
		for(int v = 0; v < mHeight; ++v)
		{
			for(int u = 0; u < mWidth; ++u)
			{
				char c = this.getChar(u, v);
				this.append(Character.toString(c));
			}
			this.append("\n");
		}
	}
}
