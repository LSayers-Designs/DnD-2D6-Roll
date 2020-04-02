/*
Author: Letisha Rahming
Creation Date: 3/4/2020
Submission Date: 3/4/2020
Last Revision Date:
Description: GUI upgrade of DiceGame DnD style
*/

//Import statments
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiceGameGUI extends JFrame implements
ActionListener
{
	//Label, TextField and Button objects
	JLabel title = new JLabel ("Roll 2d20 for Spell Damage.");
	JLabel label1 = new JLabel("First Die Roll is");
	JTextField output1 = new JTextField(2);
	JLabel label2 = new JLabel("Second Die Roll is");
	JTextField output2 = new JTextField(2);
	JButton button = new JButton("Roll!"); /*put a hint label here*/
	JTextField summary = new JTextField(22);
	
	
	//Constructor method for this class
	public DiceGameGUI()
	{
		super("Twenty Sided Die");
		setBounds(370,270, 370, 270);
		output1.setEditable(false); 
		output2.setEditable(false);
		summary.setEditable(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//Colors and Fonts
		Color color1 = new Color(123, 111, 0);
		Color color2 = new Color(0, 111, 123);
		Color color3 = new Color(111, 23, 111);
		Color color4 = new Color(11, 23, 11);
		title.setForeground(color1);
		title.setFont(new Font("Serif", Font.BOLD, 28)); 
		label1.setForeground(color2);
		label2.setForeground(color2);
		output1.setFont(new Font("Serif", Font.BOLD, 18)); 
		output2.setFont(new Font("Serif", Font.BOLD, 18)); 
		button.setForeground(color3);
		button.setFont(new Font("Serif", Font.BOLD,28));
		label1.setFont(new Font("Verdana", Font.BOLD, 22));
		label2.setFont(new Font("Verdana", Font.BOLD, 22));
		summary.setForeground(color4);
		summary.setFont(new Font("Serif", Font.BOLD, 18)); 
		
		//Addying components to the layout
		add (title);
		add (label1);
		add (output1);
		add (label2);
		add (output2);
		add (button);
		button.setToolTipText("Click here to roll the die");
		add (summary);

		//Key action listener to the button component for the game
		button.addActionListener(this);
	}
	
	//Performs theDieRoll action and math.random calculation reference 
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//objects
		DieRoll firstDie = new DieRoll();
		DieRoll secondDie = new DieRoll();
		
		//variables and constants
		int value1 = firstDie.getValue();
		int value2 = secondDie.getValue();
		String msg;
		
		//calculation phase
		if(value1==value2)
		{
			msg= "The dice are a match!";
		}
		else
		{
			if(value1>value2)
			{
				msg = "The first die roll was higher.";
			}
			else
			{
				msg = "The second die roll was greater.";
			}
		}
		
		// Output phase modified to display in a GUI upon click of the button. 
		output1.setText(String.valueOf(value1));
		output2.setText(String.valueOf(value2));
		summary.setText(msg);	
		
	}
	//Without this nothing will happen and the compiler will tell you to add a public static void... 
	 public static void main(String[] args)
	 {
			DiceGameGUI demo1 = new DiceGameGUI();
			demo1.setVisible(true);
		}
}
	
	
	
	
