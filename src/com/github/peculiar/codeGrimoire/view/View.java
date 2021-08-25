package com.github.peculiar.codeGrimoire.view; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import com.github.peculiar.codeGrimoire.io.FileHandler;
import com.github.peculiar.codeGrimoire.io.FileBackup;
import com.github.peculiar.codeGrimoire.model.ContentData;

public class View extends JFrame{
	private JPanel optionPnl,statusPnl;
	private JSplitPane jspn;
	private MyTextArea textArea1,textArea2;
	private static MyTextArea lines1;
	private static MyTextArea lines2;

	private MyButton editBtn,updateBtn,zplusBtn,zminBtn,selectBtn;
	private MyButton insertDivBtn;
	private MyButton insertDateBtn;
	private MyButton addHighlighterBtn;
	private MyButton clearBtn;
	private MyButton copyBtn;
	private MyButton printBtn;
	private MyButton exitBtn;
	private JComboBox list;
	private int fontSize = 16;

	public View(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			System.out.println(ex);
		}
		setSize(UI.WIDTH,UI.HEIGHT);
		setMinimumSize(new Dimension(UI.WIDTH,UI.HEIGHT));
		setTitle(UI.APP_TITLE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(UI.ICON_PATH)));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setVisible(true);
		setComponents();
		setComponentUI();
		setComponentsLayout(getContentPane());
		setActionEvent();

	}
	private void setComponents(){
		jspn = new JSplitPane();
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
		printBtn = new MyButton("Print");
		exitBtn = new MyButton("X");
		list = new JComboBox(UI.COMBO_LIST);


	}
	private void setComponentUI(){

		jspn.setBorder(BorderFactory.createLineBorder( new Color(50,50,50),12));
		jspn.setDividerSize(4);
		jspn.setDividerLocation(UI.WIDTH);

		var BG_COLOR = new Color(50,50,50);
		var FG_COLOR = Color.WHITE;
		var BTN_BG = new Color(40,40,40);

		jspn.setBackground(BG_COLOR);
		statusPnl.setBackground(BG_COLOR);
		optionPnl.setBackground(BG_COLOR);

		textArea1.setUIColor(BG_COLOR,new Color(69,246,122),FG_COLOR,new Color(69,246,122),new Color(225,225,225,100));
		textArea2.setUIColor(BG_COLOR,new Color(69,246,122),FG_COLOR,new Color(69,246,122),new Color(225,225,225,100));
		lines1.setUIColor(new Color(45,45,45),Color.WHITE,FG_COLOR,new Color(69,246,122),new Color(225,225,225,100));
		lines2.setUIColor(new Color(45,45,45),Color.WHITE,FG_COLOR,new Color(69,246,122),new Color(225,225,225,100));

		textArea1.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,true,true);
		textArea2.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,true,true);
		lines1.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,false,false);
		lines2.setUI(new Font("Consolas",0,fontSize),new Insets(2,12,2,2),4,false,false);

		var fontFamily = "Arial";
		var btnFontSize = 12;
		list.setFont(new Font(fontFamily,0,btnFontSize));
		
		editBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[1]);
		updateBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[2]);
		zminBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[3]);
		zplusBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[4]);
		selectBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[5]);
		insertDivBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[6]);
		insertDateBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[7]);
		addHighlighterBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[8]);
		clearBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[9]);
		copyBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[10]);
		printBtn.setUI(BTN_BG,FG_COLOR,new Font(fontFamily,0,btnFontSize),UI.TOOL_TIPS[11]);

		exitBtn.setBackground(Color.RED);

		textArea1.setEditable(false);
		lines1.setEditable(false);

		insertDivBtn.setEnabled(false);
		insertDateBtn.setEnabled(false);
		
		textArea1.getDocument().addDocumentListener(new MyDocumentListener(textArea1,lines1));
		textArea2.getDocument().addDocumentListener(new MyDocumentListener(textArea2,lines2));

		list.setToolTipText(UI.TOOL_TIPS[0]);
	}



	private void setComponentsLayout(Container ctnPane){
		jspn.setOrientation(JSplitPane.VERTICAL_SPLIT);
		var jsp1 = new JScrollPane();
		jsp1.setBorder(BorderFactory.createLineBorder(new Color(45,45,45),1));
		jsp1.getViewport().add(textArea1);
		jsp1.setRowHeaderView(lines1);
		jspn.setLeftComponent(jsp1);


		var jsp2 = new JScrollPane();
		jsp2.setBorder(BorderFactory.createLineBorder(new Color(45,45,45),1));
		jsp2.getViewport().add(textArea2);
		jsp2.setRowHeaderView(lines2);
		jsp2.setPreferredSize(new Dimension(1000-550,700));;
		jspn.setRightComponent(jsp2);

		optionPnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
		optionPnl.add(list);
		optionPnl.add(zplusBtn);
		optionPnl.add(zminBtn);
		optionPnl.add(insertDateBtn);
		optionPnl.add(insertDivBtn);
		optionPnl.add(addHighlighterBtn);
		optionPnl.add(editBtn);
		optionPnl.add(updateBtn);
		optionPnl.add(clearBtn);
		optionPnl.add(selectBtn);
		optionPnl.add(copyBtn);
		optionPnl.add(printBtn);
		optionPnl.add(exitBtn);

		ctnPane.setLayout(new BorderLayout());
		ctnPane.add(jspn,BorderLayout.CENTER);
		ctnPane.add(optionPnl,BorderLayout.NORTH);
		ctnPane.add(statusPnl,BorderLayout.SOUTH);

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
			textArea1.setForeground(new Color(69,246,122));
			readTopicContent(list.getSelectedIndex());
		});
		updateBtn.addActionListener(e->{
			var content =(String) textArea1.getText();
			updateTopicContent(list.getSelectedIndex(),content);
			textArea1.setEditable(false);
			textArea1.setForeground(new Color(69,246,122));
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


		final UndoManager undoManager = new UndoManager();
		textArea1.getDocument().addUndoableEditListener(undoManager);
		textArea1.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent e){
				try{
					if(e.getKeyChar() == 26){
						undoManager.undo();
					}
					if(e.getKeyChar() == 25){
						undoManager.redo();
					}
				}catch(Exception ex){
					
				}
			}
		});

		textArea2.getDocument().addUndoableEditListener(undoManager);
		textArea2.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent e){
				try{
					if(e.getKeyChar() == 26){
						undoManager.undo();
					}
					if(e.getKeyChar() == 25){
						undoManager.redo();
					}
				}catch(Exception ex){
					
				}
			}
		});


		printBtn.addActionListener(e-> {
			try{
				textArea2.setForeground(Color.BLACK);
				textArea2.setBackground(Color.WHITE);
				textArea2.print();
				textArea2.setForeground(new Color(69,246,122));
				textArea2.setBackground(new Color(50,50,50));

			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,ex);
			}
		});
		exitBtn.addActionListener(e-> System.exit(0));
	}
}



