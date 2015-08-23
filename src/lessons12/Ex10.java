package lessons12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Ввидите номер платежа: ");
		int num = in.nextInt();
		System.out.println("Ввидите дату платежа: ");
		String date = in.next();
		System.out.println("Ввидите  плательщика: ");
		int receiver = in.nextInt();
		System.out.println("Ввидите  сумму платежа: ");
		double value = in.nextDouble();

		String dbURL = "jdbc:mysql://localhost:3306/mydb";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver:" + e);
		}

		Connection myConnection = null;
		PreparedStatement preparedStatement;
		int resultSet = 0;
		ResultSet resultSet1 = null;
		String selectValue = "SELECT expenses.num, paydate, name, value FROM expenses, receivers WHERE receiver=receivers.num and value >= ?";
		String insertInto = "INSERT INTO expenses VALUE(?,?,?,?)";

		try {
			myConnection = DriverManager.getConnection(dbURL, "root", "1234p");
			preparedStatement = myConnection.prepareStatement(insertInto);
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, date);
			preparedStatement.setInt(3, receiver);
			preparedStatement.setDouble(4, value);
			resultSet = preparedStatement.executeUpdate();
			if (resultSet == 1) {
				System.out.println("Запись прошла успешно!");
			} else {
				System.out.println("Запись не была осуществленна!");
			}
			System.out.println("Видите для поиска value: ");
			double valueSelect = in.nextDouble();
			preparedStatement = myConnection.prepareStatement(selectValue);
			preparedStatement.setDouble(1, valueSelect);
			resultSet1 = preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet1.next()) {
				System.out.println(resultSet1.getInt(1) + " "
						+ resultSet1.getDate(2) + " " + resultSet1.getString(3)
						+ " " + resultSet1.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
