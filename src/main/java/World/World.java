package World;

import Lights.Light;
import Renderables.GeometricObject;
import Utilities.*;
import Tracers.*;

import java.util.Vector;

public class World 
{
	public ViewPlane	vp;
	public RGBColor		background_color;
	public Tracer		tracer;
	public RenderWindow window;
	public Light ambient;
	public Vector<Light> lights;
	public Vector<GeometricObject>	objects;
	

	public World(RenderWindow _window, Vector<GeometricObject> _objects, Light _ambient, Vector<Light> _lights, ViewPlane _plane, RGBColor _background)
	{
		this.window = _window;
		this.tracer = new RayCast(this);
		this.ambient = _ambient;
		this.lights = _lights;
		this.objects = _objects;
		this.vp = _plane;
		this.background_color = _background;
	}

	public ShadeRec hit_objects(Ray ray)
	{
		ShadeRec s = new ShadeRec(this);
		double t = 0;
		Point3D local_hit_point = new Point3D();
		double tmin = Constants.kHugeValue;
		
		for(GeometricObject obj : objects)
		{
			t = obj.hit(ray, t, s);
			
			if (t!=0 && t < tmin)
			{
				s.hit_an_object = true;
				tmin = t;
				s.material = obj.get_material();
				s.hit_point = ray.origin.add_vector(ray.direction.multiply_constant(t));
				local_hit_point = s.local_hit_point;
			}
		}
		
		if (s.hit_an_object)
		{
			s.t = (float) tmin;
			//s.normal = normal;
			s.local_hit_point = local_hit_point;
		}
		
		return s;
	}

}
