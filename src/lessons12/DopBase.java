package lessons12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DopBase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Выборка: 1");
		System.out.println("Добавить запись: 2");
		System.out.println("Удалить запись: 3");
		System.out.println("Изменить запись: 4");
		System.out.println("Выход: 5");
		System.out.print("Сделайте ваш выбор: ");
		int choice = in.nextInt();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection myConnection = null;
		String dbUDL = "jdbc:mysql://localhost:3306/mydb";
		if (choice < 5 && choice != 0) {
			try {
				myConnection = DriverManager.getConnection(dbUDL, "root",
						"1234p");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		switch (choice) {
		case 1:
			System.out
					.println("Выборка по номеру платежа - 1 , Выборка по значению(платежам) - 2");
			System.out.print("Сделайте выбор:");
			int choiceViborka = in.nextInt();
			switch (choiceViborka) {
			case 1:
				System.out.println("Введите номер платежа(num): ");
				int valueSelectNum = in.nextInt();
				String queryNum = "SELECT expenses.num, paydate, value, name FROM expenses,receivers WHERE receiver= receivers.num and expenses.num >="
						+ valueSelectNum + " ORDER BY num";

				try {

					statement = myConnection.createStatement();
					resultSet = statement.executeQuery(queryNum);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					while (resultSet.next()) {
						System.out.println(resultSet.getInt(1) + " "
								+ resultSet.getDate(2) + " "
								+ resultSet.getDouble(3) + " "
								+ resultSet.getString(4));

					}
				} catch (SQLException e) {
					System.out.println("Проблема с выводом!");
				}

			case 2:
				System.out.println("Введите значение(value): ");
				double valueSelectValue = in.nextDouble();
				String queryValue = "SELECT expenses.num, paydate, value, name FROM expenses,receivers WHERE  receiver= receivers.num and value >="
						+ valueSelectValue + "ORDER BY value";

				try {

					statement = myConnection.createStatement();
					resultSet = statement.executeQuery(queryValue);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					while (resultSet.next()) {
						System.out.println(resultSet.getInt(1) + " "
								+ resultSet.getDate(2) + " "
								+ resultSet.getDouble(3) + " "
								+ resultSet.getString(4));

					}
					myConnection.close();
				} catch (SQLException e) {
					System.out.println("Проблема с выводом!");
				}
			}
			break;
		case 2:
			System.out.println("Ввидите номер платежа: ");
			int numInsert = in.nextInt();
			System.out.println("Ввидите дату платежа: ");
			String dateInsert = in.next();
			System.out.println("Ввидите  плательщика: ");
			int receiverInsert = in.nextInt();
			System.out.println("Ввидите  сумму платежа: ");
			double valueInsert = in.nextDouble();

			String insertInto = "INSERT INTO expenses VALUE(?,?,?,?)";
			try {
				preparedStatement = myConnection.prepareStatement(insertInto);
				preparedStatement.setInt(1, numInsert);
				preparedStatement.setString(2, dateInsert);
				preparedStatement.setInt(3, receiverInsert);
				preparedStatement.setDouble(4, valueInsert);
				result = preparedStatement.executeUpdate();
				myConnection.close();
				in.close();
			} catch (SQLException e) {
			}
			if (result == 1) {
				System.out.println("Запись записи прошла успешно!");
			} else {
				System.out.println("Запись записи не была осуществленна!");
			}
			break;
		case 3:
			System.out
					.println("Ввидите номер платежа который хотите удалить: ");
			int numDelete = in.nextInt();

			String deleteFrom = "DELETE FROM expenses WHERE num=?";
			try {
				preparedStatement = myConnection.prepareStatement(deleteFrom);
				preparedStatement.setInt(1, numDelete);
				result = preparedStatement.executeUpdate();
				myConnection.close();
				in.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 1) {
				System.out.println("Запись удалена успешно!");
			} else {
				System.out.println("Запись не удаленна!");
			}
			break;
		case 4:
			System.out.println("Ввидите номер платежа который хотите изменить: ");
			int numUpdate = in.nextInt();
			System.out.println("ВВедите новый платеж:(который заменит старый)");
			double valueUpdate = in.nextDouble();

			String update = "UPDATE expenses SET value = ? WHERE num=?;";

			try {
				preparedStatement = myConnection.prepareStatement(update);
				preparedStatement.setInt(2, numUpdate);
				preparedStatement.setDouble(1, valueUpdate);
				result = preparedStatement.executeUpdate();
				myConnection.close();
				in.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 1) {
				System.out.println("Запись изменена успешно!");
			} else {
				System.out.println("Запись не  изменена!");
			}

		case 5:
			in.close();
			break;
		default:
			in.close();
			System.out.println("Неверный ввод");

		}

	}
}
