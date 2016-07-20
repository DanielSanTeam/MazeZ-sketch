package MazeZ.Graphics;

/**
 * Created by Eddy on 7/15/2016.
 */
public class Position
{
	public int x;
	public int y;

	public Position()
	{
		this.x = 0;
		this.y = 0;
	}

	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Position(Position pos)
	{
		this.x = pos.x;
		this.y = pos.y;
	}

	public Position add(Position pos)
	{
		this.x += pos.x;
		this.y += pos.y;

		return this;
	}

	public static Position add(Position p1, Position p2)
	{
		Position result = new Position(p1);
		result.add(p2);

		return result;
	}

	public Position subtract(Position pos)
	{
		this.x -= pos.x;
		this.y -= pos.y;

		return this;
	}

	public static Position subtract(Position p1, Position p2)
	{
		Position result = new Position(p1);
		result.subtract(p2);

		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Position position = (Position) o;

		if (x != position.x) return false;
		return y == position.y;

	}

	@Override
	public int hashCode()
	{
		int result = x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString()
	{
		return String.format("Position(%d,%d)", x, y);
	}
}
