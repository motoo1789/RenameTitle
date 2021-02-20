package reader;

import java.io.File;
import java.util.ArrayList;

public class FileReader {

	public FileReader() {
		readFiles();
	}

	public void readFiles()
	{
		final String path = "./";
		final String extension = "pdf";
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
	}
}
