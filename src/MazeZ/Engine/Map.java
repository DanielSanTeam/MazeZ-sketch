package MazeZ.Engine;

import MazeZ.Graphics.Drawable;
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

	Map(String path)
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

	private char getChar(int x, int y)
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
