package com.github.peculiar.codeGrimoire.view; 
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import com.github.peculiar.codeGrimoire.io.FileHandler;
import com.github.peculiar.codeGrimoire.io.FileBackup;
import com.github.peculiar.codeGrimoire.model.ContentData;

public class View extends JFrame{
	private JPanel areaPnl,optionPnl,statusPnl;
	private MyTextArea textArea1,textArea2;
	private static MyTextArea lines1;
	private static MyTextArea lines2;

	private MyButton editBtn,updateBtn,zplusBtn,zminBtn,selectBtn;
	private MyButton insertDivBtn;
	private MyButton insertDateBtn;
	private MyButton addHighlighterBtn;
	private MyButton clearBtn;
	private MyButton copyBtn;
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
		setComponentsLayout(getContentPane());
		setActionEvent();

	}
	private void setComponents(){
		areaPnl = new JPanel();
		optionPnl = new JPanel();
		statusPnl = new JPanel();
		textArea1 = new MyTextArea();
		textArea2 = new MyTextArea();
		lines1 = new MyTextArea("1");
		lines2 = new MyTextArea("1");

		editBtn = new MyButton(UI.BTN_NAMES[0]);
		updateBtn = new MyButton(UI.BTN_NAMES[1]);
		zplusBtn = new MyButton(UI.BTN_NAMES[2]);
		zminBtn = new MyButton(UI.BTN_NAMES[3]);
		selectBtn = new MyButton(UI.BTN_NAMES[4]);
		insertDivBtn = new MyButton(UI.BTN_NAMES[5]);
		insertDateBtn = new MyButton(UI.BTN_NAMES[6]);
		addHighlighterBtn = new MyButton(UI.BTN_NAMES[7]);
		clearBtn = new MyButton(UI.BTN_NAMES[8]);
		copyBtn = new MyButton(UI.BTN_NAMES[9]);
		list = new JComboBox(UI.COMBO_LIST);


	}
	private void setComponentUI(){
		var BG_COLOR = new Color(45,45,45);
		var FG_COLOR = Color.WHITE;
		var BTN_BG = new Color(40,40,40);
		
		areaPnl.setBackground(BG_COLOR);
		statusPnl.setBackground(BG_COLOR);
		optionPnl.setBackground(BG_COLOR);

		textArea1.setUIColor(BG_COLOR,Color.CYAN,FG_COLOR,Color.CYAN,new Color(225,225,225,100));
		textArea2.setUIColor(BG_COLOR,Color.CYAN,FG_COLOR,Color.CYAN,new Color(225,225,225,100));
		lines1.setUIColor(BTN_BG,Color.WHITE,FG_COLOR,Color.CYAN,new Color(225,225,225,100));
		lines2.setUIColor(BTN_BG,Color.WHITE,FG_COLOR,Color.CYAN,new Color(225,225,225,100));

		textArea1.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,true,true);
		textArea2.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,true,true);
		lines1.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,false,false);
		lines2.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,false,false);

		var fontFamily = "Arial";
		var btnFontSize = 12;
		list.setFont(new Font(fontFamily,0,btnFontSize));
		
		editBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[1]);
		updateBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[2]);
		zminBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[3]);
		zplusBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[4]);
		selectBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[5]);
		insertDivBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[6]);
		insertDateBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[7]);
		addHighlighterBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[8]);
		clearBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[9]);
		copyBtn.setUI(BG_COLOR,FG_COLOR,false,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[10]);

		textArea1.setEditable(false);
		lines1.setEditable(false);

		insertDivBtn.setEnabled(false);
		insertDateBtn.setEnabled(false);
		
		textArea1.getDocument().addDocumentListener(new MyDocumentListener(textArea1,lines1));
		textArea2.getDocument().addDocumentListener(new MyDocumentListener(textArea2,lines2));

		list.setToolTipText(UI.TOOL_TIPS[0]);
	}



	private void setComponentsLayout(Container ctnPane){
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
		optionPnl.add(list);
		optionPnl.add(zplusBtn);
		optionPnl.add(zminBtn);
		optionPnl.add(insertDateBtn);
		optionPnl.add(insertDivBtn);
		optionPnl.add(addHighlighterBtn);
		optionPnl.add(selectBtn);
		optionPnl.add(clearBtn);
		optionPnl.add(copyBtn);
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
	private void setActionEvent(){
		readTopicContent(list.getSelectedIndex());
		list.addActionListener(e->{
			textArea1.setEditable(false);
			textArea1.setForeground(Color.CYAN);
			readTopicContent(list.getSelectedIndex());
		});
		updateBtn.addActionListener(e->{
			var content =(String) textArea1.getText();
			updateTopicContent(list.getSelectedIndex(),content);
			textArea1.setEditable(false);
			textArea1.setForeground(Color.CYAN);
		});
		editBtn.addActionListener(e->{
			textArea1.setEditable(true);
			textArea1.setForeground(Color.YELLOW);
			insertDateBtn.setEnabled(true);
			insertDivBtn.setEnabled(true);
		});
		selectBtn.addActionListener(e->{
			textArea2.append(textArea1.getSelectedText());
		});
		insertDateBtn.addActionListener(e->{
			textArea1.append("\n"+new java.util.Date()+"\n");
		});
		insertDivBtn.addActionListener(e->{
			textArea1.append(UI.HORIZONTAL_DIVIDER);

		});
		zminBtn.addActionListener(e->{
			textArea1.setFont(new Font("Consolas",0,fontSize));
			textArea2.setFont(new Font("Consolas",0,fontSize));
			lines1.setFont(new Font("Consolas",0,fontSize));
			lines2.setFont(new Font("Consolas",0,fontSize));
			fontSize--;
		});
		zplusBtn.addActionListener(e->{
			textArea1.setFont(new Font("Consolas",0,fontSize));
			textArea2.setFont(new Font("Consolas",0,fontSize));
			lines1.setFont(new Font("Consolas",0,fontSize));
			lines2.setFont(new Font("Consolas",0,fontSize));
			fontSize++;
		});

		addHighlighterBtn.addActionListener(e->{
			var highlighter = textArea1.getHighlighter();
			var painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(225,225,225,100));
			int p1 = 0,p2 = 0; 
			try{
				p1 = textArea1.getSelectionStart();
				p2 = textArea1.getSelectionEnd();
				highlighter.addHighlight(p1,p2,painter);
			}catch(BadLocationException ex){
				System.out.println(ex);
			}
		});
		clearBtn.addActionListener(e->{
			textArea2.setText("");
		});
		copyBtn.addActionListener(e->{
			textArea2.selectAll();
			textArea2.copy();
		});
	}
}



