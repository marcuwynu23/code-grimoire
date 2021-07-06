package com.github.peculiar.codeGrimoire.view; 
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Element;
import com.github.peculiar.codeGrimoire.io.FileHandler;
import com.github.peculiar.codeGrimoire.io.FileBackup;
import com.github.peculiar.codeGrimoire.model.ContentData;

public class View extends JFrame{
	private static class UI{
		private static final String APP_TITLE = "Code Grimoire";
		private static final String[] COMBO_LIST ={
			"Development Logs","Java Manual and Snippets","Python3 Manual and Snippets",
			"C Manual and Snippets","C++ Manual and Snippets","SQLite3 Manual and Snippets",
			"Project Journal","Project Ideas","Sites Account"
		};
		private static final String[] BTN_NAMES = {
			"Edit Content","Update Content","+",
			"-","Copy Selected","Insert Divider",
			"Insert Date","Settings"
		};
		private static final String[] OBJ_FILE_NAME_LIST = {
			"devLogs.grimoire","manual_java.grimoire","manual_python3.grimoire",
			"manual_c.grimoire","manual_c++.grimoire",
			"manual_sqlite3.grimoire","journal.grimoire",
			"projectIdeas.grimoire","sitesAccount.grimoire"
		};
		private static final String HORIZONTAL_DIVIDER = "\n=========================================================\n";
		private static final String[] DATA_FOLDERS ={"data\\","data\\backup\\"};
		private static final String ICON_PATH = "icon\\icon.png";
	}
	private JPanel areaPnl,optionPnl,statusPnl;
	private JTextArea textArea1,textArea2;
	private static JTextArea lines1;
	private static JTextArea lines2;

	private JButton editBtn,updateBtn,zplusBtn,zminBtn,selectBtn;
	private JButton insertDivBtn;
	private JButton insertDateBtn;
	private JButton settingsBtn;
	private JComboBox list;
	private int fontSize = 13;

