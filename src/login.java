import javax.swing.*; 

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class login extends JFrame implements ActionListener{
	JPanel Namepnl,Moneypnl,Btnpnl,Imagepnl,Centerpnl,Westpnl;
	JLabel Namelabel,Moneylabel;
	static JTextField TF0;
	JComboBox combo;
	static String[] Image = {"image/sel11.jpg","image/sel22.jpg","image/sel33.png","image/sel44.jpg","image/sel55.jpg"};
	String[] ranname= {"���","ȫ�浿","�����","�Ʊ�","¦��","����","�Ƿη�","������","�ڸ��"};
	String[] money = {"10��","100��","1000��","5000��"};
	JCheckBox btn1,btn2,btn3,btn4,btn5;
	JLabel imagelabel;
	JLabel south;
	JLabel profile; //����������
	JButton button;
	ButtonGroup group;
	JLabel north;
	String pay;
	Random ran = new Random();
	String icon=("image/imgimg.jpg");
	ImageIcon originIcon2; 
    Image originImg2;
    Image changedImg2;
    ImageIcon Icon2;
    JButton close; //�ݱ��ư
    boolean isran;
	login(){
		isran=false;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("����");
		this.setSize(550,500);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		originIcon2 = new ImageIcon(icon);  
	    originImg2 = originIcon2.getImage(); 
	    changedImg2= originImg2.getScaledInstance(550,500, Image.length );
	    Icon2 = new ImageIcon(changedImg2);
	    
		JPanel background = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(Icon2.getImage(),0,0,null);
				setOpaque(false);
				//super.paintComponents(g);
			}
		};
		ImageIcon closeimg = new ImageIcon("image/xx.jpg");
	    close = new JButton();
	    close.setIcon(closeimg);
	    close.setBounds(515,5,30,30);
	    close.setBorderPainted(false);
	    close.setContentAreaFilled(false);
	    close.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==close){
					setVisible(false);
				}			
			}
		});
		
		background.setLayout(null);
		//WESt �г�
		btn1 = new JCheckBox("���̾�");  //����������
		btn1.addActionListener(this);
		btn1.setSelected(true);
		btn1.setForeground(Color.white);
		btn2 = new JCheckBox("�Ǿ�");
		btn2.setForeground(Color.white);
		btn2.addActionListener(this);
		btn3 = new JCheckBox("����ġ");
		btn3.setForeground(Color.white);
		btn3.addActionListener(this);
		btn4 = new JCheckBox("������");
		btn4.setForeground(Color.white);
		btn4.addActionListener(this);
		btn5 = new JCheckBox("����");
		btn5.setForeground(Color.white);
		btn5.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(btn1);
		group.add(btn2);
		group.add(btn3);
		group.add(btn4);
		group.add(btn5);
		
		Btnpnl = new JPanel(new GridLayout(0,1));
		Btnpnl.setOpaque(false);
		profile = new JLabel("             ������ ����"); //����������
		profile.setForeground(Color.white);
		Btnpnl.add(btn1);
		Btnpnl.add(btn2);
		Btnpnl.add(btn3);
		Btnpnl.add(btn4);
		Btnpnl.add(btn5);
		btn1.setOpaque(false);
		btn2.setOpaque(false);
		btn3.setOpaque(false);
		btn4.setOpaque(false);
		btn5.setOpaque(false);
		
		imagelabel = new JLabel(new ImageIcon(Image[0]));//����
		play.Checkimage = Image[0];
		
		Imagepnl = new JPanel();
		Imagepnl.add(imagelabel);
		Imagepnl.setOpaque(false);
		
		Westpnl = new JPanel(new GridLayout(2,1,3,3));
		Westpnl.add(Imagepnl);
		Westpnl.add(Btnpnl);
				
		Namepnl = new JPanel(new FlowLayout());
		Moneypnl = new JPanel(new FlowLayout());
		Namelabel = new JLabel("�г���");
	
		Namelabel.setForeground(Color.white);
		Moneylabel = new JLabel("������");
		Moneylabel.setForeground(Color.white);
		TF0 = new JTextField(10);//����
		TF0.setOpaque(false);
		TF0.setForeground(Color.white);
		combo = new JComboBox<String>(money);
		combo.setPreferredSize(new Dimension(170,20));
		
		
		
		
		button = new JButton("");
	/*	try {		 
	          UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	     //     setDefaultLookAndFeelDecorated(true); 
	            } catch (Exception e) {}*/
		button.addActionListener(this);
		ImageIcon ic = new ImageIcon("image/ok.png");
		button.setIcon(ic);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		
		Centerpnl = new JPanel();
		Centerpnl.setLayout(null);
		
		Namepnl.setBounds(5,30,300,30);
		Moneypnl.setBounds(0,70,300,30);
		button.setBounds(187,110,70,40);
		button.updateUI();
		JButton ranbtn = new JButton("");
		ranbtn.setBorderPainted(false);
		ranbtn.setContentAreaFilled(false);
		ranbtn.setPreferredSize(new Dimension(56,20));
		ImageIcon ic2 = new ImageIcon("image/random.png");	
		ranbtn.setIcon(ic2);	
		ranbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent rbt) {
				int num = ran.nextInt(ranname.length);
				TF0.setText(ranname[num]);
				isran = true;
				
			}
		});
		
		
		Namepnl.add(Namelabel);
		Namepnl.setOpaque(false);
		Namepnl.add(TF0);
		Namepnl.add(ranbtn);//����
		Moneypnl.add(Moneylabel);
		Moneypnl.setOpaque(false);
		Moneypnl.add(combo);
		
		Centerpnl.add(Namepnl);
		Centerpnl.add(Moneypnl);
		
		
		Centerpnl.add(button);
		
		
		south = new JLabel("���� 1.8 190916");
		south.setHorizontalAlignment(JLabel.CENTER);
		
		north = new JLabel("");
		north.setHorizontalAlignment(JLabel.CENTER);
		north.setFont(new Font("���� ���",Font.BOLD,15));
		
		Westpnl.setOpaque(false);
		Westpnl.setBounds(0,50,150,300);
		Centerpnl.setOpaque(false);
		Centerpnl.setBounds(250,50,300,300);
		south.setOpaque(false);
		south.setBounds(210,335,100,300);
		
		background.add(close); //�ݱ��ư
		background.add(Westpnl);
		background.add(Centerpnl);
		background.add(south);
		add(background);
		setVisible(true);
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource()==btn1){
			ImageIcon icon = new ImageIcon(Image[0]);
			imagelabel.setIcon(icon);
			play.Checkimage = Image[0];
		}else if(e.getSource()==btn2){
			ImageIcon icon = new ImageIcon(Image[1]);
			imagelabel.setIcon(icon);
			play.Checkimage = Image[1];
		}else if(e.getSource()==btn3){
			ImageIcon icon = new ImageIcon(Image[2]);
			imagelabel.setIcon(icon);
			play.Checkimage = Image[2];
		}else if(e.getSource()==btn4){
			ImageIcon icon = new ImageIcon(Image[3]);
			imagelabel.setIcon(icon);
			play.Checkimage = Image[3];
		}else if(e.getSource()==btn5){
			ImageIcon icon = new ImageIcon(Image[4]);
			imagelabel.setIcon(icon);
			play.Checkimage = Image[4];
		}
		if(e.getSource()==button){
			if(TF0.getText().length() != 0)
				isran=true;
			
			if(isran==false){
			int num = ran.nextInt(ranname.length);//����������
			TF0.setText(ranname[num]);//����������
			}
			
			for(int i=0;i<5;i++){
				if(combo.getSelectedItem()=="10��"){
				play.PlayerMoney[i] = 100000;
				
				}else if(combo.getSelectedItem()=="100��"){
				play.PlayerMoney[i] = 1000000;
				
				}else if(combo.getSelectedItem()=="1000��"){
				play.PlayerMoney[i] = 10000000;
				
				}else if(combo.getSelectedItem()=="5000��"){
				play.PlayerMoney[i] = 50000000;
				
			}
			}
			new chan();
			setVisible(false);
		}
}
	

	public static void main(String[] args) {
		
		new login();
	}
}