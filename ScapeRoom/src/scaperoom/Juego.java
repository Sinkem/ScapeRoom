package scaperoom;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Juego {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, imagePanel, inventoryPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel, counterLabel;
	Font titleFont = new Font("Georgia", Font.PLAIN, 70);
	Font normalFont = new Font("Georgia", Font.PLAIN, 26);
	JButton startButton, choice1, choice2, choice3, choice4, inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing, i, second, minute;
	String weapon, position, inventoryStatus, text, ddSecond, ddMinute;
	
	DecimalFormat dFormat = new DecimalFormat("00");

	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler iHandler = new InventoryHandler();
	
	String [] playerItem = new String[5];

		
		public Juego() {
		
			window = new JFrame();
			window.setSize(800, 600);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().setBackground(Color.black);
			window.setLayout(null);
			window.setVisible(true);
			window.setResizable(false);
			con = window.getContentPane();
			startMenu();
		}
		
		public void startMenu() {
			
			titleNamePanel = new JPanel();
			titleNamePanel.setBounds(100, 100, 600, 150);
			titleNamePanel.setBackground(Color.black);
			titleNameLabel = new JLabel("PROVISIONAL");
			titleNameLabel.setForeground(Color.white);
			titleNameLabel.setFont(titleFont);
			
			startButtonPanel = new JPanel();
			startButtonPanel.setBounds(300, 400, 200, 100);
			startButtonPanel.setBackground(Color.black);
			
			startButton = new JButton("START");
			startButton.setBackground(Color.black);
			startButton.setForeground(Color.white);
			startButton.setFont(normalFont);
			startButton.addActionListener(tsHandler);
			startButton.setFocusPainted(false);
			
			titleNamePanel.add(titleNameLabel);
			startButtonPanel.add(startButton);
			con.add(titleNamePanel);
			con.add(startButtonPanel);
		}
		
		public void createGameScreen(){
			
			titleNamePanel.setVisible(false);
			startButtonPanel.setVisible(false);
			
			mainTextPanel = new JPanel();
			mainTextPanel.setBounds(100, 100, 600, 250);
			mainTextPanel.setBackground(Color.black);
			con.add(mainTextPanel);
			
			mainTextArea = new JTextArea("");
			mainTextArea.setBounds(100, 100, 600, 250);
			mainTextArea.setBackground(Color.black);
			mainTextArea.setForeground(Color.white);
			mainTextArea.setFont(normalFont);
			mainTextArea.setLineWrap(true);
			mainTextPanel.add(mainTextArea);
			
			choiceButtonPanel = new JPanel();
			choiceButtonPanel.setBounds(250, 350, 300, 200);
			choiceButtonPanel.setBackground(Color.black);
			choiceButtonPanel.setLayout(new GridLayout(5, 1));
			con.add(choiceButtonPanel);
			
			choice1 = new JButton("Choice 1");
			choice1.setBackground(Color.black);
			choice1.setForeground(Color.white);
			choice1.setFont(normalFont);
			choice1.setFocusPainted(false);
			choice1.addActionListener(choiceHandler);
			choice1.setActionCommand("c1");
			choiceButtonPanel.add(choice1);
			
			choice2 = new JButton("Choice 2");
			choice2.setBackground(Color.black);
			choice2.setForeground(Color.white);
			choice2.setFont(normalFont);
			choice2.setFocusPainted(false);
			choice2.addActionListener(choiceHandler);
			choice2.setActionCommand("c2");
			choiceButtonPanel.add(choice2);
			
			choice3 = new JButton("Choice 3");
			choice3.setBackground(Color.black);
			choice3.setForeground(Color.white);
			choice3.setFont(normalFont);
			choice3.setFocusPainted(false);
			choice3.addActionListener(choiceHandler);
			choice3.setActionCommand("c3");
			choiceButtonPanel.add(choice3);
			
			choice4 = new JButton("Choice 4");
			choice4.setBackground(Color.black);
			choice4.setForeground(Color.white);
			choice4.setFont(normalFont);
			choice4.setFocusPainted(false);
			choice4.addActionListener(choiceHandler);
			choice4.setActionCommand("c4");
			choiceButtonPanel.add(choice4);
			
			inventoryButton = new JButton("[Inventory]");
			inventoryButton.setBackground(Color.black);
			inventoryButton.setForeground(Color.yellow);
			inventoryButton.setFont(normalFont);
			inventoryButton.setFocusPainted(false);
			inventoryButton.addActionListener(iHandler);
			inventoryButton.setActionCommand("inventoryButton");
			choiceButtonPanel.add(inventoryButton);
			
			inventoryPanel = new JPanel();
			inventoryPanel.setBounds(550, 350, 200, 200);
			inventoryPanel.setBackground(Color.black);
			inventoryPanel.setLayout(new GridLayout(5,1));
			con.add(inventoryPanel);
			
			itemButton1 = new JButton();
			itemButton1.setBackground(Color.black);
			itemButton1.setForeground(Color.white);
			itemButton1.setFont(normalFont);
			itemButton1.setFocusPainted(false);
			itemButton1.addActionListener(iHandler);
			itemButton1.setActionCommand("item1");
			
			itemButton2 = new JButton();
			itemButton2.setBackground(Color.black);
			itemButton2.setForeground(Color.white);
			itemButton2.setFont(normalFont);
			itemButton2.setFocusPainted(false);
			itemButton2.addActionListener(iHandler);
			itemButton2.setActionCommand("item2");
			
			itemButton3 = new JButton();
			itemButton3.setBackground(Color.black);
			itemButton3.setForeground(Color.white);
			itemButton3.setFont(normalFont);
			itemButton3.setFocusPainted(false);
			itemButton3.addActionListener(iHandler);
			itemButton3.setActionCommand("item3");
			
			itemButton4 = new JButton();
			itemButton4.setBackground(Color.black);
			itemButton4.setForeground(Color.white);
			itemButton4.setFont(normalFont);
			itemButton4.setFocusPainted(false);
			itemButton4.addActionListener(iHandler);
			itemButton4.setActionCommand("item4");
			
			itemButton5 = new JButton();
			itemButton5.setBackground(Color.black);
			itemButton5.setForeground(Color.white);
			itemButton5.setFont(normalFont);
			itemButton5.setFocusPainted(false);
			itemButton5.addActionListener(iHandler);
			itemButton5.setActionCommand("item5");
			
			inventoryPanel.add(itemButton1);
			inventoryPanel.add(itemButton2);
			inventoryPanel.add(itemButton3);
			inventoryPanel.add(itemButton4);
			inventoryPanel.add(itemButton5);
			
			inventoryPanel.setVisible(false);
			
			playerPanel = new JPanel();
			playerPanel.setBounds(100, 15, 600, 50);
			playerPanel.setBackground(Color.black);
			playerPanel.setLayout(new GridLayout(1, 4));
			con.add(playerPanel);
			hpLabel = new JLabel("HP:");
			hpLabel.setFont(normalFont);
			hpLabel.setForeground(Color.white);
			playerPanel.add(hpLabel);
			hpLabelNumber = new JLabel();
			hpLabelNumber.setFont(normalFont);
			hpLabelNumber.setForeground(Color.white);
			playerPanel.add(hpLabelNumber);
			weaponLabel = new JLabel ("Weapon:");
			weaponLabel.setFont(normalFont);
			weaponLabel.setForeground(Color.white);
			playerPanel.add(weaponLabel);
			weaponLabelName = new JLabel();
			weaponLabelName.setFont(normalFont);
			weaponLabelName.setForeground(Color.white);
			playerPanel.add(weaponLabelName);
			
			
			playerSetup();
		}
		

			Timer countdownTimer = new Timer(1000, new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					
					second--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					counterLabel.setText(ddMinute + ":" + ddSecond);
					
					if(second == -1) {
						second = 59;
						minute--;
						ddSecond = dFormat.format(second);
						ddMinute = dFormat.format(minute);
						counterLabel.setText(ddMinute + ":" + ddSecond);
					}
					if(minute == 0 && second == 0) {
						countdownTimer.stop();
					}
				}
			});
		
		
		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				char character[] = text.toCharArray();
				int arrayNumber = character.length;
				
				String addedCharacter = "";
				String blank = "";
				
				addedCharacter = blank + character[i];
				mainTextArea.append(addedCharacter);
				
				i++;
				
				if(i == arrayNumber) {
					i = 0;
					timer.stop();
				}
			}
		});
		
			public void prepareText() {
				i = 0;
				mainTextArea.setText("");
				timer.start();
			}
		
		
		public void playerSetup() {
			playerHP = 15;
			monsterHP = 20;
			weapon = "Knife";
			
			hpLabelNumber.setText("" + playerHP);
			inventoryStatus = "Close";
			weaponLabelName.setText(weapon);
			
			playerItem[0] = "Potion";
			playerItem[1] = "Orange";
			playerItem[2] = "";
			playerItem[3] = "";
			playerItem[4] = "";
	
			introductionPartOne();
		}
		
		public void introductionPartOne() {
			position = "introductionPartOne";
			
			text = "Te despiertas en una plaza medio destruida. \nNo reconoces el lugar. \nDe repente una voz suena de alguna parte";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void introductionPartTwo() {
			position = "introductionPartTwo";
			
			text = "Voz desconocida: Bienvenido. Se que ahora mismo tendras muchas preguntas, pero todo sera respondido en su momento. Ahora simplemente prestame atencion.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void introductionPartThree() {
			position = "introductionParThree";
			
			text = "Voz desconocida: Tienes 5 minutos para vivir. Podras añadir tiempo cada vez que derrotes a uno de los enemigos que vas a encontrar aqui.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void introductionPartFour() {
			position = "introductionPartFour";
			
			text = "Voz desconocida: Si sigues cualquier camino llegaras a uno de tus rivales. Buena suerte, la vas a necesitar";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void mainSquare() {
			position = "mainSquare";
			
			//mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \nA woman is standing on your left. \n\nWhat do you do?");
			text = "Miras a tu alrededor, ves un camino a tu izquierda, otro delante y otro a tu derecha. \n\n¿Donde quieres ir?";
			prepareText();
			choice1.setText("Ir a la izquierda");
			choice2.setText("Ir a delante");
			choice3.setText("Ir a la derecha");
			choice4.setText("");
		}
		
		public void leftWay() {
			position = "leftWay";
			
			//mainTextArea.setText("Guard: Hello stranger. \nI have never seen your face. \nI'm sorry but we cannot let a stranger enter our town");
			text = "Guard: Hello stranger. \nI have never seen your face. \nI'm sorry but we cannot let a stranger enter our town";
			prepareText();
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void attackGuard() {
			position = "attackGuard";
			
			//mainTextArea.setText("Guard: Hey don't be stupid!\n \nguard fought back and hit you hard.\n(You receive 3 damage)");
			text = "Guard: Hey don't be stupid!\n \nguard fought back and hit you hard.\n(You receive 3 damage)";
			prepareText();
			playerHP = playerHP - 3;
			hpLabelNumber.setText("" + playerHP);
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void talkWoman() {
			position = "talkWoman";
			
			int slotNumber = 0;
			while(playerItem[slotNumber] != "" && slotNumber < 4) {
				slotNumber++;
			}
			
			if(playerItem[slotNumber]=="") {
				//mainTextArea.setText("Woman: You look hungry, take this. \n(You received orange)");
				text = "Woman: You look hungry, take this. \n(You received orange)";
				prepareText();
				playerItem[slotNumber] = "Orange";
			}
			else if(playerItem[slotNumber]!= "") {
				//mainTextArea.setText("Woman: It seems you cannot carry anymore");
				text = "Woman: It seems you cannot carry anymore";
				prepareText();
			}
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
		}
		
		public void crossRoad() {
			position = "crossRoad";
			
			text = "You are at a crossroad. \nIf you go South, you will go back to the town.";
			prepareText();
			
			choice1.setText("Go North");
			choice2.setText("Go East");
			choice3.setText("Go South");
			choice4.setText("Go West");
		}
		
		public void north() {
			position = "north";
			
			text = "There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)";
			prepareText();	
			playerHP = playerHP + 2;
			hpLabelNumber.setText("" + playerHP);
			
			choice1.setText("Go South");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void east() {
			position = "east";
			
			text = "You walked into a forest and found a Long Sword!\n\n(You obtainer a Long Sword)";
			prepareText();
			weapon = "Long Sword";
			weaponLabelName.setText(weapon);
			
			choice1.setText("Go West");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}	
		
		public void west() {
			position = "west";
			
			text  ="You encounter a goblin!";
			prepareText();
			
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void fight() {
			position = "fight";
			
			text = "Monster HP: " + monsterHP +"\n\nWhat do you do?";
			prepareText();
			
			choice1.setText("Attack");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void playerAttack() {
			position = "playerAttack";
			
			int playerDamage = 0;
			
			if(weapon.equals("Knife")) {
				playerDamage = new java.util.Random().nextInt(3);
			}
			else if(weapon.equals("Long Sword")) {
				playerDamage = new java.util.Random().nextInt(12);
			}
			
			text = "You attacked the monster and gave " + playerDamage + " damage!";
			prepareText();
			
			monsterHP = monsterHP - playerDamage;
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void monsterAttack() {
			position = "monsterAttack";
			
			int monsterDamage = 0;
			
			monsterDamage = new java.util.Random().nextInt(6);
			
			text = "The monster attacked you and gave " + monsterDamage + " damage!";
			prepareText();
			
			playerHP = playerHP - monsterDamage;
			hpLabelNumber.setText("" + playerHP);
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void win() {
			position = "win";
			
			text = "You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)";
			prepareText();
			
			silverRing = 1;
			
			choice1.setText("Go East");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void lose() {
			position = "lose";
			
			text = "You are dead!\n\n<GAME OVER>";
			prepareText();
			
			choice1.setText("Reintentar");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void ending() {
			position = "ending";
			
			text = "Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n<THE END>";
			prepareText();
			
			choice1.setText("");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			choice1.setVisible(false);
			choice2.setVisible(false);
			choice3.setVisible(false);
			choice4.setVisible(false);
		}
		
		public void itemUsed(int slotNumber) {
			
			switch(playerItem[slotNumber]) {
			case "Potion":
				playerHP = playerHP +10;
				hpLabelNumber.setText(""+playerHP);
				playerItem[slotNumber] = "";
				break;
			case "Orange":
				playerHP = playerHP -2;
				hpLabelNumber.setText("" + playerHP);
				playerItem[slotNumber] = "";
				break;
			case "":
				break;
			}
		}
		
		public class TitleScreenHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				createGameScreen();
			}
		}
		
		public class ChoiceHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				String yourChoice = event.getActionCommand();
				
				switch(position) {
				case "introductionPartOne":
					switch(yourChoice) {
					case "c1":
						introductionPartTwo(); break;
					}
					break;
				case "introductionPartTwo":
					switch(yourChoice) {
					case "c1":
						introductionPartThree(); break;
					}
					break;
				case "introductionPartThree":
					switch(yourChoice) {
					case "c1":
						introductionPartFour(); break;
					}
					break;
				case "introductionPartFour":
					switch(yourChoice) {
					case "c1":
						mainSquare(); break;
					}
					break;
				case "mainSquare":
					switch(yourChoice) {
					case "c1": leftWay(); break;
					case "c2": attackGuard(); break;
					case "c3": talkWoman(); break;
					case "c4": crossRoad(); break;
					}
					break;
				case "talkGuard":
					switch(yourChoice) {
					case "c1": mainSquare(); break;
					}
					break;
				case "attackGuard":
					switch(yourChoice) {
					case "c1": mainSquare(); break;
					}
					break;
				case "talkWoman":
					switch(yourChoice) {
					case "c1": mainSquare(); break;
					}
					break;
				case "crossRoad":
					switch(yourChoice) {
					case "c1": north(); break;
					case "c2": east(); break;
					case "c3": mainSquare(); break;
					case "c4": west(); break;
					}
					break;
				case "north":
					switch(yourChoice){
						case "c1": crossRoad(); break;
					}
					break;
				case "east":
					switch(yourChoice) {
				    case "c1": crossRoad(); break;
				    }
					break;
				case "west":
					switch(yourChoice) {
					case "c1": fight(); break;
					case "c2": crossRoad(); break;
					}
					break;
				case "fight":
					switch(yourChoice) {
					case "c1": playerAttack();break;
					case "c2": crossRoad(); break;
					}
					break;
				case "playerAttack":
					switch(yourChoice) {
					case "c1":
						if(monsterHP < 1) {
							win();
						}
						else {
							monsterAttack();
						}
						break;
					}
					break;
				case "monsterAttack":
					switch(yourChoice) {
					case "c1": 
						if(playerHP<1) {
							lose();
						}
						else {
							fight();
						}
						break;
					}
					break;
				case "win":
					switch(yourChoice) {
					case "c1": crossRoad(); break;
					}
					break;
				case "lose":
					switch(yourChoice) {
					case "c1":; break;
					}
				}
			}
			
		}
		
		public class InventoryHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				
				String yourChoice = event.getActionCommand();
				
				switch(yourChoice) {
				case "inventoryButton":
					if(inventoryStatus.equals("Close")) {
						choice1.setVisible(false);
						choice2.setVisible(false);
						choice3.setVisible(false);
						choice4.setVisible(false);
						inventoryPanel.setVisible(true);
						itemButton1.setText(playerItem[0]);
						itemButton2.setText(playerItem[1]);
						itemButton3.setText(playerItem[2]);
						itemButton4.setText(playerItem[3]);
						itemButton5.setText(playerItem[4]);
						inventoryStatus = "Open";
					} else if(inventoryStatus.equals("Open")) {
						choice1.setVisible(true);
						choice2.setVisible(true);
						choice3.setVisible(true);
						choice4.setVisible(true);
						inventoryPanel.setVisible(false);
						inventoryStatus = "Close";
					}
						break;
					case "item1":
						itemButton1.setText("");
						itemUsed(0);
						break;
					case "item2":
						itemButton2.setText("");
						itemUsed(1);
						break;
					case "item3":
						itemButton3.setText("");
						itemUsed(2);
						break;
					case "item4":
						itemButton4.setText("");
						itemUsed(3);
						break;
					case "item5":
						itemButton5.setText("");
						itemUsed(4);
						break;
				}
			}
		}
		
	}
