package Renderables;
import Materials.Material;
import Utilities.Ray;
import Utilities.ShadeRec;

public abstract class GeometricObject 
{
	public abstract double hit(Ray ray, double t, ShadeRec s);
	public Material material;

	public Material get_material()
	{
		return material;
	}
}
