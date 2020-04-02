import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
	//Instances Objects/ variables/ consts for this class
	JLabel title = new JLabel("Two Dice!");


	JLabel subtitle = new JLabel("Lets get the dice rollin:", SwingConstants.CENTER);
	JLabel firstRoll = new JLabel("The First Roll is" , SwingConstants.CENTER);
	JLabel secondRoll = new JLabel("The Second Roll is");
	JLabel result1 = new JLabel("");
	JLabel result2 = new JLabel("");
	JLabel message = new JLabel(" ");

	//Panels to combine first roll and results + second roll and results
	//decided not to use because it was hiding the results 
	/*JPanel panelaAnderson = new JPanel();
	JPanel peterPanel = new JPanel();*/

	//Button to make all the magic happen
	JButton letsRoll = new JButton("Let's Roll!");
	


	//Constructor for the GUI 
	public TwoDiceGUI()
	{
		
		
		super("Dice em' Up!");
		final int WIDTH = 400;
		final int HEIGHT = 400;
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);//CENTERS THE BOX
		//FONTS!!
		Font bigFont = new Font("Charcoal CY", Font.BOLD, 67);
		Font headlineFont = new Font("Thonburi", Font.BOLD, 29);
		Font diceFont = new Font("Ayuthaya", Font.PLAIN, 16);


		//created a color instead of using standard 
		Color purple = new Color(129, 20, 186);
		getContentPane().setBackground(purple);
		title.setForeground(Color.WHITE);

		//add the objects to the page 
		title.setFont(bigFont);
		subtitle.setFont(headlineFont);
		//set size of button "letsRoll" + font and color 
		//letsRoll.setPreferredSize(new Dimension(350, 100));
		letsRoll.setFont(new Font("Arial", Font.PLAIN, 40));
		letsRoll.setForeground(purple);
		letsRoll.setBackground(Color.YELLOW);
		
		message.setFont(headlineFont);
		message.setForeground(Color.WHITE);

		//the dice 
		firstRoll.setFont(diceFont);
		secondRoll.setFont(diceFont);
		result1.setFont(diceFont);
		result2.setFont(diceFont);
		result1.setForeground(Color.YELLOW);
		result2.setForeground(Color.YELLOW);

		//add an icon!!
		Image icon = Toolkit.getDefaultToolkit().getImage("Dice.png");
		setIconImage(icon);



		add(title);
		add(subtitle);
		add(firstRoll);
		add(result1);
		add(secondRoll);
		add(result2);
		add(letsRoll);
		add(message);


		//adding the action listener to the button now 
		letsRoll.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		rollTheDice();
	}
	//method that handles everything else
	public void rollTheDice()
	{
		// objects 
		Die firstDie = new Die();
		Die secondDie = new Die();
		
		// variables and constants
		int value1 = firstDie.getValue();
		int value2 = secondDie.getValue();
		String mess;
		
		// calculation phase
		if(value1 == value2)
		{
			mess = "The dice are a match!";
		}
		else
		{
			if(value1 > value2)
			{
				mess = "First die roll is greater.";
			}
			else
			{
				mess = "Second die roll is greater.";
			}
		}
		
		// output phase
		message.setText("" + mess);
		result1.setText(": " + value1);
		result2.setText(": " + value2);
		
	}




}
