import Cameras.Pinhole;
import Lights.Ambient;
import Lights.Light;
import Materials.Matte;
import Renderables.GeometricObject;
import Renderables.Sphere;
import Samplers.Jittered;
import Samplers.Sampler;
import Utilities.*;
import World.*;
import Lights.Point;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Initial 
{
	public static void main(String[] args)
	{
		Dimension size = new Dimension(600,600);
		RGBColor background = new RGBColor(0);

		Sampler sampler = new Jittered(36,83);

		Vector<Light> lights = new Vector<>();
		Vector<GeometricObject> renderables = new Vector<GeometricObject>();
		RenderWindow window = new RenderWindow(size,"Render Window",Color.white);
		ViewPlane plane = new ViewPlane(size,0.5f,sampler);

		Ambient ambient = new Ambient();
		ambient.ls = 1.0f;
		ambient.color = new RGBColor(1);

		Point light1 = new Point();
		light1.location = new Point3D(100,50,150);
		light1.ls = 3;
		light1.color = new RGBColor(1);
		
		Point light2 = new Point();
		light2.location = new Point3D(0,0,0);
		light2.ls = 3;
		light2.color = new RGBColor(1);
		
		//lights.add(light1);
		lights.add(light2);
		
		Matte m = new Matte();
		m.Set_Ka(0.1f);
		m.Set_Kd(0.9f);
		m.Set_Cd(new RGBColor(1,0,0));

		int count = 8;
		Random generator = new Random(System.currentTimeMillis());
		
		for(int index = 0; index < count; index++)
		{
			Point2D on_circle = GetPointOnCircle((index/(float)count*360), 70);
			int x = (int)on_circle.x;
			int y = (int)on_circle.y;
			int z = 75-generator.nextInt(150);
			
			Sphere s = new Sphere(new Point3D(x, y, z), 20);//generator.nextInt(20)+5);
			s.material = m;
			renderables.add(s);
		}
		
		World w = new World(window,renderables,ambient,lights,plane,background);

		Point3D eye = new Point3D(0,0,10000);
		Point3D look_at = new Point3D(0,0,0);
		Vector3D up = new Vector3D(0,1,0);

		Pinhole camera = new Pinhole(eye,look_at,up,15000,1);
		camera.compute_uvw();
		
		camera.render_scene(w);
	}

	public static Point2D GetPointOnCircle(double angle, double radius)
	{
		angle *= Constants.PI_ON_180;
		return new Point2D(radius*Math.cos(angle),radius*Math.sin(angle));
	}
}
