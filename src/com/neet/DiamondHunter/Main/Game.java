// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.DiamondHunter.Main;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game {
	
	public static void main(String[] args) {
        GamePanel gamepanel=new GamePanel();
		
		JFrame window = new JFrame("Diamond Hunter");
		
		window.add(gamepanel);
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				window.setVisible(false);

			}
		});

	}
	
}
