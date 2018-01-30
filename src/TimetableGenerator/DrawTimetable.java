package TimetableGenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.util.Pair;

public class DrawTimetable {

	public boolean createTimetableForPhone(String data,  String imageName){
		 /* Average phone's screen sizes */
		 /* y: (1200=50*2+4*275); 0-50, 1150-1200:empty space; 50-325-600-875-1150:blocks' starting-ending y coordinates (4 blocks total);  */
		 /* x: (750=75*2+300*2); 0-75, 675-750:empty space; 75-375-675:blocks' starting-ending y coordinates (2 blocks total); */
		 /* every block (x,y) = (300, 275). */
		 /* every block x contains plan, time.(Thus 300=230+50+20) plan - 230|time - 50|empty space - 20|5 10 5| delete extra data*/
		 /* every block y contains dayOfWeek, plan lines.(Thus 275 = 20*10 + 4*10+ 25*1+10*1)*/
		 /* Thus fontsize of plan is 20, space between lines 4,fontsize of dayofweek is 25, space between lines 10*/
		 /* Average phone's screen sizes */
		 int width = 750;
	     int height = 1200;

	     int x0 =0, x1 = 75, x2 = 375, x3 = 675, x4 = 750;
	     Double xd0 =0.0d, xd1 = 75.0d, xd2 = 375.0d, xd3 = 675.0d, xd4 = 750.0d;

	     int y0 = 0, y1 = 50, y2 = 325, y3 = 600, y4 = 875, y5 = 1150, y6 = 1200;
	     Double yd0 = 0.0d, yd1 = 50.0d, yd2 = 325.0d, yd3 = 600.0d, yd4 = 875.0d, yd5 = 1150.0d, yd6 = 1200.0d;

	     int dayOfWeekFontsize = 25;
	     int dayOfWeekSpacesize = 10;
	     int toRight = 200;
	     int planFontsize = 20;
	     int planSpacesize = 4;
	     int screenPaddingSize = 5;
	     int timeSize = 110;

	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	     Graphics2D graphics = image.createGraphics();


	     /* Set background color */
	     graphics.setPaint (Color.WHITE);
	     graphics.fillRect ( 0, 0, image.getWidth(), image.getHeight() );

	     /* Draw block separating lines */
	     graphics.setColor(new Color(235, 235, 235));
	     //x1, y1, x2, y2
	     graphics.draw(new Line2D.Double(xd0, yd1, xd4, yd1));
	     graphics.draw(new Line2D.Double(xd0, yd2, xd4, yd2));
	     graphics.draw(new Line2D.Double(xd0, yd3, xd4, yd3));
	     graphics.draw(new Line2D.Double(xd0, yd4, xd4, yd4));
	     graphics.draw(new Line2D.Double(xd0, yd5, xd4, yd5));
	     graphics.draw(new Line2D.Double(xd1, yd0, xd1, yd6));
	     graphics.draw(new Line2D.Double(xd2, yd0, xd2, yd6));
	     graphics.draw(new Line2D.Double(xd3, yd0, xd3, yd6));

	     /* Set dayOfWeek of each block  */
	     Font font = new Font("Arial", Font.PLAIN, dayOfWeekFontsize);
	     graphics.setFont(font);
	     graphics.setColor(Color.BLACK);
	     graphics.drawString("Monday", x1+toRight, (y1+dayOfWeekFontsize));
	     graphics.drawString("Tuesday", x2+toRight-3, (y1+dayOfWeekFontsize));
	     graphics.drawString("Wednesday", x1+toRight-40, (y2+dayOfWeekFontsize));
	     graphics.drawString("Thursday", x2+toRight-9, (y2+dayOfWeekFontsize));
	     graphics.drawString("Friday", x1+toRight+22, (y3+dayOfWeekFontsize));
	     graphics.drawString("Saturday", x2+toRight-6, (y3+dayOfWeekFontsize));
	     graphics.drawString("Sunday", x1+toRight+11, (y4+dayOfWeekFontsize));

	     int block1planx = x1+screenPaddingSize, block1plany= y1+dayOfWeekFontsize+dayOfWeekSpacesize+planFontsize;
	     int block1timex= x2-timeSize, block1timey= block1plany;
	     int block1bordery= y2;

	     /* Write dynamic data to image */
	     Timetable timetable = new Timetable();
	     ArrayList< Pair<Integer, Pair<Integer,Pair<String , String>>>> input = timetable.prepareData(data);
	     font = new Font("Arial", Font.PLAIN, planFontsize);
	     graphics.setFont(font);
	     graphics.setColor(Color.BLACK);
	     for(int i = 0; i< input.size(); i++){
	    	 Pair<Integer, Pair<Integer,Pair<String , String>>> plan= input.get(i);
	    	 int blockborder = -1, planx = -1, plany = -1, timex = -1, timey = -1;
	    	 if(plan.getKey()==1){
	    		 planx = block1planx;
	    		 plany = block1plany;
	    		 timex = block1timex;
	    		 timey = block1timey;
	    		 blockborder = block1bordery;
	    	 }
	    	 if((plany<blockborder&&timey<blockborder)){
	    		 graphics.drawString(plan.getValue().getValue().getKey(), planx, plany);
	    		 graphics.drawString(plan.getValue().getValue().getValue(), timex, timey);
	    		 block1plany+=(planFontsize+planSpacesize); block1timey+=(planFontsize+planSpacesize);
	    	 }
	     }
	     /* write image to file */
	     return writeImageToFile(image, imageName);
	}

	private boolean writeImageToFile(BufferedImage image, String imageName){
		File myFile = null;
		try{
			myFile = new File(imageName);
	        ImageIO.write(image, "png", myFile);
	    }catch(IOException e){
	       System.out.println("Error: " + e);
	    }
		return (myFile!=null);
	}


}
