import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;

public class GraphicsTest 
	{
	public static void main(String[] args) 
		{
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setTitle("Loreshard");
		
		ImageIcon logoicon = new ImageIcon("MagicScroll[1].jpg");
		Image logo = logoicon.getImage();
		frame.setIconImage(logo);
		
		frame.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		
		frame.setLocation(x, y);		
		
		//
		
		ImageIcon image = new ImageIcon("11971499214831170476zeimusu_Crossed_swords.svg.hi[1].png");
		//frame.setIconImage(image);
		JLabel imageLabel = new JLabel(image);
		
		}	
	}

