//OASIS INFOBYTE INTERNSHIP PROGRAM

//Number Guessing Game using GUI java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.Scanner;

public class Task2_Game extends JFrame implements ActionListener {
	JLabel a, b, r;
	JTextField num;
	JButton guess, exit;
	public int number;
	public int guessCount = 1;

	public static void main(String args[]) {
		Task2_Game w = null;
		w = new Task2_Game();

	}// end main

	public Task2_Game() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		frame.setTitle("NUMBER GUESSING GAME");
		frame.setSize(500, 200);

		Font f;
		f = new Font("Sans Serif", Font.BOLD, 18);

		this.number = (int) (Math.random() * 100 + 1);

		GridLayout g = null;
		g = new GridLayout(5, 2, 20, 10);
		frame.setLayout(g);

		// create row1
		a = new JLabel("Guess the number\f");
		a.setFont(f);
		frame.add(a);
		b = new JLabel("Chances = 7");
		b.setFont(f);
		frame.add(b);

		// create row2
		num = new JTextField();
		frame.add(num);

		// create row3
		r = new JLabel();
		r.setFont(f);
		frame.add(r);

		// create row4
		guess = new JButton("Guess");
		frame.add(guess);
		guess.addActionListener(this);

		// create row5
		exit = new JButton("exit");
		frame.add(exit);
		exit.addActionListener(this);

		frame.setVisible(true);

	}// end constructor

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guess) {

			String s;
			s = num.getText();
			int x;
			x = Integer.parseInt(s);

			if (x > number) {
				r.setText("Guess should be lower!!!");
			} else if (x < number) {
				r.setText("Guess should be higher!!");
			} else if (x == number) {
				JOptionPane.showMessageDialog(null, ("Congratulations, YOU WIN! " + " \nIt took you " + guessCount
						+ " guesses " + "\n\nSCORE: " + ((8 - guessCount) * 10) + "/70"));
				
						System.exit(0);
			}

			guessCount++;

			if (guessCount > 7) {
				JOptionPane.showMessageDialog(null, "Out of Chances... \nYou lose \nThe number was " + number);
				System.exit(0);
			}
		}

		else if (e.getSource() == exit) {

			System.exit(0);
		}

	}// end actionPerformed

}// end class
