package games.view;

import javax.swing.JFrame;
import games.controller.GamesController;
import java.awt.Dimension;

public class GamesFrame extends JFrame
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private MenuPanel menuPanel;
	private GamesPanel gamesPanel;
	private HangmanPanel hangmanPanel;
	
	public GamesFrame(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		menuPanel = new MenuPanel(baseController);
		gamesPanel = new GamesPanel(baseController);
		hangmanPanel = new HangmanPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(menuPanel);
		this.setTitle("Minigames");
		this.setSize(new Dimension(900,600));
		this.setResizable(false);
		this.setVisible(true);	
	}

	public GamesFrame getGamesFrame()
	{
		return baseFrame;
	}
	
	public MenuPanel getMenuPanel()
	{
		return menuPanel;
	}

	public GamesPanel getGamesPanel()
	{
		return gamesPanel;
	}

	public HangmanPanel getHangmanPanel()
	{
		return hangmanPanel;
	}
	
	public void setHangmanPanel(HangmanPanel hangmanPanel)
	{
		this.hangmanPanel = hangmanPanel;
	}
	
	public void setMenuPanel(MenuPanel menuPanel)
	{
		this.menuPanel = menuPanel;
	}

	public void setGamesPanel(GamesPanel gamesPanel)
	{
		this.gamesPanel = gamesPanel;
	}
	
	public void switchScreenToGames()
	{
		this.getContentPane();
		this.setContentPane(gamesPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToMenu()
	{
		this.getContentPane();
		this.setContentPane(menuPanel);
		this.validate();
		this.repaint();
	}
	
	public void swtichScreenToHangman()
	{
		this.getContentPane();
		this.setContentPane(hangmanPanel);
		this.validate();
		this.repaint();
	}
}
