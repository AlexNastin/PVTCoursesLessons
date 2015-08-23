package amybd.bin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.binding.StringBinding;

public class MainDAO {

	public static void main(String[] args) {

		int control = 0;
		MyDAO myDAO = null;
		Scanner in = new Scanner(System.in);

		char x = 'y';
		while (x == 'y') {
			System.out.println("�������: 1");
			System.out.println("�������� ������: 2");
			System.out.println("������� ������: 3");
			System.out.println("�������� ������: 4");
			System.out.println("�������� ������ ������: 5");
			System.out.println("����������: 6");
			System.out.println("�����: 7");
			System.out.print("�������� ��� �����: ");
			int choice = in.nextInt();

			switch (choice) {
			// �������
			case 1:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out.println("�������� �������: ");
				choice = in.nextInt();

				switch (choice) {
				case 1:
					System.out.println("������ ����� �������:");
					int numExpense = in.nextInt();
					System.out.println(myDAO.getExpense(numExpense));
					break;
				case 2:
					System.out.println("������ ����� �����������:");
					int numReceivers = in.nextInt();
					System.out.println(myDAO.getReceiver(numReceivers));
					break;
				}
				break;
			// ����������
			case 2:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("�������� ������� ���� ������ ������� ������: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("������� ����� �������: ");
					int numExpenseInsert = in.nextInt();
					System.out.println("������� ���� �������: ");
					String dateExpenseInsert = in.next();
					System.out.println("�������  �����������: ");
					int receiverExpenseInsert = in.nextInt();
					System.out.println("�������  ����� �������: ");
					double valueExpenseInsert = in.nextDouble();
					Expense expense = new Expense(numExpenseInsert,
							dateExpenseInsert, receiverExpenseInsert,
							valueExpenseInsert);
					control = myDAO.addExpense(expense);
					if (control == 1) {
						System.out.println("������ ������ ������ �������!");
					} else {
						System.out
								.println("������ ������ �� ���� �������������!");
					}
					break;
				case 2:
					System.out.println("������� ����� �����������: ");
					int numReceiverInsert = in.nextInt();
					System.out.println("������� ��� �����������: ");
					String nameReceiverInsert = in.nextLine();
					Receiver receiver = new Receiver(numReceiverInsert,
							nameReceiverInsert);
					control = myDAO.addReceiver(receiver);
					if (control == 1) {
						System.out.println("������ ������ ������ �������!");
					} else {
						System.out
								.println("������ ������ �� ���� �������������!");
					}
					break;
				}
				break;
			// ��������
			case 3:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("�������� ������� ������ ������ ������� ������: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("������� ����� �������: ");
					int numExpenseDelete = in.nextInt();
					control = myDAO.deleteExpense(numExpenseDelete);
					if (control == 1) {
						System.out.println("�������� ������ ������ �������!");
					} else {
						System.out.println("�������� �� ���������!");
					}
					break;
				case 2:
					System.out.println("������� ����� �����������: ");
					int numReceiverDelete = in.nextInt();
					control = myDAO.deleteReceiver(numReceiverDelete);
					if (control == 1) {
						System.out.println("�������� ������ ������ �������!");
					} else {
						System.out.println("�������� �� ���������!");
					}
					break;
				}
				break;
			// ���������
			case 4:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("�������� ������� ��� ������ �������� ������: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("������� ����� �������: ");
					int numExpenseUpdate = in.nextInt();
					System.out.println("������� ���� �������: ");
					String dateExpenseUpdate = in.next();
					System.out.println("�������  �����������: ");
					int receiverExpenseUpdate = in.nextInt();
					System.out.println("�������  ����� �������: ");
					double valueExpenseUpdate = in.nextDouble();
					control = myDAO.updateExpense(numExpenseUpdate,
							dateExpenseUpdate, receiverExpenseUpdate,
							valueExpenseUpdate);
					if (control == 1) {
						System.out.println("��������� ������ ������ �������!");
					} else {
						System.out.println("��������� �� ���������!");
					}
					break;
				case 2:
					System.out.println("������� ����� �����������: ");
					int numReceiverUpdate = in.nextInt();
					System.out.println("������� ��� �����������: ");
					String nameReceiverUpdate = in.nextLine();
					myDAO.updateReceiver(numReceiverUpdate, nameReceiverUpdate);
					if (control == 1) {
						System.out.println("��������� ������ ������ �������!");
					} else {
						System.out.println("��������� �� ���������!");
					}
				}
				break;
			// ������
			case 5:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("�������� ������� ��� �� �������� �� ������: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					ArrayList<Expense> listExpenses = new ArrayList<Expense>();
					listExpenses = myDAO.getExpenses();
					for (int i = 0; i < listExpenses.size(); i++) {
						System.out.println(listExpenses.get(i).getNum() + " "
								+ listExpenses.get(i).getDate() + " "
								+ listExpenses.get(i).getReceiver() + " "
								+ listExpenses.get(i).getValue());
					}
					break;
				case 2:
					ArrayList<Receiver> listReceivers = new ArrayList<Receiver>();
					listReceivers = myDAO.getReceivers();
					for (int i = 0; i < listReceivers.size(); i++) {
						System.out.println(listReceivers.get(i).getNum() + " "
								+ listReceivers.get(i).getName());
					}
					break;
				}
				break;
			case 6:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("1 - ����� �������� ������� �����������");
				System.out.println("2- ");
				System.out.println("3- ");
				System.out.println("�������� ����������: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					ArrayList<String> listString = new ArrayList<String>();
					listString = myDAO.statisticSumma();

					for (int i = 0; i < listString.size(); i++) {
						System.out.print(listString.get(i));
						System.out.println();
					}
					break;
				case 2:
				case 7:
					in.close();
					break;
				default:
					in.close();
					System.out.println("�������� ����");

				}
			}
			System.out.println("������ ����������: y/n");
			String yn = in.next();
			x = yn.charAt(0);
		}
		myDAO.closeConnection();
	}
}
