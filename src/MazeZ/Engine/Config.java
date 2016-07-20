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
		// Load map files
		maps = new ArrayList<>();
		maps.add(new Map("maps/MazeEddy.txt"));
		mCurrentLevel = 0;
		mDeathCount = 0;

	}

	public static Config getInstance()
	{
		if(instance == null)
			instance = new Config();

		return instance;
	}

	public Map getMap(int index)
	{
		return maps.get(index);
	}
}
