import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCVS {

	public static void main(String[] args) {
		ReadCVS obj = new ReadCVS();
		obj.run();

	}

	public void run() {

		String csvFile = "notes.csv";
		BufferedReader br = null;
		String line = "";
		// String cvsSplitBy = ",";

		try {
			String s = "";
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (line.isEmpty())
					continue;
				// use comma as separator
				// String[] column = line.split(cvsSplitBy);
				// if (column == null || column.length == 0)
				// || column.length < 121
				// || !Character.isDigit(column[0].charAt(0)))
				// continue;
				s += line;
			}
			try {
				Files.write(Paths.get("notes.txt"), s.getBytes(),
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				// exception handling left as an exercise for the reader
			}
			// PrintWriter out = new PrintWriter("notes.txt");
			// out.println(s);
			// out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}

}