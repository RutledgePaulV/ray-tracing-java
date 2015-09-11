package Utilities;


public class Point3D 
{
	public double x, y ,z;
	
	public Point3D()
	{
		this.x=0; this.y=0; this.z=0;
	}
	
	public Point3D copy()
	{
		return new Point3D(this.x,this.y,this.z);
	}
	
	public Point3D(double a)
	{
		x = y = z = a;
	}
	public Point3D(double _x, double _y, double _z)
	{
		this.x = _x; this.y = _y; this.z = _z;
	}
	
	public Point3D multiply_constant(double a)
	{
		return new Point3D(this.x*a,this.y*a,this.z*a);
	}
	
	public Point3D add_vector(Vector3D v)
	{
		return new Point3D(this.x+v.x,this.y+v.y,this.z+v.z);
	}
	
	public Point3D subtract_vector(Vector3D v)
	{
		return new Point3D(this.x-v.x,this.y-v.y,this.z-v.z);
	}
	
	public Vector3D vector_between(Point3D p)
	{
		return new Vector3D(this.x-p.x,this.y-p.y,this.z-p.z);
	}
	
	public Point3D negate_point()
	{
		return new Point3D(this.x*-1,this.y*-1,this.z*-1);
	}
	
	public double distance_squared(Point3D p)
	{
		return (this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y)+(this.z-p.z)*(this.z-p.z);
	}
	
	public double distance(Point3D p)
	{
		return Math.sqrt(this.distance_squared(p));
	}
	
}
