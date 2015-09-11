package Lights;

import Utilities.Point3D;
import Utilities.RGBColor;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public class Point extends Light
{

	public float ls;
	public RGBColor color;
	public Point3D location;
	
	public Vector3D get_direction(ShadeRec s) 
	{
		return location.vector_between(s.hit_point).normalize();
	}

	public RGBColor L(ShadeRec s) 
	{
		return color.multiply_constant(ls);
	}

}
