package de.noneatme.bullshitgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class cFilewriter
{
	private String folderName;
	
	
	public cFilewriter(String folder)
	{
		this.folderName	= folder;
	}
	
	
	public cFile createFile(String title) throws IOException
	{
		cFile f	= new cFile(this.folderName + "\\" + title);
		
		if(!f.exists())
			f.createNewFile();
		
		return f;
	}
	
	/*
	public boolean writeToFile(File file, String inhalt) throws FileNotFoundException
	{
		if(file.canWrite())
		{
			PrintWriter writer = new PrintWriter(file);
			writer.write(inhalt + "\n");
			writer.flush();
			writer.close();
			return true;
		}
		return false;
	}
	*/
}
