package controller;

/**
 *	@author Ariana Fairbanks
 *	A file chooser
 */


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;




public class FileChooser
{

	public static String getMediaPath(String fileName)
	{
		String path = null;
		String directory = getMediaDirectory();
		path = directory + fileName;
		return path;
	}

	public static String pickPath(JFileChooser fileChooser)
	{
		String path = null;
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);

		int returnVal = fileChooser.showOpenDialog(frame);

		if (returnVal == JFileChooser.APPROVE_OPTION)
			path = fileChooser.getSelectedFile().getPath();
		return path;
	}


	public String pickAFile()
	{
		JFileChooser fileChooser = null;
		String fileName = null;
		String mediaDir = getMediaDirectory();


		try
		{
			File file = new File(mediaDir);
			if (file.exists())
				fileChooser = new JFileChooser(file);
		}
		catch (Exception ex)
		{
			
		}

		if (fileChooser == null)
			fileChooser = new JFileChooser();

		fileName = pickPath(fileChooser);

		return fileName;
	}


	public static String getMediaDirectory()
	{
		String directory = null;
		File dirFile = null;


		try
		{

			URL classURL = FileChooser.class.getResource("FileChooser.class");
			URL fileURL = new URL(classURL, "../images/");
			directory = fileURL.getPath();
			directory = URLDecoder.decode(directory, "UTF-8");
			dirFile = new File(directory);
			if (dirFile.exists())
			{
				return directory;
			}
		}
		catch (MalformedURLException ex)
		{
			ex.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return directory;
	}

}