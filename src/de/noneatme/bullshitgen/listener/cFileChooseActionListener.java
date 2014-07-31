package de.noneatme.bullshitgen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.noneatme.bullshitgen.cMain;

public class cFileChooseActionListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		try
		{
			cMain.bullshitFrame.openFilechooser();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
