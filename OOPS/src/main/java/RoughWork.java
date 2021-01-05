import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RoughWork {
	static Properties prop;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selinium NaveenAUto Lab\\OOPS\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));

	}

}
