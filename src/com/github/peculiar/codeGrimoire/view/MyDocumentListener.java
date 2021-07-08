package com.github.peculiar.codeGrimoire.view; 




import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Element;

public class MyDocumentListener implements DocumentListener{
		private JTextArea textArea,lineArea;
		public MyDocumentListener(JTextArea textArea,JTextArea lineArea){
			this.textArea = textArea;
			this.lineArea = lineArea;
		}
		public String getText() {
			int caretPosition = textArea.getDocument().getLength();
			Element root = textArea.getDocument().getDefaultRootElement();
			String text = "1" + System.getProperty("line.separator");
			for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
				text += i + System.getProperty("line.separator");
			}
			return text;
		}
		@Override
		public void changedUpdate(DocumentEvent de) {
			lineArea.setText(getText());
		}
		@Override
		public void insertUpdate(DocumentEvent de) {
			lineArea.setText(getText());
		}
		@Override
		public void removeUpdate(DocumentEvent de) {
			lineArea.setText(getText());
		}
	}


