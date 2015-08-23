package lessons9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Ex21 {

	public static void main(String[] args) {

		DataOutputStream writefile = null;
		DataInputStream readfile = null;
		int read = 0;
		int sred = 0, col = 0;

		try {
			writefile = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream("C:/Java/2.dat")));
			readfile = new DataInputStream(new BufferedInputStream(
					new FileInputStream("C:/Java/2.dat")));

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 20; i++) {
			int cluch = (int) (Math.random() * 100 + 1);
			try {
				writefile.writeInt(cluch);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		try {
			writefile.close();

			read = readfile.readInt();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			System.out.print(read + " ");
			try {
				read = readfile.readInt();
				sred += read;
				col++;
			} catch (IOException e) {
				break;
			}

		}
		sred = sred / col;
		try {
			readfile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Cреднее арифмитическое: "+sred);
		
	}

}
