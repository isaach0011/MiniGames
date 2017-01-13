package games.view;

import javax.swing.JFrame;
import games.controller.GamesController;
import java.awt.Dimension;

public class GamesFrame extends JFrame
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private MenuPanel basePanel;
	private GamesPanel gamesPanel;
	
	public GamesFrame(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		basePanel = new MenuPanel(baseController);
		gamesPanel = new GamesPanel(baseController);
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

	public GamesFrame getGamesFrame()
	{
		return baseFrame;
	}
	
	public MenuPanel getBasePanel()
	{
		return basePanel;
	}

	public GamesPanel getGamesPanel()
	{
		return gamesPanel;
	}

	public void setBasePanel(MenuPanel basePanel)
	{
		this.basePanel = basePanel;
	}

	public void setGamesPanel(GamesPanel gamesPanel)
	{
		this.gamesPanel = gamesPanel;
	}
	
	public void switchScreenToGames()
	{
		this.setContentPane(gamesPanel);
		this.validate();
		this.repaint();
	}
	
	public void returnContentPane()
	{
		this.getContentPane();
	}
}
