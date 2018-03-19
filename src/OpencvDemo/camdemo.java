package OpencvDemo;

import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class camdemo {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public static void main(String[] args) {
		VideoCapture capture=new VideoCapture();
		capture.open(0);
		JFrame mainframe=new JFrame("Image");
		
		mainframe.setTitle("WebCam 影像視窗");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setSize(600, 600);
		mainframe.setBounds(0, 0, mainframe.getWidth(), mainframe.getHeight());
		JLabel mainlabel = new JLabel("");
		mainlabel.setBounds(21 , 23 , 571, 413);
		mainframe.add(mainlabel);
		mainframe.setVisible(true);
		if(!capture.isOpened()) {
			System.out.println("Error");
			
		}
		else {
			Mat cam_image = new Mat();
			capture.read(cam_image);
			mainframe.setSize(cam_image.width() + 40, cam_image.height() + 60);
			while(true) {
				capture.read(cam_image);
				matToBuffferedImage a=new matToBuffferedImage();
				BufferedImage image_c=a.MToB(cam_image);
				mainlabel.setIcon(new ImageIcon(image_c));
				
			}
			
		}
		
	}
}
