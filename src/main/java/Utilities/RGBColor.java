package Utilities;


import java.awt.*;

public class RGBColor
{
	public float	r, g, b;
	
	public RGBColor()
	{
		r = g = b = 0;
	}
	public RGBColor(float a)
	{
		r = g = b = a;
	}
	public RGBColor(float _r, float _g, float _b)
	{
		r = _r;
		g = _g;
		b = _b;
	}
	
	public RGBColor add_color(RGBColor c)
	{
		return new RGBColor(r+c.r,g+c.g,b+c.b);
	}
	
	public RGBColor multiply_constant(float a)
	{
		return new RGBColor(a*r,a*g,a*b);
	}
	
	
	public RGBColor(Color c)
	{
		r = c.getRed()/255f;
		g = c.getGreen()/255f;
		b = c.getBlue()/255f;
		
	}
	public Color toColor()
	{
		return new Color(r,g,b);
	}
	
	public String toString()
	{
		return "Red: " + r + " Green: " + g + " Blue: " + b + "\n";
	}
	public RGBColor multiply(RGBColor l) 
	{
		return new RGBColor(r*l.r,g*l.g,b*l.b);
	}
}
