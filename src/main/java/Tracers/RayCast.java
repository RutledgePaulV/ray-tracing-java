package Tracers;
import Utilities.RGBColor;
import Utilities.Ray;
import Utilities.ShadeRec;
import World.World;

public class RayCast extends Tracer
{

	public RayCast(World w)
	{
		super(w);
	}
	
	public RGBColor trace_ray(Ray ray) 
	{
		ShadeRec sr = world.hit_objects(ray);
		if(sr.hit_an_object)
		{
			sr.ray = ray;
			return sr.material.shade(sr);
		}
		else
		{
			return world.background_color;
		}
	}


	public RGBColor trace_ray(Ray ray, int depth) 
	{
		ShadeRec sr = world.hit_objects(ray);
		if(sr.hit_an_object)
		{
			sr.ray = ray;
			return sr.material.shade(sr);
		}
		else
		{
			return world.background_color;
		}
	}
	
}
