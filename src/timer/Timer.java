package timer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

public class Timer extends JFrame {
	static int hour=0;
	static int minutes=0;
	static int second=0;
	static int milisecond=0;
	static boolean state=true;

	private JPanel contentPane;
	private JLabel minutetf;
	private JLabel hourtf;
	private JLabel secondtf;
	private JLabel milisecondtf;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer frame = new Timer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Timer() {
		setResizable(false);
		setForeground(Color.WHITE);
		setBackground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Timer.class.getResource("/image/Start-icon (1).png")));
		setTitle("StopWatch");
		
		
		
		design();
	}
	//this is just test
	private void test() {
		//this is just a test.
	}
	private void stopwatch() {
		state=true;
		Thread t= new Thread() {
			public void run() 
			{
			for(;;)
			{
			if(state==true) 
			{
			try 
			{
			sleep(1);
			if(milisecond >1000) {
				milisecond=0;
				second++;
				
			}
			if(second >60) {
				milisecond=0;
				second=0;
				minutes++;
				
			}
			if(minutes >60) {
				milisecond=0;
				second=0;
				minutes=0;
				hour++;
				
			}
			milisecondtf.setText(" : "+milisecond);
			milisecond++;
			secondtf.setText(" : "+second);
			minutetf.setText(" : "+minutes);
			hourtf.setText(" : "+hour);
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
			else {
				break;
			}
			}
			}
		};
		t.start();
	}
	
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 hourtf = new JLabel("00:");
		 hourtf.setForeground(SystemColor.text);
		 hourtf.setBackground(SystemColor.info);
		hourtf.setHorizontalAlignment(SwingConstants.CENTER);
		hourtf.setFont(new Font("Tahoma", Font.BOLD, 22));
		hourtf.setBounds(12, 13, 164, 49);
		contentPane.add(hourtf);
		
		 minutetf = new JLabel("00:");
		 minutetf.setForeground(SystemColor.text);
		 minutetf.setBackground(SystemColor.info);
		minutetf.setHorizontalAlignment(SwingConstants.CENTER);
		minutetf.setFont(new Font("Tahoma", Font.BOLD, 22));
		minutetf.setBounds(157, 13, 164, 49);
		contentPane.add(minutetf);
		
		 secondtf = new JLabel("00:");
		 secondtf.setForeground(SystemColor.text);
		 secondtf.setBackground(SystemColor.info);
		secondtf.setHorizontalAlignment(SwingConstants.CENTER);
		secondtf.setFont(new Font("Tahoma", Font.BOLD, 22));
		secondtf.setBounds(333, 13, 164, 49);
		contentPane.add(secondtf);
		
		 milisecondtf = new JLabel("00:");
		 milisecondtf.setForeground(SystemColor.text);
		 milisecondtf.setBackground(SystemColor.info);
		milisecondtf.setHorizontalAlignment(SwingConstants.CENTER);
		milisecondtf.setFont(new Font("Tahoma", Font.BOLD, 22));
		milisecondtf.setBounds(498, 13, 164, 49);
		contentPane.add(milisecondtf);
		
		JButton start = new JButton("Start");
		start.setIcon(new ImageIcon(Timer.class.getResource("/image/Start-icon (1).png")));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				state=true;
				stopwatch();
				
			}
		});
		start.setFont(new Font("Tahoma", Font.BOLD, 24));
		start.setBounds(12, 115, 192, 68);
		contentPane.add(start);
		
		JButton Stop = new JButton("Stop");
		Stop.setIcon(new ImageIcon(Timer.class.getResource("/image/Stop-icon (1).png")));
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
			}
		});
		Stop.setFont(new Font("Tahoma", Font.BOLD, 24));
		Stop.setBounds(265, 115, 192, 68);
		contentPane.add(Stop);
		
		JButton reset = new JButton("Reset");
		reset.setIcon(new ImageIcon(Timer.class.getResource("/image/Clear-icon (1).png")));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
				hour=0;
				minutes=0;
				second=0;
				milisecond=0;
				hourtf.setText("00: ");
				minutetf.setText("00:");
				secondtf.setText("00");
				milisecondtf.setText("00:");
				
				
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 24));
		reset.setBounds(498, 115, 192, 68);
		contentPane.add(reset);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Timer.class.getResource("/image/5.jpg")));
		lblNewLabel.setBounds(0, 0, 730, 290);
		contentPane.add(lblNewLabel);
	}
}
