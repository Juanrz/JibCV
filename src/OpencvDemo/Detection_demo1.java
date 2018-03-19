package OpencvDemo;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import exercise1.ImageGui;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.util.*;


import javax.swing.JFrame;

public class Detection_demo1 {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	private JFrame imgWindow;
	public static void main(String[] args) {	
		Mat image=Imgcodecs.imread("C://321.bmp");
		
		matToBuffferedImage a=new matToBuffferedImage();
		BufferedImage image_c=a.MToB(image);	
		try {
			
			Mat image1= new Mat(3, 3, CvType.CV_8UC1);
			System.out.println(image1.dump());
			Mat image2=Imgcodecs.imread("C://321.bmp");
			System.out.println(image2.channels());
			String window_name = "mat";
			
			ImageGui ig = new ImageGui(image2,window_name);
			ig.imshow();
			ig.waitKey(0);
		
		}catch(Exception e) {
			System.out.println("error: "+e.getMessage());
		}
		
	}

}
