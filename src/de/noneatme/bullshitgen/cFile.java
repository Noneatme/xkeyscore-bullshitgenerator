package de.noneatme.bullshitgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class cFile extends File
{
	PrintWriter writer;
	private static final long	serialVersionUID	= 1L;
	private boolean started		= false;

	public cFile(String loc) throws FileNotFoundException
	{
		super(loc);
		this.writer	= new PrintWriter(this);
	}
	
	public boolean startWrite()
	{
		return true;
	}
	
	public boolean endWrite()
	{
		if(this.writer != null)
		{
			this.writer.flush();
			this.writer.close();
			return true;
		}
		return false;
	}
	
	public boolean writeln(String s)
	{
		if(this.canWrite())
		{
			if(this.started)
				this.writer.write("\n" + s);
			else
				this.writer.write(s);
			
			this.started	= true;
			
			return true;
		}
		return false;
	}
}
