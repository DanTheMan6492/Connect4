import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Token {

	private Image Sprite;
	private AffineTransform tx;
    public int x, y;
    public double vy;
    public double ay;
    public int cap = 30;
    public int player = 1;
    public boolean dropping = false;
    int yGoal = 10000;
    int[] pos  = new int[2];
	public Token() {
		Sprite = getImage("/imgs/P" + player + ".png");
		x = 60;
		y = 20;
		tx = ATpos(x, y);
		tx.scale(5, 5);
	}

	public void update() {
		vy += ay;
		if(vy > cap) vy = cap;
		y += vy;
		if(yGoal < y) {
			dropping = false;
			y = 20;
			ay = 0;
			vy = 0;
			Frame.b.board[pos[0]][pos[1]] = player;
			Frame.displayWin = Frame.b.checkWin();
			flipPlayers();
			
		}
	}
	
	public void flipPlayers() {
		player = player % 2 + 1;
		Sprite = getImage("/imgs/P" + player + ".png");
	}
	
	public void drop(int X, int row) {
		dropping = true;
		int col = X;
		yGoal = 100+5*10+row*17*5;
		x = 60+5*7+col*17*5;
		ay = 0.5;
		pos[0] = row;
		pos[1] = col;
	}
	
	public void paint(Graphics g) {
		update();
		Graphics2D g2 = (Graphics2D) g;
		tx = ATpos(x, y);
		tx.scale(5, 5);
		g2.drawImage(Sprite, tx, null);
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
