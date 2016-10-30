package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CalculationReport {

	static void saveToFile(String content) throws IOException {
		FileWriter writer = new FileWriter("d:\\test.txt");
		BufferedWriter out = new BufferedWriter(writer);
		out.write(content);
		out.close();
	}

}
