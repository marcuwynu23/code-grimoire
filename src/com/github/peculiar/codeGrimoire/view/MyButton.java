package com.github.peculiar.codeGrimoire.view; 


public class MyButton extends javax.swing.JButton{
	public MyButton(String name){
		super(name);
	}
	public void setUI(java.awt.Color bgColor,java.awt.Color fgColor,boolean isBorderPainted,java.awt.Font font,String toolkitText){
		setBackground(bgColor);
		setForeground(fgColor);
		setBorderPainted(isBorderPainted);
		setFont(font);
		setToolTipText(toolkitText);
	}
}