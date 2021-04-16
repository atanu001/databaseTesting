package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'Atanu';");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Resources\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		while (rs.next()) {

			driver.get("https://www.facebook.com/");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(rs.getString("location"));
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(rs.getString("age"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getString("age"));
		}

	}

}
