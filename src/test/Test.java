


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Test{
	public static void main(String[] args){
		FileHandler.createObjectFile(new person(),"test.obj");
	}
}

class FileHandler {

	public static void createObjectFile(person data, String filePath) {
		try {
			var objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
			objectOutputStream.writeObject((Object)data);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static person readObjectFile(String filePath) {
		person obj;
		try {
			var objectInputStream = new ObjectInputStream(new FileInputStream(new File(filePath)));
			obj = (person) objectInputStream.readObject();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
class person implements java.io.Serializable{

}