	public View(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			System.out.println(ex);
		}
		setSize(900,700);
		setMinimumSize(new Dimension(900,700));
		setTitle(UI.APP_TITLE);
		setIconImage(new ImageIcon("icon\\icon.png").getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setVisible(true);
		setComponents();
		setComponentUI();
		setComponentsLayout();
		setAction();

	}
	private void setComponents(){
		areaPnl = new JPanel();
		optionPnl = new JPanel();
		statusPnl = new JPanel();
		textArea1 = new JTextArea();
		textArea2 = new JTextArea();
		lines1 = new JTextArea("1");
		lines2 = new JTextArea("1");


		editBtn = new JButton(UI.BTN_NAMES[0]);
		updateBtn = new JButton(UI.BTN_NAMES[1]);
		zplusBtn = new JButton(UI.BTN_NAMES[2]);
		zminBtn = new JButton(UI.BTN_NAMES[3]);
		selectBtn = new JButton(UI.BTN_NAMES[4]);
		insertDivBtn = new JButton(UI.BTN_NAMES[5]);
		insertDateBtn = new JButton(UI.BTN_NAMES[6]);
		settingsBtn = new JButton(UI.BTN_NAMES[7]);
		list = new JComboBox(UI.COMBO_LIST);


	}
	private void setComponentUI(){
		var BG_COLOR = new Color(45,45,45);
		var FG_COLOR = Color.WHITE;
		var BTN_BG = new Color(40,40,40);


		textArea1.setBackground(BTN_BG);
		textArea2.setBackground(BTN_BG);
		areaPnl.setBackground(BG_COLOR);
		statusPnl.setBackground(BG_COLOR);
		optionPnl.setBackground(BG_COLOR);
		
		zplusBtn.setBackground(BTN_BG);
		zminBtn.setBackground(BTN_BG);
		editBtn.setBackground(BTN_BG);
		updateBtn.setBackground(BTN_BG);
		selectBtn.setBackground(BTN_BG);
		insertDivBtn.setBackground(BTN_BG);
		insertDateBtn.setBackground(BTN_BG);
		settingsBtn.setBackground(BTN_BG);

		textArea1.setForeground(Color.CYAN);
		textArea2.setForeground(Color.CYAN);

		zplusBtn.setForeground(FG_COLOR);
		zminBtn.setForeground(FG_COLOR);
		editBtn.setForeground(FG_COLOR);
		updateBtn.setForeground(FG_COLOR);
		selectBtn.setForeground(FG_COLOR);
		insertDivBtn.setForeground(FG_COLOR);
		insertDateBtn.setForeground(FG_COLOR);
		settingsBtn.setForeground(FG_COLOR);

		textArea1.setCaretColor(FG_COLOR);
		textArea2.setCaretColor(FG_COLOR);

		

		zplusBtn.setBorderPainted(false);
		zminBtn.setBorderPainted(false);
		editBtn.setBorderPainted(false);
		updateBtn.setBorderPainted(false);
		selectBtn.setBorderPainted(false);
		insertDivBtn.setBorderPainted(false);
		insertDateBtn.setBorderPainted(false);
		settingsBtn.setBorderPainted(false);


		var fontFamily = "Arial";
		textArea1.setFont(new Font("Consolas",0,fontSize));
		textArea2.setFont(new Font("Consolas",0,fontSize));
		lines1.setFont(new Font("Consolas",0,fontSize));
		lines2.setFont(new Font("Consolas",0,fontSize));
		var btnFontSize = 12;
		list.setFont(new Font(fontFamily,0,btnFontSize));
		editBtn.setFont(new Font(fontFamily,0,btnFontSize));
		updateBtn.setFont(new Font(fontFamily,0,btnFontSize));
		zminBtn.setFont(new Font(fontFamily,0,btnFontSize));
		zplusBtn.setFont(new Font(fontFamily,0,btnFontSize));
		selectBtn.setFont(new Font(fontFamily,0,btnFontSize));
		insertDivBtn.setFont(new Font(fontFamily,0,btnFontSize));
		insertDateBtn.setFont(new Font(fontFamily,0,btnFontSize));
		settingsBtn.setFont(new Font(fontFamily,0,btnFontSize));

		textArea1.setMargin(new Insets(2,12,2,2));
		textArea2.setMargin(new Insets(2,12,2,2));
		lines1.setMargin(new Insets(2,12,2,2));
		lines2.setMargin(new Insets(2,12,2,2));

		list.setSize(new Dimension(25,200));

		textArea1.setSelectedTextColor(Color.CYAN);
		textArea1.setSelectionColor(new Color(225,225,225,100));
		textArea2.setSelectedTextColor(Color.CYAN);
		textArea2.setSelectionColor(new Color(225,225,225,100));

		list.setToolTipText("Topic List");
		editBtn.setToolTipText("Edit Record Mode");
		updateBtn.setToolTipText("Update Record");
		zminBtn.setToolTipText("Decrement Font Size");
		zplusBtn.setToolTipText("Increment Font Size");
		selectBtn.setToolTipText("Copy Selected Text From The Left Panel to Right Panel");
		insertDivBtn.setToolTipText("Insert Horizontal line in Left Panel");
		insertDateBtn.setToolTipText("Insert Date in Left Panel");
		settingsBtn.setToolTipText("Settings");

		textArea1.setEditable(false);
		insertDivBtn.setEnabled(false);
		insertDateBtn.setEnabled(false);

		lines1.setBackground(BG_COLOR);
		lines1.setForeground(Color.WHITE);
		lines1.setEditable(false);
		textArea1.getDocument().addDocumentListener(new MyDocumentListener(textArea1,lines1));
		lines2.setBackground(BG_COLOR);
		lines2.setForeground(Color.WHITE);
		textArea2.getDocument().addDocumentListener(new MyDocumentListener(textArea2,lines2));
	}


