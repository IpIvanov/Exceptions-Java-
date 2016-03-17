package FileExeptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class File {

	private String fileName;
	private String filePath;
	FileInputStream fstream = null;
	BufferedReader br = null;
	String strLine;

	public File(String fileName, String filePath) {
		this.setFileName(fileName);
		this.setFilePath(filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void readFromFile(String pathToFile) throws IOException {
		// Open the file
		fstream = new FileInputStream(pathToFile);
		br = new BufferedReader(new InputStreamReader(fstream));
		int lineNumber = 0;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			lineNumber++;
			try {
				if (this.isParsable(strLine)) {
					throw new ParseException(strLine, lineNumber);
				}

			} catch (ParseException e) {
				System.out.println("--------------------------");
				this.handleParseEception(strLine, lineNumber);
			}
		}

		// Close the input stream
		br.close();
	}

	public boolean isParsable(String strLine) throws FileNotFoundException {
		boolean parsable = false;
		try {
			Integer.parseInt(strLine);
		} catch (NumberFormatException e) {
			parsable = true;
		}
		return parsable;
	}

	public void handleParseEception(String strLine, int lineNumber) {
		if ("".equals(strLine)) {
			System.out.println("This line is empty: " + lineNumber);
		} else {
			System.out.println(strLine + " --> This is not a number and it is at line: " + lineNumber);
		}
	}

	public void printTextLine(String pathToFile) throws IOException {
		// Open the file
		fstream = new FileInputStream(pathToFile);
		br = new BufferedReader(new InputStreamReader(fstream));
		int lineNumber = 0;
		// Read File Line By Line
		System.out.println("Line     |    Content");
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			lineNumber++;
			System.out.println(lineNumber + "              " + strLine);
		}

		// Close the input stream
		br.close();
	}

}
