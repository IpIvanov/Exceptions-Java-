package FileExeptions;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		File fileObject = new File("TextFile",
				"C:\\PRJ\\EclipseWorkspace\\Exceptions\\src\\FileExeptions\\textfile.txt");

		System.out.println(fileObject.getFileName());
		fileObject.printTextLine(fileObject.getFilePath());
		fileObject.readFromFile(fileObject.getFilePath());
	}

}
