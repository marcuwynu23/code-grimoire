package com.github.peculiar.codeGrimoire.view; 


public class MyButton extends javax.swing.JButton{
	public MyButton(String name){
		super(name);
		setBorderPainted(false);
		setForeground(java.awt.Color.WHITE);
	}
	public void setUI(java.awt.Color bgColor,java.awt.Color fgColor,java.awt.Font font,String toolkitText){
		setBackground(bgColor);
		setForeground(fgColor);
		setFont(font);
		setToolTipText(toolkitText);
	}
}