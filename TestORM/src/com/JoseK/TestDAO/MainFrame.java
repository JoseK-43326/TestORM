package com.JoseK.TestDAO;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public JButton seekButton;
	public JButton deleteButton;
	public JButton addButton;
	public JButton updateButton;
	
	public MainFrame(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
			});
		setTitle("MySQL数据库操作");
		setSize(300,100);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/java/Image/Doc.png"));
		JPanel buttonPanel = new JPanel();
		seekButton = new JButton("查 询");
		deleteButton = new JButton("删 除");
		addButton = new JButton("添 加");
		updateButton = new JButton("修 改");
		buttonPanel.add(seekButton);
		buttonPanel.add(addButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);
		add(buttonPanel,BorderLayout.CENTER);		
		setVisible(true);
	}
	
	public void addLuanchAction(){
		seekButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeekFrame seekFrame = new SeekFrame();				
				seekFrame.setVisible(true);	
				UserAPP.mainFrame.setVisible(false);
			}
		});
		deleteButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteFrame deleteFrame = new DeleteFrame();
				deleteFrame.setVisible(true);
				UserAPP.mainFrame.setVisible(false);
			}
		});	
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateFrame createFrame = new CreateFrame();
				createFrame.setVisible(true);
				UserAPP.mainFrame.setVisible(false);
			}
		});
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateFrame updateFrame = new UpdateFrame();
				updateFrame.setVisible(true);;
				UserAPP.mainFrame.setVisible(false);
			}
		});
	}
	
}
