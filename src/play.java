
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
	JLabel userjok;// 수정
	JPanel userpanel;// 수정
	// 채팅로그
	BufferedReader in = null;
	PrintWriter out = null;
	Writer wr;
	public int savecard[] = new int[10];
	public int wc[] = { 0, 0, 0, 0, 0 };
	int betscore;
	int wp = -1;
	public JButton btn[] = new JButton[6];
	int aw[] = { 0, 0, 0, 0, 0 }; // 복수 승자
	// 미니족보변수
	JLabel imglb3;
	static String img = "image/minijokbo2.png"; // 미니족보 이미지
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
	// 돈

	int base = chan.base; // 기본금
	int savedmoney;
	public int Money = 0; // 판돈
	int bet = chan.bet; // 배팅금액
	int bettime = 3;// 수정

	// 마지막수정
	int betcount = 3;
	JLabel countlb;
	Color colors = new Color(255, 126, 0);

	// 선
	int boss = 0;

	int live[] = { 1, 1, 1, 1, 1 };

	int myscore = 5;
	int p1score = 5;
	int p2score = 9;
	int p3score = 9;
	int p4score = 10;
	static String jokbo[] = { "망통", "4끗", "5끗", "6끗", "7끗", "8끗", "갑오", "세륙",
			"장사", "장삥", "구삥", "독사", "알리", "1땡", "2땡", "3땡", "4땡", "5땡", "6땡",
			"7땡", "8땡", "9땡", "장땡", "1·3광땡", "1·8광땡", "3·8광땡", "구사", "멍텅구리구사",
			"3·7땡잡이", "4·7 암행어사", "2끗", "3끗", "1끗" };// 33개

	String player[] = { "", "", "", "", "" }; // 플레이어의 조합
	int scoreArray[] = { myscore, p1score, p2score, p3score, p4score };// 플레이어의
																		// 카드점수
	static int PlayerMoney[] = { 1000000, 1000000, 1000000, 1000000, 1000000 };// 플레이어의
	// 재산
	String PM[] = { "", "", "", "", "" };// zxcv
	static Random ran = new Random();

	Color mycolor = new Color(95, 114, 055);
	// 패널 위치
	JPanel tazzapnl = new JPanel(new BorderLayout());
	JPanel Eastpnl = new JPanel(new GridLayout(2, 2, 3, 3));
	JPanel Westpnl = new JPanel(new GridLayout(2, 2, 3, 3));
	JPanel Southpnl = new JPanel(new BorderLayout());
	static JPanel centerpnl = new JPanel();
	// 플레이어 패널
	JPanel player1 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player2 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player3 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel player4 = new JPanel(new GridLayout(2, 1, 3, 3));
	JPanel user = new JPanel();
	// 플레이어 프로필 레이블,패널
	JLabel player1profile, player2profile, player3profile, player4profile,
			userprofile;
	JPanel player1profilepnl, player2profilepnl, player3profilepnl,
			player4profilepnl, userprofilepnl;
	
	// 플레이어 프로필 이미지 레이블
	JLabel player1label, player2label, player3label, player4label, userlabel;
	JLabel player1money, player2money, player3money, player4money;
	static JLabel usermoney;// 수정
	static JLabel username;// 수정

	JPanel player1moneypnl, player2moneypnl, player3moneypnl, player4moneypnl,
			usermoneypnl;
	// 카드뒷면 이미지 레이블,센터이미지 레이블
	static JLabel backlabel1;
	static JLabel backlabel2;
	static JLabel backlabel3;
	static JLabel backlabel4;
	JLabel centerlabel;
	JLabel centerTlabel;// 수정
	
	JLabel player1bat,player2bat,player3bat,player4bat,userbat;//122
	// 족보 설명
	JButton rule;
	ImageIcon originIcon;
	Image originImg;
	Image New_changedImg;
	ImageIcon Icon;
	// 패 오픈,클로즈 버튼
	JButton btn1, btn2, btn3;
	JPanel btnpnl, btnpnl2;
	// 카드 레이블
	static JLabel[] cardslabel = new JLabel[20];
	// 텍스트아레아 패널
	JTextPane TF1;
	JPanel TF1pnl;
	// 유저패널 , 로고 패널
	JPanel userplayer;
	JPanel logopnl;
	JLabel logolabel, logolabel2, logolabel3;
	JScrollPane JSP;
	JLabel cen;
	JLabel[] scorelabel = new JLabel[5];
	JLabel[] winplayer = new JLabel[5]; // 승리한 플레이어 이미지

	// 카드를 뒤집었는지 저장
	boolean isback = true;
	static String[] picture = { "image/1monthgwang.png", "image/1month1.png",
			"image/2month1.png", "image/2month2.png", "image/3monthgwang.png",
			"image/3month1.png", "image/4month1.png", "image/4month2.png",
			"image/5month1.png", "image/5month2.png", "image/6month1.png",
			"image/6month2.png", "image/7month1.png", "image/7month2.png",
			"image/8monthgwang.png", "image/8month1.png", "image/9month1.png",
			"image/9month2.png", "image/10month1.png", "image/10month2.png" };
	// 이미지 경로값을 String 형태로 저장
	static String back = "image/back.png"; // 카드 뒷면 이미지
	String exam = "image/ex.png";

	public play() {
		for (int i = 0; i < 5; i++) { // zxcv
			if (PlayerMoney[i] % 10000 == 0)
				PM[i] = PlayerMoney[i] / 10000 + "만원";
			else
				PM[i] = PlayerMoney[i] / 10000 + "만" + (PlayerMoney[i] % 10000)
						/ 1000 + "천원";

		}

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("섯다");
		this.setSize(1100, 1050);
		this.setLocationRelativeTo(null);
		// 채팅로그

		// 카드 패 오픈&클로즈 버튼
		btn1 = new JButton("시작");
		btn2 = new JButton("종료");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login();

			}
		});
		btn3 = new JButton("방 바꾸기");
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

		// 플레이어 프로필 레이블,패널
		player1money = new JLabel("<html>컴퓨터 아카데미1<br/>현재 금액은<html>" + PM[1]);
		player1money.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		player1money.setForeground(Color.white);
		player1money.setHorizontalAlignment(JLabel.CENTER);

		player2money = new JLabel("<html>컴퓨터 아카데미2<br/>현재 금액은<html>" + PM[2]);
		player2money.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		player2money.setForeground(Color.white);
		player2money.setHorizontalAlignment(JLabel.CENTER);

		player3money = new JLabel("<html>컴퓨터 아카데미3<br/>현재 금액은<html>" + PM[3]);
		player3money.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		player3money.setForeground(Color.white);
		player3money.setHorizontalAlignment(JLabel.CENTER);

		player4money = new JLabel("<html>컴퓨터 아카데미4<br/>현재 금액은<html>" + PM[4]);
		player4money.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		player4money.setForeground(Color.white);
		player4money.setHorizontalAlignment(JLabel.CENTER);

		username = new JLabel(login.TF0.getText());// 수정
		userjok = new JLabel("현재 패 :    ");// 수정
		usermoney = new JLabel("현재 금액은" + PM[0]);// 수정

		userpanel = new JPanel();// 수정
		userpanel.setLayout(new BoxLayout(userpanel, BoxLayout.Y_AXIS));// 수정
		userpanel.add(username);// 수정
		userpanel.add(userjok);// 수정
		userpanel.add(usermoney);// 수정

		username.setFont(new Font("맑은 고딕", Font.BOLD, 20));// 수정
		username.setForeground(Color.white);
		userjok.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		userjok.setForeground(Color.white);
		usermoney.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		usermoney.setForeground(Color.white);
		userpanel.setBackground(mycolor);// 수정

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
		
		// 각각 플레이어의 프로필이미지 넣기
		player1label = new JLabel(new ImageIcon("image/q.png"));
		player2label = new JLabel(new ImageIcon("image/w.png"));
		player3label = new JLabel(new ImageIcon("image/uzi.png"));
		player4label = new JLabel(new ImageIcon("image/e.png"));
		userlabel = new JLabel(new ImageIcon(Checkimage));

		// 센터패널 레이블 이미지
		centerlabel = new JLabel(new ImageIcon("image/im.gif"));
		centerTlabel = new JLabel("현재 판돈: " + (Money + savedmoney)
				+ " | 현재 콜 금액 : " + bet);

		// 카드뒷면 레이블 이미지
		backlabel1 = new JLabel("");
		backlabel2 = new JLabel("");
		backlabel3 = new JLabel("");
		backlabel4 = new JLabel("");

		// 족보설명
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
			cardslabel[i] = new JLabel(""); // 화투패 사이즈
																	// 조정
		}

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent b) {
			if(PlayerMoney[0] != 0)
				new Card(); // 패돌리는 쓰레드 클래스
			
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
					countlb.setText("            " + betcount + "회"); // 마지막수정

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
						appendToPane(TF1, "게임을 시작합니다." + "\n", Color.black);

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
									"")); // 레이블에 모든 화투이미지 삽입
							cardslabel[0 + (i * 2)]
									.setPreferredSize(new Dimension(75, 150)); // 화투패
																				// 사이즈
																				// 조정
							cardslabel[1 + (i * 2)].setIcon(new ImageIcon(
									"")); // 레이블에 모든 화투이미지 삽입
							cardslabel[1 + (i * 2)]
									.setPreferredSize(new Dimension(75, 150)); // 화투패
																				// 사이즈
																				// 조정

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
							// 망통 - 2월8월*/

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
								cardcombinations[i] = jokbo[32];// 1끗-2월9월
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
								cardcombinations[i] = jokbo[32];// 1끗-3월8월
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
								cardcombinations[i] = jokbo[32]; // 1끗 4월7월
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
							}// 1끗 - 5월6월

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
								cardcombinations[i] = jokbo[30]; // 2끗 -2월10월
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
								cardcombinations[i] = jokbo[30]; // 2끗 -3월9월
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
								cardcombinations[i] = jokbo[30]; // 2끗 -4월8월
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
							} // 2끗 -5월7월

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
								cardcombinations[i] = jokbo[31];// 3끗-3월10월
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
								cardcombinations[i] = jokbo[31];// 3끗-5월8월
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
							} // 3끗- 6월7월

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
								cardcombinations[i] = jokbo[1];// 4끗 - 1월3월
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
								cardcombinations[i] = jokbo[1];// 4끗 -6월8월
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
							} // 4끗 -5월9월

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
								cardcombinations[i] = jokbo[2]; // 5끗 - 2월3월
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
								cardcombinations[i] = jokbo[2];// 5끗- 5월10월
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
								cardcombinations[i] = jokbo[2];// 5끗- 7월8월
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
							}// 5끗- 7월8월

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
								cardcombinations[i] = jokbo[3];// 6끗 -2월5월
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
								cardcombinations[i] = jokbo[3]; // 6끗 -2월4월
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
								cardcombinations[i] = jokbo[3]; // 6끗 6월10월
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
							} // 6끗 7월9월

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
								cardcombinations[i] = jokbo[4];// 7끗 - 1월6월
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
								cardcombinations[i] = jokbo[4];// 7끗 - 2월5월
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
								cardcombinations[i] = jokbo[4]; // 7끗 - 3월4월
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
								cardcombinations[i] = jokbo[4];// 7끗 - 7월10월
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
							} // 7끗 8월9월

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
								cardcombinations[i] = jokbo[5];// 8끗 - 1월8월
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
								cardcombinations[i] = jokbo[5];// 8끗 -2월7월
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
								cardcombinations[i] = jokbo[5]; // 8끗 -,3월5월
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
							} // 8끗 -8월 10월

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
								cardcombinations[i] = jokbo[6];// 갑오 -2월8월
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
								cardcombinations[i] = jokbo[6];// 갑오 -2월7월
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
								cardcombinations[i] = jokbo[6];// 갑오 -3월6월
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
								cardcombinations[i] = jokbo[6]; // 갑오 -4월5월
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
							} // 갑오 - 9월10월

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
							}// 세륙- 4월6월

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
							}// 장사-4월10월

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
							}// 장삥 - 1월10월

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
							}// 구삥

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
							}// 독사

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
							}// 알리 1월2월

							else if (cards[0] == 0 && cards[1] == 1) {
								score[i] = 16;
								cardcombinations[i] = jokbo[13];
							} else if (cards[0] == 1 && cards[1] == 0) {
								score[i] = 16;
								cardcombinations[i] = jokbo[13];
							}// 1땡

							else if (cards[0] == 2 && cards[1] == 3) {
								score[i] = 17;
								cardcombinations[i] = jokbo[14];
							} else if (cards[0] == 3 && cards[1] == 2) {
								score[i] = 17;
								cardcombinations[i] = jokbo[14];
							}// 2땡

							else if (cards[0] == 4 && cards[1] == 5) {
								score[i] = 18;
								cardcombinations[i] = jokbo[15];
							} else if (cards[0] == 5 && cards[1] == 4) {
								score[i] = 18;
								cardcombinations[i] = jokbo[15];
							}// 3땡

							else if (cards[0] == 6 && cards[1] == 7) {
								score[i] = 19;
								cardcombinations[i] = jokbo[16];
							} else if (cards[0] == 7 && cards[1] == 6) {
								score[i] = 19;
								cardcombinations[i] = jokbo[16];
							}// 4땡

							else if (cards[0] == 8 && cards[1] == 9) {
								score[i] = 20;
								cardcombinations[i] = jokbo[17];
							} else if (cards[0] == 9 && cards[1] == 8) {
								score[i] = 20;
								cardcombinations[i] = jokbo[17];
							}// 5땡

							else if (cards[0] == 10 && cards[1] == 11) {
								score[i] = 21;
								cardcombinations[i] = jokbo[18];
							} else if (cards[0] == 11 && cards[1] == 10) {
								score[i] = 21;
								cardcombinations[i] = jokbo[18];
							}// 6땡

							else if (cards[0] == 12 && cards[1] == 13) {
								score[i] = 22;
								cardcombinations[i] = jokbo[19];
							} else if (cards[0] == 13 && cards[1] == 12) {
								score[i] = 22;
								cardcombinations[i] = jokbo[19];
							}// 7땡

							else if (cards[0] == 14 && cards[1] == 15) {
								score[i] = 23;
								cardcombinations[i] = jokbo[20];
							} else if (cards[0] == 15 && cards[1] == 14) {
								score[i] = 23;
								cardcombinations[i] = jokbo[20];
							}// 8땡

							else if (cards[0] == 16 && cards[1] == 17) {
								score[i] = 24;
								cardcombinations[i] = jokbo[21];
							} else if (cards[0] == 17 && cards[1] == 16) {
								score[i] = 24;
								cardcombinations[i] = jokbo[21];
							}// 9땡

							else if (cards[0] == 18 && cards[1] == 19) {
								score[i] = 26;
								cardcombinations[i] = jokbo[22];
							} else if (cards[0] == 19 && cards[1] == 18) {
								score[i] = 26;
								cardcombinations[i] = jokbo[22];
							}// 장땡

							else if (cards[0] == 0 && cards[1] == 4) {
								score[i] = 27;
								cardcombinations[i] = jokbo[23];
							} else if (cards[0] == 4 && cards[1] == 0) {
								score[i] = 27;
								cardcombinations[i] = jokbo[23];
							}// 13광땡

							else if (cards[0] == 0 && cards[1] == 14) {
								score[i] = 27;
								cardcombinations[i] = jokbo[24];
							} else if (cards[0] == 14 && cards[1] == 0) {
								score[i] = 27;
								cardcombinations[i] = jokbo[24];
							}// 18광땡

							else if (cards[0] == 4 && cards[1] == 14) {
								score[i] = 28;
								cardcombinations[i] = jokbo[25];
							} else if (cards[0] == 14 && cards[1] == 4) {
								score[i] = 28;
								cardcombinations[i] = jokbo[25];
							}// 38광땡

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
							}// 구사 -상대가 알리이하의족보일때 재경기가능

							else if (cards[0] == 6 && cards[1] == 16) {
								score[i] = -1;
								cardcombinations[i] = jokbo[27];
							} else if (cards[0] == 16 && cards[1] == 6) {
								score[i] = -1;
								cardcombinations[i] = jokbo[27];
							}// 멍텅구리구사 - 상대가 장땡이하일시 재경기가능

							else if (cards[0] == 4 && cards[1] == 12) {
								score[i] = -3;
								cardcombinations[i] = jokbo[28];
							} else if (cards[0] == 12 && cards[1] == 4) {
								score[i] = -3;
								cardcombinations[i] = jokbo[28];
							} // 땡잡이

							else if (cards[0] == 6 && cards[1] == 12) {
								score[i] = -4;
								cardcombinations[i] = jokbo[29];
							} else if (cards[0] == 12 && cards[1] == 6) {
								score[i] = -4;
								cardcombinations[i] = jokbo[29];
							} // 암행어사

							bet = chan.bet;
							bettime = 0;
							if (wp == 6) { // 구사 아닐경우 판돈으로만 재경기
								live[i] = aw[i]; // aw값을 이용 재경기 대상자 가림
								if (live[i] == 1) {// live 1일경우 경기 참여
									if (i == 0) {// 나의 카드뽑기
										player[i] = cardcombinations[i];
										scoreArray[i] = score[i];

										appendToPane(TF1, "나의 재경기" + "\n",
												Color.black);

									} else {// 나머지
										player[i] = cardcombinations[i];
										scoreArray[i] = score[i];

										appendToPane(TF1, "플레이어" + i + "의 재경기"
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
											.setIcon(new ImageIcon(back)); // 레이블에
																			// 모든
																			// 화투이미지
																			// 삽입
									cardslabel[0 + (i * 2)]
											.setPreferredSize(new Dimension(75,
													150));
									cardslabel[1 + (i * 2)]
											.setIcon(new ImageIcon(back)); // 레이블에
																			// 모든
																			// 화투이미지
																			// 삽입
									cardslabel[1 + (i * 2)]
											.setPreferredSize(new Dimension(75,
													150));
								}

							} else { // wp=6이 아니면 모두 라이프 부여가능
								if (PlayerMoney[i] < 1) {
									live[i] = 0;
									if (i == 1)
										appendToPane(TF1, "플레이어" + i,
												Color.green);
									if (i == 2)
										appendToPane(TF1, "플레이어" + i,
												Color.orange);
									if (i == 3)
										appendToPane(TF1, "플레이어" + i,
												Color.cyan);
									if (i == 4)
										appendToPane(TF1, "플레이어" + i,
												Color.blue);
									appendToPane(TF1, "는 배팅할 돈이 없습니다." + "\n",
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

									for (int u = 0; u < 5; u++) { // 수정
										if (PlayerMoney[u] % 10000 == 0)// 수정
											PM[u] = PlayerMoney[u] / 10000
													+ "만원"; // 수정
										else
											// 수정
											PM[u] = PlayerMoney[u] / 10000
													+ "만"
													+ (PlayerMoney[u] % 10000)
													/ 1000 + "천원"; // 수정

									}

									player1money
											.setText("<html>컴퓨터 아카데미1<br/>현재 금액은<html>"
													+ PM[1]);// 수정
									player2money
											.setText("<html>컴퓨터 아카데미2<br/>현재 금액은<html>"
													+ PM[2]);// 수정
									player3money
											.setText("<html>컴퓨터 아카데미3<br/>현재 금액은<html>"
													+ PM[3]);// 수정
									player4money
											.setText("<html>컴퓨터 아카데미4<br/>현재 금액은<html>"
													+ PM[4]);// 수정
									usermoney.setText("현재 금액은" + PM[0]);// 수정

									centerTlabel.setText("현재 판돈: "
											+ (Money + savedmoney)
											+ " | 현재 콜 금액 : " + bet);// 수정

								}

							}
							userjok.setText("현재 패 : " + player[0]);// 수정

						}
						Money += savedmoney;
						savedmoney = 0;
						
						startT = new StartThread();
						startT.start();
						
						centerTlabel.setText("현재 판돈: " + Money
								+ " | 현재 콜 금액 : " + bet);// 수정
						aw[0] = 0; // 중복체크 배열 초기화는 for 실시한뒤
						aw[1] = 0;
						aw[2] = 0;
						aw[3] = 0;
						aw[4] = 0;
						wp = 0;
					}
				}
			}
				else{
					appendToPane(TF1, "현재 처리중인 쓰레드 있습니다." + "\n", Color.black);
					curThr = 0;
				}
			}
		});
		// 플레이어1 패널
		winplayer[0] = new JLabel(""); // 승리한 플레이어 이미지
		winplayer[1] = new JLabel(""); // 승리한 플레이어 이미지
		winplayer[2] = new JLabel(""); // 승리한 플레이어 이미지
		winplayer[3] = new JLabel(""); // 승리한 플레이어 이미지
		winplayer[4] = new JLabel(""); // 승리한 플레이어 이미지
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
		winplayer[0].setBounds(157, 0, 75, 150); // 승리한 플레이어 이미지

		player1profilepnl.add(winplayer[0]); // 승리한 플레이어 이미지
		player1profilepnl.add(scorelabel[1]);
		player1profilepnl.add(cardslabel[2]);
		player1profilepnl.add(backlabel1);
		player1profilepnl.add(player1label);
		player1profilepnl.setPreferredSize(new Dimension(240, 150));
		player1profilepnl.setBackground(mycolor);

		player1.add(player1profilepnl);
		player1.add(player1moneypnl);
		player1.setBackground(mycolor);

		// 플레이어2 패널
		player2moneypnl.add(player2money);
		player2moneypnl.setBackground(mycolor);

		cardslabel[4].setBounds(0, 0, 75, 150);
		backlabel2.setBounds(78, 0, 75, 150);
		player2label.setBounds(157, 0, 75, 150);
		scorelabel[2].setBounds(3, 80, 146, 40);
		winplayer[1].setBounds(157, 0, 75, 150);

		player2profilepnl.add(winplayer[1]); // 승리한 플레이어 이미지
		player2profilepnl.add(scorelabel[2]);
		player2profilepnl.add(cardslabel[4]);
		player2profilepnl.add(backlabel2);
		player2profilepnl.add(player2label);
		player2profilepnl.setBackground(mycolor);

		player2.add(player2profilepnl);
		player2.add(player2moneypnl);
		player2.setBackground(mycolor);

		// 플레이어3 패널
		player3moneypnl.add(player3money);
		player3moneypnl.setBackground(mycolor);

		player3label.setBounds(0, 0, 75, 150);
		backlabel3.setBounds(78, 0, 75, 150);
		cardslabel[6].setBounds(156, 0, 75, 150);
		scorelabel[3].setBounds(81, 80, 147, 40);
		winplayer[2].setBounds(0, 0, 75, 150); // 승리한 플레이어 이미지

		player3profilepnl.add(winplayer[2]); // 승리한 플레이어 이미지
		player3profilepnl.add(scorelabel[3]);
		player3profilepnl.add(player3label);
		player3profilepnl.add(backlabel3);
		player3profilepnl.add(cardslabel[6]);
		player3profilepnl.setPreferredSize(new Dimension(240, 150));
		player3profilepnl.setBackground(mycolor);

		player3.add(player3profilepnl);
		player3.add(player3moneypnl);
		player3.setBackground(mycolor);

		// 플레이어4 패널
		player4moneypnl.add(player4money);
		player4moneypnl.setBackground(mycolor);

		player4label.setBounds(0, 0, 75, 150);
		backlabel4.setBounds(78, 0, 75, 150);
		cardslabel[8].setBounds(156, 0, 75, 150);
		scorelabel[4].setBounds(81, 80, 147, 40);
		winplayer[3].setBounds(0, 0, 75, 150); // 승리한 플레이어 이미지

		player4profilepnl.add(winplayer[3]); // 승리한 플레이어 이미지
		player4profilepnl.add(scorelabel[4]);
		player4profilepnl.add(player4label);
		player4profilepnl.add(backlabel4);
		player4profilepnl.add(cardslabel[8]);
		player4profilepnl.setBackground(mycolor);

		player4.add(player4profilepnl);
		player4.add(player4moneypnl);
		player4.setBackground(mycolor);
		// 버튼 패널
		btnpnl2 = new JPanel();
		btnpnl2.setLayout(null);
		btnpnl2.setBackground(mycolor);
		btnpnl2.setPreferredSize(new Dimension(250, 30));

		JLabel jokbolabel = new JLabel(new ImageIcon("image/jokbolabel.png"));
		btn[0] = new JButton(new ImageIcon("image/half.png", "하프"));
		btn[0].addActionListener(this);
		btn[1] = new JButton(new ImageIcon("image/call.png", "콜"));
		btn[1].addActionListener(this);
		btn[4] = new JButton(new ImageIcon("image/check.png", "체크"));
		btn[4].addActionListener(this);
		btn[2] = new JButton(new ImageIcon("image/ddadang.png", "따당"));
		btn[2].addActionListener(this);
		btn[3] = new JButton(new ImageIcon("image/bbing.png", "삥"));
		btn[3].addActionListener(this);
		btn[5] = new JButton(new ImageIcon("image/die.png", "다이"));
		btn[5].addActionListener(this);

		jokbolabel.setBounds(0, 0, 250, 101); // 미니족보 위치//마지막수정

		countlb = new JLabel("            " + betcount + "회");// 마지막수정
		countlb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		;
		countlb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		TitledBorder border = new TitledBorder(new LineBorder(colors),
				"남은 베팅 횟수");
		border.setTitleColor(colors);
		border.setTitleFont(new Font("맑은 고딕", Font.BOLD, 20));
		countlb.setBorder(border);
		countlb.setBounds(30, 120, 170, 50); // 마지막수정

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
		// 유저패널
		TF1 = new JTextPane();
		JSP = new JScrollPane(TF1);
		JSP.setPreferredSize(new Dimension(600, 200));// 수정
		TF1pnl = new JPanel();
		TF1pnl.add(JSP);
		userplayer = new JPanel(new BorderLayout());
		logopnl = new JPanel(new GridLayout(2, 1));
		logopnl.setBackground(mycolor);
		logolabel = new JLabel(new ImageIcon("image/tazzaa.png"));
		logolabel2 = new JLabel("<html>최영진 | 차민재  | 박민규 | 오세민<br/>"
				+ "　　 2019.12.26 ~ 2020.01.10<html>");
		logolabel2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		logolabel2.setForeground(Color.black);
		logolabel.setBackground(mycolor);

		logolabel.setBackground(mycolor);
		logopnl.add(logolabel);
		logopnl.add(logolabel2);

		userlabel.setBounds(150, 0, 75, 150);
		cardslabel[0].setBounds(228, 0, 75, 150);
		cardslabel[1].setBounds(306, 0, 75, 150);
		scorelabel[0].setBounds(232, 80, 147, 40);
		winplayer[4].setBounds(150, 0, 75, 150); // 승리한 플레이어 이미지
		userprofilepnl.setPreferredSize(new Dimension(260, 150));

		userprofilepnl.add(winplayer[4]); // 승리한 플레이어 이미지
		userprofilepnl.add(scorelabel[0]);
		userprofilepnl.add(userlabel);
		userprofilepnl.add(cardslabel[0]);
		userprofilepnl.add(cardslabel[1]);
		userprofilepnl.setBackground(mycolor);

		user.setLayout(new BoxLayout(user, BoxLayout.Y_AXIS));
		userpanel.setAlignmentX(Component.CENTER_ALIGNMENT);// 수정
		user.add(userprofilepnl);
		user.add(userpanel);// 수정
		user.add(JSP);
		// 패널 공백(상,좌,하,우)
		user.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));// 수정
		user.setBackground(mycolor);

		btnpnl.add(btn3);
		btnpnl.add(btn1);
		btnpnl.add(btn2);

		Westpnl.add(player3); // West 패널
		Westpnl.add(player4);
		Westpnl.setBackground(mycolor);

		Eastpnl.add(player1); // East 패널
		Eastpnl.add(player2);
		Eastpnl.setBackground(mycolor);

		Southpnl.add(logopnl, "West");
		Southpnl.add(btnpnl2, "East");
		Southpnl.add(user); // South 패널
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
		
		centerTlabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));// 수정
		centerTlabel.setForeground(Color.white);// 수정

		centerlabel.setAlignmentX(Component.CENTER_ALIGNMENT);// 수정
		centerTlabel.setAlignmentX(Component.CENTER_ALIGNMENT);// 수정
		centerpnl.setBackground(mycolor);
		// 패널 공백(상,하,좌,우)
		centerpnl.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));

		tazzapnl.setOpaque(false); // 패널 투명화
		tazzapnl.add(Westpnl, "West");
		tazzapnl.add(Eastpnl, "East");
		tazzapnl.add(Southpnl, "South");
		tazzapnl.add(centerpnl, "Center");
		tazzapnl.add(btnpnl, "North");

		this.add(tazzapnl);
		this.setVisible(true);

	}

	// 베팅 버튼 누르면 내돈 베팅 + 컴퓨터 베팅
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int om;// 내 올인 관련
		int om2;// 올인관련 2
		// 내 베팅
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
		}*/ // 배팅수정 
		
		while (live[0] == 1) {
			betcount--; // 마지막수정
			if (boss != 0 )// 승자가 나일때만 실행
				break;
			if (PlayerMoney[0] == 0) {
				isall[0] = true;
				appendToPane(TF1, "올인이므로 넘김" + "\n", Color.black);
			} else {
				if (e.getSource() == btn[0] && bettime !=3) { // 하프 //배팅수정
					new BettingThread(); // 베팅하는 쓰레드 클래스
					bet = Money / 2;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "올인" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}
					appendToPane(TF1, "하프 선택" + "\n", Color.black);			
					userbat.setIcon(new ImageIcon("image/halfbat.png"));
				} else if (e.getSource() == btn[1] && bettime !=3) { // 콜
					new BettingThread(); // 베팅하는 쓰레드 클래스
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;

					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "올인" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "콜 선택" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/callbat.png"));
				} else if (e.getSource() == btn[2] && bettime !=3) { // 따당
					new BettingThread(); // 베팅하는 쓰레드 클래스
					bet += bet;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "올인" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "따당 선택" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/ddadangbat.png"));
				} else if (e.getSource() == btn[3] && bettime !=3) { // 삥
					new BettingThread(); // 베팅하는 쓰레드 클래스
					bet = base;
					om2 = Money;
					Money += bet;
					om = PlayerMoney[0];
					PlayerMoney[0] -= bet;
					if (PlayerMoney[0] < 0) {
						appendToPane(TF1, "올인" + "\n", Color.black);
						Money = om2 + om;
						bet = om;
						live[0] = 0;
						PlayerMoney[0] = 0;
						isall[0] = true;
					}

					appendToPane(TF1, "삥 선택" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/bbingbat.png"));
				} else if (e.getSource() == btn[4] && bettime !=3) { // 체크

					if (boss != 0) { // 체크는 선만
						if (bettime <= 2) {
							appendToPane(TF1, "선일때만 체크를 할 수 있습니다." + "\n",
									Color.black);
							bet = 0;
							Money += bet;
						}
					}

					appendToPane(TF1, "체크 선택" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/checkbat.png"));
				} else if (e.getSource() == btn[5] && bettime !=3) { // 다이
					cardslabel[0].setIcon(new ImageIcon(back));
					cardslabel[1].setIcon(new ImageIcon(back));
					scorelabel[0].setText("다이");
					scorelabel[0].setBackground(Color.black);
					scorelabel[0].setOpaque(true);
					scorelabel[0].setForeground(Color.white);
					scorelabel[0].setFont(new Font("맑은 고딕", Font.BOLD, 25));
					scorelabel[0].setHorizontalAlignment(JLabel.CENTER);

					live[0] = 0;
					scoreArray[0] = -5; // 죽었으니 점수 0 점으로 간주

					appendToPane(TF1, "다이 선택" + "\n", Color.black);
					userbat.setIcon(new ImageIcon("image/diebat.png"));
				}
			}
			break;
		}
		while (true) {
			if (bettime <= 2) { // 배팅횟수가 3회 미만일때 컴퓨터 배팅실시
				playT1 = new PlayThread();
				
				if (e.getSource() == btn[4] && boss != 0) {// 체크 눌렀을때 처리
					appendToPane(TF1, "선일때만 체크를 할 수 있습니다." + "\n", Color.black);
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
					appendToPane(TF1, bettime + "회차 베팅 종료" + "\n",
							Color.black);
					Thread bc = new BatClear(); //배팅수정
						bc.start();
					countlb.setText("            " + betcount + "회"); // 마지막수정
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
					if (boss == 0)//승자가 내가 아닐때 실행
						break;
					if (PlayerMoney[0] == 0) {

						appendToPane(TF1, "올인이므로 넘김" + "\n", Color.black);
						isall[0] = true;
					} else {
						if (e.getSource() == btn[0]) { // 하프
							new BettingThread(); // 베팅하는 쓰레드 클래스
							bet = Money / 2;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "올인" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "하프 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/halfbat.png"));
						} else if (e.getSource() == btn[1]) { // 콜
							new BettingThread(); // 베팅하는 쓰레드 클래스
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;

							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "올인" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "콜 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/callbat.png"));
						} else if (e.getSource() == btn[2]) { // 따당
							new BettingThread(); // 베팅하는 쓰레드 클래스
							bet += bet;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "올인" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "따당 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/ddadangbat.png"));
						} else if (e.getSource() == btn[3]) { // 삥
							new BettingThread(); // 베팅하는 쓰레드 클래스
							bet = base;
							om2 = Money;
							Money += bet;
							om = PlayerMoney[0];
							PlayerMoney[0] -= bet;
							if (PlayerMoney[0] < 0) {
								appendToPane(TF1, "올인" + "\n", Color.black);
								Money = om2 + om;
								bet = om;
								live[0] = 0;
								PlayerMoney[0] = 0;
								isall[0] = true;
							}

							appendToPane(TF1, "삥 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/bbingbat.png"));
						} else if (e.getSource() == btn[4]) { // 체크

							if (boss != 0) { // 체크는 선만
								if (bettime <= 2) {
									appendToPane(TF1, "선일때만 체크를 할 수 있습니다."
											+ "\n", Color.black);
									bet = 0;
									Money += bet;
								}
							}

							appendToPane(TF1, "체크 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/checkbat.png"));
						} else if (e.getSource() == btn[5]) { // 다이
							cardslabel[0].setIcon(new ImageIcon(back));
							cardslabel[1].setIcon(new ImageIcon(back));
							scorelabel[0].setText("다이");
							scorelabel[0].setBackground(Color.black);
							scorelabel[0].setOpaque(true);
							scorelabel[0].setForeground(Color.white);
							scorelabel[0].setFont(new Font("맑은 고딕", Font.BOLD,
									25));
							scorelabel[0].setHorizontalAlignment(JLabel.CENTER);

							live[0] = 0;
							scoreArray[0] = -5; // 죽었으니 점수 0 점으로 간주

							appendToPane(TF1, "다이 선택" + "\n", Color.black);
							userbat.setIcon(new ImageIcon("image/diebat.png"));
						}
					}
					break;
				}
				playT2 = new PlayThread2();
				if (bettime <= 2) { // 배팅횟수가 3회 미만일때 컴퓨터 배팅실시
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
						
				appendToPane(TF1, bettime + "회차 베팅 종료" + "\n",
						Color.black);
				Thread bc2 = new BatClear(); //배팅수정
					bc2.start();
				
				countlb.setText("            " + betcount + "회"); // 마지막수정
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
				if (wp == -1) { // 수정
					appendToPane(TF1, "게임을 시작하고 싶으시면 시작버튼을 누르세요." + "\n",
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
					Money = 0;// 수정

				} else
					// 수정
					appendToPane(TF1, "게임이 종료되었습니다. 시작버튼을 누르세요." + "\n",
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
			for (int i = 1; i < 5; i++) {// 컴퓨터가 선 잡았을때의 처리
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
					Thread bF = new BtnFalse();//버튼비활성화1
					 bF.start();
					
					try {
						
						sleep(1000);
					} catch (InterruptedException e) {
						interrupt();
					}
					}
				
				if (i == boss && bettime==0)// 첫배팅처리
											break;
				if(i<boss)
					continue;

				if(boss!=0 && bettime == 0)
					break;
				
			if (live[i] == 0)
				continue;
			if(bettime==3 & boss != 0)
				break;
			appendToPane(TF1,"베팅", Color.black);
			
			
			
			if (scoreArray[i] == 0) { // 컴퓨터 다이 망통이면 무조건 다이
				if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
					bettime=2;
					continue;
				}
				cardslabel[i*2].setIcon(new ImageIcon(back));
				cardslabel[i*2+1].setIcon(new ImageIcon(back));
				scorelabel[i].setText("다이");
				scorelabel[i].setBackground(Color.black);
				scorelabel[i].setOpaque(true);
				scorelabel[i].setForeground(Color.white);
				scorelabel[i].setFont(new Font("맑은 고딕",Font.BOLD,25));
				scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
				live[i] = 0;
				if(i==1)
				appendToPane(TF1,"플레이어"+i,Color.green);
				if(i==2)
					appendToPane(TF1,"플레이어"+i,Color.orange);
				if(i==3)
					appendToPane(TF1,"플레이어"+i,Color.cyan);
				if(i==4)
					appendToPane(TF1,"플레이어"+i,Color.blue);
				appendToPane(TF1,"의 다이"+"\n",Color.black);
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
				if (scoreArray[i] == -1)// 멍구사
					betscore = 8;
				if (scoreArray[i] == -2)// 구사
					betscore = 8;
				if (scoreArray[i] == -3)// 땡잡이
					betscore = 8;
				if (scoreArray[i] == -4)// 암행어사
					betscore = 8;
				int cb = ran.nextInt(betscore + 1); // 0~25까지
				int prem; // 올인시 사용될 데이터
				int prem2; // 올인시 사용될 데이터 2
				if (cb == 0) {// 다이
					if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
						bettime=2;
						continue;
					}
					cardslabel[i*2].setIcon(new ImageIcon(back));
					cardslabel[i*2+1].setIcon(new ImageIcon(back));
					scorelabel[i].setText("다이");
					scorelabel[i].setBackground(Color.black);
					scorelabel[i].setOpaque(true);
					scorelabel[i].setForeground(Color.white);
					scorelabel[i].setFont(new Font("맑은 고딕",Font.BOLD,25));
					scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
					live[i] = 0;
					scoreArray[i] = -5;
					if(i==1)
						appendToPane(TF1,"플레이어"+i,Color.green);
						if(i==2)
							appendToPane(TF1,"플레이어"+i,Color.orange);
						if(i==3)
							appendToPane(TF1,"플레이어"+i,Color.cyan);
						if(i==4)
							appendToPane(TF1,"플레이어"+i,Color.blue);
					appendToPane(TF1,"의 다이"+"\n",Color.black);
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
				if (rr1 == 0) { // 체크
					if (i == boss) { // 선만 체크 가능
						bet = 0;
						Money += bet;
						if(i==1)
							appendToPane(TF1,"플레이어"+i,Color.green);
							if(i==2)
								appendToPane(TF1,"플레이어"+i,Color.orange);
							if(i==3)
								appendToPane(TF1,"플레이어"+i,Color.cyan);
							if(i==4)
								appendToPane(TF1,"플레이어"+i,Color.blue);
						appendToPane(TF1,"의 체크"+"\n",Color.black);
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
				if (rr2 == 0) { // 콜
					
					prem = PlayerMoney[i];// 올인 대비 저장
					PlayerMoney[i] -= bet; 
					
					prem2 = Money;
					Money += bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스								
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 올인!"+"\n",Color.black);
						bet = prem; // 올인시 실제 배팅금액으로 처리
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						
						continue;
					}
					if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
						appendToPane(TF1,"플레이어"+i,Color.green);}
						if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.orange);}
						if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.blue);}
					appendToPane(TF1,"의 콜"+"\n",Color.black);
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
				if (rr3 == 0) { // 하프

					bet = Money / 2;

					prem = PlayerMoney[i];
					PlayerMoney[i] -= bet;
					prem2 = Money;
					Money += bet;

					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 올인!"+"\n",Color.black);
						bet = prem; // 올인시 실제 배팅금액으로 처리
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
						appendToPane(TF1,"플레이어"+i,Color.green);}
						if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.orange);}
						if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.blue);}
					appendToPane(TF1,"의 하프"+"\n",Color.black);
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
				if (rr4 == 0) { // 삥
					bet = base;

					prem = PlayerMoney[i];// 올인 대비 저장
					PlayerMoney[i] -= bet;
					prem2 = Money;
					Money += bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 올인!"+"\n",Color.black);
						bet = prem; // 올인시 실제 배팅금액으로 처리
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
						appendToPane(TF1,"플레이어"+i,Color.green);}
						if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.orange);}
						if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.blue);}
					appendToPane(TF1,"의 삥"+"\n",Color.black);
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
				} else { // 따당

					bet += bet;
					prem2 = Money;
					Money += bet;
					prem = PlayerMoney[i];// 올인 대비 저장
					PlayerMoney[i] -= bet;
					if (PlayerMoney[i] < 0) {
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 올인!"+"\n",Color.black);
						bet = prem; // 올인시 실제 배팅금액으로 처리
						Money = prem2 + prem;
						PlayerMoney[i] = 0;
						live[i] = 0;
						isall[i]=true;
						continue;
					}
					if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
						appendToPane(TF1,"플레이어"+i,Color.green);}
						if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.orange);}
						if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.cyan);}
						if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.blue);}
					appendToPane(TF1,"의 따당"+"\n",Color.black);
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
			Thread bT = new BtnTrue(); //버튼활성화1
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
			for (int i = 1; i < boss; i++) {// 컴퓨터가 선 잡았을때의 처리
				
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
					bF2.start();  //버튼비활성화2
				try {
					
					sleep(1000);
					
				} catch (InterruptedException e) {
					interrupt();
				}
				}
				
				if (live[i] == 0)
					continue;
				appendToPane(TF1,"배팅2", Color.black);
				if (scoreArray[i] == 0) { // 컴퓨터 다이 망통이면 무조건 다이
					if(live[0]+live[1]+live[2]+live[3]+live[4]==1){
						bettime=2;
						continue;
					}
					cardslabel[i*2].setIcon(new ImageIcon(back));
					cardslabel[i*2+1].setIcon(new ImageIcon(back));
					scorelabel[i].setText("다이");
					scorelabel[i].setBackground(Color.black);
					scorelabel[i].setOpaque(true);
					scorelabel[i].setForeground(Color.white);
					scorelabel[i].setFont(new Font("맑은 고딕",Font.BOLD,25));
					scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
					
					live[i] = 0;
					if(i==1)
						appendToPane(TF1,"플레이어"+i,Color.green);
						if(i==2)
							appendToPane(TF1,"플레이어"+i,Color.orange);
						if(i==3)
							appendToPane(TF1,"플레이어"+i,Color.cyan);
						if(i==4)
							appendToPane(TF1,"플레이어"+i,Color.blue);
					appendToPane(TF1,"의 다이"+"\n",Color.black);
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
					if (scoreArray[i] == -1)// 멍구사
						betscore = 8;
					if (scoreArray[i] == -2)// 구사
						betscore = 8;
					if (scoreArray[i] == -3)// 땡잡이
						betscore = 8;
					if (scoreArray[i] == -4)// 암행어사
						betscore = 8;
					int cb = ran.nextInt(betscore + 1); // 0~25까지
					int prem; // 올인시 사용될 데이터
					int prem2; // 올인시 사용될 데이터 2
					if (cb == 0) {// 다이
						cardslabel[i*2].setIcon(new ImageIcon(back));
						cardslabel[i*2+1].setIcon(new ImageIcon(back));
						scorelabel[i].setText("다이");
						scorelabel[i].setBackground(Color.black);
						scorelabel[i].setOpaque(true);
						scorelabel[i].setForeground(Color.white);
						scorelabel[i].setFont(new Font("맑은 고딕",Font.BOLD,25));
						scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
						
						live[i] = 0;
						scoreArray[i] = -5;
						if(i==1)
							appendToPane(TF1,"플레이어"+i,Color.green);
							if(i==2)
								appendToPane(TF1,"플레이어"+i,Color.orange);
							if(i==3)
								appendToPane(TF1,"플레이어"+i,Color.cyan);
							if(i==4)
								appendToPane(TF1,"플레이어"+i,Color.blue);
						appendToPane(TF1,"의 다이"+"\n",Color.black);
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
					if (rr1 == 0) { // 체크
						if (i == boss) { // 선만 체크 가능
							bet = 0;
							Money += bet;
							if(i==1)
								appendToPane(TF1,"플레이어"+i,Color.green);
								if(i==2)
									appendToPane(TF1,"플레이어"+i,Color.orange);
								if(i==3)
									appendToPane(TF1,"플레이어"+i,Color.cyan);
								if(i==4)
									appendToPane(TF1,"플레이어"+i,Color.blue);
							appendToPane(TF1,"의 체크"+"\n",Color.black);
							
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
					if (rr2 == 0) { // 콜
						
						prem = PlayerMoney[i];// 올인 대비 저장
						PlayerMoney[i] -= bet; 
						
						prem2 = Money;
						Money += bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.green);}
								if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.orange);}
								if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.blue);}
							appendToPane(TF1,"의 올인!"+"\n",Color.black);
							bet = prem; // 올인시 실제 배팅금액으로 처리
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 콜"+"\n",Color.black);
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
					if (rr3 == 0) { // 하프

						bet = Money / 2;

						prem = PlayerMoney[i];
						PlayerMoney[i] -= bet;
						prem2 = Money;
						Money += bet;

						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.green);}
								if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.orange);}
								if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.blue);}
							appendToPane(TF1,"의 올인!"+"\n",Color.black);
							bet = prem; // 올인시 실제 배팅금액으로 처리
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 하프"+"\n",Color.black);
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
					if (rr4 == 0) { // 삥
						bet = base;

						prem = PlayerMoney[i];// 올인 대비 저장
						PlayerMoney[i] -= bet;
						prem2 = Money;
						Money += bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.green);}
								if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.orange);}
								if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.blue);}
							appendToPane(TF1,"의 올인!",Color.black);
							bet = prem; // 올인시 실제 배팅금액으로 처리
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 삥"+"\n",Color.black);
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
					} else { // 따당

						bet += bet;
						prem2 = Money;
						Money += bet;
						prem = PlayerMoney[i];// 올인 대비 저장
						PlayerMoney[i] -= bet;
						if (PlayerMoney[i] < 0) {
							if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.green);}
								if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.orange);}
								if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.cyan);}
								if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
									appendToPane(TF1,"플레이어"+i,Color.blue);}
							appendToPane(TF1,"의 올인!"+"\n",Color.black);
							bet = prem; // 올인시 실제 배팅금액으로 처리
							Money = prem2 + prem;
							PlayerMoney[i] = 0;
							live[i] = 0;
							isall[i]=true;
							continue;
						}
						if(i==1){new BettingThread1(); // 베팅하는 쓰레드 클래스
							appendToPane(TF1,"플레이어"+i,Color.green);}
							if(i==2){new BettingThread2(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.orange);}
							if(i==3){new BettingThread3(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.cyan);}
							if(i==4){new BettingThread4(); // 베팅하는 쓰레드 클래스
								appendToPane(TF1,"플레이어"+i,Color.blue);}
						appendToPane(TF1,"의 따당"+"\n",Color.black);
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
			Thread bT2 = new BtnTrue(); //버튼활성화2
			bT2.start();  	
	}
	}
	
	
	class StartThread extends Thread{
		public void run(){
			if(boss!=0){
			Thread bF3 = new BtnFalse();//버튼비활성화3
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
					if (scoreArray[i] == 0) { // 컴퓨터 다이 망통이면 무조건 다이
						if (live[0] + live[1] + live[2] + live[3]
								+ live[4] == 1) {
							bettime = 2;
							continue;
						}
						cardslabel[i * 2].setIcon(new ImageIcon(
								back));// 마지막 수정 다이 부분과 scorelabel
										// 부분 다 수정
						cardslabel[i * 2 + 1]
								.setIcon(new ImageIcon(back));
						scorelabel[i].setText("다이");
						scorelabel[i].setBackground(Color.black);
						scorelabel[i].setOpaque(true);
						scorelabel[i].setForeground(Color.white);
						scorelabel[i].setFont(new Font("맑은 고딕",
								Font.BOLD, 25));
						scorelabel[i]
								.setHorizontalAlignment(JLabel.CENTER);

						live[i] = 0;
						appendToPane(TF1, "플레이어" + i + "의 다이"
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
						if (scoreArray[i] == -1)// 멍구사
							betscore = 8;
						if (scoreArray[i] == -2)// 구사
							betscore = 8;
						if (scoreArray[i] == -3)// 땡잡이
							betscore = 8;
						if (scoreArray[i] == -4)// 암행어사
							betscore = 8;
						int cb = ran.nextInt(betscore + 1);
						if (cb == 0) {// 다이
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
							scorelabel[i].setText("다이");
							scorelabel[i]
									.setBackground(Color.black);
							scorelabel[i].setOpaque(true);
							scorelabel[i]
									.setForeground(Color.white);
							scorelabel[i].setFont(new Font("맑은 고딕",
									Font.BOLD, 25));
							scorelabel[i]
									.setHorizontalAlignment(JLabel.CENTER);
							live[i] = 0;
							scoreArray[i] = -5;
							appendToPane(TF1, "플레이어" + i + "의 다이"
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
						if (rr1 == 0) { // 체크
							if (i == boss) { // 선만 체크 가능
								bet = 0;
								Money += bet;
								appendToPane(TF1, "플레이어" + i
										+ "의 체크" + "\n",
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
						if (rr2 == 0) { // 콜

							Money += bet;

							PlayerMoney[i] -= bet;
							appendToPane(TF1, "플레이어" + i + "의 콜"
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
						if (rr3 == 0) { // 하프

							bet = Money / 2;
							Money += bet;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "플레이어" + i + "의 하프"
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
						if (rr4 == 0) { // 삥
							bet = base;
							Money += bet;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "플레이어" + i + "의 삥"
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
						} else { // 따당

							bet += bet;
							Money += bet * 2;
							PlayerMoney[i] -= bet;
							appendToPane(TF1, "플레이어" + i + "의 따당"
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
			Thread bT3 = new BtnTrue();//버튼활성화3
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
			Thread bF4 = new BtnFalse();//버튼비활성화1
			 bF4.start();
				
	if (bettime >= 3) {// 베팅 횟수가 3이면 끝냄.
		try {
			sleep(1000);
			Thread fe = new Free();
			fe.start();
		} catch (InterruptedException e) {
		}
		wp = 0;// 비교 승자수정
		int max = -6; // 이긴사람의 점수

		for (int i = 0; i < 5; i++) {
			if (scoreArray[i] == -2) {// 구사 처리
				if (max < 16)
					wp = 7;
			} else if (scoreArray[i] < 16) { // 앞에서 구사가 나왔는지 찾아봄
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -2)
						wp = 7;

				}

			}
			if (scoreArray[i] == -1 && max < 26) { // 멍텅구리구사 처리
				wp = 8;
			} else if (scoreArray[i] < 26) { // 앞에서 멍구사가 나왔는지 찾아봄
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -1)
						wp = 8;

				}

			}
			if (scoreArray[i] == -3) { // 땡잡이
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

			} else if (scoreArray[i] > 15 && scoreArray[i] < 25) {// n땡일때
																	// 앞사람
																	// 패를
																	// 확인
				for (int m = i; m > -1; m--) {
					if (scoreArray[m] == -3) {
						wp = i;
						scoreArray[i] = 25;
					}
				}
			}

			if (scoreArray[i] == -4) { // 암행어사 처리
				if (max == 27) {
					scoreArray[i] = 28;
					wp = i;
				}
			} else if (scoreArray[i] == -4 && max == 0) {// 암행어사 1끗취급
															// 당할때
															// 이기는 경우
				wp = i;
				max = 1;
			} else if (scoreArray[i] == -4 && max == 1) {// 암행어사 1끗취급
															// 당할때
															// 비기는 경우
				aw[i] = 1;
			} else if (scoreArray[i] == 27) { // 광땡일때 암행어사 있는지 체크
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

			} else if (max == scoreArray[i]) {// 점수 같을경우
				for (int m = i; m > -1; m--) { // 앞의 패중 본인과 점수 같은 패를 찾아냄
					if (scoreArray[m] == scoreArray[i])
						aw[m] = 1;
					else if (scoreArray[m] != scoreArray[i])
						aw[m] = 0;
				}

			}

			if ((aw[0] + aw[1] + aw[2] + aw[3] + aw[4]) != 0) {
				// 승자 복수 발생으로 재경기처리
				wp = 6;

			}

		}

		
		appendToPane(TF1, "나: " + player[0] + ", 플레이어 1:" + player[1]
				+ ", 플레이어 2:" + player[2] + ", 플레이어 3:" + player[3]
				+ ", 플레이어 4:" + player[4] + "\n", Color.black);

		player1money.setText("<html>컴퓨터 아카데미1<br/>현재 금액은" + PM[1]);// zxcv
		player2money.setText("<html>컴퓨터 아카데미2<br/>현재 금액은" + PM[2]);
		player3money.setText("<html>컴퓨터 아카데미3<br/>현재 금액은" + PM[3]);
		player4money.setText("<html>컴퓨터 아카데미4<br/>현재 금액은" + PM[4]);
		usermoney.setText("현재 금액은" + PM[0]);

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
		scorelabel[4].setText(player[4]);// 수정

		for (int i = 0; i < scorelabel.length; i++) {// 수정
			scorelabel[i].setBackground(Color.black);
			scorelabel[i].setOpaque(true);
			scorelabel[i].setForeground(Color.white);
			scorelabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			scorelabel[i].setHorizontalAlignment(JLabel.CENTER);
		}
		
		if (wp == 0) {
			try {
				appendToPane(TF1, "승자는...",Color.black);
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "나! " + "\n", Color.black);
			winplayer[4].setIcon((new ImageIcon("image/win.jpg"))); // 승리한
																	// 플레이어
																	// 이미지
			PlayerMoney[0] += Money;
			Money = 0;

			boss = wp;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp < 6) {
			try {
				appendToPane(TF1, "승자는...",Color.black);
				sleep(1000);
			} catch (InterruptedException e) {
			}
			if (wp == 1) {
				appendToPane(TF1, "플레이어" + wp + "\n", Color.green);
				winplayer[0].setIcon((new ImageIcon("image/win.jpg"))); // 승리한
																		// 플레이어
																		// 이미지
			}
			if (wp == 2) {
				appendToPane(TF1, "플레이어" + wp + "\n", Color.orange);
				winplayer[1].setIcon((new ImageIcon("image/win.jpg"))); // 승리한
																		// 플레이어
																		// 이미지
			}
			if (wp == 3) {
				appendToPane(TF1, "플레이어" + wp + "\n", Color.cyan);
				winplayer[2].setIcon((new ImageIcon("image/win.jpg"))); // 승리한
																		// 플레이어
																		// 이미지
			}
			if (wp == 4) {
				appendToPane(TF1, "플레이어" + wp + "\n", Color.blue);
				winplayer[3].setIcon((new ImageIcon("image/win.jpg"))); // 승리한
																		// 플레이어
																		// 이미지
			}
			PlayerMoney[wp] += Money;
			Money = 0;

			boss = wp;
			appendToPane(TF1,
					"------------------------------------------------------------------"
							+ "\n", Color.black);
		} else if (wp == 6) { // 돈을 안걸게 수정
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			appendToPane(TF1, "재경기" + "\n", Color.black);

			appendToPane(TF1, "누적된 판돈: " + Money + "원" + "\n",
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
			appendToPane(TF1, "구사로 인한 재경기" + "\n", Color.black);

			appendToPane(TF1, "누적된 판돈: " + Money + "원" + "\n",
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
			appendToPane(TF1, "멍텅구리 구사로 인한 재경기" + "\n", Color.black);
			appendToPane(TF1, "누적된 판돈: " + Money + "원" + "\n",
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
	for (int i = 0; i < 5; i++) { // 수정
		if (PlayerMoney[i] % 10000 == 0)// 수정
			PM[i] = PlayerMoney[i] / 10000 + "만원"; // 수정
		else
			// 수정
			PM[i] = PlayerMoney[i] / 10000 + "만"
					+ (PlayerMoney[i] % 10000) / 1000 + "천원"; // 수정

	}
	player1money.setText("<html>컴퓨터 아카데미1<br/>현재 금액은<html>" + PM[1]);// 수정
	player2money.setText("<html>컴퓨터 아카데미2<br/>현재 금액은<html>" + PM[2]);// 수정
	player3money.setText("<html>컴퓨터 아카데미3<br/>현재 금액은<html>" + PM[3]);// 수정
	player4money.setText("<html>컴퓨터 아카데미4<br/>현재 금액은<html>" + PM[4]);// 수정
	usermoney.setText("현재 금액은" + PM[0]);// 수정

	centerTlabel.setText("현재 판돈: " + (Money + savedmoney)
			+ " | 현재 콜 금액 : " + bet);// 수정
	centerlabel.setIcon(new ImageIcon("image/im.gif"));// 수정

	Thread bT4 = new BtnTrue(); //버튼활성화1
	bT4.start();	
	Thread bc = new BatClear();
	bc.start();
	
	
}
		
}
	class BtnFalse extends Thread{
		@Override
		public void run(){
			for(int i=0 ; i<btn.length ; i++)
				btn[i].setEnabled(false); // 버튼비활성화
			
		}
	}	

	class BtnTrue extends Thread{
		@Override
		public void run(){
			for(int i=0 ; i<btn.length ; i++)
				btn[i].setEnabled(true); // 버튼활성화
			
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
	class BatClear extends Thread{ //배팅수정
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
	class BettingThread extends JFrame{ // 유저 플레이어 베팅 쓰레드
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
		class BettingThread1 extends JFrame{ // 1번 플레이어 베팅 쓰레드
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
		class BettingThread2 extends JFrame{ // 2번 플레이어 베팅 쓰레드
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
		class BettingThread3 extends JFrame{ // 3번 플레이어 베팅 쓰레드
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
		class BettingThread4 extends JFrame{ // 4번 플레이어 베팅 쓰레드
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
		
	class Card extends JFrame{ // 패돌리는 쓰레드 클래스

		 	JLabel label1;
			JLabel label2;
			JLabel label3;
			JLabel label4;
			JLabel label5;
			
			
			int x1 = 250, y1 = 300; // x좌표.
			int x2 = 250, y2 = 300;
			int x3 = 250, y3 = 300;
			int x4 = 250, y4 = 300;
			int x5 = 250, y5 = 300;
			
			class MyThread extends Thread{
				public void run(){
					while(true){
					for(int i = 0; i <30; i++){
						try{
							Thread.sleep(7); // sleep은 도중에 예외가 발생할수 있기때문에 try/catch를 사용 해 준다.
						}catch(InterruptedException e){
							e.printStackTrace(); // 리턴값이 없고 가장 자세한 예외 정보를 제공한다.
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
				label2.setBounds(250,300,100,100); // 오른쪽으로 정렬
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
							play.cardslabel[i].setIcon(new ImageIcon(play.picture[i])); // 레이블에 모든
																					// 화투이미지 삽입
							play.cardslabel[i].setPreferredSize(new Dimension(75, 150)); // 화투패 사이즈
							
						}
					}
					
				}
				new cardvisibleT().start();
			}
		}
	

}
 