package Samplers;
import Utilities.Point2D;

public class Jittered extends Sampler
{

	public Jittered(int _samples, int _sets) 
	{
		super(_samples, _sets);
	}

	public void generate_samples()
	{
		int n = (int) Math.sqrt(num_samples);
		num_samples = n*n;
		
		for(int p = 0; p < num_sets; p++)
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					samples.add(new Point2D((k+gen.nextFloat()) / n,(j+gen.nextFloat()) / n));
	}
	
}
