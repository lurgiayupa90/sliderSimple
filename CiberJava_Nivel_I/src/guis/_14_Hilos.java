package guis;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class _14_Hilos extends JFrame implements Runnable {
	//  Variables globales
	int posX = 0, posY = 0,
	    unoX = 1, unoY = 1;
	Thread hilo;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_14_Hilos frame = new _14_Hilos();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public _14_Hilos() {
		setTitle("_14_Hilos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(50,130,180));
		
		lblLogo = new JLabel(new ImageIcon("imagenes/MN-Global.png"));
		lblLogo.setBounds(0, 0, 213, 153);
		contentPane.add(lblLogo);
		
		hilo = new Thread(this);
 		hilo.start();
	}
	//  Controla el tiempo
	public void run() {
	 	while (hilo != null)
	 		try {
	 			Thread.sleep(15);
	 			procesar();	 			
	 		}
	 		catch (Exception e) {
	 		}
	}
	//  Métodos tipo void (sin parámetros)	
	void procesar() {
	 	posX += unoX;
	 	posY += unoY;
	 	if (posX + lblLogo.getWidth() > getWidth() - 15)
	 		unoX = -1;
	 	if (posX < 0)
	 		unoX = 1;
	 	if (posY + lblLogo.getHeight() > getHeight() - 40)
	 		unoY = -1;
	 	if (posY < 0)
	 		unoY = 1;
		lblLogo.setLocation(posX, posY);
	}
	
}