package Utilities;
import Materials.Material;
import World.World;

public class ShadeRec 
{
	public boolean 			hit_an_object;		// did the ray hit an object?
	public Material			material;
	public Point3D			hit_point;
	public Point3D			local_hit_point;	// world coordinates of hit point 
	public Vector3D			normal;				// normal at hit point
	public RGBColor			color;				// used in Chapter 3 only
	public Ray 				ray;
	public int				depth;
	public Vector3D			direction;
	public World			w;					// world reference for shading
	public float            t;
	

	public ShadeRec(World wr) 
	{ 
		hit_an_object = false;
		material = null;
		hit_point = new Point3D();
		local_hit_point = new Point3D();
		normal = new Vector3D();
		ray = new Ray();
		depth = 0;
		direction = new Vector3D();
		color = wr.background_color;
		w = wr;
	}
}
