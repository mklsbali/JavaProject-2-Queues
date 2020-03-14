package ro.utcn.tp.assig2.interfacce;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ro.utcn.tp.assig2.model.RandomClientGenerator;
import ro.utcn.tp.assig2.model.Simulator;

public class Window {
	
	private JPanel mainPanel;
	
	public static JTextField[] textFields;
	public static JButton OK;
	public static JButton SET;
	
	public Window() {
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(640,480));
		f.setLocation(300, 300);;
		mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		createTextFields();
		OK=new JButton("START");
		SET=new JButton("SET");
		addThingsToPanel();
		f.setContentPane(mainPanel);
		f.setVisible(true);
		
	}
	public void createTextFields() {
		textFields=new JTextField[6];
		textFields[0]=new JTextField("Min arriving time");
		textFields[1]=new JTextField("Max ariving time");
		textFields[2]=new JTextField("Min service time");
		textFields[3]=new JTextField("Max service time");
		textFields[4]=new JTextField("Max interval");
		textFields[5]=new JTextField("Number of queues (1-->6)");
	}
	public void addThingsToPanel() {
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[0]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[1]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[2]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[3]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[4]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(textFields[5]);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.add(SET);
		mainPanel.add(OK);
	}

	

}

