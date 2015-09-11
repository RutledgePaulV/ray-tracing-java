package BRDFs;

import Utilities.RGBColor;

import Utilities.ShadeRec;
import Utilities.Vector3D;
import Utilities.Constants;

public class Lambertian extends BRDF 
{

	public  float diffuse_coefficient;
	public RGBColor color;
	
	public Lambertian()
	{
		diffuse_coefficient = 0;
		color = new RGBColor(0);
	}
	
	public RGBColor f(ShadeRec s, Vector3D in, Vector3D out) 
	{
		return color.multiply_constant((float)(diffuse_coefficient*Constants.invPI));
	}


	public RGBColor sample_f(ShadeRec s, Vector3D in, Vector3D out) 
	{
		return null;
	}

	
	public RGBColor rho(ShadeRec s, Vector3D out)
	{
		return color.multiply_constant(diffuse_coefficient);
	}

}
