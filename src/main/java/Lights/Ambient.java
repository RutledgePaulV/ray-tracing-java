package Lights;

import Utilities.RGBColor;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public class Ambient extends Light
{

	public float ls;
	public RGBColor color;
	
	public Ambient()
	{
		super();
		ls = 1;
		color = new RGBColor(1);
	}
	
	public Vector3D get_direction(ShadeRec s)
	{
		return new Vector3D(0);
	}

	public RGBColor L(ShadeRec s) 
	{
		return color.multiply_constant(ls);
	}
	
	

}
