package amybd.bin;

import java.util.ArrayList;

public interface DAO {
	Expense getExpense(int num);
	Receiver getReceiver(int num);
	ArrayList<Expense> getExpenses();
	ArrayList<Receiver> getReceivers();
	int addExpense(Expense exp);
	int addReceiver(Receiver res);
	int deleteExpense(int num);
	int deleteReceiver(int num);
	int updateExpense(int num, String date, int receiver, double value);
	int updateReceiver(int num, String name);
	ArrayList<String> statisticSumma();
}
