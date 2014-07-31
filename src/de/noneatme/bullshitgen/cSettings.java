package de.noneatme.bullshitgen;

import java.awt.Dimension;
import java.util.Random;

public class cSettings
{
	protected static String frameTitle				= "Bullshit Generator";
	protected static Dimension frameSize			= new Dimension(438, 297);
	
	public static int randInt(int min, int max)
	{

	    // Usually this should be a field rather than a method variable so
	    // that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
