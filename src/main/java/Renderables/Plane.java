package Renderables;
import Utilities.Point3D;
import Utilities.Ray;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public class Plane extends GeometricObject
{		
	private Point3D point;
	private Vector3D normal;
	private static final double kEpsilon = 0.001;
	
	public Plane(Point3D p, Vector3D normal)
	{
		this.point = p;
		this.normal = normal;
	}
	
	public double hit(Ray ray, double tmin, ShadeRec s) 
	{
		double t = ((point.vector_between(ray.origin)).dot_product(normal)) / ((ray.direction.dot_product(normal))); 
		
		if (t > kEpsilon)
		{
			s.normal = normal;
			s.local_hit_point = ray.origin.add_vector(ray.direction.multiply_constant(t));
			
			return t;	
		}

		return -1;
	}

}

	
