package Tracers;
import Utilities.RGBColor;
import Utilities.Ray;
import World.World;

public abstract class Tracer 
{
	protected World world;
	public abstract RGBColor trace_ray(Ray ray);
	public abstract RGBColor trace_ray(Ray ray, int depth);
	
	public Tracer()
	{
		world = null;
	}
	
	public Tracer(World world)
	{
		this.world = world;
	}
	
}
