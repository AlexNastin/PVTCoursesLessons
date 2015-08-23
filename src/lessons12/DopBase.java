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
		System.out.println("�������: 1");
		System.out.println("�������� ������: 2");
		System.out.println("������� ������: 3");
		System.out.println("�������� ������: 4");
		System.out.println("�����: 5");
		System.out.print("�������� ��� �����: ");
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
					.println("������� �� ������ ������� - 1 , ������� �� ��������(��������) - 2");
			System.out.print("�������� �����:");
			int choiceViborka = in.nextInt();
			switch (choiceViborka) {
			case 1:
				System.out.println("������� ����� �������(num): ");
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
					System.out.println("�������� � �������!");
				}

			case 2:
				System.out.println("������� ��������(value): ");
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
					System.out.println("�������� � �������!");
				}
			}
			break;
		case 2:
			System.out.println("������� ����� �������: ");
			int numInsert = in.nextInt();
			System.out.println("������� ���� �������: ");
			String dateInsert = in.next();
			System.out.println("�������  �����������: ");
			int receiverInsert = in.nextInt();
			System.out.println("�������  ����� �������: ");
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
				System.out.println("������ ������ ������ �������!");
			} else {
				System.out.println("������ ������ �� ���� �������������!");
			}
			break;
		case 3:
			System.out
					.println("������� ����� ������� ������� ������ �������: ");
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
				System.out.println("������ ������� �������!");
			} else {
				System.out.println("������ �� ��������!");
			}
			break;
		case 4:
			System.out.println("������� ����� ������� ������� ������ ��������: ");
			int numUpdate = in.nextInt();
			System.out.println("������� ����� ������:(������� ������� ������)");
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
				System.out.println("������ �������� �������!");
			} else {
				System.out.println("������ ��  ��������!");
			}

		case 5:
			in.close();
			break;
		default:
			in.close();
			System.out.println("�������� ����");

		}

	}
}
