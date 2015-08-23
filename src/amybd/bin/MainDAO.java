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
			System.out.println("Выборка: 1");
			System.out.println("Добавить запись: 2");
			System.out.println("Удалить запись: 3");
			System.out.println("Изменить запись: 4");
			System.out.println("Получить список таблиц: 5");
			System.out.println("Статистика: 6");
			System.out.println("Выход: 7");
			System.out.print("Сделайте ваш выбор: ");
			int choice = in.nextInt();

			switch (choice) {
			// выборка
			case 1:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out.println("Выберете таблицу: ");
				choice = in.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Ведите номер платежа:");
					int numExpense = in.nextInt();
					System.out.println(myDAO.getExpense(numExpense));
					break;
				case 2:
					System.out.println("Ведите номер плательщика:");
					int numReceivers = in.nextInt();
					System.out.println(myDAO.getReceiver(numReceivers));
					break;
				}
				break;
			// добавление
			case 2:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("Выберете таблицу куда хотите добавть запись: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Ввидите номер платежа: ");
					int numExpenseInsert = in.nextInt();
					System.out.println("Ввидите дату платежа: ");
					String dateExpenseInsert = in.next();
					System.out.println("Ввидите  плательщика: ");
					int receiverExpenseInsert = in.nextInt();
					System.out.println("Ввидите  сумму платежа: ");
					double valueExpenseInsert = in.nextDouble();
					Expense expense = new Expense(numExpenseInsert,
							dateExpenseInsert, receiverExpenseInsert,
							valueExpenseInsert);
					control = myDAO.addExpense(expense);
					if (control == 1) {
						System.out.println("Запись записи прошла успешно!");
					} else {
						System.out
								.println("Запись записи не была осуществленна!");
					}
					break;
				case 2:
					System.out.println("Ввидите номер плательщика: ");
					int numReceiverInsert = in.nextInt();
					System.out.println("Введите имя плательщика: ");
					String nameReceiverInsert = in.nextLine();
					Receiver receiver = new Receiver(numReceiverInsert,
							nameReceiverInsert);
					control = myDAO.addReceiver(receiver);
					if (control == 1) {
						System.out.println("Запись записи прошла успешно!");
					} else {
						System.out
								.println("Запись записи не была осуществленна!");
					}
					break;
				}
				break;
			// удаление
			case 3:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("Выберете таблицу откуда хотите удалить запись: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Ввидите номер платежа: ");
					int numExpenseDelete = in.nextInt();
					control = myDAO.deleteExpense(numExpenseDelete);
					if (control == 1) {
						System.out.println("Удаление записи прошло успешно!");
					} else {
						System.out.println("Удаление не произошло!");
					}
					break;
				case 2:
					System.out.println("Ввидите номер плательщика: ");
					int numReceiverDelete = in.nextInt();
					control = myDAO.deleteReceiver(numReceiverDelete);
					if (control == 1) {
						System.out.println("Удаление записи прошло успешно!");
					} else {
						System.out.println("Удаление не произошло!");
					}
					break;
				}
				break;
			// изменение
			case 4:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("Выберете таблицу где хотите изменить запись: ");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Ввидите номер платежа: ");
					int numExpenseUpdate = in.nextInt();
					System.out.println("Ввидите дату платежа: ");
					String dateExpenseUpdate = in.next();
					System.out.println("Ввидите  плательщика: ");
					int receiverExpenseUpdate = in.nextInt();
					System.out.println("Ввидите  сумму платежа: ");
					double valueExpenseUpdate = in.nextDouble();
					control = myDAO.updateExpense(numExpenseUpdate,
							dateExpenseUpdate, receiverExpenseUpdate,
							valueExpenseUpdate);
					if (control == 1) {
						System.out.println("Изменение записи прошло успешно!");
					} else {
						System.out.println("Изменение не произошло!");
					}
					break;
				case 2:
					System.out.println("Ввидите номер плательщика: ");
					int numReceiverUpdate = in.nextInt();
					System.out.println("Введите имя плательщика: ");
					String nameReceiverUpdate = in.nextLine();
					myDAO.updateReceiver(numReceiverUpdate, nameReceiverUpdate);
					if (control == 1) {
						System.out.println("Изменение записи прошло успешно!");
					} else {
						System.out.println("Изменение не произошло!");
					}
				}
				break;
			// список
			case 5:
				if (myDAO == null) {
					myDAO = MyDAO.getMyDAO();
				}
				System.out.println("Expenses = 1, Receivers = 2 ");
				System.out
						.println("Выберете таблицу что бы получить ее список: ");
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
				System.out.println("1 - сумма платежей каждого плательщика");
				System.out.println("2- ");
				System.out.println("3- ");
				System.out.println("Выберете статистику: ");
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
					System.out.println("Неверный ввод");

				}
			}
			System.out.println("Хотите продложить: y/n");
			String yn = in.next();
			x = yn.charAt(0);
		}
		myDAO.closeConnection();
	}
}
