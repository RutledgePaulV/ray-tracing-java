package Tracers;

import Utilities.*;
import World.World;


public class MultipleObjects extends Tracer {

	public MultipleObjects() 
	{
		super();
	}
			
	public MultipleObjects(World world) 
	{
		super(world);
	}

	public RGBColor trace_ray(Ray ray)
	{
		ShadeRec sr = world.hit_objects(ray); 
			
		if (sr.hit_an_object)   
			return (sr.color);   
		else
			return (world.background_color);
	}

	public RGBColor trace_ray(Ray ray, int depth) 
	{
		return trace_ray(ray);
	}

}
