package gui;


import game.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.security.auth.login.Configuration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


@SuppressWarnings("unused")
public class Launcher /*extends JFrame implements Runnable*/{



		static final long serialVersionUID = 1L;
		
		protected JPanel window = new JPanel();
		double p;
		private JButton play, options, help, quit;
		private Rectangle rplay, roptions, rhelp, rquit;
		
		private int Width = 800;
		private int Height = 600;
		
		
		
		protected int Button_width = 120;
		protected int Button_height = 40;
		boolean running = false;
		Thread thread;
		JFrame frame = new JFrame();
		
		public Launcher(int id) {
		/*	try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				frame.setUndecorated(true);
				frame.setTitle("Knights of the Undead Launcher");
				frame.setSize(new Dimension(Width, Height));
				//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				//frame.getContentPane().add(window);
				//frame.add(display);
				//frame.add(this);
				frame.add(window);
				//frame.setLocation(500, 1000);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
				//window.setLayout(null);

				if (id == 0) {
				DrawButton();
				}
		}
		







public void DrawButton() {
/*	play = new JButton("Play");
	rplay = new Rectangle((Width / 2)-(Button_width / 2), 30 ,Button_width, Button_height);
	play.setBounds(rplay);
	window.add(play);
	options = new JButton("Options");
	roptions = new Rectangle((Width / 2)-(Button_width / 2), 130 ,Button_width, Button_height);
	options.setBounds(roptions);
	window.add(options);
	help = new JButton("Help");
	rhelp = new Rectangle((Width / 2)-(Button_width / 2), 230 ,Button_width, Button_height);
	help.setBounds(rhelp);
	window.add(help);
	quit = new JButton("Quit");
	rquit = new Rectangle((Width / 2)-(Button_width / 2), 330 ,Button_width, Button_height);
	quit.setBounds(rquit);
	window.add(quit);
	*/
	play = new JButton("Play");
	rplay = new Rectangle((Width / 2)-(Button_width / 2), Height /2 -20 ,Button_width, Button_height);
	play.setBounds(rplay);
	window.add(play);
	options = new JButton("Options");
	roptions = new Rectangle((Width / 2) + 60, Height /2 - 20 ,Button_width, Button_height);
	options.setBounds(roptions);
	window.add(options);
	help = new JButton("Help");
	rhelp = new Rectangle((Width / 2) - 60,Height /2 + 20 ,Button_width, Button_height);
	help.setBounds(rhelp);
	window.add(help);
	quit = new JButton("Quit");
	rquit = new Rectangle((Width / 2) + 60, Height /2 + 20,Button_width, Button_height);
	quit.setBounds(rquit);
	window.add(quit);
	
	
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String[] args = null;
				Game.main(args);
			}
		
	
	});
	options.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//frame.dispose();
		//	new Options();
			
			
		}
	});
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		
		});
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
			
			
		});
	}
public static void main(String[] args) {
	new Launcher(0);
}
}