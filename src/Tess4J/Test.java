package Tess4J;

import java.io.File;

import javax.imageio.ImageIO;

import com.gtranslate.Language;
import com.gtranslate.Translator;

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
		File imageFile = new File("C:\\Users\\Cameron Anderson\\git\\OCR-Program\\images\\Chinese1.png");

	    ITesseract instance = new Tesseract(); // JNA Interface Mapping
	    instance.setLanguage("chi_sim");
	    instance.setDatapath("C:\\Users\\Cameron Anderson\\git\\OCR-Program\\tessdata");
	    try {
	    	/*
			Rectangle viewRect = new Rectangle(100,100,200,200);
	    	String result = instance.doOCR(new Robot().createScreenCapture(viewRect));
	    	*/
	    	String result = instance.doOCR(imageFile);
	    	System.out.println(result);
	    	
	    	
	    	Process p = Runtime.getRuntime().exec("python translate.py \"" + result +"\"");
	    	System.out.println("THe program has run!");
	    	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	String s = null;
	    	while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                System.out.println("We've entered the loop");
            }
	    	
	    	//Add | AWTException e to catch statement if using screen picture
	    	/*
	    	PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
	    	writer.println(result);
	    	writer.close();
	    	*/
	    }catch(TesseractException e) {
	    	System.err.println(e.getMessage());
	    }
	}
    

}
