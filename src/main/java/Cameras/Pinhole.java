package Cameras;
import World.World;
import Utilities.*;

public class Pinhole extends Camera
{
	float plane_distance, zoom;
	
	public Pinhole(float _plane_distance, float _zoom)
	{
		super();
		plane_distance = _plane_distance;
		zoom = _zoom;
	}

	public Pinhole(Point3D _eye, Point3D _look_at, Vector3D _up, float _plane_distance, float _zoom)
	{
		super(_eye, _look_at, _up);
		plane_distance = _plane_distance;
		zoom = _zoom;
	}
	
	public Vector3D ray_direction(Point2D p)
	{
		Vector3D dir = u.multiply_constant(p.x).add_vector(v.multiply_constant(p.y)).add_vector(w.multiply_constant(-plane_distance));
		return dir.normalize();
	}
	
	public void render_scene(World world) 
	{
		RGBColor pixel_color;
		Ray ray = new Ray();
		int depth = 0;
		Point2D sp= new Point2D(), pp= new Point2D();
		world.vp.s/=zoom;
		ray.origin = eye;
		
		for(int r = 0; r < world.vp.vres; r++)
			for(int c = 0; c < world.vp.hres; c++)
			{
				pixel_color = new RGBColor(0); // black
				
				for(int j = 0; j < world.vp.sampler.num_samples; j++)
				{
					sp = world.vp.sampler.sample_unit_square();
					pp.x = world.vp.s * (c - 0.5 * world.vp.hres + sp.x);
					pp.y = world.vp.s * (r - 0.5 * world.vp.hres + sp.y);
					ray.direction = ray_direction(pp);
					RGBColor color = world.tracer.trace_ray(ray,depth);
					pixel_color=pixel_color.add_color(world.tracer.trace_ray(ray,depth));
				}
				
				pixel_color=pixel_color.multiply_constant(1.0f/world.vp.sampler.num_samples);
				pixel_color=pixel_color.multiply_constant(exposure_time);
				world.window.pane.SetPixel(pixel_color.toColor(), c, r);
			}
	}


}
