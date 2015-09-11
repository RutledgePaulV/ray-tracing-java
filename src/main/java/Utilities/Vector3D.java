package Utilities;

public class Vector3D 
{
	double x,y,z;
	public Vector3D()
	{
		this.x=0; this.y=0; this.z=0;
	}
	public Vector3D(double a)
	{
		this.x = a; this.y = a; this.z = a;
	}
	
	public Vector3D(double _x, double _y, double _z)
	{
		this.x = _x; this.y=_y; this.z=_z;
	}
	
	public Vector3D copy()
	{
		return new Vector3D(this.x,this.y,this.z);
	}
	
	public Vector3D multiply_constant(double a)
	{
		return new Vector3D(this.x*a,this.y*a,this.z*a);
	}
	
	public Vector3D add_vector(Vector3D v)
	{
		return new Vector3D(this.x+v.x,this.y+v.y,this.z+v.z);
	}
	
	public double dot_product(Vector3D v)
	{
		return this.x*v.x+this.y*v.y+this.z*v.z;
	}
	
	public Vector3D cross_product(Vector3D v)
	{
		return new Vector3D(this.y*v.z-this.z*v.y,this.x*v.z-this.z*v.x,this.x*v.y-this.y*v.x);
	}
	
	public Vector3D normalize()
	{
		double l = this.length();
		return new Vector3D(x/l,y/l,z/l);
	}
	
	public double length()
	{
		return Math.sqrt(this.length_squared());
	}
	
	public double length_squared()
	{
		return this.x*this.x + this.y*this.y + this.z*this.z;
	}
}
