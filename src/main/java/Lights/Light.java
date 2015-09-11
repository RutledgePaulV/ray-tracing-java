package Lights;

import Utilities.RGBColor;
import Utilities.ShadeRec;
import Utilities.Vector3D;

public abstract class Light 
{
	protected boolean shadows;
	public abstract Vector3D get_direction(ShadeRec s);
	public abstract RGBColor L(ShadeRec s);
}
