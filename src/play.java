
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class play extends JFrame implements ActionListener {
	
	int curThr = 0;
	Thread playT1;
	Thread playT2;
	Thread BetT1;
	Thread BetT2;
	Thread startT;
	Thread resultT;
	boolean isall[] = { false, false, false, false, false };
	JLabel userjok;// ����
	JPanel userpanel;// ����
	// ä�÷α�
	BufferedReader in = null;
	PrintWriter out = null;
	Writer wr;
	public int savecard[] = new int[10];
	public int wc[] = { 0, 0, 0, 0, 0 };
	int betscore;
	int wp = -1;
	public JButton btn[] = new JButton[6];
	int aw[] = { 0, 0, 0, 0, 0 }; // ���� ����
	// �̴���������
	JLabel imglb3;
	static String img = "image/minijokbo2.png"; // �̴����� �̹���
	ImageIcon originIcon3;
	Image originImg3;
	Image New_changedImg3;
	ImageIcon Icon3;
	JPanel bG3;

	static String Checkimage;
	static String Hwatoo[] = new String[20];
	static int score[] = new int[5];
	static int cards[] = new int[2];
	static String cardcombinations[] = new String[5];
	// ��

	int base = chan.base; // �⺻��
	int savedmoney;
	public int Money = 0; // �ǵ�
	int bet = chan.bet; // ���ñݾ�
	int bettime = 3;// ����

	// ����������
	int betcount = 3;
	JLabel countlb;
	Color colors = new Color(255, 126, 0);

	// ��
	int boss = 0;

	int live[] = { 1, 1, 1, 1, 1 };

	int myscore = 5;
	int p1score = 5;
	int p2score = 9;
	int p3score = 9;
	int p4score = 10;
	static String jokbo[] = { "����", "4��", "5��", "6��", "7��", "8��", "����", "����",
			"���", "���", "����", "����", "�˸�", "1��", "2��", "3��", "4��", "5��", "6��",
			"7��", "8��", "9��", "�嶯", "1��3����", "1��8����", "3��8����", "����", "���ֱ�������",
			"3��7������", "4��7 ������", "2��", "3��", "1��" };// 33��

	String player[] = { "", "", "", "", "" }; // �÷��̾��� ����
	int scoreArray[] = { myscore, p1score, p2score, p3score, p4score };// �÷��̾���
																		// ī������
	static int PlayerMoney[] = { 1000000, 1000000, 1000000, 1000000, 1000000 };// �÷��̾���
	// ���
	String PM[] = { "", "", "", "", "" };// zxcv
	static Random ran = new Random();

	Color mycolor = new Color(95, 114, 055);
	// �г� ��ġ
	JPanel tazzapnl = new JPanel(new BorderLayout());
	JPanel Eastpnl = new JPanel(new GridLayout(2, 2, 3, 3));
	JPanel Westpnl = new JPanel(new GridLayout(2, 2, 3, 3));
	JPanel Southpnl = new JPanel(new BorderLayout());
	static JPanel centerpnl = new JPanel();
	// �÷��̾� �г�
	JPanel player1 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player2 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player3 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player4 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel user = new JPanel();
	// �÷��̾� ������ ���̺�,�г�
	JLabel player1profile, player2profile, player3profile, player4profile,
			userprofile;
	JPanel player1profilepnl, player2profilepnl, player3profilepnl,
			player4profilepnl, userprofilepnl;
	
	// �÷��̾� ������ �̹��� ���̺�
	JLabel player1label, player2label, player3label, player4label, userlabel;
	JLabel player1money, player2money, player3money, player4money;
	static JLabel usermoney;// ����
	static JLabel username;// ����

	JPanel player1moneypnl, player2moneypnl, player3moneypnl, player4moneypnl,
			usermoneypnl;
	// ī��޸� �̹��� ���̺�,�����̹��� ���̺�
	static JLabel backlabel1;
	static JLabel backlabel2;
	static JLabel backlabel3;
	static JLabel backlabel4;
	JLabel centerlabel;
	JLabel centerTlabel;// ����
	
	JLabel player1bat,player2bat,player3bat,player4bat,userbat;//122
	// ���� ����
	JButton rule;
	ImageIcon originIcon;
	Image originImg;
	Image New_changedImg;
	ImageIcon Icon;
	// �� ����,Ŭ���� ��ư
	JButton btn1, btn2, btn3;
	JPanel btnpnl, btnpnl2;
	// ī�� ���̺�
	static JLabel[] cardslabel = new JLabel[20];
	// �ؽ�Ʈ�Ʒ��� �г�
	JTextPane TF1;
	JPanel TF1pnl;
	// �����г� , �ΰ� �г�
	JPanel userplayer;
	JPanel logopnl;
	JLabel logolabel, logolabel2, logolabel3;
	JScrollPane JSP;
	JLabel cen;
	JLabel[] scorelabel = new JLabel[5];
	JLabel[] winplayer = new JLabel[5]; // �¸��� �÷��̾� �̹���

	// ī�带 ���������� ����
	boolean isback = true;
	static String[] picture = { "image/1monthgwang.png", "image/1month1.png",
			"image/2month1.png", "image/2month2.png", "image/3monthgwang.png",
			"image/3month1.png", "image/4month1.png", "image/4month2.png",
			"image/5month1.png", "image/5month2.png", "image/6month1.png",
			"image/6month2.png", "image/7month1.png", "image/7month2.png",
			"image/8monthgwang.png", "image/8month1.png", "image/9month1.png",
			"image/9month2.png", "image/10month1.png", "image/10month2.png" };
	// �̹��� ��ΰ��� String ���·� ����
	static String back = "image/back.png"; // ī�� �޸� �̹���
	String exam = "image/ex.png";

	public play() {
		for (int i = 0; i < 5; i++) { // zxcv
			if (PlayerMoney[i] % 10000 == 0)
				PM[i] = PlayerMoney[i] / 10000 + "����";
			else
				PM[i] = PlayerMoney[i] / 10000 + "��" + (PlayerMoney[i] % 10000)
						/ 1000 + "õ��";

		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("����");
		this.setSize(1100, 1050);
		this.setLocationRelativeTo(null);
		// ä�÷α�

		// ī�� �� ����&Ŭ���� ��ư
		btn1 = new JButton("����");
		btn2 = new JButton("����");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login();

			}
		});
		btn3 = new JButton("�� �ٲٱ�");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				centerTlabel.setText("");
				chan.savepm = PlayerMoney[0];
				setVisible(false);
				new chan();

			}
		});

		btnpnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		btnpnl.setBackground(mycolor);

		// �÷��̾� ������ ���̺�,�г�
		player1money = new JLabel("<html>��ǻ�� ��ī����1<br/>���� �ݾ���<html>" + PM[1]);
		player1money.setFont(new Font("���� ���", Font.BOLD, 20));
		player1money.setForeground(Color.white);
		player1money.setHorizontalAlignment(JLabel.CENTER);

		player2money = new JLabel("<html>��ǻ�� ��ī����2<br/>���� �ݾ���<html>" + PM[2]);
		player2money.setFont(new Font("���� ���", Font.BOLD, 20));
		player2money.setForeground(Color.white);
		player2money.setHorizontalAlignment(JLabel.CENTER);

		player3money = new JLabel("<html>��ǻ�� ��ī����3<br/>���� �ݾ���<html>" + PM[3]);
		player3money.setFont(new Font("���� ���", Font.BOLD, 20));
		player3money.setForeground(Color.white);
		player3money.setHorizontalAlignment(JLabel.CENTER);

		player4money = new JLabel("<html>��ǻ�� ��ī����4<br/>���� �ݾ���<html>" + PM[4]);
		player4money.setFont(new Font("���� ���", Font.BOLD, 20));
		player4money.setForeground(Color.white);
		player4money.setHorizontalAlignment(JLabel.CENTER);

		username = new JLabel(login.TF0.getText());// ����
		userjok = new JLabel("���� �� :    ");// ����
		usermoney = new JLabel("���� �ݾ���" + PM[0]);// ����

		userpanel = new JPanel();// ����
		userpanel.setLayout(new BoxLayout(userpanel, BoxLayout.Y_AXIS));// ����
		userpanel.add(username);// ����
		userpanel.add(userjok);// ����
		userpanel.add(usermoney);// ����

		username.setFont(new Font("���� ���", Font.BOLD, 20));// ����
		username.setForeground(Color.white);
		userjok.setFont(new Font("���� ���", Font.BOLD, 20));
		userjok.setForeground(Color.white);
		usermoney.setFont(new Font("���� ���", Font.BOLD, 20));
		usermoney.setForeground(Color.white);
		userpanel.setBackground(mycolor);// ����

		player1moneypnl = new JPanel();
		player2moneypnl = new JPanel();
		player3moneypnl = new JPanel();
		player4moneypnl = new JPanel();

		player1profilepnl = new JPanel();
		player1profilepnl.setLayout(null);
		player2profilepnl = new JPanel();
		player2profilepnl.setLayout(null);
		player3profilepnl = new JPanel();
		player3profilepnl.setLayout(null);
		player4profilepnl = new JPanel();
		player4profilepnl.setLayout(null);
		userprofilepnl = new JPanel();
		userprofilepnl.setLayout(null);
		
		//122
		player1bat = new JLabel(new ImageIcon(""));
		player2bat = new JLabel(new ImageIcon(""));
		player3bat = new JLabel(new ImageIcon(""));
		player4bat = new JLabel(new ImageIcon(""));
		userbat = new JLabel(new ImageIcon(""));
		
		// ���� �÷��̾��� �������̹��� �ֱ�
		player1label = new JLabel(new ImageIcon("image/q.png"));
		player2label = new JLabel(new ImageIcon("image/w.png"));
		player3label = new JLabel(new ImageIcon("image/uzi.png"));
		player4label = new JLabel(new ImageIcon("image/e.png"));
		userlabel = new JLabel(new ImageIcon(Checkimage));

		// �����г� ���̺� �̹���
		centerlabel = new JLabel(new ImageIcon("image/im.gif"));
		centerTlabel = new JLabel("���� �ǵ�: " + (Money + savedmoney)
				+ " | ���� �� �ݾ� : " + bet);

		// ī��޸� ���̺� �̹���
		backlabel1 = new JLabel("");
		backlabel2 = new JLabel("");
		backlabel3 = new JLabel("");
		backlabel4 = new JLabel("");

		// ��������
		String ruleimg = ("image/rule.png");
		originIcon = new ImageIcon(ruleimg);
		originImg = originIcon.getImage();
		New_changedImg = originImg.getScaledInstance(90, 43, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(New_changedImg);
		rule = new JButton(new ImageIcon(New_changedImg));
		rule.setBounds(5, 5, 70, 28);
		// rule.setBounds(880,5,70,28);
		rule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rule) {
					new Jokboimpor();
				}
			}
		});
		this.add(rule);

		for (int i = 0; i < cardslabel.length; i++) {
			cardslabel[i] = new JLabel(""); // ȭ���� ������
																	// ����
		}

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent b) {
			if(PlayerMoney[0] != 0)
				new Card(); // �е����� ������ Ŭ����
			
				 Thread hd = new Hold();
				 hd.start();
				
				try
				{
				if(BetT1.isAlive()==true){
					curThr ++;
					}
				if(BetT2.isAlive()==true){
					curThr ++;
						}
				if(playT1.isAlive()==true){
					curThr ++;
						}
				if(playT2.isAlive()==true){
					curThr ++;
						}
				if(resultT.isAlive()==true){
					curThr ++;
						}
				}
				catch(Exception e){
					
				}
				if(curThr == 0){
				if (bettime < 3) {

				} else {
					userbat.setIcon(new ImageIcon(""));
					player1bat.setIcon(new ImageIcon(""));
					player2bat.setIcon(new ImageIcon(""));
					player3bat.setIcon(new ImageIcon(""));
					player4bat.setIcon(new ImageIcon(""));
					backlabel1.setIcon(new ImageIcon(""));
					backlabel2.setIcon(new ImageIcon(""));
					backlabel3.setIcon(new ImageIcon(""));
					backlabel4.setIcon(new ImageIcon(""));

					betcount = 3;
					countlb.setText("            " + betcount + "ȸ"); // ����������

					for (int i = 0; i < scorelabel.length; i++) {
						scorelabel[i].setText("");
						scorelabel[i].setOpaque(false);
					}

					if (PlayerMoney[0] == 0) {
						appendToPane(TF1, "game over" + "\n", Color.black);
						JOptionPane.showMessageDialog(null, "Game Over",
								"Game Over", JOptionPane.WARNING_MESSAGE);
						setVisible(false);
						new login();
					} else {
						appendToPane(TF1, "������ �����մϴ�." + "\n", Color.black);

						for (int j = 0; j < 20; j++) {
							Hwatoo[j] = "" + j;
						}
						Collections.shuffle(Arrays.asList(Hwatoo));

						for (int i = 0; i < 5; i++) {
							winplayer[i].setIcon(null);
							isall[i] = false;

							cards[0] = Integer.parseInt(Hwatoo[0 + (i * 2)]);
							cards[1] = Integer.parseInt(Hwatoo[1 + (i * 2)]);
							int a1 = cards[0];
							int b1 = cards[1];
							savecard[(i * 2)] = cards[0];
							savecard[1 + (i * 2)] = cards[1];
							cardslabel[0 + (i * 2)].setIcon(new ImageIcon(
									"")); // ���̺� ��� ȭ���̹��� ����
							cardslabel[0 + (i * 2)]
									.setPreferredSize(new Dimension(75, 150)); // ȭ����
																				// ������
																				// ����
							cardslabel[1 + (i * 2)].setIcon(new ImageIcon(
									"")); // ���̺� ��� ȭ���̹��� ����
							cardslabel[1 + (i * 2)]
									.setPreferredSize(new Dimension(75, 150)); // ȭ����
																				// ������
																				// ����

							if (cards[0] == 2 && cards[1] == 14) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];

							} else if (cards[0] == 2 && cards[1] == 14) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 2 && cards[1] == 15) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 3 && cards[1] == 14) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 3 && cards[1] == 15) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 14 && cards[1] == 2) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 14 && cards[1] == 3) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 15 && cards[1] == 2) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 15 && cards[1] == 3) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 5 && cards[1] == 12) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 12 && cards[1] == 5) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 5 && cards[1] == 13) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 13 && cards[1] == 5) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 4 && cards[1] == 13) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							} else if (cards[0] == 13 && cards[1] == 4) {
								score[i] = 0;
								cardcombinations[i] = jokbo[0];
							}
							// ���� - 2��8��*/

							else if (cards[0] == 2 && cards[1] == 16) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 2 && cards[1] == 17) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 3 && cards[1] == 16) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 3 && cards[1] == 17) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 16 && cards[1] == 2) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 16 && cards[1] == 3) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 17 && cards[1] == 2) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 17 && cards[1] == 3) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];// 1��-2��9��
							} else if (cards[0] == 4 && cards[1] == 15) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 5 && cards[1] == 14) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 5 && cards[1] == 15) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 14 && cards[1] == 5) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 15 && cards[1] == 4) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 15 && cards[1] == 5) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];// 1��-3��8��
							} else if (cards[0] == 6 && cards[1] == 12) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 6 && cards[1] == 13) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 7 && cards[1] == 12) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 7 && cards[1] == 13) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 12 && cards[1] == 6) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 12 && cards[1] == 7) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 13 && cards[1] == 6) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 13 && cards[1] == 7) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32]; // 1�� 4��7��
							} else if (cards[0] == 8 && cards[1] == 10) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 8 && cards[1] == 11) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 9 && cards[1] == 10) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 9 && cards[1] == 11) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 10 && cards[1] == 8) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 10 && cards[1] == 9) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 11 && cards[1] == 8) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							} else if (cards[0] == 11 && cards[1] == 9) {
								score[i] = 1;
								cardcombinations[i] = jokbo[32];
							}// 1�� - 5��6��

							else if (cards[0] == 2 && cards[1] == 18) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 2 && cards[1] == 19) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 3 && cards[1] == 18) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 3 && cards[1] == 19) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 18 && cards[1] == 2) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 18 && cards[1] == 3) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 19 && cards[1] == 2) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 19 && cards[1] == 3) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30]; // 2�� -2��10��
							} else if (cards[0] == 4 && cards[1] == 16) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 4 && cards[1] == 17) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 5 && cards[1] == 16) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 5 && cards[1] == 17) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 16 && cards[1] == 4) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 16 && cards[1] == 5) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 17 && cards[1] == 4) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 17 && cards[1] == 5) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30]; // 2�� -3��9��
							} else if (cards[0] == 6 && cards[1] == 14) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 6 && cards[1] == 15) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 7 && cards[1] == 14) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 7 && cards[1] == 15) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 14 && cards[1] == 6) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 14 && cards[1] == 7) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 15 && cards[1] == 6) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 15 && cards[1] == 7) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30]; // 2�� -4��8��
							} else if (cards[0] == 8 && cards[1] == 12) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 8 && cards[1] == 13) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 9 && cards[1] == 12) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 9 && cards[1] == 13) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 12 && cards[1] == 8) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 12 && cards[1] == 9) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 13 && cards[1] == 8) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} else if (cards[0] == 13 && cards[1] == 9) {
								score[i] = 2;
								cardcombinations[i] = jokbo[30];
							} // 2�� -5��7��

							else if (cards[0] == 4 && cards[1] == 18) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 4 && cards[1] == 19) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 5 && cards[1] == 18) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 5 && cards[1] == 19) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 18 && cards[1] == 4) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 18 && cards[1] == 5) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 19 && cards[1] == 4) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 19 && cards[1] == 5) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];// 3��-3��10��
							} else if (cards[0] == 8 && cards[1] == 14) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 8 && cards[1] == 15) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 9 && cards[1] == 14) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 9 && cards[1] == 15) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 14 && cards[1] == 8) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 14 && cards[1] == 9) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 15 && cards[1] == 8) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 15 && cards[1] == 9) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];// 3��-5��8��
							} else if (cards[0] == 10 && cards[1] == 12) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 10 && cards[1] == 13) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 11 && cards[1] == 12) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 11 && cards[1] == 13) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 12 && cards[1] == 10) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 12 && cards[1] == 11) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 13 && cards[1] == 10) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} else if (cards[0] == 13 && cards[1] == 11) {
								score[i] = 3;
								cardcombinations[i] = jokbo[31];
							} // 3��- 6��7��

							else if (cards[0] == 0 && cards[1] == 5) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 1 && cards[1] == 4) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 1 && cards[1] == 5) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 4 && cards[1] == 1) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 5 && cards[1] == 0) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 5 && cards[1] == 1) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];// 4�� - 1��3��
							} else if (cards[0] == 10 && cards[1] == 14) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 10 && cards[1] == 15) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 11 && cards[1] == 14) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 11 && cards[1] == 15) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 14 && cards[1] == 10) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 14 && cards[1] == 11) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 15 && cards[1] == 10) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 15 && cards[1] == 11) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];// 4�� -6��8��
							} else if (cards[0] == 8 && cards[1] == 16) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 8 && cards[1] == 17) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 9 && cards[1] == 16) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 9 && cards[1] == 17) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 16 && cards[1] == 8) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 16 && cards[1] == 9) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 17 && cards[1] == 8) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} else if (cards[0] == 17 && cards[1] == 9) {
								score[i] = 4;
								cardcombinations[i] = jokbo[1];
							} // 4�� -5��9��

							else if (cards[0] == 2 && cards[1] == 4) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 2 && cards[1] == 5) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 3 && cards[1] == 4) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 3 && cards[1] == 5) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 4 && cards[1] == 2) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 4 && cards[1] == 3) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 5 && cards[1] == 2) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 5 && cards[1] == 3) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2]; // 5�� - 2��3��
							} else if (cards[0] == 8 && cards[1] == 18) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 8 && cards[1] == 19) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 9 && cards[1] == 18) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 9 && cards[1] == 19) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 18 && cards[1] == 8) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 18 && cards[1] == 9) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 19 && cards[1] == 8) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 19 && cards[1] == 9) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];// 5��- 5��10��
							} else if (cards[0] == 10 && cards[1] == 16) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 10 && cards[1] == 17) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 11 && cards[1] == 16) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 11 && cards[1] == 17) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 16 && cards[1] == 10) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 16 && cards[1] == 11) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 17 && cards[1] == 10) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 17 && cards[1] == 11) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];// 5��- 7��8��
							} else if (cards[0] == 12 && cards[1] == 14) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 12 && cards[1] == 15) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 13 && cards[1] == 14) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 13 && cards[1] == 15) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 14 && cards[1] == 12) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 14 && cards[1] == 13) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 15 && cards[1] == 12) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							} else if (cards[0] == 15 && cards[1] == 13) {
								score[i] = 5;
								cardcombinations[i] = jokbo[2];
							}// 5��- 7��8��

							else if (cards[0] == 0 && cards[1] == 8) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 0 && cards[1] == 9) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 1 && cards[1] == 8) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 1 && cards[1] == 9) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 8 && cards[1] == 0) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 8 && cards[1] == 1) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 9 && cards[1] == 0) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 9 && cards[1] == 1) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];// 6�� -2��5��
							} else if (cards[0] == 2 && cards[1] == 6) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 2 && cards[1] == 7) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 3 && cards[1] == 6) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 3 && cards[1] == 7) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 6 && cards[1] == 2) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 6 && cards[1] == 3) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 7 && cards[1] == 2) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 7 && cards[1] == 3) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3]; // 6�� -2��4��
							} else if (cards[0] == 10 && cards[1] == 18) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 10 && cards[1] == 19) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 11 && cards[1] == 18) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 11 && cards[1] == 19) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 18 && cards[1] == 10) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 18 && cards[1] == 11) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 19 && cards[1] == 10) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 19 && cards[1] == 11) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3]; // 6�� 6��10��
							} else if (cards[0] == 12 && cards[1] == 16) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 12 && cards[1] == 17) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 13 && cards[1] == 16) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 13 && cards[1] == 17) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 16 && cards[1] == 12) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 16 && cards[1] == 13) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 17 && cards[1] == 12) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} else if (cards[0] == 17 && cards[1] == 13) {
								score[i] = 6;
								cardcombinations[i] = jokbo[3];
							} // 6�� 7��9��

							else if (cards[0] == 0 && cards[1] == 10) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 0 && cards[1] == 11) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 1 && cards[1] == 10) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 1 && cards[1] == 11) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 10 && cards[1] == 0) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 10 && cards[1] == 1) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 11 && cards[1] == 0) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 11 && cards[1] == 1) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];// 7�� - 1��6��
							} else if (cards[0] == 2 && cards[1] == 8) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 2 && cards[1] == 9) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 3 && cards[1] == 8) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 3 && cards[1] == 9) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 8 && cards[1] == 2) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 8 && cards[1] == 3) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 9 && cards[1] == 2) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 9 && cards[1] == 3) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];// 7�� - 2��5��
							} else if (cards[0] == 4 && cards[1] == 6) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 4 && cards[1] == 7) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 5 && cards[1] == 6) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 5 && cards[1] == 7) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 6 && cards[1] == 4) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 6 && cards[1] == 5) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 7 && cards[1] == 4) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 7 && cards[1] == 5) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4]; // 7�� - 3��4��
							} else if (cards[0] == 12 && cards[1] == 18) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 12 && cards[1] == 19) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 13 && cards[1] == 18) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 13 && cards[1] == 19) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 18 && cards[1] == 12) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 18 && cards[1] == 13) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 19 && cards[1] == 12) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 19 && cards[1] == 13) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];// 7�� - 7��10��
							} else if (cards[0] == 14 && cards[1] == 16) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 14 && cards[1] == 17) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 15 && cards[1] == 16) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 15 && cards[1] == 17) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 16 && cards[1] == 14) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 16 && cards[1] == 15) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 17 && cards[1] == 14) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} else if (cards[0] == 17 && cards[1] == 15) {
								score[i] = 7;
								cardcombinations[i] = jokbo[4];
							} // 7�� 8��9��

							else if (cards[0] == 0 && cards[1] == 12) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 0 && cards[1] == 13) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 1 && cards[1] == 12) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 1 && cards[1] == 13) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 12 && cards[1] == 0) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 12 && cards[1] == 1) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 13 && cards[1] == 0) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 13 && cards[1] == 1) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];// 8�� - 1��8��
							} else if (cards[0] == 2 && cards[1] == 10) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 2 && cards[1] == 11) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 3 && cards[1] == 10) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 3 && cards[1] == 11) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 10 && cards[1] == 2) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 10 && cards[1] == 3) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 11 && cards[1] == 2) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 11 && cards[1] == 3) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];// 8�� -2��7��
							} else if (cards[0] == 4 && cards[1] == 8) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 4 && cards[1] == 9) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 5 && cards[1] == 8) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 5 && cards[1] == 9) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 8 && cards[1] == 4) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 8 && cards[1] == 5) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 9 && cards[1] == 4) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 9 && cards[1] == 5) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5]; // 8�� -,3��5��
							} else if (cards[0] == 14 && cards[1] == 18) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 14 && cards[1] == 19) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 15 && cards[1] == 18) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 15 && cards[1] == 19) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 18 && cards[1] == 14) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 18 && cards[1] == 15) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 19 && cards[1] == 14) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} else if (cards[0] == 19 && cards[1] == 15) {
								score[i] = 8;
								cardcombinations[i] = jokbo[5];
							} // 8�� -8�� 10��

							else if (cards[0] == 0 && cards[1] == 15) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 1 && cards[1] == 14) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 1 && cards[1] == 15) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 14 && cards[1] == 1) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 15 && cards[1] == 0) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 15 && cards[1] == 1) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];// ���� -2��8��
							} else if (cards[0] == 2 && cards[1] == 12) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 2 && cards[1] == 13) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 3 && cards[1] == 12) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 3 && cards[1] == 13) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 12 && cards[1] == 2) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 12 && cards[1] == 3) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 13 && cards[1] == 2) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 13 && cards[1] == 3) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];// ���� -2��7��
							} else if (cards[0] == 4 && cards[1] == 10) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 4 && cards[1] == 11) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 5 && cards[1] == 10) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 5 && cards[1] == 11) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 10 && cards[1] == 4) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 10 && cards[1] == 5) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 11 && cards[1] == 4) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 11 && cards[1] == 5) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];// ���� -3��6��
							} else if (cards[0] == 6 && cards[1] == 8) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 6 && cards[1] == 9) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 7 && cards[1] == 8) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 7 && cards[1] == 9) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 8 && cards[1] == 6) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 8 && cards[1] == 7) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 9 && cards[1] == 6) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 9 && cards[1] == 7) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6]; // ���� -4��5��
							} else if (cards[0] == 16 && cards[1] == 18) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 16 && cards[1] == 19) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 17 && cards[1] == 18) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 17 && cards[1] == 19) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 18 && cards[1] == 16) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 18 && cards[1] == 17) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 19 && cards[1] == 16) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} else if (cards[0] == 19 && cards[1] == 17) {
								score[i] = 9;
								cardcombinations[i] = jokbo[6];
							} // ���� - 9��10��

							else if (cards[0] == 6 && cards[1] == 10) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 6 && cards[1] == 11) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 7 && cards[1] == 10) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 7 && cards[1] == 11) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 10 && cards[1] == 6) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 10 && cards[1] == 7) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 11 && cards[1] == 6) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							} else if (cards[0] == 11 && cards[1] == 7) {
								score[i] = 10;
								cardcombinations[i] = jokbo[7];
							}// ����- 4��6��

							else if (cards[0] == 6 && cards[1] == 18) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 6 && cards[1] == 19) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 7 && cards[1] == 18) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 7 && cards[1] == 19) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 18 && cards[1] == 6) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 18 && cards[1] == 7) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 19 && cards[1] == 6) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							} else if (cards[0] == 19 && cards[1] == 7) {
								score[i] = 11;
								cardcombinations[i] = jokbo[8];
							}// ���-4��10��

							else if (cards[0] == 0 && cards[1] == 18) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 0 && cards[1] == 19) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 1 && cards[1] == 18) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 1 && cards[1] == 19) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 18 && cards[1] == 0) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 18 && cards[1] == 1) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 19 && cards[1] == 0) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							} else if (cards[0] == 19 && cards[1] == 1) {
								score[i] = 12;
								cardcombinations[i] = jokbo[9];
							}// ��� - 1��10��

							else if (cards[0] == 0 && cards[1] == 16) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 0 && cards[1] == 17) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 1 && cards[1] == 16) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 1 && cards[1] == 17) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 16 && cards[1] == 0) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 16 && cards[1] == 1) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 17 && cards[1] == 0) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							} else if (cards[0] == 17 && cards[1] == 1) {
								score[i] = 13;
								cardcombinations[i] = jokbo[10];
							}// ����

							else if (cards[0] == 0 && cards[1] == 6) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 0 && cards[1] == 7) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 1 && cards[1] == 6) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 1 && cards[1] == 7) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 6 && cards[1] == 0) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 6 && cards[1] == 1) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 7 && cards[1] == 0) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							} else if (cards[0] == 7 && cards[1] == 1) {
								score[i] = 14;
								cardcombinations[i] = jokbo[11];
							}// ����

							else if (cards[0] == 0 && cards[1] == 2) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 0 && cards[1] == 3) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 1 && cards[1] == 2) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 1 && cards[1] == 3) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 2 && cards[1] == 0) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 2 && cards[1] == 1) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 3 && cards[1] == 0) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							} else if (cards[0] == 3 && cards[1] == 1) {
								score[i] = 15;
								cardcombinations[i] = jokbo[12];
							}// �˸� 1��2��

							else if (cards[0] == 0 && cards[1] == 1) {
								score[i] = 16;
								cardcombinations[i] = jokbo[13];
							} else if (cards[0] == 1 && cards[1] == 0) {
								score[i] = 16;
								cardcombinations[i] = jokbo[13];
							}// 1��

							else if (cards[0] == 2 && cards[1] == 3) {
								score[i] = 17;
								cardcombinations[i] = jokbo[14];
							} else if (cards[0] == 3 && cards[1] == 2) {
								score[i] = 17;
								cardcombinations[i] = jokbo[14];
							}// 2��

							else if (cards[0] == 4 && cards[1] == 5) {
								score[i] = 18;
								cardcombinations[i] = jokbo[15];
							} else if (cards[0] == 5 && cards[1] == 4) {
								score[i] = 18;
								cardcombinations[i] = jokbo[15];
							}// 3��

							else if (cards[0] == 6 && cards[1] == 7) {
								score[i] = 19;
								cardcombinations[i] = jokbo[16];
							} else if (cards[0] == 7 && cards[1] == 6) {
								score[i] = 19;
								cardcombinations[i] = jokbo[16];
							}// 4��

							else if (cards[0] == 8 && cards[1] == 9) {
								score[i] = 20;
								cardcombinations[i] = jokbo[17];
							} else if (cards[0] == 9 && cards[1] == 8) {
								score[i] = 20;
								cardcombinations[i] = jokbo[17];
							}// 5��

							else if (cards[0] == 10 && cards[1] == 11) {
								score[i] = 21;
								cardcombinations[i] = jokbo[18];
							} else if (cards[0] == 11 && cards[1] == 10) {
								score[i] = 21;
								cardcombinations[i] = jokbo[18];
							}// 6��

							else if (cards[0] == 12 && cards[1] == 13) {
								score[i] = 22;
								cardcombinations[i] = jokbo[19];
							} else if (cards[0] == 13 && cards[1] == 12) {
								score[i] = 22;
								cardcombinations[i] = jokbo[19];
							}// 7��

							else if (cards[0] == 14 && cards[1] == 15) {
								score[i] = 23;
								cardcombinations[i] = jokbo[20];
							} else if (cards[0] == 15 && cards[1] == 14) {
								score[i] = 23;
								cardcombinations[i] = jokbo[20];
							}// 8��

							else if (cards[0] == 16 && cards[1] == 17) {
								score[i] = 24;
								cardcombinations[i] = jokbo[21];
							} else if (cards[0] == 17 && cards[1] == 16) {
								score[i] = 24;
								cardcombinations[i] = jokbo[21];
							}// 9��

							else if (cards[0] == 18 && cards[1] == 19) {
								score[i] = 26;
								cardcombinations[i] = jokbo[22];
							} else if (cards[0] == 19 && cards[1] == 18) {
								score[i] = 26;
								cardcombinations[i] = jokbo[22];
							}// �嶯

							else if (cards[0] == 0 && cards[1] == 4) {
								score[i] = 27;
								cardcombinations[i] = jokbo[23];
							} else if (cards[0] == 4 && cards[1] == 0) {
								score[i] = 27;
								cardcombinations[i] = jokbo[23];
							}// 13����

							else if (cards[0] == 0 && cards[1] == 14) {
								score[i] = 27;
								cardcombinations[i] = jokbo[24];
							} else if (cards[0] == 14 && cards[1] == 0) {
								score[i] = 27;
								cardcombinations[i] = jokbo[24];
							}// 18����

							else if (cards[0] == 4 && cards[1] == 14) {
								score[i] = 28;
								cardcombinations[i] = jokbo[25];
							} else if (cards[0] == 14 && cards[1] == 4) {
								score[i] = 28;
								cardcombinations[i] = jokbo[25];
							}// 38����

							else if (cards[0] == 6 && cards[1] == 17) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							} else if (cards[0] == 17 && cards[1] == 6) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							} else if (cards[0] == 7 && cards[1] == 17) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							} else if (cards[0] == 17 && cards[1] == 7) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							} else if (cards[0] == 7 && cards[1] == 16) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							} else if (cards[0] == 16 && cards[1] == 7) {
								score[i] = -2;
								cardcombinations[i] = jokbo[26];
							}// ���� -��밡 �˸������������϶� ���Ⱑ��

							else if (cards[0] == 6 && cards[1] == 16) {
								score[i] = -1;
								cardcombinations[i] = jokbo[27];
							} else if (cards[0] == 16 && cards[1] == 6) {
								score[i] = -1;
								cardcombinations[i] = jokbo[27];
							}// ���ֱ������� - ��밡 �嶯�����Ͻ� ���Ⱑ��

							else if (cards[0] == 4 && cards[1] == 12) {
								score[i] = -3;
								cardcombinations[i] = jokbo[28];
							} else if (cards[0] == 12 && cards[1] == 4) {
								score[i] = -3;
								cardcombinations[i] = jokbo[28];
							} // ������

							else if (cards[0] == 6 && cards[1] == 12) {
								score[i] = -4;
								cardcombinations[i] = jokbo[29];
							} else if (cards[0] == 12 && cards[1] == 6) {
								score[i] = -4;
								cardcombinations[i] = jokbo[29];
							} // ������

							bet = chan.bet;
							bettime = 0;
							if (wp == 6) { // ���� �ƴҰ�� �ǵ����θ� ����
								live[i] = aw[i]; // aw���� �̿� ���� ����� ����
								if (live[i] == 1) {// live 1�ϰ�� ��� ����
									if (i == 0) {// ���� ī��̱�
										player[i] = cardcombinations[i];
										scoreArray[i] = score[i];

										appendToPane(TF1, "���� ����" + "\n",
												Color.black);

									} else {// ������
										player[i] = cardcombinations[i];
										scoreArray[i] = score[i];

										appendToPane(TF1, "�÷��̾�" + i + "�� ����"
												+ "\n", Color.black);

									}
								} else if (live[i] == 0) {
									if (i == 0) {
										player[i] = "";
										scoreArray[i] = -5;
										wc[0] = 1;
										backlabel1.setIcon(new ImageIcon(back));
										cardslabel[0].setIcon(new ImageIcon(
												back));
										cardslabel[1].setIcon(new ImageIcon(
												back));

									} else {
										player[i] = "";
										scoreArray[i] = -5;
										wc[i] = 1;
									}
									cardslabel[0 + (i * 2)]
											.setIcon(new ImageIcon(back)); // ���̺�
																			// ���
																			// ȭ���̹���
																			// ����
									cardslabel[0 + (i * 2)]
											.setPreferredSize(new Dimension(75,
													150));
									cardslabel[1 + (i * 2)]
											.setIcon(new ImageIcon(back)); // ���̺�
																			// ���
																			// ȭ���̹���
																			// ����
									cardslabel[1 + (i * 2)]
											.setPreferredSize(new Dimension(75,
													150));
								}

							} else { // wp=6�� �ƴϸ� ��� ������ �ο�����
								if (PlayerMoney[i] < 1) {
									live[i] = 0;
									if (i == 1)
										appendToPane(TF1, "�÷��̾�" + i,
												Color.green);
									if (i == 2)
										appendToPane(TF1, "�÷��̾�" + i,
												Color.orange);
									if (i == 3)
										appendToPane(TF1, "�÷��̾�" + i,
												Color.cyan);
									if (i == 4)
										appendToPane(TF1, "�÷��̾�" + i,
												Color.blue);
									appendToPane(TF1, "�� ������ ���� �����ϴ�." + "\n",
											Color.black);
									cardslabel[i * 2].setIcon(new ImageIcon(
											back));
									player[i] = "";
									scoreArray[i] = -5;
								} else {
									PlayerMoney[i] -= bet;
									Money += bet;

									live[i] = 1;

									player[i] = cardcombinations[i];
									scoreArray[i] = score[i];
									wp = 0;

									for (int u = 0; u < 5; u++) { // ����
										if (PlayerMoney[u] % 10000 == 0)// ����
											PM[u] = PlayerMoney[u] / 10000
													+ "����"; // ����
										else
											// ����
											PM[u] = PlayerMoney[u] / 10000
													+ "��"
													+ (PlayerMoney[u] % 10000)
													/ 1000 + "õ��"; // ����

									}

									player1money
											.setText("<html>��ǻ�� ��ī����1<br/>���� �ݾ���<html>"
													+ PM[1]);// ����
									player2money
											.setText("<html>��ǻ�� ��ī����2<br/>���� �ݾ���<html>"
													+ PM[2]);// ����
									player3money
											.setText("<html>��ǻ�� ��ī����3<br/>���� �ݾ���<html>"
													+ PM[3]);// ����
									player4money
											.setText("<html>��ǻ�� ��ī����4<br/>���� �ݾ���<html>"
													+ PM[4]);// ����
									usermoney.setText("���� �ݾ���" + PM[0]);// ����

									centerTlabel.setText("���� �ǵ�: "
											+ (Money + savedmoney)
											+ " | ���� �� �ݾ� : " + bet);// ����

								}

							}
							userjok.setText("���� �� : " + player[0]);// ����

						}
						Money += savedmoney;
						savedmoney = 0;
						
						startT = new StartThread();
						startT.start();
						
						centerTlabel.setText("���� �ǵ�: " + Money
								+ " | ���� �� �ݾ� : " + bet);// ����
						aw[0] = 0; // �ߺ�üũ �迭 �ʱ�ȭ�� for �ǽ��ѵ�
						aw[1] = 0;
						aw[2] = 0;
						aw[3] = 0;
						aw[4] = 0;
						wp = 0;
					}
				}
			}
				else{
					appendToPane(TF1, "���� ó������ ������ �ֽ��ϴ�." + "\n", Color.black);
					curThr = 0;
				}
			}
		});
		// �÷��̾�1 �г�
		winplayer[0] = new JLabel(""); // �¸��� �÷��̾� �̹���
		winplayer[1] = new JLabel(""); // �¸��� �÷��̾� �̹���
		winplayer[2] = new JLabel(""); // �¸��� �÷��̾� �̹���
		winplayer[3] = new JLabel(""); // �¸��� �÷��̾� �̹���
		winplayer[4] = new JLabel(""); // �¸��� �÷��̾� �̹���
		scorelabel[0] = new JLabel("");
		scorelabel[1] = new JLabel("");
		scorelabel[2] = new JLabel("");
		scorelabel[3] = new JLabel("");
		scorelabel[4] = new JLabel("");

		player1moneypnl.add(player1money);
		player1moneypnl.setBackground(mycolor);

		cardslabel[2].setBounds(0, 0, 75, 150);
		backlabel1.setBounds(78, 0, 75, 150);
		player1label.setBounds(157, 0, 75, 150);
		scorelabel[1].setBounds(3, 80, 146, 40);
		winplayer[0].setBounds(157, 0, 75, 150); // �¸��� �÷��̾� �̹���

		player1profilepnl.add(winplayer[0]); // �¸��� �÷��̾� �̹���
		player1profilepnl.add(scorelabel[1]);
		player1profilepnl.add(cardslabel[2]);
		player1profilepnl.add(backlabel1);
		player1profilepnl.add(player1label);
		player1profilepnl.setPreferredSize(new Dimension(240, 150));
		player1profilepnl.setBackground(mycolor);

		player1.add(player1profilepnl);
		player1.add(player1moneypnl);
		player1.setBackground(mycolor);

		// �÷��̾�2 �г�
		player2moneypnl.add(player2money);
		player2moneypnl.setBackground(mycolor);

		cardslabel[4].setBounds(0, 0, 75, 150);
		backlabel2.setBounds(78, 0, 75, 150);
		player2label.setBounds(157, 0, 75, 150);
		scorelabel[2].setBounds(3, 80, 146, 40);
		winplayer[1].setBounds(157, 0, 75, 150);

		player2profilepnl.add(winplayer[1]); // �¸��� �÷��̾� �̹���
		player2profilepnl.add(scorelabel[2]);
		player2profilepnl.add(cardslabel[4]);
		player2profilepnl.add(backlabel2);
		player2profilepnl.add(player2label);
		player2profilepnl.setBackground(mycolor);

		player2.add(player2profilepnl);
		player2.add(player2moneypnl);
		player2.setBackground(mycolor);

		// �÷��̾�3 �г�
		player3moneypnl.add(player3money);
		player3moneypnl.setBackground(mycolor);

		player3label.setBounds(0, 0, 75, 150);
		backlabel3.setBounds(78, 0, 75, 150);
		cardslabel[6].setBounds(156, 0, 75, 150);
		scorelabel[3].setBounds(81, 80, 147, 40);
		winplayer[2].setBounds(0, 0, 75, 150); // �¸��� �÷��̾� �̹���

		player3profilepnl.add(winplayer[2]); // �¸��� �÷��̾� �̹���
		player3profilepnl.add(scorelabel[3]);
		player3profilepnl.add(player3label);
		player3profilepnl.add(backlabel3);
		player3profilepnl.add(cardslabel[6]);
		player3profilepnl.setPreferredSize(new Dimension(240, 150));
		player3profilepnl.setBackground(mycolor);

		player3.add(player3profilepnl);
		player3.add(player3moneypnl);
		player3.setBackground(mycolor);

		// �÷��̾�4 �г�
		player4moneypnl.add(player4money);
		player4moneypnl.setBackground(mycolor);

		player4label.setBounds(0, 0, 75, 150);
		backlabel4.setBounds(78, 0, 75, 150);
		cardslabel[8].setBounds(156, 0, 75, 150);
		scorelabel[4].setBounds(81, 80, 147, 40);
		winplayer[3].setBounds(0, 0, 75, 150); // �¸��� �÷��̾� �̹���

		player4profilepnl.add(winplayer[3]); // �¸��� �÷��̾� �̹���
		player4profilepnl.add(scorelabel[4]);
		player4profilepnl.add(player4label);
		player4profilepnl.add(backlabel4);
		player4profilepnl.add(cardslabel[8]);
		player4profilepnl.setBackground(mycolor);

		player4.add(player4profilepnl);
		player4.add(player4moneypnl);
		player4.setBackground(mycolor);
		// ��ư �г�
		btnpnl2 = new JPanel();
		btnpnl2.setLayout(null);
		btnpnl2.setBackground(mycolor);
		btnpnl2.setPreferredSize(new Dimension(250, 30));

		JLabel jokbolabel = new JLabel(new ImageIcon("image/jokbolabel.png"));
		btn[0] = new JButton(new ImageIcon("image/half.png", "����"));
		btn[0].addActionListener(this);
		btn[1] = new JButton(new ImageIcon("image/call.png", "��"));
		btn[1].addActionListener(this);
		btn[4] = new JButton(new ImageIcon("image/check.png", "üũ"));
		btn[4].addActionListener(this);
		btn[2] = new JButton(new ImageIcon("image/ddadang.png", "����"));
		btn[2].addActionListener(this);
		btn[3] = new JButton(new ImageIcon("image/bbing.png", "��"));
		btn[3].addActionListener(this);
		btn[5] = new JButton(new ImageIcon("image/die.png", "����"));
		btn[5].addActionListener(this);

		jokbolabel.setBounds(0, 0, 250, 101); // �̴����� ��ġ//����������

		countlb = new JLabel("            " + betcount + "ȸ");// ����������
		countlb.setFont(new Font("���� ���", Font.BOLD, 15));
		;
		countlb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		TitledBorder border = new TitledBorder(new LineBorder(colors),
				"���� ���� Ƚ��");
		border.setTitleColor(colors);
		border.setTitleFont(new Font("���� ���", Font.BOLD, 20));
		countlb.setBorder(border);
		countlb.setBounds(30, 120, 170, 50); // ����������

		btnpnl2.add(countlb);
		btn[0].setBounds(0, 180, 110, 73);
		btn[1].setBounds(120, 180, 110, 73);
		btn[2].setBounds(0, 260, 110, 73);
		btn[3].setBounds(120, 260, 110, 73);
		btn[4].setBounds(0, 340, 110, 73);
		btn[5].setBounds(120, 340, 110, 73);

		btnpnl2.add(jokbolabel);
		btnpnl2.add(btn[0]);
		btnpnl2.add(btn[1]);
		btnpnl2.add(btn[2]);
		btnpnl2.add(btn[3]);
		btnpnl2.add(btn[4]);
		btnpnl2.add(btn[5]);
		// �����г�
		TF1 = new JTextPane();
		JSP = new JScrollPane(TF1);
		JSP.setPreferredSize(new Dimension(600, 200));// ����
		TF1pnl = new JPanel();
		TF1pnl.add(JSP);
		userplayer = new JPanel(new BorderLayout());
		logopnl = new JPanel(new GridLayout(2, 1));
		logopnl.setBackground(mycolor);
		logolabel = new JLabel(new ImageIcon("image/tazzaa.png"));
		logolabel2 = new JLabel("<html>�ֿ��� | ������  | �ڹα� | ������<br/>"
				+ "���� 2019.12.26 ~ 2020.01.10<html>");
		logolabel2.setFont(new Font("���� ���", Font.BOLD, 17));
		logolabel2.setForeground(Color.black);
		logolabel.setBackground(mycolor);

		logolabel.setBackground(mycolor);
		logopnl.add(logolabel);
		logopnl.add(logolabel2);

		userlabel.setBounds(150, 0, 75, 150);
		cardslabel[0].setBounds(228, 0, 75, 150);
		cardslabel[1].setBounds(306, 0, 75, 150);
		scorelabel[0].setBounds(232, 80, 147, 40);
		winplayer[4].setBounds(150, 0, 75, 150); // �¸��� �÷��̾� �̹���
		userprofilepnl.setPreferredSize(new Dimension(260, 150));

		userprofilepnl.add(winplayer[4]); // �¸��� �÷��̾� �̹���
		userprofilepnl.add(scorelabel[0]);
		userprofilepnl.add(userlabel);
		userprofilepnl.add(cardslabel[0]);
		userprofilepnl.add(cardslabel[1]);
		userprofilepnl.setBackground(mycolor);

		user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
		userpanel.setAlignmentX(Component.CENTER_ALIGNMENT);// ����
		user.add(userprofilepnl);
		user.add(userpanel);// ����
		user.add(JSP);
		// �г� ����(��,��,��,��)
		user.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));// ����
		user.setBackground(mycolor);

		btnpnl.add(btn3);
		btnpnl.add(btn1);
		btnpnl.add(btn2);

		Westpnl.add(player3); // West �г�
		Westpnl.add(player4);
		Westpnl.setBackground(mycolor);

		Eastpnl.add(player1); // East �г�
		Eastpnl.add(player2);
		Eastpnl.setBackground(mycolor);

		Southpnl.add(logopnl, "West");
		Southpnl.add(btnpnl2, "East");
		Southpnl.add(user); // South �г�
		Southpnl.setBackground(mycolor);

		centerpnl.setLayout(null);// 122
		centerpnl.add(centerlabel);//122
		centerlabel.setBounds(0, 0, 0, 0);//122
		centerpnl.add(centerTlabel);// 122
		centerTlabel.setBounds(150, 300, 500, 200);//122
		centerpnl.add(player1bat);
		centerpnl.add(player2bat);
		centerpnl.add(player3bat);
		centerpnl.add(player4bat);
		centerpnl.add(userbat);
		player1bat.setBounds(500, 0, 100, 100);
		player2bat.setBounds(500, 250, 100, 100);
		player3bat.setBounds(0, 0, 100, 100);
		player4bat.setBounds(0, 250, 100, 100);
		userbat.setBounds(170,450,100,100);
		
		centerTlabel.setFont(new Font("���� ���", Font.BOLD, 20));// ����
		centerTlabel.setForeground(Color.white);// ����

		centerlabel.setAlignmentX(Component.CENTER_ALIGNMENT);// ����
		centerTlabel.setAlignmentX(Component.CENTER_ALIGNMENT);// ����
		centerpnl.setBackground(mycolor);
		// �г� ����(��,��,��,��)
		centerpnl.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

		tazzapnl.setOpaque(false); // �г� ����ȭ
		tazzapnl.add(Westpnl, "West");
		tazzapnl.add(Eastpnl, "East");
		tazzapnl.add(Southpnl, "South");
		tazzapnl.add(centerpnl, "Center");
		tazzapnl.add(btnpnl, "North");

		this.add(tazzapnl);
		this.setVisible(true);

	}

	// ���� ��ư ������ ���� ���� + ��ǻ�� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int om;// �� ���� ����
		int om2;// ���ΰ��� 2
		// �� ����
	/*	if(live[0]==1){
		if(e.getSource()==btn[0])//122
			userbat.setIcon(new ImageIcon("image/halfbat.png"));//122
		if(e.getSource()==btn[1])//122
			userbat.setIcon(new ImageIcon("image/callbat.png"));//122
		if(e.getSource()==btn[2])//122
			userbat.setIcon(new ImageIcon("image/ddadangbat.png"));//122
		if(e.getSource()==btn[3])//122
			userbat.setIcon(new ImageIcon("image/bbingbat.png"));//122		
		if(e.getSource()==btn[4])//122
			userbat.setIcon(new ImageIcon("image/checkbat.png"));//122				
		if(e.getSource()==btn[5])//122
			userbat.setIcon(new ImageIcon("image/diebat.png"));//122
		}*/ // ���ü��� 
		
		while (live[0] == 1) {
			betcount--; // ����������
			if (boss != 0 )// ���ڰ� ���϶��� ����
				break;
			if (PlayerMoney[0] == 0) {
				isall[0] = true;
				appendToPane(TF1, "�����̹Ƿ� �ѱ�" + "\n", Color.black);
			} else {
				if (e.getSource() == btn[0] && bettime !=3) { // ���� //���ü���
					new BettingThread(); // �����ϴ� ������ Ŭ����
					bet = Money / 2;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "����" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}
					appendToPane(TF1, "���� ����" + "\n", Color.black);			
					userbat.setIcon(new ImageIcon("image/halfbat.png"));
				} else if (e.getSource() == btn[1] && bettime !=3) { // ��
					new BettingThread(); // �����ϴ� ������ Ŭ����
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;

					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "����" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "�� ����" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/callbat.png"));
				} else if (e.getSource() == btn[2] && bettime !=3) { // ����
					new BettingThread(); // �����ϴ� ������ Ŭ����
					bet += bet;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "����" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "���� ����" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/ddadangbat.png"));
				} else if (e.getSource() == btn[3] && bettime !=3) { // ��
					new BettingThread(); // �����ϴ� ������ Ŭ����
					bet = base;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "����" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "�� ����" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/bbingbat.png"));
				} else if (e.getSource() == btn[4] && bettime !=3) { // üũ

					if (boss != 0) { // üũ�� ����
						if (bettime <= 2) {
							appendToPane(TF1, "���϶��� üũ�� �� �� �ֽ��ϴ�." + "\n",
									Color.black);
							bet = 0;
							Money += bet;
						}
					}

					appendToPane(TF1, "üũ ����" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/checkbat.png"));
				} else if (e.getSource() == btn[5] && bettime !=3) { // ����
					cardslabel[0].setIcon(new ImageIcon(back));
					cardslabel[1].setIcon(new ImageIcon(back));
					scorelabel[0].setText("����");
					scorelabel[0].setBackground(Color.black);
					scorelabel[0].setOpaque(true);
					scorelabel[0].setForeground(Color.white);
					scorelabel[0].setFont(new Font("���� ���", Font.BOLD, 25));
					scorelabel[0].setHorizontalAlignment(JLabel.CENTER);

					live[0] = 0;
					scoreArray[0] = -5; // �׾����� ���� 0 ������ ����

					appendToPane(TF1, "���� ����" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/diebat.png"));
				}
			}
			break;
		}
		while (true) {
			if (bettime <= 2) { // ����Ƚ���� 3ȸ �̸��϶� ��ǻ�� ���ýǽ�
				playT1 = new PlayThread();
				
				if (e.getSource() == btn[4] && boss != 0) {// üũ �������� ó��
					appendToPane(TF1, "���϶��� üũ�� �� �� �ֽ��ϴ�." + "\n", Color.black);
					betcount++;
					break;
				} else {
					playT1.start(); //
					
					class BetThread extends Thread{
						public void run(){
								try {
									playT1.join();
								} catch (InterruptedException e) {
								}
								
								if(boss == 0){
					appendToPane(TF1, "BetThread1 -",
										Color.black);
					appendToPane(TF1, bettime + "ȸ�� ���� ����" + "\n",
							Color.black);
					Thread bc = new BatClear(); //���ü���
						bc.start();
					countlb.setText("            " + betcount + "ȸ"); // ����������
					appendToPane(TF1,
							"------------------------------------------------------------------"
									+ "\n", Color.black);
					resultT = new ResultThread();
					resultT.start();
								}
								}
					}
					BetT1 = new BetThread();
					BetT1.start();
					if(boss!=0)
						BetT1.interrupt();
				}
				while (live[0] == 1) {
					if (boss == 0)//���ڰ� ���� �ƴҶ� ����
						break;
					if (PlayerMoney[0] == 0) {

						appendToPane(TF1, "�����̹Ƿ� �ѱ�" + "\n", Color.black);
						isall[0] = true;
					} else {
						if (e.getSource() == btn[0]) { // ����
							new BettingThread(); // �����ϴ� ������ Ŭ����
							bet = Money / 2;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "����" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "���� ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/halfbat.png"));
						} else if (e.getSource() == btn[1]) { // ��
							new BettingThread(); // �����ϴ� ������ Ŭ����
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;

							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "����" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "�� ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/callbat.png"));
						} else if (e.getSource() == btn[2]) { // ����
							new BettingThread(); // �����ϴ� ������ Ŭ����
							bet += bet;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "����" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "���� ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/ddadangbat.png"));
						} else if (e.getSource() == btn[3]) { // ��
							new BettingThread(); // �����ϴ� ������ Ŭ����
							bet = base;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "����" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "�� ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/bbingbat.png"));
						} else if (e.getSource() == btn[4]) { // üũ

							if (boss != 0) { // üũ�� ����
								if (bettime <= 2) {
									appendToPane(TF1, "���϶��� üũ�� �� �� �ֽ��ϴ�."
											+ "\n", Color.black);
									bet = 0;
									Money += bet;
								}
							}

							appendToPane(TF1, "üũ ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/checkbat.png"));
						} else if (e.getSource() == btn[5]) { // ����
							cardslabel[0].setIcon(new ImageIcon(back));
							cardslabel[1].setIcon(new ImageIcon(back));
							scorelabel[0].setText("����");
							scorelabel[0].setBackground(Color.black);
							scorelabel[0].setOpaque(true);
							scorelabel[0].setForeground(Color.white);
							scorelabel[0].setFont(new Font("���� ���", Font.BOLD,
									25));
							scorelabel[0].setHorizontalAlignment(JLabel.CENTER);

							live[0] = 0;
							scoreArray[0] = -5; // �׾����� ���� 0 ������ ����

							appendToPane(TF1, "���� ����" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/diebat.png"));
						}
					}
					break;
				}
				playT2 = new PlayThread2();
				if (bettime <= 2) { // ����Ƚ���� 3ȸ �̸��϶� ��ǻ�� ���ýǽ�
					playT2.start();

				}
				class BetThread2 extends Thread{
					public void run(){
							try {
								playT2.join();
							} catch (InterruptedException e) {
							}
							if(boss!=0){
				appendToPane(TF1, "BetThread2 -",
									Color.black);
						
				appendToPane(TF1, bettime + "ȸ�� ���� ����" + "\n",
						Color.black);
				Thread bc2 = new BatClear(); //���ü���
					bc2.start();
				
				countlb.setText("            " + betcount + "ȸ"); // ����������
				appendToPane(TF1,
						"------------------------------------------------------------------"
								+ "\n", Color.black);
				resultT = new ResultThread();
				resultT.start();
						}
						}
				}
				BetT2 = new BetThread2();
				BetT2.start();
			} else {
				if (wp == -1) { // ����
					appendToPane(TF1, "������ �����ϰ� �����ø� ���۹�ư�� ��������." + "\n",
							Color.black);
					live[0] = 0;
					if (e.getSource() == btn[1]) {
						PlayerMoney[0] += bet;
					} else if (e.getSource() == btn[2]) {
						PlayerMoney[0] += bet;
					} else if (e.getSource() == btn[3]) {
						PlayerMoney[0] += bet;
					}
					;
					Money = 0;// ����

				} else
					// ����
					appendToPane(TF1, "������ ����Ǿ����ϴ�. ���۹�ư�� ��������." + "\n",
							Color.black);
			}
			bettime++;
			
			
			break;
		}
	}

	private void appendToPane(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
				StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily,
				"Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment,
				StyleConstants.ALIGN_JUSTIFIED);

		int len = tp.getDocument().getLength();
		tp.setCaretPosition(len);
		tp.setCharacterAttributes(aset, false);
		tp.replaceSelection(msg);
	}

	class PlayThread extends Thread{
		@Override
		public void run(){
			try {
				startT.join();
			} catch (InterruptedException e1) {
			}
			for (int i = 1; i < 5; i++) {// ��ǻ�Ͱ� �� ��������� ó��
				if(isall[1]==true){
					player1bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[2]==true){
					player2bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[3]==true){
					player3bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[4]==true){
					player4bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				
				if(live[i]==1){
					Thread bF = new BtnFalse();//��ư��Ȱ��ȭ1
					 bF.start();
					
					try {
						
						sleep(1000);
					} catch (InterruptedException e) {
						interrupt();
					}
					}
				
				if (i == boss && bettime==0)// ù����ó��
											break;
				if(i<boss)
					continue;

				if(boss!=0 && bettime == 0)
					break;
				
			if (live[i] == 0)
				continue;
			if(bettime==3 & boss != 0)
				break;
			appendToPane(TF1,"����", Color.black);
			
			
			
			if (scoreArray[i] == 0) { // ��ǻ�� ���� �����̸� ������ ����
				if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
					bettime=2;
					continue;
				}
				cardslabel[i*2].setIcon(new ImageIcon(back));
				cardslabel[i*2+1].setIcon(new ImageIcon(back));
				scorelabel[i].setText("����");
				scorelabel[i].setBackground(Color.black);
				scorelabel[i].setOpaque(true);
				scorelabel[i].setForeground(Color.white);
				scorelabel[i].setFont(new Font("���� ���",Font.BOLD,25));
				scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
				live[i] = 0;
				if(i==1)
				appendToPane(TF1,"�÷��̾�"+i,Color.green);
				if(i==2)
					appendToPane(TF1,"�÷��̾�"+i,Color.orange);
				if(i==3)
					appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
				if(i==4)
					appendToPane(TF1,"�÷��̾�"+i,Color.blue);
				appendToPane(TF1,"�� ����"+"\n",Color.black);
				if(i==1){
					player1bat.setIcon(new ImageIcon("image/diebat.png"));
				}
				else if(i==2){
					player2bat.setIcon(new ImageIcon("image/diebat.png"));
				}
				else if(i==3){
					player3bat.setIcon(new ImageIcon("image/diebat.png"));
				}
				else if(i==4){
					player4bat.setIcon(new ImageIcon("image/diebat.png"));
				}
				continue;
			} else if (scoreArray[i] != 0) {
				betscore = scoreArray[i];
				if (scoreArray[i] == -1)// �۱���
					betscore = 8;
				if (scoreArray[i] == -2)// ����
					betscore = 8;
				if (scoreArray[i] == -3)// ������
					betscore = 8;
				if (scoreArray[i] == -4)// ������
					betscore = 8;
				int cb = ran.nextInt(betscore + 1); // 0~25����
				int prem; // ���ν� ���� ������
				int prem2; // ���ν� ���� ������ 2
				if (cb == 0) {// ����
					if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
						bettime=2;
						continue;
					}
					cardslabel[i*2].setIcon(new ImageIcon(back));
					cardslabel[i*2+1].setIcon(new ImageIcon(back));
					scorelabel[i].setText("����");
					scorelabel[i].setBackground(Color.black);
					scorelabel[i].setOpaque(true);
					scorelabel[i].setForeground(Color.white);
					scorelabel[i].setFont(new Font("���� ���",Font.BOLD,25));
					scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
					live[i] = 0;
					scoreArray[i] = -5;
					if(i==1)
						appendToPane(TF1,"�÷��̾�"+i,Color.green);
						if(i==2)
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);
						if(i==3)
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
						if(i==4)
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);
					appendToPane(TF1,"�� ����"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					continue;
				}
				int rr1 = ran.nextInt(cb);
				if (rr1 == 0) { // üũ
					if (i == boss) { // ���� üũ ����
						bet = 0;
						Money += bet;
						if(i==1)
							appendToPane(TF1,"�÷��̾�"+i,Color.green);
							if(i==2)
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);
							if(i==3)
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
							if(i==4)
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);
						appendToPane(TF1,"�� üũ"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/checkbat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/checkbat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/checkbat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/checkbat.png"));
						}
						continue;
					}
				}
				int rr2 = ran.nextInt(rr1 + 1);
				if (rr2 == 0) { // ��
					
					prem = PlayerMoney[i];// ���� ��� ����
					PlayerMoney[i] -= bet; 
					
					prem2 = Money;
					Money += bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����								
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����!"+"\n",Color.black);
						bet = prem; // ���ν� ���� ���ñݾ����� ó��
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						
						continue;
					}
					if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
						appendToPane(TF1,"�÷��̾�"+i,Color.green);}
						if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
						if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
					appendToPane(TF1,"�� ��"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/callbat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/callbat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/callbat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/callbat.png"));
					}
					continue;
				}
				int rr3 = ran.nextInt(rr2);
				if (rr3 == 0) { // ����

					bet = Money / 2;

					prem = PlayerMoney[i];
					PlayerMoney[i] -= bet;
					prem2 = Money;
					Money += bet;

					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����!"+"\n",Color.black);
						bet = prem; // ���ν� ���� ���ñݾ����� ó��
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
						appendToPane(TF1,"�÷��̾�"+i,Color.green);}
						if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
						if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
					appendToPane(TF1,"�� ����"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/halfbat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/halfbat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/halfbat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/halfbat.png"));
					}
					continue;
				}
				int rr4 = ran.nextInt(rr3);
				if (rr4 == 0) { // ��
					bet = base;

					prem = PlayerMoney[i];// ���� ��� ����
					PlayerMoney[i] -= bet;
					prem2 = Money;
					Money += bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����!"+"\n",Color.black);
						bet = prem; // ���ν� ���� ���ñݾ����� ó��
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
						appendToPane(TF1,"�÷��̾�"+i,Color.green);}
						if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
						if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
					appendToPane(TF1,"�� ��"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/bbingbat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/bbingbat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/bbingbat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/bbingbat.png"));
					}
					continue;
				} else { // ����

					bet += bet;
					prem2 = Money;
					Money += bet;
					prem = PlayerMoney[i];// ���� ��� ����
					PlayerMoney[i] -= bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����!"+"\n",Color.black);
						bet = prem; // ���ν� ���� ���ñݾ����� ó��
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
						appendToPane(TF1,"�÷��̾�"+i,Color.green);}
						if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
						if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
					appendToPane(TF1,"�� ����"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/ddadangbat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/ddadangbat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/ddadangbat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/ddadangbat.png"));
					}
					continue;

				}
			}
			
		}
			Thread bT = new BtnTrue(); //��ưȰ��ȭ1
			bT.start();
		}
	}
	
	class PlayThread2 extends Thread{
		@Override
		public void run(){

			try {
				startT.join();
			} catch (InterruptedException e1) {
			}
			for (int i = 1; i < boss; i++) {// ��ǻ�Ͱ� �� ��������� ó��
				
				if(isall[1]==true){
					player1bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[2]==true){
					player2bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[3]==true){
					player3bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				if(isall[4]==true){
					player4bat.setIcon(new ImageIcon("image/allinbat.png"));
				}
				
				if(live[i]==1){
					Thread bF2 = new BtnFalse();
					bF2.start();  //��ư��Ȱ��ȭ2
				try {
					
					sleep(1000);
					
				} catch (InterruptedException e) {
					interrupt();
				}
				}
				
				if (live[i] == 0)
					continue;
				appendToPane(TF1,"����2", Color.black);
				if (scoreArray[i] == 0) { // ��ǻ�� ���� �����̸� ������ ����
					if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
						bettime=2;
						continue;
					}
					cardslabel[i*2].setIcon(new ImageIcon(back));
					cardslabel[i*2+1].setIcon(new ImageIcon(back));
					scorelabel[i].setText("����");
					scorelabel[i].setBackground(Color.black);
					scorelabel[i].setOpaque(true);
					scorelabel[i].setForeground(Color.white);
					scorelabel[i].setFont(new Font("���� ���",Font.BOLD,25));
					scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
					
					live[i] = 0;
					if(i==1)
						appendToPane(TF1,"�÷��̾�"+i,Color.green);
						if(i==2)
							appendToPane(TF1,"�÷��̾�"+i,Color.orange);
						if(i==3)
							appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
						if(i==4)
							appendToPane(TF1,"�÷��̾�"+i,Color.blue);
					appendToPane(TF1,"�� ����"+"\n",Color.black);
					if(i==1){
						player1bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==2){
						player2bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==3){
						player3bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					else if(i==4){
						player4bat.setIcon(new ImageIcon("image/diebat.png"));
					}
					
					continue;
				} else if (scoreArray[i] != 0) {
					betscore = scoreArray[i];
					if (scoreArray[i] == -1)// �۱���
						betscore = 8;
					if (scoreArray[i] == -2)// ����
						betscore = 8;
					if (scoreArray[i] == -3)// ������
						betscore = 8;
					if (scoreArray[i] == -4)// ������
						betscore = 8;
					int cb = ran.nextInt(betscore + 1); // 0~25����
					int prem; // ���ν� ���� ������
					int prem2; // ���ν� ���� ������ 2
					if (cb == 0) {// ����
						cardslabel[i*2].setIcon(new ImageIcon(back));
						cardslabel[i*2+1].setIcon(new ImageIcon(back));
						scorelabel[i].setText("����");
						scorelabel[i].setBackground(Color.black);
						scorelabel[i].setOpaque(true);
						scorelabel[i].setForeground(Color.white);
						scorelabel[i].setFont(new Font("���� ���",Font.BOLD,25));
						scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
						
						live[i] = 0;
						scoreArray[i] = -5;
						if(i==1)
							appendToPane(TF1,"�÷��̾�"+i,Color.green);
							if(i==2)
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);
							if(i==3)
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
							if(i==4)
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);
						appendToPane(TF1,"�� ����"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						continue;
					}
					int rr1 = ran.nextInt(cb);
					if (rr1 == 0) { // üũ
						if (i == boss) { // ���� üũ ����
							bet = 0;
							Money += bet;
							if(i==1)
								appendToPane(TF1,"�÷��̾�"+i,Color.green);
								if(i==2)
									appendToPane(TF1,"�÷��̾�"+i,Color.orange);
								if(i==3)
									appendToPane(TF1,"�÷��̾�"+i,Color.cyan);
								if(i==4)
									appendToPane(TF1,"�÷��̾�"+i,Color.blue);
							appendToPane(TF1,"�� üũ"+"\n",Color.black);
							
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/checkbat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/checkbat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/checkbat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/checkbat.png"));
							}
							continue;
						
							
						}
					}
					int rr2 = ran.nextInt(rr1 + 1);
					if (rr2 == 0) { // ��
						
						prem = PlayerMoney[i];// ���� ��� ����
						PlayerMoney[i] -= bet; 
						
						prem2 = Money;
						Money += bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.green);}
								if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
								if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
							appendToPane(TF1,"�� ����!"+"\n",Color.black);
							bet = prem; // ���ν� ���� ���ñݾ����� ó��
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ��"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/callbat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/callbat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/callbat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/callbat.png"));
						}
						continue;
					}
					int rr3 = ran.nextInt(rr2);
					if (rr3 == 0) { // ����

						bet = Money / 2;

						prem = PlayerMoney[i];
						PlayerMoney[i] -= bet;
						prem2 = Money;
						Money += bet;

						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.green);}
								if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
								if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
							appendToPane(TF1,"�� ����!"+"\n",Color.black);
							bet = prem; // ���ν� ���� ���ñݾ����� ó��
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/halfbat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/halfbat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/halfbat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/halfbat.png"));
						}
						continue;
					}
					int rr4 = ran.nextInt(rr3);
					if (rr4 == 0) { // ��
						bet = base;

						prem = PlayerMoney[i];// ���� ��� ����
						PlayerMoney[i] -= bet;
						prem2 = Money;
						Money += bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.green);}
								if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
								if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
							appendToPane(TF1,"�� ����!",Color.black);
							bet = prem; // ���ν� ���� ���ñݾ����� ó��
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ��"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/bbingbat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/bbingbat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/bbingbat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/bbingbat.png"));
						}
						continue;
					} else { // ����

						bet += bet;
						prem2 = Money;
						Money += bet;
						prem = PlayerMoney[i];// ���� ��� ����
						PlayerMoney[i] -= bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.green);}
								if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
								if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
									appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
							appendToPane(TF1,"�� ����!"+"\n",Color.black);
							bet = prem; // ���ν� ���� ���ñݾ����� ó��
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // �����ϴ� ������ Ŭ����
							appendToPane(TF1,"�÷��̾�"+i,Color.green);}
							if(i==2){new BettingThread2(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.orange);}
							if(i==3){new BettingThread3(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // �����ϴ� ������ Ŭ����
								appendToPane(TF1,"�÷��̾�"+i,Color.blue);}
						appendToPane(TF1,"�� ����"+"\n",Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/ddadangbat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/ddadangbat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/ddadangbat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/ddadangbat.png"));
						}
						continue;

					}
				}
		}
			Thread bT2 = new BtnTrue(); //��ưȰ��ȭ2
			bT2.start();  	
	}
	}
	
	
	class StartThread extends Thread{
		public void run(){
			if(boss!=0){
			Thread bF3 = new BtnFalse();//��ư��Ȱ��ȭ3
			bF3.start();
			}
			for (int i = boss; i < 5; i++) {
			
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					interrupt();
				}
				if (boss == 0)
					break;
				if (live[i] == 1) {
					if (scoreArray[i] == 0) { // ��ǻ�� ���� �����̸� ������ ����
						if (live[0] + live[1] + live[2] + live[3]
								+ live[4] == 1) {
							bettime = 2;
							continue;
						}
						cardslabel[i * 2].setIcon(new ImageIcon(
								back));// ������ ���� ���� �κа� scorelabel
										// �κ� �� ����
						cardslabel[i * 2 + 1]
								.setIcon(new ImageIcon(back));
						scorelabel[i].setText("����");
						scorelabel[i].setBackground(Color.black);
						scorelabel[i].setOpaque(true);
						scorelabel[i].setForeground(Color.white);
						scorelabel[i].setFont(new Font("���� ���",
								Font.BOLD, 25));
						scorelabel[i]
								.setHorizontalAlignment(JLabel.CENTER);

						live[i] = 0;
						appendToPane(TF1, "�÷��̾�" + i + "�� ����"
								+ "\n", Color.black);
						if(i==1){
							player1bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==2){
							player2bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==3){
							player3bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						else if(i==4){
							player4bat.setIcon(new ImageIcon("image/diebat.png"));
						}
						continue;
					} else if (scoreArray[i] != 0) {
						betscore = scoreArray[i];
						if (scoreArray[i] == -1)// �۱���
							betscore = 8;
						if (scoreArray[i] == -2)// ����
							betscore = 8;
						if (scoreArray[i] == -3)// ������
							betscore = 8;
						if (scoreArray[i] == -4)// ������
							betscore = 8;
						int cb = ran.nextInt(betscore + 1);
						if (cb == 0) {// ����
							if (live[0] + live[1] + live[2]
									+ live[3] + live[4] == 1) {
								bettime = 2;
								continue;
							}
							if (scoreArray[i] == 28) {
								cb = 27;
								continue;
							}
							if (scoreArray[i] == 27) {
								cb = 26;
								continue;
							}
							if (scoreArray[i] == 26) {
								cb = 25;
								continue;
							}
							cardslabel[i * 2]
									.setIcon(new ImageIcon(back));
							cardslabel[i * 2 + 1]
									.setIcon(new ImageIcon(back));
							scorelabel[i].setText("����");
							scorelabel[i]
									.setBackground(Color.black);
							scorelabel[i].setOpaque(true);
							scorelabel[i]
									.setForeground(Color.white);
							scorelabel[i].setFont(new Font("���� ���",
									Font.BOLD, 25));
							scorelabel[i]
									.setHorizontalAlignment(JLabel.CENTER);
							live[i] = 0;
							scoreArray[i] = -5;
							appendToPane(TF1, "�÷��̾�" + i + "�� ����"
									+ "\n", Color.black);
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/diebat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/diebat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/diebat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/diebat.png"));
							}
							continue;
						}
						int rr1 = ran.nextInt(cb);
						if (rr1 == 0) { // üũ
							if (i == boss) { // ���� üũ ����
								bet = 0;
								Money += bet;
								appendToPane(TF1, "�÷��̾�" + i
										+ "�� üũ" + "\n",
										Color.black);
								if(i==1){
									player1bat.setIcon(new ImageIcon("image/checkbat.png"));
								}
								else if(i==2){
									player2bat.setIcon(new ImageIcon("image/checkbat.png"));
								}
								else if(i==3){
									player3bat.setIcon(new ImageIcon("image/checkbat.png"));
								}
								else if(i==4){
									player4bat.setIcon(new ImageIcon("image/checkbat.png"));
								}
								continue;
							}
						}
						int rr2 = ran.nextInt(rr1 + 1);
						if (rr2 == 0) { // ��

							Money += bet;

							PlayerMoney[i] -= bet;
							appendToPane(TF1, "�÷��̾�" + i + "�� ��"
									+ "\n", Color.black);
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/callbat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/callbat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/callbat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/callbat.png"));
							}
							continue;
						}
						int rr3 = ran.nextInt(rr2);
						if (rr3 == 0) { // ����

							bet = Money / 2;
							Money += bet;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "�÷��̾�" + i + "�� ����"
									+ "\n", Color.black);
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/halfbat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/halfbat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/halfbat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/halfbat.png"));
							}
							continue;
						}
						int rr4 = ran.nextInt(rr3);
						if (rr4 == 0) { // ��
							bet = base;
							Money += bet;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "�÷��̾�" + i + "�� ��"
									+ "\n", Color.black);
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/bbingbat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/bbingbat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/bbingbat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/bbingbat.png"));
							}
							continue;
						} else { // ����

							bet += bet;
							Money += bet * 2;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "�÷��̾�" + i + "�� ����"
									+ "\n", Color.black);
							if(i==1){
								player1bat.setIcon(new ImageIcon("image/ddadangbat.png"));
							}
							else if(i==2){
								player2bat.setIcon(new ImageIcon("image/ddadangbat.png"));
							}
							else if(i==3){
								player3bat.setIcon(new ImageIcon("image/ddadangbat.png"));
							}
							else if(i==4){
								player4bat.setIcon(new ImageIcon("image/ddadangbat.png"));
							}
							continue;

						}
					}
				}
			}
			Thread bT3 = new BtnTrue();//��ưȰ��ȭ3
			bT3.start();
		}
		
	}
	class CardThread extends Thread{
		public void run(){
			
		}
		
	}
	class ResultThread extends Thread{
		public void run(){
			try {
				playT1.join();
				playT2.join();
			} catch (InterruptedException e1) {
			}
			Thread bF4 = new BtnFalse();//��ư��Ȱ��ȭ1
			 bF4.start();
				
	if (bettime >= 3) {// ���� Ƚ���� 3�̸� ����.
		try {
			sleep(1000);
			Thread fe = new Free();
			fe.start();
		} catch (InterruptedException e) {
		}
		wp = 0;// �� ���ڼ���
		int max = -6; // �̱����� ����

		for (int i = 0; i < 5; i++) {
			if (scoreArray[i] == -2) {// ���� ó��
				if (max < 16)
					wp = 7;
			} else if (scoreArray[i] < 16) { // �տ��� ���簡 ���Դ��� ã�ƺ�
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -2)
						wp = 7;

				}

			}
			if (scoreArray[i] == -1 && max < 26) { // ���ֱ������� ó��
				wp = 8;
			} else if (scoreArray[i] < 26) { // �տ��� �۱��簡 ���Դ��� ã�ƺ�
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -1)
						wp = 8;

				}

			}
			if (scoreArray[i] == -3) { // ������
				if (max > 24) {
					scoreArray[i] = 0;
				} else if (max < 16) {
					if (max == 0) {
						scoreArray[i] = 0;
						for (int m = i; m > -1; m--) {
							if (scoreArray[m] == scoreArray[i])
								aw[m] = 1;
						}
					}
				} else if (max > 15 && max < 25) {
					wp = i;
					scoreArray[i] = 25;
				}

			} else if (scoreArray[i] > 15 && scoreArray[i] < 25) {// n���϶�
																	// �ջ��
																	// �и�
																	// Ȯ��
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -3) {
						wp = i;
						scoreArray[i] = 25;
					}
				}
			}

			if (scoreArray[i] == -4) { // ������ ó��
				if (max == 27) {
					scoreArray[i] = 28;
					wp = i;
				}
			} else if (scoreArray[i] == -4 && max == 0) {// ������ 1�����
															// ���Ҷ�
															// �̱�� ���
				wp = i;
				max = 1;
			} else if (scoreArray[i] == -4 && max == 1) {// ������ 1�����
															// ���Ҷ�
															// ���� ���
				aw[i] = 1;
			} else if (scoreArray[i] == 27) { // �����϶� ������ �ִ��� üũ
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -4) {
						wp = m;
						scoreArray[m] = 28;
					}
				}
			}

			if (max < scoreArray[i]) {
				max = scoreArray[i];
				wp = i;
				for (int l = i; l > -1; l--)
					aw[l] = 0;

			} else if (max == scoreArray[i]) {// ���� �������
				for (int m = i; m > -1; m--) { // ���� ���� ���ΰ� ���� ���� �и� ã�Ƴ�
					if (scoreArray[m] == scoreArray[i])
						aw[m] = 1;
					else if (scoreArray[m] != scoreArray[i])
						aw[m] = 0;
				}

			}

			if ((aw[0] + aw[1] + aw[2] + aw[3] + aw[4]) != 0) {
				// ���� ���� �߻����� ����ó��
				wp = 6;

			}

		}

		
		appendToPane(TF1, "��: " + player[0] + ", �÷��̾� 1:" + player[1]
				+ ", �÷��̾� 2:" + player[2] + ", �÷��̾� 3:" + player[3]
				+ ", �÷��̾� 4:" + player[4] + "\n", Color.black);

		player1money.setText("<html>��ǻ�� ��ī����1<br/>���� �ݾ���" + PM[1]);// zxcv
		player2money.setText("<html>��ǻ�� ��ī����2<br/>���� �ݾ���" + PM[2]);
		player3money.setText("<html>��ǻ�� ��ī����3<br/>���� �ݾ���" + PM[3]);
		player4money.setText("<html>��ǻ�� ��ī����4<br/>���� �ݾ���" + PM[4]);
		usermoney.setText("���� �ݾ���" + PM[0]);

		backlabel1.setIcon(new ImageIcon(picture[savecard[3]]));
		backlabel2.setIcon(new ImageIcon(picture[savecard[5]]));
		backlabel3.setIcon(new ImageIcon(picture[savecard[7]]));
		backlabel4.setIcon(new ImageIcon(picture[savecard[9]]));
		cardslabel[2].setIcon((new ImageIcon(picture[savecard[2]])));
		cardslabel[4].setIcon((new ImageIcon(picture[savecard[4]])));
		cardslabel[6].setIcon((new ImageIcon(picture[savecard[6]])));
		cardslabel[8].setIcon((new ImageIcon(picture[savecard[8]])));
		// /////////////////

		scorelabel[0].setText(player[0]);
		scorelabel[1].setText(player[1]);
		scorelabel[2].setText(player[2]);
		scorelabel[3].setText(player[3]);
		scorelabel[4].setText(player[4]);// ����

		for (int i = 0; i < scorelabel.length; i++) {// ����
			scorelabel[i].setBackground(Color.black);
			scorelabel[i].setOpaque(true);
			scorelabel[i].setForeground(Color.white);
			scorelabel[i].setFont(new Font("���� ���", Font.BOLD, 25));
			scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
		}
		
		if (wp == 0) {
			try {
				appendToPane(TF1, "���ڴ�...",Color.black);
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "��! " + "\n", Color.black);
			winplayer[4].setIcon((new ImageIcon("image/win.jpg"))); // �¸���
																	// �÷��̾�
																	// �̹���
			PlayerMoney[0] += Money;
			Money = 0;

			boss = wp;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp < 6) {
			try {
				appendToPane(TF1, "���ڴ�...",Color.black);
				sleep(1000);
			} catch (InterruptedException e) {
			}
			if (wp == 1) {
				appendToPane(TF1, "�÷��̾�" + wp + "\n", Color.green);
				winplayer[0].setIcon((new ImageIcon("image/win.jpg"))); // �¸���
																		// �÷��̾�
																		// �̹���
			}
			if (wp == 2) {
				appendToPane(TF1, "�÷��̾�" + wp + "\n", Color.orange);
				winplayer[1].setIcon((new ImageIcon("image/win.jpg"))); // �¸���
																		// �÷��̾�
																		// �̹���
			}
			if (wp == 3) {
				appendToPane(TF1, "�÷��̾�" + wp + "\n", Color.cyan);
				winplayer[2].setIcon((new ImageIcon("image/win.jpg"))); // �¸���
																		// �÷��̾�
																		// �̹���
			}
			if (wp == 4) {
				appendToPane(TF1, "�÷��̾�" + wp + "\n", Color.blue);
				winplayer[3].setIcon((new ImageIcon("image/win.jpg"))); // �¸���
																		// �÷��̾�
																		// �̹���
			}
			PlayerMoney[wp] += Money;
			Money = 0;

			boss = wp;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp == 6) { // ���� �Ȱɰ� ����
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "����" + "\n", Color.black);

			appendToPane(TF1, "������ �ǵ�: " + Money + "��" + "\n",
					Color.black);
			savedmoney = Money;
			Money = 0;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp == 7) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "����� ���� ����" + "\n", Color.black);

			appendToPane(TF1, "������ �ǵ�: " + Money + "��" + "\n",
					Color.black);
			savedmoney = Money;
			Money = 0;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp == 8) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "���ֱ��� ����� ���� ����" + "\n", Color.black);
			appendToPane(TF1, "������ �ǵ�: " + Money + "��" + "\n",
					Color.black);
			savedmoney = Money;
			Money = 0;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		}

		for (int i = 0; i < 5; i++) {
			if (PlayerMoney[i] == 0 && isall[i]) {
				live[i] = 1;
			}
		}

		if (live[0] == 0) {
			cardslabel[0].setIcon((new ImageIcon(back)));
			cardslabel[1].setIcon((new ImageIcon(back)));
			scorelabel[0].setText(null);
			scorelabel[0].setOpaque(false);
		}

		if (live[1] == 0) {
			cardslabel[2].setIcon((new ImageIcon(back)));
			backlabel1.setIcon(new ImageIcon(back));
			scorelabel[1].setText(null);
			scorelabel[1].setOpaque(false);
		}
		if (live[2] == 0) {

			cardslabel[4].setIcon((new ImageIcon(back)));
			backlabel2.setIcon(new ImageIcon(back));
			scorelabel[2].setText(null);
			scorelabel[2].setOpaque(false);
		}
		if (live[3] == 0) {

			cardslabel[6].setIcon((new ImageIcon(back)));
			backlabel3.setIcon(new ImageIcon(back));
			scorelabel[3].setText(null);
			scorelabel[3].setOpaque(false);
		}

		if (live[4] == 0) {

			cardslabel[8].setIcon((new ImageIcon(back)));
			backlabel4.setIcon(new ImageIcon(back));
			scorelabel[4].setText(null);
			scorelabel[4].setOpaque(false);

		}
	
	
	}
	for (int i = 0; i < 5; i++) { // ����
		if (PlayerMoney[i] % 10000 == 0)// ����
			PM[i] = PlayerMoney[i] / 10000 + "����"; // ����
		else
			// ����
			PM[i] = PlayerMoney[i] / 10000 + "��"
					+ (PlayerMoney[i] % 10000) / 1000 + "õ��"; // ����

	}
	player1money.setText("<html>��ǻ�� ��ī����1<br/>���� �ݾ���<html>" + PM[1]);// ����
	player2money.setText("<html>��ǻ�� ��ī����2<br/>���� �ݾ���<html>" + PM[2]);// ����
	player3money.setText("<html>��ǻ�� ��ī����3<br/>���� �ݾ���<html>" + PM[3]);// ����
	player4money.setText("<html>��ǻ�� ��ī����4<br/>���� �ݾ���<html>" + PM[4]);// ����
	usermoney.setText("���� �ݾ���" + PM[0]);// ����

	centerTlabel.setText("���� �ǵ�: " + (Money + savedmoney)
			+ " | ���� �� �ݾ� : " + bet);// ����
	centerlabel.setIcon(new ImageIcon("image/im.gif"));// ����

	Thread bT4 = new BtnTrue(); //��ưȰ��ȭ1
	bT4.start();	
	Thread bc = new BatClear();
	bc.start();
	
	
}
		
}
	class BtnFalse extends Thread{
		@Override
		public void run(){
			for(int i=0 ; i<btn.length ; i++)
				btn[i].setEnabled(false); // ��ư��Ȱ��ȭ
			
		}
	}	

	class BtnTrue extends Thread{
		@Override
		public void run(){
			for(int i=0 ; i<btn.length ; i++)
				btn[i].setEnabled(true); // ��ưȰ��ȭ
			
		}
	}
	class Hold extends Thread{
		@Override
		public void run(){
			btn1.setEnabled(false);
			btn2.setEnabled(false);
			btn3.setEnabled(false);
		}
	}
	class Free extends Thread{
		@Override
		public void run(){
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
		}
	}
	class BatClear extends Thread{ //���ü���
		@Override
		public void run(){
			try {
				sleep(1000);
				userbat.setIcon(new ImageIcon(""));
				player1bat.setIcon(new ImageIcon(""));
				player2bat.setIcon(new ImageIcon(""));
				player3bat.setIcon(new ImageIcon(""));
				player4bat.setIcon(new ImageIcon(""));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
	class MonetStack extends Thread{
		@Override
		public void run(){
			
		}
	}
	public static void main(String[] args) {
		new play();

	}
	class BettingThread extends JFrame{ // ���� �÷��̾� ���� ������
		int xx1 = 250, yy1 = 600;
		JLabel Betlabel;
		
		class BetThread extends Thread{
			public void run(){		
					for(int i=0;i<70;i++){
				try{
					Thread.sleep(7);
				}catch(InterruptedException e){
					e.printStackTrace();
					break;
				}
				yy1 -= play.ran.nextInt(13);
				Betlabel.setBounds(250,yy1,85,56);
			}
		}
	}
	public BettingThread(){
			
			Betlabel = new JLabel();
			Betlabel.setIcon(new ImageIcon("image/money.Png"));
			play.centerpnl.add(Betlabel);
			Betlabel.setBounds(250,600,85,56);
			final Thread betThread = new BetThread();
			betThread.start();
			class BettingVisible extends Thread{
				public void run(){
					try{
						betThread.join();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				//	Betlabel.setVisible(false);
				}
			}		
		}
		
	}
		class BettingThread1 extends JFrame{ // 1�� �÷��̾� ���� ������
			int xx1 = 400, yy1 = 100;
			JLabel Betlabel1;
			
			class BetThread extends Thread{
				public void run(){
					
				
						for(int i=0;i<24;i++){
					try{
						Thread.sleep(15);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
					yy1 += play.ran.nextInt(13);
					xx1 -= play.ran.nextInt(13);
					Betlabel1.setBounds(xx1,yy1,85,56);					
				}			
			}
		}
		public BettingThread1(){
			
			Betlabel1 = new JLabel();
			Betlabel1.setIcon(new ImageIcon("image/money.Png"));
			play.centerpnl.add(Betlabel1);
			Betlabel1.setBounds(400,100,85,56);
			final Thread betThread = new BetThread();
			betThread.start();
			class BettingVisible1 extends Thread{
				public void run(){
					try{
						betThread.join();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				//	Betlabel1.setVisible(false);
				}
			}
			new BettingVisible1().start();
		}
	}
		class BettingThread2 extends JFrame{ // 2�� �÷��̾� ���� ������
			int xx1 = 400, yy1 = 300;
			JLabel Betlabel2;
			
			class BetThread extends Thread{
				public void run(){
							
						for(int i=0;i<20;i++){
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
					xx1 -= play.ran.nextInt(13);
					Betlabel2.setBounds(xx1,300,85,56);
					
				}
			}
		}
		public BettingThread2(){
			
			Betlabel2 = new JLabel();
			Betlabel2.setIcon(new ImageIcon("image/money.Png"));
			play.centerpnl.add(Betlabel2);
			Betlabel2.setBounds(450,600,85,56);
			final Thread betThread = new BetThread();
			betThread.start();
			class BettingVisible2 extends Thread{
				public void run(){
					try{
						betThread.join();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				//	Betlabel2.setVisible(false);
				}
			}
			new BettingVisible2().start();
			
		}
		
	}
		class BettingThread3 extends JFrame{ // 3�� �÷��̾� ���� ������
			int xx3 = 0, yy3 = 100;
			JLabel Betlabel3;
			
			class BetThread extends Thread{
				public void run(){
									
						for(int i=0;i<27;i++){
					try{
						Thread.sleep(15);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
					xx3 += play.ran.nextInt(13);
					yy3 += play.ran.nextInt(13);
					Betlabel3.setBounds(xx3,yy3,85,56);
					
					}
				
			}
		}
		public BettingThread3(){
			
			Betlabel3 = new JLabel();
			Betlabel3.setIcon(new ImageIcon("image/money.Png"));
			play.centerpnl.add(Betlabel3);
			Betlabel3.setBounds(0,100,85,56);
			final Thread betThread = new BetThread();
			betThread.start();
			class BettingVisibel2 extends Thread{
				public void run(){
				try{
					betThread.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			//	Betlabel3.setVisible(false);
			}
			}
			new BettingVisibel2().start();
		}
		
	}
		class BettingThread4 extends JFrame{ // 4�� �÷��̾� ���� ������
			int xx1 = 0, yy1 = 300;
			JLabel Betlabel4;
			
			class BetThread extends Thread{
				public void run(){
					
					
						for(int i=0;i<27;i++){
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
					xx1 += play.ran.nextInt(16);
					Betlabel4.setBounds(xx1,300,85,56);
					
					}
				
				
			}
		}
		public BettingThread4(){
			
			Betlabel4 = new JLabel();
			Betlabel4.setIcon(new ImageIcon("image/money.Png"));
			play.centerpnl.add(Betlabel4);
			Betlabel4.setBounds(250,600,85,56);
			final Thread betThread = new BetThread();
			betThread.start();
			class BettingVisible4 extends Thread{
				public void run(){
					try{
						betThread.join();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				//	Betlabel4.setVisible(false);
				}
			}
			new BettingVisible4().start();
		}
		
	}
		
	class Card extends JFrame{ // �е����� ������ Ŭ����

		 	JLabel label1;
			JLabel label2;
			JLabel label3;
			JLabel label4;
			JLabel label5;
			
			
			int x1 = 250, y1 = 300; // x��ǥ.
			int x2 = 250, y2 = 300;
			int x3 = 250, y3 = 300;
			int x4 = 250, y4 = 300;
			int x5 = 250, y5 = 300;
			
			class MyThread extends Thread{
				public void run(){
					while(true){
					for(int i = 0; i <30; i++){
						try{
							Thread.sleep(7); // sleep�� ���߿� ���ܰ� �߻��Ҽ� �ֱ⶧���� try/catch�� ��� �� �ش�.
						}catch(InterruptedException e){
							e.printStackTrace(); // ���ϰ��� ���� ���� �ڼ��� ���� ������ �����Ѵ�.
							break;
						}
						x1 -= 10;
						y1 -= 10;					
						label1.setBounds(x1,y1,100,100);
										
					}
					for(int i=0;i<30;i++){
						try{
							Thread.sleep(7);
						}catch(InterruptedException e){
							e.printStackTrace();
							break;
						}
						x2 -= 10; 
						y2 -= 10;
						label2.setBounds(x2,300,100,100);
					}
					for(int i=0;i<30;i++){
						try{
							Thread.sleep(7);
						}catch(InterruptedException e){
							e.printStackTrace();
							break;
						}
						x3 += 10; 
						y3 += 10;
						label3.setBounds(250,y3,100,100);
					}
					for(int i=0;i<30;i++){
						try{
							Thread.sleep(7);
						}catch(InterruptedException e){
							e.printStackTrace();
							break;
						}
						x4 += 10; 
						y4 -= 10;
						label4.setBounds(x4,300,100,100);
					}
					for(int i=0;i<30;i++){
						try{
							Thread.sleep(7);
						}catch(InterruptedException e){
							e.printStackTrace();
							break;
						}
						
						x5 += 10; 
						y5 -= 10;
						label5.setBounds(x5,y5,100,100);
					}
					break;
				}
					
			}
		}
			Card(){
				
				
				label1 = new JLabel();
				label1.setIcon(new ImageIcon("image/back.png"));
				label2 = new JLabel();
				label2.setIcon(new ImageIcon("image/back.png"));
				label3 = new JLabel();
				label3.setIcon(new ImageIcon("image/back.png"));
				label4 = new JLabel();
				label4.setIcon(new ImageIcon("image/back.png"));
				label5 = new JLabel();
				label5.setIcon(new ImageIcon("image/back.png"));
				
				play.centerpnl.add(label1);
				play.centerpnl.add(label2);
				play.centerpnl.add(label3);
				play.centerpnl.add(label4);
				play.centerpnl.add(label5);
				
				label1.setBounds(250,300,100,100);
				label2.setBounds(250,300,100,100); // ���������� ����
				label3.setBounds(250,300,100,100);
				label4.setBounds(250,300,100,100);
				label5.setBounds(250,300,100,100);
				final Thread tt = new MyThread();
				tt.start();
				class cardvisibleT extends Thread{
					public void run(){
						try {
							tt.join();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						label1.setVisible(false);
						label2.setVisible(false);
						label3.setVisible(false);
						label4.setVisible(false);
						label5.setVisible(false);
						
						play.backlabel1.setIcon(new ImageIcon(play.back));
						play.backlabel2.setIcon(new ImageIcon(play.back));
						play.backlabel3.setIcon(new ImageIcon(play.back));
						play.backlabel4.setIcon(new ImageIcon(play.back));
						
						for (int i = 0; i < play.cardslabel.length; i++) {
							play.cardslabel[i].setIcon(new ImageIcon(play.picture[i])); // ���̺� ���
																					// ȭ���̹��� ����
							play.cardslabel[i].setPreferredSize(new Dimension(75, 150)); // ȭ���� ������
							
						}
					}
					
				}
				new cardvisibleT().start();
			}
		}
	

}
 