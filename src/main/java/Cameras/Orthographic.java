package Cameras;
import Utilities.*;
import World.World;

public class Orthographic extends Camera
{
	public Orthographic()
	{
		super();
	}
	
	public Orthographic(Point3D _eye, Point3D _look_at, Vector3D _up)
	{
		super(_eye, _look_at, _up);
	}
	
	public void render_scene(World world)
	{
		RGBColor	pixel_color;	 	
		Ray			ray 	= new Ray();					
		double		zw		= 100.0;			// hardwired in
		Point2D sp = new Point2D(), pp = new Point2D();

		ray.direction = new Vector3D(0, 0, -1);

		for (int r = 0; r < world.vp.vres; r++)
			for (int c = 0; c < world.vp.hres; c++) 
			{	
				pixel_color = new RGBColor(0); //starts at nothing
				for(int j = 0; j < world.vp.sampler.num_samples; j++)
				{
					sp = world.vp.sampler.sample_unit_square();
					pp.x = world.vp.s * (c - 0.5 * world.vp.hres + sp.x);
					pp.y = world.vp.s * (r - 0.5 * world.vp.hres + sp.y);
					ray.origin = new Point3D(pp.x, pp.y, zw);
					pixel_color = pixel_color.add_color(world.tracer.trace_ray(ray));
				}
				pixel_color = pixel_color.multiply_constant(1.0f/world.vp.sampler.num_samples);
				world.window.pane.SetPixel(pixel_color.toColor(), c,r);
			}	
	}

}
