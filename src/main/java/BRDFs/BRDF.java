package BRDFs;

import Samplers.Sampler;
import Utilities.RGBColor;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public abstract class BRDF 
{
	protected Sampler sampler;
	public abstract RGBColor f(ShadeRec s, Vector3D in, Vector3D out);
	public abstract RGBColor sample_f(ShadeRec s, Vector3D in, Vector3D out);
	public abstract RGBColor rho(ShadeRec s, Vector3D out);
}
