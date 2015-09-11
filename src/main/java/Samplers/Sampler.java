package Samplers;



import Utilities.Point2D;

import java.util.ArrayList;
import java.util.Random;

public abstract class Sampler 
{
	protected Random gen;
	public int num_samples;
	protected int num_sets;
	protected ArrayList<Point2D> samples;
	protected ArrayList<Integer> shuffled_indices;
	protected long count;
	protected int jump;
	
	public Sampler(int _samples, int _sets)
	{
		samples = new ArrayList<Point2D>();
		shuffled_indices = new ArrayList<Integer>();
		num_samples = _samples;
		num_sets = _sets;
		gen = new Random();
		count = 0;
	}
	
//	public Point2D sample_unit_square()
//	{
//		int index =(int)(count++ % (num_samples*num_sets));
//		return samples.get(index);
//	}
	
	public Point2D sample_unit_square()
	{
		if(count%num_samples == 0)
			jump = gen.nextInt(num_sets)*num_samples;
		return samples.get(jump+(int)(count++%num_samples));
	}
	
	public abstract void generate_samples();
	
}
