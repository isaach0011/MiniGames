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
	private SettingsPanel settingsPanel;
	
	public GamesFrame(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		menuPanel = new MenuPanel(baseController);
		gamesPanel = new GamesPanel(baseController);
		hangmanPanel = new HangmanPanel(baseController);
		settingsPanel = new SettingsPanel(baseController);
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
	
	public SettingsPanel getSettingsPanel()
	{
		return settingsPanel;
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
	
	public void setSettingsPanel(SettingsPanel settingsPanel)
	{
		this.settingsPanel = settingsPanel;
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
	
	public void switchScreenToHangman()
	{
		this.getContentPane();
		this.setContentPane(hangmanPanel);
		this.validate();
		this.repaint();
	}
	
	public void switchScreenToSettings()
	{
		this.getContentPane();
		this.setContentPane(settingsPanel);
		this.validate();
		this.repaint();
	}
}
