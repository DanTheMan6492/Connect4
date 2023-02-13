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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Frame extends JPanel implements KeyListener, MouseListener, ActionListener{
    private AffineTransform tx;
    Board b = new Board();
    
    
    /* paint is getting called roughly 144x per second */
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        b.paint(g);
	    
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
    
    public boolean randBool() {if (Math.random() > 0.5) {return true;} else {return false;}}
    
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
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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