package scaperoom;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Juego {
	
	public int moves;
	
	private JFrame window;
	private Container con;
	private JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel;
	private JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, movesLabel, movesLabelName;
	private Font titleFont = new Font("Georgia", Font.PLAIN, 70);
	private Font normalFont = new Font("Georgia", Font.PLAIN, 26);
	private JButton startButton, choice1, choice2, choice3, choice4, inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
	private JTextArea mainTextArea;
	private int playerHP, i;
	private String weapon, position, inventoryStatus, text;
	private boolean option = false, conversationLeftLeft = false, conversationLeftLeftFinished = false, conversationLeftRightFinished = false;
	
	private TitleScreenHandler tsHandler = new TitleScreenHandler();
	private ChoiceHandler choiceHandler = new ChoiceHandler();
	private InventoryHandler iHandler = new InventoryHandler();
	
	private String [] playerItem = new String[5];

		
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
			titleNameLabel = new JLabel("LANOISIVORP");
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
			weaponLabel = new JLabel ("Arma:");
			weaponLabel.setFont(normalFont);
			weaponLabel.setForeground(Color.white);
			playerPanel.add(weaponLabel);
			weaponLabelName = new JLabel();
			weaponLabelName.setFont(normalFont);
			weaponLabelName.setForeground(Color.white);
			playerPanel.add(weaponLabelName);
			movesLabel = new JLabel ("Pasos:");
			movesLabel.setFont(normalFont);
			movesLabel.setForeground(Color.white);
			playerPanel.add(movesLabel);
			movesLabelName = new JLabel();
			movesLabelName.setFont(normalFont);
			movesLabelName.setForeground(Color.white);
			playerPanel.add(movesLabelName);
			
			
			
			playerSetup();
		}
		
		
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
			playerHP = 30;
			weapon = "";
			moves = 20;
			
			
			hpLabelNumber.setText("" + playerHP);
			inventoryStatus = "Close";
			weaponLabelName.setText(weapon);
			movesLabelName.setText("" + moves);
			
			playerItem[0] = "";
			playerItem[1] = "";
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
			position = "introductionPartThree";
			
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
			
			text = "Miras a tu alrededor, ves un camino a tu izquierda, otro delante y otro a tu derecha. \n\n¿Donde quieres ir?";
			prepareText();
			
			choice1.setText("Ir a la izquierda");
			choice2.setText("Ir a delante");
			choice3.setText("Ir a la derecha");
			choice4.setText("");
		}
		
		public void straightWay() {
			position = "straightWay";
			
			mainTextArea.setText("No había tiempo para hacer más");
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void rightWay() {
			position = "rightWay";
			
			text = "Pisas unos pinchos y pierdes mucha sangre";
			prepareText();
			
			playerHP = playerHP - 30;
			hpLabelNumber.setText("" + playerHP);
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWay1() {
			position = "leftWay1";
			
			text = "Con cada paso que avanzas ves que el desierto del que venías va siendo consumido poco a poco por una ciudad.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWay2() {
			position = "leftWay2";
			
			text = "Al principio solo ves edificios en ruinas y una carretera en muy mal estado, pero cuanto mas entras en ella empiezas a vislumbrar una gran ciudad con una edificacion que nunca antes habias visto y con una apariencia bastante futurista.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWay3() {
			position = "leftWay3";
			
			text = "Acabas llegando al cruce de una avenida. Piensas que es bastante parecida a Times Square pero con mucha más iluminación. \n\nNo, por mucho que se parezca a ese sitio, te recuerda a la plaza en la que estuviste al principio. Y esta igual de vacia.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWay4() {
			position = "leftWay4";
			
			text = "Te fijas bien y puedes distinguir otros 3 caminos. \nA tu izquierda hay una calle bastante oscura, con muy mal aspecto. \nA tu derecha hay una calle completamente contraria a la otra, perfectamente iluminada y con pinta de ser la zona más cara de la ciudad. \n Delante tuya hay una puerta gigante.";
			prepareText();
			
			choice1.setText("Ir a delante");
			choice2.setText("Ir a la izquierda");
			choice3.setText("Ir a la derecha");
			choice4.setText("Volver atrás");
		}
		
		public void leftWayStraightNoItem() {
			position = "leftWayStraightNoItem";
			
			text = "Te acercas a la puerta, no tiene ni pomo, casi no parece una puerta. Intentas empujarla pero no cede ni un milimetro.";
			prepareText();
				
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
			
		public void leftWayStraightItem() {
			position = "leftWayStraightItem";
			
			text = "La puerta se abre. Comienzas a andar por un pasillo, es estrecho. \n\nLlegas a un salon enorme y en el medio hay un hombre vestido de negro.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void ending1() {
			position = "ending1";
			
			text = "La puerta se abre. Comienzas a andar por un pasillo, es estrecho. \n\nLlegas a un salon enorme y en el medio hay un hombre vestido de negro de espaldas.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void ending2() {
			position = "ending2";
			
			text = "???: No sabía si llegarías. \n\nSe gira y... \nTu: Te encuentras mirandote a ti mismo";
			prepareText();
			
			choice1.setText("Eres... ¿Yo?");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void ending3() {
			position = "ending3";
			
			text = "Tu: Si, bueno, soy nuestro yo principal y también el narrador. \nNo se como no te has extrañado de escuchar una voz en tu cabeza.";
			prepareText();
			
			choice1.setText("No entiendo nada");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void ending4() {
			position = "ending4";
			
			text = "Tu: Es sencillo. Necesitamos un cambio de personalidad y estoy probandoos";
			prepareText();
			
			choice1.setText("¿Y que pasa ahora?");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void neutralEnding1() {
			position = "neutralEnding1";
			
			text = "Tu: Bueno, has pasado todas las pruebas, así que solo queda la última. Coge la pistola y matame";
			prepareText();
			
			choice1.setText("DISPARA");
			choice2.setText("No hagas nada");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void neutralEnding2() {
			position = "neutralEndingShoot2";
			
			text = "Tu: Vaya, que decepción, pensaba que serías el indicado supongo que habrá que seguir buscando... Donde vas es oscuro, pero estarás bien, tranquilo";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void goodEnding1() {
			position = "goodEnding1";
			
			text = "Tu: Bien, no esperaba menos, a partir de ahora tu llevas el mando. Permiteme despedirme usando la narracion, queda mejor.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void goodEnding2() {
			position = "goodEnding2";
			
			text = "Tu yo desaparece y tu te quedas encerrado en esa habitación. Espero que lo hagas bien.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void badEnding() {
			position = "badEnding";
			
			text = "Bueno, mataste a ese pobre hombre. Asi que estás fuera. Sayonara.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void lameEnding() {
			position = "lameEnding";
			
			text = "¿De verdad? Pensaba que era imposible, ya veo que no";
			prepareText();
			
			choice1.setVisible(false);
			choice2.setVisible(false);
			choice3.setVisible(false);
			choice4.setVisible(false);
		}
		
		public void ending() {
			position = "ending";
			
			titleNameLabel.setText("FIN");
		}
		
		public void leftWayLeft() {
			position = "leftWayLeft";
			
			text = "Avanzas por esas calles estrechas y oscuras hasta que ves el letrero de una bar iluminado. Te acercas a el y entras, hay un hombre, probablemente tendrá unos 40 y algo pero parece bastante deteriorado";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWayRight1() {
			position = "leftWayRight1";
			
			text = "Avanzas y no tardas mucho en encontrarte a un señor de unos 30 años, bien vestido, parece adinerado.";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWayRight2() {
			position = "leftWayRight2";
			
			text = "Hombre desconocido: Oh hola, tu eres El, ¿no?";
			prepareText();
			
			choice1.setText("¿El?");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWayRight3() {
			position = "leftWayRight3";
			
			text = "Ah si, se me había olvidado que no podías saber nada. \nEntonces acabemos rápido. \n\n";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWayRight4() {
			position = "leftWayRight4";
			
			int slotNumber = 0;
			
			text = "Hombre desconocido: Toma. \n\n<Recibes 'Estrella de oro' y 'Pocion'>";
			prepareText();
			
			playerItem[slotNumber] = "Pocion";
			playerItem[slotNumber+1] = "Estrella de oro";
			
			conversationLeftRightFinished = true;
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		
		public void conversationLeft1() {
			position = "conversationLeft1";
			
			text = "Hombre desconocido: ¿Quien eres tu? ¿Que haces aqui?.";
			prepareText();
			
			choice1.setText("No se quien soy");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
			conversationLeftLeft = true;
		}
		
		public void conversationLeft2() {
			position = "conversationLeft2";
			
			text = "Hombre desconocido: Espera... Tu eres... JAJAJAJA.";
			prepareText();
			
			choice1.setText("¿Quien soy?");
			choice2.setText("¿De que te ries?");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void conversationLeft2Option1() {
			position = "conversationLeft2Option1";
			
			text = "Hombre desconocido: Hey, no voy a ser yo quien arruine la sorpresa. \nBueno, tengo cosas que vas a necesitar si quieres abrir la puerta";
			prepareText();
			
			choice1.setText("Damelo");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void conversationLeft2Option2() {
			position = "conversationLeft2Option2";
			
			text = "Hombre desconocido: Jajaja ¿Estas seguro de que quieres llevar esto así? Porque tengo cosas que necesitas y si te pones asi no vas a conseguirlo.";
			prepareText();
			
			choice1.setText("Damelo");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void conversationLeft3() {
			position = "conversationLeft3";
	
				
			text = "Hombre desconocido: Si lo quieres tendras que pagarme una estrella de oro";
			prepareText();
				
			choice1.setText("Pagar");
			choice2.setText("Atacar");
			choice3.setText("");
			choice4.setText("Salir");
			
		}
		
		public void conversationLeft4() {
			position = "conversationLeft4";
			
			text = "Hombre desconocido: ¿Ya estas de vuelta? ¿Vas a pagar ya?";
			prepareText();
			
			choice1.setText("Pagar");
			choice2.setText("Atacar");
			choice3.setText("");
			choice4.setText("Salir");
		}
		
		public void pay() {
			position = "pay";
			
			int slotNumber = 0;
			
			if(playerItem[0] == "Estrella de oro" || playerItem[1] == "Estrella de oro" || playerItem[2] == "Estrella de oro" ||playerItem[3] == "Estrella de oro" || playerItem[4] == "Estrella de oro") {
			
				text = "Hombre desconocido: Buena eleccion. Aqui tienes chaval, \n\n <Recibes 'Pistola' y 'Orbe'>";
				prepareText();
				
				playerItem[slotNumber] = "";
			
				while(playerItem[slotNumber] != "") {
					slotNumber++;
				}
				
				weapon = "Pistola";
				playerItem[slotNumber] = "Orbe";
			
				conversationLeftLeftFinished = true;
				
				choice1.setText(">");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
			}
			else {
				text = "Hombre desconocido: Pero si no tienes para pagar, vuelve cuando lo tengas.";
				prepareText();
				
				choice1.setText(">");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
			}
		}
		
		public void attackLeft1() {
			position = "attackLeft1";
			
			text = "Te lanzas sobre el y comienzas a pegarle";
			prepareText();
			
			option = true;
			
			choice1.setText("PEGAR");
			choice2.setText("PEGAR");
			choice3.setText("PEGAR");
			choice4.setText("PEGAR");
		}
		
		public void attackLeft2() {
			position = "attackLeft2";
		
			int x = 0;
			
			while(x<3) {
				text = "SIGUE PEGANDO";
				prepareText();
				
				playerHP = playerHP + 212;
				hpLabelNumber.setText("" + playerHP);
				x++;
			}
			
			choice1.setText("SIGUE");
			choice2.setText("SIGUE");
			choice3.setText("SIGUE");
			choice4.setText("SIGUE");
		}
		
		public void attackLeft3() {
			position = "attackLeft3";
		
			int x = 0;
			
			while(x<3) {
				text = "NO PARES";
				prepareText();
				
				playerHP = playerHP + 111;
				hpLabelNumber.setText("" + playerHP);
				x++;
			}
			
			choice1.setText("SIGUE");
			choice2.setText("SIGUE");
			choice3.setText("SIGUE");
			choice4.setText("SIGUE");
		}
		
		public void attackLeft4() {
			position = "attackLeft4";
			
			int x = 0;
			
			while(x<3) {
				text = "Suficiente";
				prepareText();
				
				playerHP = playerHP - 323;
				hpLabelNumber.setText("" + playerHP);
				x++;
			}
			
			choice1.setText("...");
			choice2.setText("...");
			choice3.setText("...");
			choice4.setText("...");
		}
		
		public void reward() {
			position = "reward";
			
			int slotNumber = 0;
			
			text = "Lo has matado. \n\nMiras a tu alrededor en busca de los objetos. \nEn el suelo encuentras una pistola y un orbe. \n\n<Obtienes 'Pistola' y 'Orbe'>";
			prepareText();
			
			while(playerItem[slotNumber] != "") {
				slotNumber++;
			}
			
			weapon = "Pistola";
			playerItem[slotNumber] = "Orbe";
			conversationLeftLeftFinished = true;
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void leftWayClosed() {
			position = "leftWayClosed";
			
			text = "No tienes motivos para ir allí";
			prepareText();
			
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		
		public void itemUsed(int slotNumber) {
			
			switch(playerItem[slotNumber]) {
			case "Pocion":
				playerHP = playerHP + 10;
				hpLabelNumber.setText(""+playerHP);
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
					case "c1": leftWay1(); break;
					case "c2": straightWay(); break;
					case "c3": rightWay(); break;
					}
					break;
				case "straightWay":
					switch(yourChoice) {
					case "c1": mainSquare(); break;
					}
					break;
				case "rightWay":
					switch(yourChoice) {
					case "c1": 
						if(playerHP == 0) {
							lameEnding();
						}
						else {
							mainSquare();
						}
					}
					break;
				case "leftWay1":
					switch(yourChoice) {
					case "c1": leftWay2(); break;
					}
					break;
				case "leftWay2":
					switch(yourChoice) {
					case "c1": leftWay3(); break;
					}
					break;
				case "leftWay3":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "leftWay4":
					switch(yourChoice) {
					case "c1": 
						if(weapon == "pistola") {
							leftWayStraightItem();
						}
						else {
							leftWayStraightNoItem();
						}
						break;
					case "c2": 
						if(conversationLeftLeft == true && conversationLeftLeftFinished == false) {
							conversationLeft4(); 
						}
						else {
							if(conversationLeftLeft == true && conversationLeftLeftFinished == true){
								leftWayClosed();
							}
							else {
								leftWayLeft();
							}
						}
						break;
					case "c3":
						if(conversationLeftRightFinished == true) {
							leftWayClosed();
						}
						else {
							leftWayRight1();
						}
						break;
					case "c4": mainSquare(); break;
					}
					break;
				case "leftWayStraightNoItem":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "leftWayStraightItem":
					switch(yourChoice) {
					case "c1": ending1(); break;
					}
					break;
				case "ending1":
					switch(yourChoice) {
					case "c1": ending2(); break;
					}
					break;
				case "ending2":
					switch(yourChoice) {
					case "c1": ending3(); break;
					}
					break;
				case "ending3":
					switch(yourChoice) {
					case "c1": ending4(); break;
					}
					break;
				case "ending4":
					switch(yourChoice) {
					case "c1": 
						if(option == true) {
							badEnding();
						}
						else {
							neutralEnding1();
						}
						break;
					}
					break;
				case "badEnding":
					switch(yourChoice) {
					case "c1": ending(); break;
					}
					break;
				case "neutralEnding1":
					switch(yourChoice) {
					case "c1": neutralEnding2(); break;
					case "c2": goodEnding1(); break;
					}
					break;
				case "NeutralEnding2":
					switch(yourChoice) {
					case "c1": ending(); break;
					}
					break;
				case "goodEnding1":
					switch(yourChoice) {
					case "c1": goodEnding2(); break;
					}
					break;
				case "goodEnding2":
					switch(yourChoice) {
					case "c1": ending(); break;
					}
					break;
				case "leftWayLeft":
					switch(yourChoice) {
					case "c1": conversationLeft1(); break;
					}
					break;
				case "conversationLeft1":
					switch(yourChoice) {
					case "c1": conversationLeft2(); break;
					}
					break;
				case "conversationLeft2":
					switch(yourChoice) {
					case "c1": conversationLeft2Option1(); break;
					case "c2": conversationLeft2Option2(); break;
					}
					break;
				case "conversationLeft2Option1":
					switch(yourChoice) {
					case "c1": conversationLeft3(); break;
					}
					break;
				case "conversationLeft2Option2":
					switch(yourChoice) {
					case "c1": conversationLeft3(); break;
					}
					break;
				case "conversationLeft3":
					switch(yourChoice) {
					case "c1": pay(); break;
					case "c2": attackLeft1(); break;
					case "c4": leftWay4(); break;
					}
					break;
				case "conversationLeft4":
					switch(yourChoice) {
					case "c1": pay(); break;
					case "c2": attackLeft1(); break;
					case "c4": leftWay4(); break;
					}
					break;
				case "pay":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "attackLeft1":
					switch(yourChoice) {
					case "c1": attackLeft2(); break;
					case "c2": attackLeft2(); break;
					case "c3": attackLeft2(); break;
					case "c4": attackLeft2(); break;
					}
					break;
				case "attackLeft2":
					switch(yourChoice) {
					case "c1": attackLeft3(); break;
					case "c2": attackLeft3(); break;
					case "c3": attackLeft3(); break;
					case "c4": attackLeft3(); break;
					}
					break;
				case "attackLeft3":
					switch(yourChoice) {
					case "c1": attackLeft4(); break;
					case "c2": attackLeft4(); break;
					case "c3": attackLeft4(); break;
					case "c4": attackLeft4(); break;
					}
					break;
				case "attackLeft4":
					switch(yourChoice) {
					case "c1": reward(); break;
					}
					break;
				case "reward":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "leftWayClosed":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "leftWayRight1":
					switch(yourChoice) {
					case "c1": leftWayRight2(); break;
					}
					break;
				case "leftWayRight2":
					switch(yourChoice) {
					case "c1": leftWayRight3(); break;
					}
					break;
				case "leftWayRight3":
					switch(yourChoice) {
					case "c1": leftWayRight4(); break;
					}
					break;
				case "leftWayRight4":
					switch(yourChoice) {
					case "c1": leftWay4(); break;
					}
					break;
				case "talkGuard":
					switch(yourChoice) {
					case "c1": mainSquare(); break;
					}
					break;
				
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
