package amybd.bin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class MyDAO implements DAO {

	private Connection myConnection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int intResultSet = 0;
	private static MyDAO inst;

	private MyDAO() {
		createConnection();
	}

	public static MyDAO getMyDAO() {
		if (inst == null) {
			inst = new MyDAO();
		}
		return inst;
	}

	private synchronized void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver" + cnfe);
		}
		String dbURL = "jdbc:mysql://localhost:3306/mydb";
		try {
			this.myConnection = DriverManager.getConnection(dbURL, "root",
					"1234p");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public synchronized void closeConnection() {
		try {
			myConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Expense getExpense(int num) {
		String queryGetExpense = "SELECT num, paydate,receiver,value FROM expenses WHERE num ="
				+ num;
		Expense expense = null;

		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(queryGetExpense);
			while (resultSet.next()) {

				expense = new Expense(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3),
						resultSet.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return expense;
	}

	@Override
	public Receiver getReceiver(int num) {
		String queryGetReceiver = "SELECT num, name FROM receivers WHERE num ="
				+ num;
		Receiver receiver = null;

		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(queryGetReceiver);
			while (resultSet.next()) {
				receiver = new Receiver(resultSet.getInt(1),
						resultSet.getString(2));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return receiver;
	}

	@Override
	public ArrayList<Expense> getExpenses() {
		ArrayList<Expense> listExpenses = new ArrayList<Expense>();
		String queryGetExpenses = "SELECT * FROM expenses";
		Expense expense = null;

		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(queryGetExpenses);
			while (resultSet.next()) {
				expense = new Expense(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3),
						resultSet.getDouble(4));
				listExpenses.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listExpenses;
	}

	@Override
	public ArrayList<Receiver> getReceivers() {
		ArrayList<Receiver> listReceivers = new ArrayList<Receiver>();
		String queryGetReceivers = "SELECT * FROM receivers";
		Receiver receiver = null;

		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(queryGetReceivers);
			while (resultSet.next()) {
				receiver = new Receiver(resultSet.getInt(1),
						resultSet.getString(2));
				listReceivers.add(receiver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listReceivers;
	}

	@Override
	public int addExpense(Expense exp) {
		String queryAddExpense = "INSERT INTO expenses VALUE(?,?,?,?)";
		try {
			preparedStatement = myConnection.prepareStatement(queryAddExpense);
			preparedStatement.setInt(1, exp.getNum());
			preparedStatement.setString(2, exp.getDate());
			preparedStatement.setInt(3, exp.getReceiver());
			preparedStatement.setDouble(4, exp.getValue());
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intResultSet;
	}

	@Override
	public int addReceiver(Receiver res) {
		String queryAddReceiver = "INSERT INTO receivers VALUE(?,?)";
		try {
			preparedStatement = myConnection.prepareStatement(queryAddReceiver);
			preparedStatement.setInt(1, res.getNum());
			preparedStatement.setString(2, res.getName());
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intResultSet;
	}

	@Override
	public int deleteExpense(int num) {
		String queryDeleteExpense = "DELETE FROM expenses WHERE num=?";
		try {
			preparedStatement = myConnection
					.prepareStatement(queryDeleteExpense);
			preparedStatement.setInt(1, num);
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return intResultSet;
	}

	@Override
	public int deleteReceiver(int num) {
		String queryDeleteReceiver = "DELETE FROM receivers WHERE num=?";
		try {
			preparedStatement = myConnection
					.prepareStatement(queryDeleteReceiver);
			preparedStatement.setInt(1, num);
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intResultSet;
	}

	@Override
	public int updateExpense(int num, String date, int receiver, double value) {
		String querySelectExpense = "SELECT num, paydate,receiver,value FROM expenses WHERE num ="
				+ num;
		Expense expense = null;

		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(querySelectExpense);
			while (resultSet.next()) {
				expense = new Expense(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3),
						resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String queryUpdateExpense = "UPDATE expenses SET paydate=?, receiver=?, value=? WHERE num=?;";
		try {
			preparedStatement = myConnection
					.prepareStatement(queryUpdateExpense);
			preparedStatement.setInt(4, num);
			if (date == "") {
				preparedStatement.setString(1, expense.getDate());
			} else {
				preparedStatement.setString(1, date);
			}
			if (receiver == 0) {
				preparedStatement.setInt(2, expense.getReceiver());
			} else {
				preparedStatement.setInt(2, receiver);
			}
			if (value == 0) {
				preparedStatement.setDouble(3, expense.getValue());
			} else {
				preparedStatement.setDouble(3, value);
			}
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intResultSet;
	}

	@Override
	public int updateReceiver(int num, String name) {
		String queryUpdateReceiver = "UPDATE receivers SET name = ? WHERE num=?";
		try {
			preparedStatement = myConnection
					.prepareStatement(queryUpdateReceiver);
			preparedStatement.setInt(2, num);
			preparedStatement.setString(1, name);
			intResultSet = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intResultSet;
	}

	@Override
	public ArrayList<String> statisticSumma() {
		String queryStatistic = "SELECT name, sum(value) FROM expenses, receivers rc WHERE receiver=rc.num  group by name";
		ArrayList<String> listStrings = new ArrayList<String>();
		try {
			statement = myConnection.createStatement();
			resultSet = statement.executeQuery(queryStatistic);
			while (resultSet.next()) {
				String statistic = resultSet.getString(1) + " "
						+ resultSet.getDouble(2);
				listStrings.add(statistic);
				statistic = "";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
	}
}