	private void setComponentsLayout(){
		var ctnPane = getContentPane();
		ctnPane.setLayout(new BorderLayout());
		ctnPane.add(areaPnl,BorderLayout.CENTER);
		ctnPane.add(optionPnl,BorderLayout.NORTH);
		ctnPane.add(statusPnl,BorderLayout.SOUTH);

		areaPnl.setLayout(new BorderLayout());
		var jsp1 = new JScrollPane();
		jsp1.getViewport().add(textArea1);
		jsp1.setRowHeaderView(lines1);
		areaPnl.add(jsp1,BorderLayout.CENTER);
		var jsp2 = new JScrollPane();
		jsp2.getViewport().add(textArea2);
		jsp2.setRowHeaderView(lines2);
		jsp2.setPreferredSize(new Dimension(1000-550,700));;
		areaPnl.add(jsp2,BorderLayout.EAST);

		optionPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		optionPnl.add(settingsBtn);
		optionPnl.add(list);
		optionPnl.add(zplusBtn);
		optionPnl.add(zminBtn);
		optionPnl.add(insertDateBtn);
		optionPnl.add(insertDivBtn);
		optionPnl.add(selectBtn);
		optionPnl.add(editBtn);
		optionPnl.add(updateBtn);

	}
	private void readTopicContent(int topicIndex){
		for(int i = 0; i < UI.COMBO_LIST.length;i++){
			for(int j=0; j < UI.OBJ_FILE_NAME_LIST.length;j++){
				if(topicIndex == i && i == j){
					textArea1.setText("");
					textArea1.setText(FileHandler.readObjectFile(UI.DATA_FOLDERS[0]+UI.OBJ_FILE_NAME_LIST[j]).getContent());
					break;
				}
			}
		}
	}
	private void updateTopicContent(int topicIndex,String content){
		for(int i = 0; i < UI.COMBO_LIST.length;i++){
			for(int j=0; j < UI.OBJ_FILE_NAME_LIST.length;j++){
				if(topicIndex == i  && i == j){
					textArea1.setText("");
					FileHandler.createObjectFile(new ContentData(content),UI.DATA_FOLDERS[0]+UI.OBJ_FILE_NAME_LIST[j]);
					try{
						FileBackup.getFileBackupInstance().writeBackup(content,UI.DATA_FOLDERS[1]+UI.OBJ_FILE_NAME_LIST[j]);
					}catch(java.io.IOException ex){
						System.out.println(ex);
					}
					readTopicContent(topicIndex);
					break;
				}
			}
		}
	}
	private void setAction(){
		readTopicContent(list.getSelectedIndex());
		list.addActionListener((e)->{
			textArea1.setEditable(false);
			textArea1.setForeground(Color.CYAN);
			readTopicContent(list.getSelectedIndex());
		});
		updateBtn.addActionListener((e)->{
			var content =(String) textArea1.getText();
			updateTopicContent(list.getSelectedIndex(),content);
			textArea1.setEditable(false);
			textArea1.setForeground(Color.CYAN);
		});
		editBtn.addActionListener((e)->{
			textArea1.setEditable(true);
			textArea1.setForeground(Color.YELLOW);
			insertDateBtn.setEnabled(true);
			insertDivBtn.setEnabled(true);
		});
		selectBtn.addActionListener((e)->{
			textArea2.append(textArea1.getSelectedText());
		});
		insertDateBtn.addActionListener((e)->{
			textArea1.append("\n"+new java.util.Date()+"\n");
		});
		insertDivBtn.addActionListener((e)->{
			textArea1.append(UI.HORIZONTAL_DIVIDER);

		});
		zminBtn.addActionListener((e)->{
			textArea1.setFont(new Font("Consolas",0,fontSize));
			textArea2.setFont(new Font("Consolas",0,fontSize));
			lines1.setFont(new Font("Consolas",0,fontSize));
			lines2.setFont(new Font("Consolas",0,fontSize));
			fontSize--;
		});
		zplusBtn.addActionListener((e)->{
			textArea1.setFont(new Font("Consolas",0,fontSize));
			textArea2.setFont(new Font("Consolas",0,fontSize));
			lines1.setFont(new Font("Consolas",0,fontSize));
			lines2.setFont(new Font("Consolas",0,fontSize));
			fontSize++;
		});

		settingsBtn.addActionListener(e->{
			System.out.println("settings");
		});
	}
	
	private static class MyDocumentListener implements DocumentListener{
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
}





