package Tess4J;

import java.io.File;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import net.sourceforge.tess4j.*;

public class Test {
	public static void main(String[] args) throws IOException{
		//We don't really need this anymore, because we're just using buffered images
		File imageFile = new File("C:\\Users\\thril\\eclipse-workspace\\OCRTest\\images\\sdf.png");

	    ITesseract instance = new Tesseract(); // JNA Interface Mapping
	    instance.setDatapath("C:\\Users\\thril\\eclipse-workspace\\OCRTest\\tessdata");
	    try {
			Rectangle viewRect = new Rectangle(100,100,200,200);
	    	String result = instance.doOCR(new Robot().createScreenCapture(viewRect));
	    	System.out.println(result);
	    }catch(TesseractException | AWTException e) {
	    	System.err.println(e.getMessage());
	    }
	}
    

}
