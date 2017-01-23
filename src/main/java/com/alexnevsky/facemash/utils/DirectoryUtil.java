package com.alexnevsky.facemash.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * User: Alex Nevsky
 * Date: 21.10.13
 */
public class DirectoryUtil {
	/**
	 * Finds files within a given directory (and optionally its subdirectories)
	 * which match an array of extensions.
	 *
	 * @param directory
	 *            the directory to search in
	 * @param extensions
	 *            an array of extensions, ex. {"java","xml"}. If this parameter
	 *            is null, all files are returned.
	 * @param recursive
	 *            if true all subdirectories are searched as well
	 * @return a collection of java.io.File with the matching files or null if the directory not
	 *         exist
	 */
	public static Collection<File> listFiles(String directory, String[] extensions, boolean recursive) {
		Collection<File> files = null;

		File fileDir = new File(directory);

		if (fileDir.exists()) {
			files = org.apache.commons.io.FileUtils.listFiles(fileDir, extensions, recursive);
		}

		return files;
	}

	/**
	 * Makes a directory, including any necessary but nonexistent parent directories.
	 *
	 * @param path
	 *            directory to create
	 * @return true if the directory has been created successfully
	 */
	public static boolean createDir(final String path) {
		boolean isSuccess = false;

		if (path != null) {
			try {
				org.apache.commons.io.FileUtils.forceMkdir(new File(path));
				isSuccess = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return isSuccess;
	}
}
