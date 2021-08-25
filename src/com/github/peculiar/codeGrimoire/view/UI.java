package com.github.peculiar.codeGrimoire.view; 

public class UI{
	protected static final String APP_TITLE = "Peculiar Code Grimoire v0.01";
	protected static final int WIDTH = 1200, HEIGHT = 700;
	protected static final String[] COMBO_LIST ={
		"Development Logs","Java Manual and Snippets","Python3 Manual and Snippets",
		"C Manual and Snippets","C++ Manual and Snippets","SQLite3 Manual and Snippets",
		"Project Journal","Project Ideas and Video Topics ","Sites Account"
	};
	protected static final String[] BTN_NAMES = {
		"Edit Content","Update Content","+",
		"-","Copy Selected","Insert Divider",
		"Insert Date","Highlighter text","Clear",
		"Copy"
	};
	protected static final String[] OBJ_FILE_NAME_LIST = {
		"devLogs.grimoire","java.grimoire","python3.grimoire",
		"c.grimoire","c++.grimoire",
		"sqlite3.grimoire","journal.grimoire",
		"projectIdeas.grimoire","sitesAccount.grimoire"
	};

	protected static final String[] TOOL_TIPS = {
		"Topic List","Edit Record Mode","Update Record Mode",
		"Decrement Font Size","Increment Font Size",
		"Copy Selected Text From The Top Panel to Bottom Panel",
		"Insert Horizontal line in Top Panel",
		"Insert Date in Top Panel","Highlighter text",
		"clear content from Bottom panel","Copy Bottom Panel Content to Clipboard",
		"print Bottom Panel Content"
	};
	protected static final String HORIZONTAL_DIVIDER = "\n=========================================================\n";
	protected static final String[] DATA_FOLDERS ={"data\\","data\\backup\\"};
	protected static final String ICON_PATH = "/com/github/peculiar/codeGrimoire/icon.png";
}
