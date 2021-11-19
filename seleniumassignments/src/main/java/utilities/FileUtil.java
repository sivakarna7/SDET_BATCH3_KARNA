package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modules.TestData;

public class FileUtil  {

	public static void writeNotepad(String s, String txtFileName) {
		TestData.file = new File(
				TestData.TestResults + SeleniumUtil.datestamp() + "/" + txtFileName + "_" + SeleniumUtil.timestamp() + ".txt");
		System.out.println("Writing to file: " + TestData.file);
		try {
			if (!TestData.file.isFile() && !TestData.file.canRead()) {
				TestData.file.createNewFile();
			}
			TestData.fr = new FileReader(TestData.file);
			/*
			 * int c; while ((c = fr.read()) != -1) { System.out.println((char) c); }
			 */
			TestData.fw = new FileWriter(TestData.file, true);
			TestData.fw.write(s);
			TestData.fw.close();
		} catch (Exception e) {
			System.out.println("Errored out");
		}
	}

	public static void CompareTextFiles(String srcFileName, String dstFileName) throws IOException {
		TestData.fileSrc = new BufferedReader(new FileReader(new File(srcFileName)));
		TestData.fileDst = new BufferedReader(new FileReader(new File(dstFileName)));
		String line1 = TestData.fileSrc.readLine();
		String line2 = TestData.fileDst.readLine();
		boolean areEqual = true;
		int lineNum = 1;
		while (line1 != null || line2 != null) {
			if (!line1.equals(line2)) {
				areEqual = false;
				System.out.println("Difference at Line: " + lineNum + " -> " + line1 + " <> " + line2);
			}
			line1 = TestData.fileSrc.readLine();
			line2 = TestData.fileDst.readLine();
			lineNum++;
		}
		if (areEqual) {
			System.out.println("Two files have same content.");
		} else {

		}
		TestData.fileSrc.close();
		TestData.fileDst.close();
	}
}
