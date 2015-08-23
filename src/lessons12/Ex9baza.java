package lessons12;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex9baza {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("¬видите номер платежа: ");
		int num = in.nextInt();
		System.out.println("¬видите дату платежа: ");
		String date = in.next();
		System.out.println("¬видите  плательщика: ");
		int receiver = in.nextInt();
		System.out.println("¬видите  сумму платежа: ");
		double value = in.nextDouble();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);

		}
		String dbURL = "jdbc:mysql://localhost:3306/mydb";
		Connection myConnection = null;

		try {
			myConnection = DriverManager.getConnection(dbURL, "root", "1234p");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement statement = null;
		String query = "SELECT expenses.num, paydate, value, name FROM expenses,receivers WHERE  receiver= receivers.num ORDER BY expenses.num";
		String queryUpdate = "INSERT INTO expenses VALUES(" + num + "," + "\""+date
				+"\""+ "," + receiver + "," + value + ")";

		ResultSet resultSet = null;
		try {

			statement = myConnection.createStatement();
			statement.executeUpdate(queryUpdate);
			resultSet = statement.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " "
						+ resultSet.getDate(2) + " " + resultSet.getDouble(3)
						+ " " + resultSet.getString(4));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
