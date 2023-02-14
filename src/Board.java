import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Board {
	
	public int[][] board = new int[6][7];
	private Image boardSprite;
	private Image[] pSprites = new Image[2];
	private AffineTransform tx;
	int x, y;
	int scale = 5;
	
	public Board() {
		boardSprite = getImage("/imgs/Board.png");
		pSprites[0] = getImage("/imgs/P1.png");
		pSprites[1] = getImage("/imgs/P2.png");
		x = 60;
		y = 100;
		board[0][0] = 0;
		tx = ATpos(x, y);
		tx.scale(scale, scale);
	}
	
	public int checkWin() {
		
		//check if board is full
		boolean flag = true;
		for(int i = 0; i < 7; i++) {
			if(board[5][i] == 0) flag = false;
		}
		if(flag) return 0;
		
		
		return -1;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(boardSprite, tx, null);
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(board[i][j] != 0) {
					//60+45+j*85=x
					AffineTransform temp = ATpos(x+scale*7+j*17*scale, y+scale*10+i*17*scale);
					temp.scale(5, 5);
					g2.drawImage(pSprites[board[i][j]-1], temp, null);
				}
			}
		}
	}
	
	public int nextPlace(int pos) {
		for(int i = 0; i < 6; i++) {
			if(board[i][pos] != 0) return i;
		}
		return 6;
	}
	
	protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Frame.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    }
	
	public AffineTransform ATpos(int x, int y) {
		return AffineTransform.getTranslateInstance(x, y);
	}
}
