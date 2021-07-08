package com.github.peculiar.codeGrimoire.view; 


public class MyTextArea extends javax.swing.JTextArea{
	public MyTextArea(String name){
		super(name);
	}
	public MyTextArea(){
		super();
	}
	public void setUIColor(java.awt.Color bgColor,java.awt.Color fgColor,java.awt.Color caretColor,java.awt.Color selectedTextColor,java.awt.Color selectionColor){
		setBackground(bgColor);
		setForeground(fgColor);
		setCaretColor(caretColor);
		setSelectedTextColor(selectedTextColor);
		setSelectionColor(selectionColor);
	}
	public void setUI(java.awt.Font font,java.awt.Insets insets,int tabSize,boolean isLineWrap,boolean isWrapByWord){
		setFont(font);
		setMargin(insets);
		setTabSize(tabSize);
		setLineWrap(isLineWrap);
		setWrapStyleWord(isWrapByWord);

	}
}