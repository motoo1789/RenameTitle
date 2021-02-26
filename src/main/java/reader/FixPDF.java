package reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FixPDF {

	final private String path = "./";
	final private String extension = "pdf";

	public static FixPDF singleton = FixPDF.getInstance();

	private FixPDF() {

	}

	public static FixPDF getInstance() {
		return new FixPDF();
	}

	public ArrayList<String> readFiles()
	{

		ArrayList<String> returnfiles = new ArrayList<String>();

		File cdirectory = new File(path);
		File cdfiles[] = cdirectory.listFiles();

		System.out.println(cdirectory.getAbsolutePath());

		for(File file : cdfiles)
		{
			String allFilename = file.getName();
			String isExtension = allFilename.substring(allFilename.lastIndexOf(".") + 1);

			if(extension.equals(isExtension))
			{
				String subFilename = allFilename.substring(0, allFilename.lastIndexOf("."));
				returnfiles.add(subFilename);
			}
		}

		for(int index = 0; index < returnfiles.size(); index++)
		{
			System.out.println("index" + index + " " +  returnfiles.get(index));
		}

		return returnfiles;
	}

	public void renamePDFTitle(String beforeFilename, String newFilename)
	{
		System.out.println("before" + beforeFilename);
		System.out.println("after" + newFilename);
		File file = new File(path + beforeFilename + "." + extension);
		file.renameTo(new File(path + newFilename + "." + extension));

	}
}
