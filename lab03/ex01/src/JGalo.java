import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class JGalo extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3780928537820216588L;
	private JPanel jPanel = null;
	private JToggleButton bt[];
	JGaloInterface jogo;

	public JGalo(JGaloInterface myGreatGame) {
		super("Jogo da Galinha");
		jogo = myGreatGame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
        setLocation(100,100);
        jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3,3));
		bt = new JToggleButton[9];
		for (int i=0; i<9; i++) {
			bt[i] = new JToggleButton();
			bt[i].setFont(new Font("Tahoma", Font.BOLD, 50));
			bt[i].setForeground(Color.BLUE);
			bt[i].addActionListener(this);
			jPanel.add(bt[i]);				
		}

		this.setContentPane(jPanel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("JToggleButton")){
			((JToggleButton)e.getSource()).setText(String.valueOf(jogo.getActualPlayer()));
			((JToggleButton)e.getSource()).setEnabled(false);
		}
		for (int i=0; i<9; i++)
			if (e.getSource()==bt[i]) {
				jogo.setJogada(i/3+1,i%3+1);
			}

		if (jogo.isFinished()){
			char result = jogo.checkResult();
			if (result == ' ')
				JOptionPane.showMessageDialog(getContentPane(), "Empate!");
			else
				JOptionPane.showMessageDialog(getContentPane(), "Venceu o jogador " + result);
			System.exit(0);
		}
	}

	public static class JogoGalo implements JGaloInterface {
		private char gameBoard[][] = new char[3][3];
		private char actualPlayer = 'X';
		private int plays = 0;

		public char getActualPlayer() {
			return actualPlayer;
		}

		public boolean setJogada(int lin, int col) {
			if (gameBoard[lin-1][col-1] == 0) {
				gameBoard[lin-1][col-1] = actualPlayer;
				plays++;
				if (actualPlayer == 'X')
					actualPlayer = 'O';
				else
					actualPlayer = 'X';
				return true;
			}
			return false;
		}

		public boolean isFinished() {
			if (plays == 9)
				return true;
			return (checkResult() != ' ');
		}

		public char checkResult() {
			for (int i=0; i<3; i++) {
				if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != 0)
					return gameBoard[i][0];
				if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != 0)
					return gameBoard[0][i];
			}
			if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != 0)
				return gameBoard[0][0];
			if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != 0)
				return gameBoard[0][2];
			return ' ';
		}
	}

	public static void main(String args[]) {
		new JGalo(new JogoGalo());
	}
} 
