import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Jokboimpor  extends JFrame implements MouseListener{
		
		CardLayout lay;
		JPanel bG,Jokpan;
		//
		String jokImage[] ={"image/1_10.png","image/jok1.png","image/jok2.png"
							,"image/jok3.png","image/jok4.png","image/jok5.png","image/bat.png"};
		//
		JLabel[] joklb = new JLabel[7]; 
		//
		JLabel bar;
		//
		JLabel[] btn = new JLabel[3];
		//
		String btnimg[]={"image/close.png","image/previous.png","image/next.png","image/bar.png"};
		//
		ImageIcon[] originIcon= new ImageIcon[7]; 
	    Image[] originImg= new Image[7];
	    Image[] changedImg= new Image[7];
	    ImageIcon[] Icon= new ImageIcon[7];
	    ImageIcon[] originIcon2= new ImageIcon[3]; 
	    Image[] originImg2= new Image[3];
	    Image[] changedImg2= new Image[3];
	    ImageIcon[] Icon2= new ImageIcon[3];
		
	public Jokboimpor() {
		setTitle("¸Þ´º¾ó");
		setSize(800, 868); 	 	
	    setLocationRelativeTo(null);
	    setUndecorated(true);

	    lay = new CardLayout(0,0);
		bG= new JPanel(null);
		bG.setBackground(Color.white);
		Jokpan= new JPanel(lay);	
		Jokpan.setBounds(0,30,800,800);
		//
		for(int i=0 ; i<btn.length ; i++){
			originIcon2[i] = new ImageIcon(btnimg[i]);  
		    originImg2[i] = originIcon2[i].getImage(); 
		    changedImg2[i]= originImg2[i].getScaledInstance(50,30, Image.SCALE_SMOOTH );
		    Icon2[i] = new ImageIcon(changedImg2[i]);
		    btn[i]= new JLabel(new ImageIcon(changedImg2[i]));
		}
		//
		for(int i=0 ; i<joklb.length ; i++){
			originIcon[i] = new ImageIcon(jokImage[i]);  
		    originImg[i] = originIcon[i].getImage(); 
		    changedImg[i]= originImg[i].getScaledInstance(800, 800, Image.SCALE_SMOOTH );
		    Icon[i] = new ImageIcon(changedImg[i]);
	
			joklb[i]= new JLabel(new ImageIcon(changedImg[i]));
			joklb[i].setPreferredSize(new Dimension(800,800));	
			
		}
		
		bar=new JLabel(new ImageIcon("image/bar.png"));
		bar.setBounds(0,0,650,30);
		btn[0].setBounds(750,0,50,30);
		btn[1].setBounds(650,0,50,30);
		btn[2].setBounds(700,0,50,30);
		btn[0].addMouseListener(this);
		btn[1].addMouseListener(this);
		btn[2].addMouseListener(this);
		bG.add(btn[0]);
		bG.add(btn[1]);
		bG.add(btn[2]);
		bG.add(bar);	
		Jokpan.add(joklb[0]);
		Jokpan.add(joklb[1]);
		Jokpan.add(joklb[2]);
		Jokpan.add(joklb[3]);
		Jokpan.add(joklb[4]);
		Jokpan.add(joklb[5]);
		Jokpan.add(joklb[6]);		
		bG.add(Jokpan);
		add(bG);
		
		setVisible(true);
			
	}	
	public static void main(String[] args) {
		new Jokboimpor();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==btn[0]){
			setVisible(false);} //
		
		if(e.getSource()==btn[2]){
			lay.next(Jokpan);} //
		
		if(e.getSource()==btn[1]){
			lay.previous(Jokpan);}	//
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
