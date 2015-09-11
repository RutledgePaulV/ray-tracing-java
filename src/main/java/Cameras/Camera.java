package Cameras;


import Utilities.Point3D;
import Utilities.Vector3D;
import World.World;

public abstract class Camera
{
	protected Point3D eye, look_at;
	protected Vector3D up, u, v , w;
	protected float roll_angle, exposure_time;
	
	public Camera()
	{
		eye = new Point3D(0, 0, 100);
		look_at = new Point3D(0);
		roll_angle = 0;
		up = new Vector3D(0, 1, 0);
		u = new Vector3D(1, 0, 0);
		v=new Vector3D(0, 1, 0);
		w =new Vector3D(0, 0, 1);
		exposure_time=1;
	}
	
	public Camera(Point3D _eye, Point3D _look_at, Vector3D _up)
	{
		eye = _eye;
		look_at = _look_at;
		up = _up;
		u = new Vector3D(1, 0, 0);
		v=new Vector3D(0, 1, 0);
		w =new Vector3D(0, 0, 1);
		exposure_time=1;
		roll_angle = 0;
	}
	public void compute_uvw()
	{
		w = eye.vector_between(look_at);
		w = w.normalize();
		u = up.cross_product(w);
		u = u.normalize();
		v = w.cross_product(u);
		
		if (eye.x == look_at.x && eye.z == look_at.z && eye.y > look_at.y) { // camera looking vertically down
			u = new Vector3D(0, 0, 1);
			v = new Vector3D(1, 0, 0);
			w = new Vector3D(0, 1, 0);	
		}
		
		if (eye.x == look_at.x && eye.z == look_at.z && eye.y < look_at.y) { // camera looking vertically up
			u = new Vector3D(1, 0, 0);
			v = new Vector3D(0, 0, 1);
			w = new Vector3D(0, -1, 0);
		}
	}
	
	
	public abstract void render_scene(World world);
}
