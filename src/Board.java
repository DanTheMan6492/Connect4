import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Board {
	
	public int[][] board = new int[6][7];
	private Image boardSprite;
	private AffineTransform tx;
	
	public Board() {
		boardSprite = getImage("/imgs/Board.png");
		tx = AffineTransform.getTranslateInstance(60, 100);
		tx.scale(5, 5);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(boardSprite, tx, null);
	}
	
	protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Frame.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    }
}
