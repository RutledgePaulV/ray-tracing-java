package Materials;
import BRDFs.Lambertian;
import Lights.Light;
import Utilities.RGBColor;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public class Matte extends Material
{
	private Lambertian ambient_brdf;
	private Lambertian diffuse_brdf;

	public Matte()
	{
		ambient_brdf = new Lambertian();
		diffuse_brdf = new Lambertian();
	}

	public void Set_Ka(float ka)
	{
		ambient_brdf.diffuse_coefficient = ka;
	}


	public void Set_Kd(float kd)
	{
		diffuse_brdf.diffuse_coefficient = kd;
	}

	public void Set_Cd(RGBColor cd)
	{
		ambient_brdf.color = cd;
		diffuse_brdf.color = cd;
	}
	public RGBColor path_shade(ShadeRec sr) 
	{
		return null;
	}

	@Override
	public RGBColor area_light_shade(ShadeRec sr)
	{
		return null;
	}


	public RGBColor shade(ShadeRec sr)
	{
		Vector3D wo = sr.ray.direction.multiply_constant(-1);
		RGBColor l = ambient_brdf.rho(sr, wo).multiply(sr.w.ambient.L(sr));
		
		for(Light light : sr.w.lights)
		{
			Vector3D wi = light.get_direction(sr);
			float ndotwi = (float) sr.normal.dot_product(wi);

			if(ndotwi>0)
				l = l.add_color(diffuse_brdf.f(sr, wo, wi).multiply(light.L(sr)).multiply_constant(ndotwi));
		}
		return l;
	}

}
