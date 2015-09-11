package Renderables;
import Utilities.*;

public class Sphere extends GeometricObject
{
	private Point3D 	center;     
	private double 		radius;				
	private static final double kEpsilon = 0.001;
	
	public Sphere(Point3D center, double radius)
	{
		this.center = center;
		this.radius = radius;
	}
	
	public double hit(Ray ray, double tmin, ShadeRec sr) 
	{
		double 		t;
		Vector3D	temp 	= ray.origin.vector_between(center);
		double 		a 		= ray.direction.dot_product(ray.direction);
		double 		b 		= 2.0 * temp.dot_product(ray.direction);
		double 		c 		= temp.dot_product(temp) - (radius * radius);
		double 		disc	= b * b - 4.0 * a * c;
		
		if (disc < 0.0)
			return(0);  // no hit
		else 
		{	
			double e = Math.sqrt(disc);
			double denom = 2.0 * a;
			t = (-b - e) / denom;    // smaller root
		
			if (t > kEpsilon) 
			{
				tmin = t;
				sr.normal 	 = temp.add_vector(ray.direction.multiply_constant(t)).multiply_constant(1/radius).normalize();
				sr.local_hit_point = ray.origin.add_vector(ray.direction.multiply_constant(t));
				return (tmin);
			} 
		
			t = (-b + e) / denom;    // larger root
		
			if (t > kEpsilon) 
			{
				tmin = t;
				sr.normal 	 = temp.add_vector(ray.direction.multiply_constant(t)).multiply_constant(1/radius).normalize();
				sr.local_hit_point = sr.local_hit_point = ray.origin.add_vector(ray.direction.multiply_constant(t));
				return (tmin);
			} 
		}
		
		return (0);
	}

}
