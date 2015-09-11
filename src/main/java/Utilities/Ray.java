package Utilities;


public class Ray 
{

	public Point3D origin;
	public Vector3D direction;
	
	public Ray()
	{
		this.origin = new Point3D();
		this.direction = new Vector3D();
	}
	
	public Ray(Point3D _origin, Vector3D _direction)
	{
		this.origin = _origin;
		this.direction = _direction;
	}
	
	public Ray copy()
	{
		return new Ray(this.origin,this.direction);
	}
}
