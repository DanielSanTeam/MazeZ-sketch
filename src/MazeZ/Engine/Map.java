package MazeZ.Engine;

import MazeZ.Graphics.Drawable;
import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Map extends GameObject implements Drawable
{
	private char mMapContent[][];

	static final char START_CHAR = '*';
	static final char END_CHAR = '#';

	public Map(Map m)
	{
		int x = m.mMapContent.length;
		int y = m.mMapContent[0].length;
		mMapContent = new char[x][y];

		for(int v = 0; v < mMapContent[0].length; ++v)
		{
			for(int u = 0; u < mMapContent.length; ++u)
			{
				mMapContent[u][v] = m.mMapContent[u][v];
			}
		}

		mPos = m.mPos;
	}

	public Map(String path)
	{
		File mapFile = new File(path);

		if(!mapFile.canRead())
		{
			System.err.printf("Cannot load \"%s\".%n", path);
		}

		List<String> lines = new ArrayList<>();

		try{
			BufferedReader in = new BufferedReader(new FileReader(mapFile));

			String line;
			while((line = in.readLine()) != null)
			{
				lines.add(line);
			}

			int width = 0;
			int height = 0;

			if(lines.size() != 0)
			{
				width = lines.get(0).length();
				height = lines.size();
			}

			mMapContent = new char[width][height];

			for(int u = 0; u < height; ++u)
			{
				for(int v = 0; v < width; ++v)
				{
					mMapContent[v][u] = lines.get(u).charAt(v);
				}
			}

			in.close();
		}
		catch (FileNotFoundException e)
		{
			System.err.printf("Cannot read file \"%s\"", path);
		}
		catch (IOException e)
		{
			System.err.println(String.format("Error trying to read \"%s\"", path));
		}
	}

	char getChar(int x, int y)
	{
		try
		{
			return mMapContent[x][y];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return ' ';
		}
	}

	void setChar(int x, int y, char c)
	{
		try
		{
			mMapContent[x][y] = c;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			// Do Nothing
		}
	}

	public Position getStart()
	{
		return findChar(START_CHAR);
	}

	public Position getEnd()
	{
		return findChar(END_CHAR);
	}

	private Position findChar(char c)
	{
		for(int v = 0; v < mMapContent[0].length; ++v)
		{
			for(int u = 0; u < mMapContent.length; ++u)
			{
				if(mMapContent[u][v] == c)
				{
					return new Position(u, v);
				}
			}
		}

		// Char not found
		return new Position(0,0);
	}

	@Override
	public void draw(RenderWindow target)
	{
		for(int y = 0; y < target.getRenderHeight(); ++y)
		{
			for(int x = 0; x < target.getRenderWidth(); ++x)
			{
				target.setChar(x,y, this.getChar(x + mPos.x, y + mPos.y));
			}
		}
	}
}
