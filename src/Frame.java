import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Frame extends JPanel implements KeyListener, MouseListener, ActionListener{

    static Board b = new Board();
    Token curr = new Token();
    public static int mouseX;
	public static int mouseY;
	public static int displayWin = -1;
	boolean gameOver = false;
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(!curr.dropping && !gameOver) curr.x = mouseX-30;
        if(!gameOver) curr.paint(g);
        b.paint(g);
        
        if(displayWin != -1) {
        	gameOver = true;
        	Image Sprite = getImage("/imgs/" + displayWin + ".png");
        	AffineTransform tx = AffineTransform.getTranslateInstance(70, 100);
        	tx.scale(5, 5);
        	g2.drawImage(Sprite, tx, null);
        	
        	if(displayWin == 0) System.out.println("TIE!");
        	System.out.println("Player " + displayWin + " Won!");
        }
        
        
	}

    
    
    public static void main(String[] arg) {
        Frame f = new Frame();
        
    }    
    
    @Override
    public void keyPressed(KeyEvent arg) {
    	
    }    	

    @Override
    public void keyReleased(KeyEvent arg) {
    
    }
    
    

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        repaint();
    }
    
   
    Timer t;
    
    public Frame() {
    	
    	
    	JFrame f = new JFrame("Connect 4");
		f.setSize(new Dimension(770, 770));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(4, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent me)
			{
			  mouseX = me.getX();
			  mouseY = me.getY();
			}
		});
		f.setVisible(true);
        
       
        
    }
    
    protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Frame.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    }



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gameOver) return;
		int pos = ((mouseX+10)-105)/85;
		if(pos < 0) pos = 0;
		if(pos > 6) pos = 6;
		int row = b.nextPlace(0);
		if(b.nextPlace(pos) != 0)	curr.drop(pos, b.nextPlace(pos)-1);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}