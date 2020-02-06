package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Card{
	private final int number;
	private final String suit;
	
	
	
	//constructs object using a number and suit
	public Card(int number, String suit) {
		this.number = number;
		this.suit = suit;
	}
	public int getNumber() {
		int num = number;
		if(number == 11 ||number == 12 ||number == 13) {
			num = 10;
		}
		if(number == 1) {
			num = 11;
		}
		return num;
	}
	
	public String toString() {
		return "[Number : " + number + "; Suit: " + suit + "]";
	}
	
	public CardGraphic cardGraphic() throws IOException {
		return new CardGraphic();
	}
	
	public class CardGraphic extends JPanel{
		//size of the jpanel/card
		private int sizeH = 100;
		private int sizeW = 75;
		
		//sets size and throws exception
		CardGraphic() throws IOException{
			setSize(sizeW, sizeH);
		}
		
		private static final long serialVersionUID = 5545952195000855231L;
		
		//declares the beginning of the jpeg name for the naming scheme of the jpegs to make reading them easier
		String num = Integer.toString(number);{
			if(number == 11) num = "J";
			if(number == 12) num = "Q";
			if(number == 13) num = "K";
			if(number == 1) num = "A";
		}
	
		//renders picture of card into class and resizes it
		final BufferedImage image = ImageIO.read(new File("C:\\Users\\s133751\\eclipse-workspace\\TheyAintKnowWar\\src\\War\\cardImage\\" + num + suit.toUpperCase().charAt(0) + ".png"));
		final BufferedImage resized = resize(image, sizeH, sizeW);
	
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			
			//draws the picture onto the CardGraphic JPanel
			g2.drawImage(resized, 0, 0, null);
		}
		
		//resizes the BufferedImage
		private BufferedImage resize(BufferedImage img, int height, int width) {
	        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = resized.createGraphics();
	        g2d.drawImage(tmp, 0, 0, null);
	        g2d.dispose();
	        return resized;
	    }
	}
}
