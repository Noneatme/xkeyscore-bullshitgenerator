package de.noneatme.bullshitgen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.noneatme.bullshitgen.cMain;

public class cStartenActionListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		cMain.bullshitFrame.start();
	}
	
}
