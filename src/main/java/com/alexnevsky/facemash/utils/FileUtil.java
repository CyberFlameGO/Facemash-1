package com.alexnevsky.facemash.utils;

import java.io.File;

/**
 * User: Alex Nevsky
 * Date: 21.10.13
 */
public class FileUtil {
	/**
	 * Returns extension of path without ".". For example, png, jpg etc.
	 *
	 * @param path
	 *            path to parse
	 * @return extension or null if no extension in given path
	 */
	public static String getPathExtension(final String path) {
		String result = null;

		if (path != null) {
			result = new String();
			if (path.lastIndexOf('.') != -1) {
				result = path.substring(path.lastIndexOf('.'));
				if (result.startsWith(".")) {
					result = result.substring(1);
				}
			}
		}

		return result;
	}

	/**
	 * Returns file name without extension.
	 *
	 * @param path
	 *            path to parse
	 * @return file name  without extension or null if no file name in given path
	 */
	public static String getFileNameWithoutExtension(final String path) {
		String result = null;

		if (path != null) {
			result = new String();
			if (path.lastIndexOf('/') != -1) {
				result = path.substring(path.lastIndexOf('/'));
			} else {
				result = path;
			}
			if (result.lastIndexOf('.') != -1) {
				result = result.substring(0, result.lastIndexOf('.'));
			}
			if (result.startsWith("/")) {
				result = result.substring(1);
			}
			if (result.startsWith(".")) {
				result = result.substring(1);
			}
		}

		return result;
	}

	/**
	 * Returns file size.
	 *
	 * @param file
	 * @return file size in bytes
	 * @see //http://stackoverflow.com/questions/116574/java-get-file-size-efficiently
	 */
	public static long getFileSize(File file) {
		if (file.exists()) {
			return file.length();
		} else {
			return 0;
		}
	}
}
