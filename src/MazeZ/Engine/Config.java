package MazeZ.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Config
{
	private static Config instance = null;
	public boolean DEBUG = true;

	private List<Map> maps;
	private int mCurrentLevel;
	private int mDeathCount;

	private Config()
	{
		mCurrentLevel = 0;
		mDeathCount = 0;

		maps = new ArrayList<>();

		// Load map files
		maps.add(new Map("maps/MazeEddy.txt"));
		maps.add(new Map("maps/TestMaze.txt"));

	}

	public static Config getInstance()
	{
		if(instance == null)
			instance = new Config();

		return instance;
	}

	public void nextLevel()
	{
		++mCurrentLevel;
		if(mCurrentLevel == maps.size())
		{
			--mCurrentLevel;
		}
	}

	public Map getMap()
	{
		return maps.get(mCurrentLevel);
	}

	public Map getMap(int index)
	{
		return maps.get(index);
	}
}
