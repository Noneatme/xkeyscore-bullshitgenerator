package de.noneatme.bullshitgen.bullshit;

import java.io.File;

import javax.swing.SwingWorker;

import de.noneatme.bullshitgen.cFile;
import de.noneatme.bullshitgen.cFilewriter;
import de.noneatme.bullshitgen.cMain;
import de.noneatme.bullshitgen.cSettings;

public class cNSAXKeyscoreBullshit extends SwingWorker<Long, Object>
{
	private int			ammount;
	private cFilewriter	writer;

	public cNSAXKeyscoreBullshit(int ammount)
	{
		this.ammount = ammount;
		this.writer = new cFilewriter(cMain.bullshitFrame.currentFolder);

	}

	@Override
	protected Long doInBackground() throws Exception
	{
		try
		{
			cFile f = this.writer.createFile("bridges.txt");
			f.startWrite();
			cMain.bullshitFrame.btnStarten.setEnabled(false);

			f.writeln("https://bridges.torproject.org/");
			for (int i = 0; i <= this.ammount; i++)
			{
				int r1 = cSettings.randInt(1, 254);
				int r2 = cSettings.randInt(1, 254);
				int r3 = cSettings.randInt(1, 254);
				int r4 = cSettings.randInt(1, 254);
				int port = 443;

				f.writeln(String.format("bridge = %s.%s.%s.%s:%s", r1, r2, r3, r4, port));

				cMain.bullshitFrame.setStatus("Schreibe Zeile " + i + " von " + this.ammount);
			}

			f.endWrite();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	protected void done()
	{
		try
		{
			cMain.bullshitFrame.btnStarten.setEnabled(true);
		}
		catch ( /* InterruptedException, ExecutionException */Exception e)
		{
			
		}
	}
}
