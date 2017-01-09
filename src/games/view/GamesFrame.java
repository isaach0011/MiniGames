package games.view;

import javax.swing.JFrame;
import games.controller.GamesController;
import java.awt.Dimension;

public class GamesFrame extends JFrame
{
	private GamesController baseController;
	private GamesPanel basePanel;
	
	public GamesFrame(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		basePanel = new GamesPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Minigames");
		this.setSize(new Dimension(900,600));
		this.setResizable(false);
		this.setVisible(true);
	}
}
