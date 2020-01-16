package study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Dodge2 extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dodge2 window = new Dodge2();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Dodge2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Dodge2");
		frame.setBounds(0, 0, 500, 500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		MainMusic mainmusic = new MainMusic("music.mp3",true);
		mainmusic.start();
		frame.getContentPane().setLayout(null);
		
		ImagePanel main = new ImagePanel(new ImageIcon("C:\\Users\\82107\\Desktop\\dodgeg.jpg").getImage());
		/*\frame.add(main);
		frame.pack();*/
		main.setBounds(0, 0, 482, 432);
		frame.getContentPane().add(main);
		main.setLayout(null);
		
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel start = new JPanel();
		start.setBounds(0, 0, 482, 432);
	
		
		JButton startbtn = new JButton("START");
		startbtn.setBounds(113, 330, 278, 68);
		main.add(startbtn);
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setVisible(false); 
				start.setVisible(true);
				
				mainmusic.close(); //메인화면 음악끄고
				GameMusic gamemusic = new GameMusic("gamemusic.mp3",true);
				gamemusic.start(); //게임중 음악 키기
				frame.getContentPane().setLayout(null);
				start.add(new Play());
				
			
			}
		});
		
		frame.setVisible(true);
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		JMenu recordmenu = new JMenu("기록"); 
		JMenu exitmenu = new JMenu("기타");
		
		bar.add(recordmenu);
		bar.add(exitmenu);
		
		JMenuItem record = new JMenuItem("최고 점수");
		JMenuItem exit = new JMenuItem("종료");
		
		recordmenu.add(record);
		record.addActionListener(new ActionListener(){//exit하면 종료
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "구현 중.. DB연결 후", "메시지",JOptionPane.ERROR_MESSAGE);
			};
		});
	
	    exitmenu.add(exit);
		exit.addActionListener(new ActionListener(){//exit하면 종료
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
		
	}
	