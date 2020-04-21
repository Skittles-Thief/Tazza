
import javax.swing.*; 
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class chan extends JFrame implements ActionListener{
	
	JPanel Southpnl,Northpnl,Centerpnl;
	JButton Phandonbtn1,Phandonbtn2,Phandonbtn3,Phandonbtn4;
	JButton Northbtn1,Northbtn2;
	ImageIcon icon;
	JLabel Northlabel1,Northlabel2,Northlabel3,Southlabel;
	static int bet=0;//마지막수정
	static int base=0;//마지막수정
	static int savepm = 0; //수정
	
	chan(){
		
		this.setTitle("판돈 선택창");
		this.setSize(850,440);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
				
		icon = new ImageIcon("image/123456.jpg");
		JPanel background = new JPanel(new BorderLayout()){
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				//super.paintComponents(g);
			}
		};
		//North 패널
		Northpnl = new JPanel();
		Northpnl.setLayout(null);
		Northpnl.setPreferredSize(new Dimension(815,100));
		Northpnl.setOpaque(false);
				
		Northlabel1 = new JLabel(new ImageIcon(play.Checkimage));
		Northlabel1.setBounds(0,5,100,100);
				
		Northlabel2 = new JLabel(login.TF0.getText());//
		Northlabel2.setFont(new Font("맑은 고딕",Font.BOLD,20));
		Northlabel2.setForeground(Color.white);
		//Northlabel2.setOpaque(true);
		Northlabel2.setBounds(105,35,300,20);
		
		Northlabel3 = new JLabel("현재 소지금　"+play.PlayerMoney[0]+"원");
		Northlabel3.setFont(new Font("맑은 고딕",Font.BOLD,20));
		Northlabel3.setForeground(Color.white);
		//Northlabel3.setOpaque(true);
		Northlabel3.setBounds(105,70,300,20);
		
		Northbtn1 = new JButton(new ImageIcon("Image/GameTip.png"));
		Northbtn1.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent c) {
					new	Jokboimpor();
				
				
			}
		});
			
		Northbtn2 = new JButton(new ImageIcon("image/backbtn.png"));
		Northbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent b) {
					new login();//
					setVisible(false);
					
				
				
			}
		});
		
		Northbtn1.setBounds(660,5,80,31);
		Northbtn2.setBounds(750,5,80,31);
		
		Northpnl.add(Northlabel1);
		Northpnl.add(Northlabel2);
		Northpnl.add(Northlabel3);
		Northpnl.add(Northbtn1);
		Northpnl.add(Northbtn2);
				
		//Center 패널
		Color colors = new Color(255,126,0);
		Centerpnl = new JPanel();
		Centerpnl.setOpaque(false);
		Centerpnl.setBorder(BorderFactory.createEmptyBorder(120,0,0,0));
		TitledBorder border = new TitledBorder(new LineBorder(colors),"2장 섯다");
		border.setTitleColor(colors);
		border.setTitleFont(new Font("맑은 고딕",Font.BOLD,20));
		Centerpnl.setBorder(border);
		
		Phandonbtn1 = new JButton(new ImageIcon("image/1000.png"));
		Phandonbtn1.addActionListener(this);
		Phandonbtn1.setContentAreaFilled(false);
		Phandonbtn1.setBorderPainted(false);
		Phandonbtn1.setFocusPainted(false);
		
		Phandonbtn2 = new JButton(new ImageIcon("image/5000.png"));
		Phandonbtn2.addActionListener(this);
		Phandonbtn2.setContentAreaFilled(false);
		Phandonbtn2.setBorderPainted(false);
		Phandonbtn2.setFocusPainted(false);
		
		Phandonbtn3 = new JButton(new ImageIcon("image/50000.png"));
		Phandonbtn3.addActionListener(this);
		Phandonbtn3.setContentAreaFilled(false);
		Phandonbtn3.setBorderPainted(false);
		Phandonbtn3.setFocusPainted(false);
		
		Phandonbtn4 = new JButton(new ImageIcon("image/500000.png"));
		Phandonbtn4.addActionListener(this);
		Phandonbtn4.setContentAreaFilled(false);
		Phandonbtn4.setBorderPainted(false);
		Phandonbtn4.setFocusPainted(false);
		
		Centerpnl.add(Phandonbtn1);
		Centerpnl.add(Phandonbtn2);
		Centerpnl.add(Phandonbtn3);
		Centerpnl.add(Phandonbtn4);
		
		Southpnl = new JPanel();
		Southpnl.setOpaque(false);
		Southlabel = new JLabel("버전 1.8 190916");
		Southlabel.setHorizontalAlignment(JLabel.CENTER);
		Southlabel.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Southlabel.setForeground(Color.white);
		
		Southpnl.add(Southlabel);
				
		background.add(Northpnl,"North");
		background.add(Centerpnl,"Center");
		background.add(Southpnl,"South");
		
		add(background);
				
		setVisible(true);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		int setmoney = 0;//수정
		Random ran = new Random();//수정
		if(e.getSource()==Phandonbtn1){
			if(play.PlayerMoney[0] > 1000){//마지막수정
			bet = 1000;
			base = 1000;
			setmoney = 300000;//수정
			new play();
			setVisible(false);
			}
			else//마지막수정
				JOptionPane.showMessageDialog(null, "돈이 모자랍니다","입장불가",JOptionPane.WARNING_MESSAGE);
			

		
		}
		if(e.getSource()==Phandonbtn2){
			if(play.PlayerMoney[0] > 5000){//마지막수정
			bet = 5000; 
			base = 5000;
			setmoney = 1000000;//수정
			new play();
			setVisible(false);
			}
			else//마지막수정
				JOptionPane.showMessageDialog(null, "돈이 모자랍니다","입장불가",JOptionPane.WARNING_MESSAGE);

		}
		if(e.getSource()==Phandonbtn3){
			if(play.PlayerMoney[0] > 50000){//마지막수정
			bet = 50000;
			base = 50000;
			setmoney = 10000000;//수정
			new play();
			setVisible(false);
			}
			else//마지막수정
				JOptionPane.showMessageDialog(null, "돈이 모자랍니다","입장불가",JOptionPane.WARNING_MESSAGE);

		}
		if(e.getSource()==Phandonbtn4){
			if(play.PlayerMoney[0] > 500000){//마지막수정
			bet = 500000;
			base = 500000;
			setmoney = 100000000;//수정
			new play();
			setVisible(false);
			}
			else//마지막수정
				JOptionPane.showMessageDialog(null, "돈이 모자랍니다","입장불가",JOptionPane.WARNING_MESSAGE);

		} 
		for(int i=1;i<5;i++){//수정
			int ranm = ran.nextInt(5)+1;
			play.PlayerMoney[i] = setmoney*ranm;
		}
				
		/*if(bet!=0){//마지막수정
		new play();
		setVisible(false);
		}*/
}
	
	public static void main(String[] args) {
		new chan();

	}
}