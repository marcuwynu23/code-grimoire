# Manifest
# MANIFEST_TYPE=Main-Class
# MANIFEST_TYPE=Class-Path
# MANIFEST_VALUE=com.github.peculiar.codeManual.Main
# MANIFEST_VALUE=lib\peculiar-gui-v0.0.4.jar
PACKAGE=com.github.peculiar.codeGrimoire.view
JAVA_FILE=MyTextArea.java
# class root folder
CLASS_ROOT=com


ICON=icon.png
ICON_PATH=src\com\github\peculiar\codeGrimoire
ICON_PACKAGE=com\github\peculiar\codeGrimoire

all: compile-run clean-classes
	echo done.
compile-run:
	echo Compiling...
	jpb --compile
	xcopy /Y $(ICON_PATH)\$(ICON) $(ICON_PACKAGE)
	jar -uf dist\project.jar $(ICON_PACKAGE)\$(ICON)
	echo Running Application...
	jpb --run



add-to-Manifest:
		jpb --aim  $(MANIFEST_TYPE) $(MANIFEST_VALUE)

add-package:
	jpb --md $(PACKAGE)

add-class:
	jpb --cf $(PACKAGE) $(JAVA_FILE)

test:
	jpb --test

clean-classes:
	echo Cleaning class files...
	rd /Q /S $(CLASS_ROOT)

clean:
	echo Cleaning .jar and .exe..
	del dist\*.exe
	del dist\*.jar
