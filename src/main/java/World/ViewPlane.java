package World;



import Samplers.Sampler;

import java.awt.*;

public class ViewPlane 
{
	public int 			hres;   					// horizontal image resolution 
	public int 			vres;   					// vertical image resolution
	public float		s;							// pixel size
		
	public float		gamma;						// gamma correction factor
	public float		inv_gamma;					// the inverse of the gamma correction factor
	public boolean		show_out_of_gamut;			// display red if RGBColor out of gamut
	public Sampler sampler;
	
	public ViewPlane(Dimension size, float pixelSize, Sampler sampler)
	{							
		this.sampler = sampler;
		this.sampler.generate_samples();
		hres = size.width;
		vres = size.height;
		s = pixelSize;
		gamma = 1f;
		inv_gamma = 1f;
		show_out_of_gamut = false;
	}
	
}
