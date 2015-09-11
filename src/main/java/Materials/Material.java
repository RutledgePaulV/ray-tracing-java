package Materials;

import Utilities.RGBColor;
import Utilities.ShadeRec;

public abstract class Material
{
	public abstract RGBColor path_shade(ShadeRec sr);
	public abstract RGBColor area_light_shade(ShadeRec sr);
	public abstract RGBColor shade(ShadeRec sr);
}
