package com.alexnevsky.facemash.controller;

import com.alexnevsky.facemash.utils.DirectoryUtil;
import com.alexnevsky.facemash.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * User: Alex Nevsky
 * Date: 11.10.13
 */
@Controller
public class HelpController {

	@RequestMapping(value = "importGirls", method = RequestMethod.GET)
	public String importGirls(ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		String fileName = "/Users/alexnevsky/Pictures/Facemash/gen/girls.txt";

		InputStream fis;
		BufferedReader br;
		String line;

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

			String path;
			String firstName;
			String lastName;
			while ((line = br.readLine()) != null) {
				// Deal with the line
				path = "/resources/faces/girls/" + line;
				if (line.indexOf("_") > 0) {
					firstName = line.substring(0, line.indexOf("_"));
					lastName  = line.replaceFirst(firstName + "_", "").replaceAll("_", " ");
					lastName = lastName.substring(0, lastName.indexOf("."));
				} else {
					firstName = "";
					lastName = line.substring(0, line.indexOf("."));
				}

				sb.append("face = new Face(\"");
				sb.append(firstName);
				sb.append("\", \"");
				sb.append(lastName);
				sb.append("\", \"");
				sb.append(path);
				sb.append("\");");
				sb.append("<br>");
				sb.append("girlsFaceMap.put(face.getId(), face);<br>");
			}

			// Done with the file
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("code", sb.toString());

		return "help";
	}

	@RequestMapping(value = "importBoys", method = RequestMethod.GET)
	public String importBoys(ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		String fileName = "/Users/alexnevsky/Pictures/Facemash/gen/boys.txt";

		InputStream fis;
		BufferedReader br;
		String line;

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

			String path;
			String firstName;
			String lastName;
			while ((line = br.readLine()) != null) {
				// Deal with the line
				path = "/resources/faces/boys/" + line;
				if (line.indexOf("_") > 0) {
					firstName = line.substring(0, line.indexOf("_"));
					lastName  = line.replaceFirst(firstName + "_", "").replaceAll("_", " ");
					lastName = lastName.substring(0, lastName.indexOf("."));
				} else {
					firstName = "";
					lastName = line.substring(0, line.indexOf("."));
				}

				sb.append("face = new Face(\"");
				sb.append(firstName);
				sb.append("\", \"");
				sb.append(lastName);
				sb.append("\", \"");
				sb.append(path);
				sb.append("\");");
				sb.append("<br>");
				sb.append("boysFaceMap.put(face.getId(), face);<br>");
			}

			// Done with the file
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("code", sb.toString());

		return "help";
	}

	@RequestMapping(value = "importiOSGirls", method = RequestMethod.GET)
	public String importiOSGirls(ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		String fileName = "/Users/alexnevsky/Pictures/Facemash/gen/girls.txt";

		InputStream fis;
		BufferedReader br;
		String line;

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

			String firstName;
			String lastName;
			while ((line = br.readLine()) != null) {
				// Deal with the line
				if (line.indexOf("_") > 0) {
					firstName = line.substring(0, line.indexOf("_"));
					lastName  = line.replaceFirst(firstName + "_", "").replaceAll("_", " ");
					lastName = lastName.substring(0, lastName.indexOf("."));
				} else {
					firstName = "";
					lastName = line.substring(0, line.indexOf("."));
				}

				sb.append("face = [[Face alloc] initWithFirstName:@\"");
				sb.append(firstName);
				sb.append("\" andLastName:@ \"");
				sb.append(lastName);
				sb.append("\" andPathToImage:@ \"");
				sb.append(line);
				sb.append("\"];");
				sb.append("<br>");
				sb.append("[girlsFaceMap setObject:face forKey:[face faceId]];<br>");
			}

			// Done with the file
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("code", sb.toString());

		return "help";
	}

	@RequestMapping(value = "importiOSBoys", method = RequestMethod.GET)
	public String importiOSBoys(ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		String fileName = "/Users/alexnevsky/Pictures/Facemash/gen/boys.txt";

		InputStream fis;
		BufferedReader br;
		String line;

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

			String firstName;
			String lastName;
			while ((line = br.readLine()) != null) {
				// Deal with the line
				if (line.indexOf("_") > 0) {
					firstName = line.substring(0, line.indexOf("_"));
					lastName  = line.replaceFirst(firstName + "_", "").replaceAll("_", " ");
					lastName = lastName.substring(0, lastName.indexOf("."));
				} else {
					firstName = "";
					lastName = line.substring(0, line.indexOf("."));
				}

				sb.append("face = [[Face alloc] initWithFirstName:@\"");
				sb.append(firstName);
				sb.append("\" andLastName:@ \"");
				sb.append(lastName);
				sb.append("\" andPathToImage:@ \"");
				sb.append(line);
				sb.append("\"];");
				sb.append("<br>");
				sb.append("[boysFaceMap setObject:face forKey:[face faceId]];<br>");
			}

			// Done with the file
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("code", sb.toString());

		return "help";
	}

	@RequestMapping(value = "createAndroidFaces", method = RequestMethod.GET)
	public String createAndroidFaces(ModelMap model) {
		DirectoryUtil.createDir("/Users/alexnevsky/Pictures/Facemash/android/faces");

		Collection<File> boysFacesFileCollection = DirectoryUtil.listFiles
				("/Users/alexnevsky/Pictures/Facemash/boys",
				new String[]{"jpg"}, true);
		Collection<File> girlsFacesFileCollection = DirectoryUtil.listFiles
				("/Users/alexnevsky/Pictures/Facemash/girls",
				new String[]{"jpg"}, true);

		for (File f : boysFacesFileCollection) {
			String name = FileUtil.getFileNameWithoutExtension(f.getAbsolutePath()).toLowerCase();
			name = name.replaceAll("-", "_");
			File androidFile = new File(
					"/Users/alexnevsky/Pictures/Facemash/android/faces/faces_boys_"
							+ name
							+ ".jpg");
			try {
				org.apache.commons.io.FileUtils.copyFile(f, androidFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (File f : girlsFacesFileCollection) {
			String name = FileUtil.getFileNameWithoutExtension(f.getAbsolutePath()).toLowerCase();
			name = name.replaceAll("-", "_");
			File androidFile = new File(
					"/Users/alexnevsky/Pictures/Facemash/android/faces/faces_girls_"
							+ name
							+ ".jpg");
			try {
				org.apache.commons.io.FileUtils.copyFile(f, androidFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("code", "Done!");

		return "help";
	}

	@RequestMapping(value = "importAndroidFaces", method = RequestMethod.GET)
	public String importAndroidFaces(ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		String fileName = "/Users/alexnevsky/Pictures/Facemash/android/gen/faces.txt";

		InputStream fis;
		BufferedReader br;
		String line;

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

			String path;
			String firstName;
			String lastName;
			while ((line = br.readLine()) != null) {
				// Deal with the line
				boolean isGirls = false;
				path = FileUtil.getFileNameWithoutExtension(line);
				if (line.indexOf("boys") != -1) {
					line = line.substring("faces_boys_".length());
				} else {
					isGirls = true;
					line = line.substring("faces_girls_".length());
				}
				if (line.indexOf("_") > 0) {
					firstName = line.substring(0, line.indexOf("_"));
					lastName  = line.replaceFirst(firstName + "_", "").replaceAll("_", " ");
					lastName = lastName.substring(0, lastName.indexOf("."));
				} else {
					firstName = "";
					lastName = line.substring(0, line.indexOf("."));
				}

				if (firstName.length() > 0) {
					firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
					if (firstName.indexOf(" ") > -1) {
						firstName = firstName.substring(0, firstName.indexOf(" "))
								+ firstName.substring(firstName.indexOf(" "), firstName.indexOf(" ") + 2).toUpperCase()
								+ firstName.substring(firstName.indexOf(" ") + 2);
					}
					if (firstName.indexOf(" ") > -1) {
						firstName = firstName.substring(0, firstName.indexOf(" "))
								+ firstName.substring(firstName.indexOf(" "), firstName.indexOf(" ") + 2).toUpperCase()
								+ firstName.substring(firstName.indexOf(" ") + 2);
					}
				}

				if (lastName.length() > 0) {
					lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
					if (lastName.indexOf(" ") > -1) {
						lastName = lastName.substring(0, lastName.indexOf(" "))
								+ lastName.substring(lastName.indexOf(" "), lastName.indexOf(" ") + 2).toUpperCase()
								+ lastName.substring(lastName.indexOf(" ") + 2);
					}
					if (lastName.indexOf(" ") > -1) {
						lastName = lastName.substring(0, lastName.indexOf(" "))
								+ lastName.substring(lastName.indexOf(" "), lastName.indexOf(" ") + 2).toUpperCase()
								+ lastName.substring(lastName.indexOf(" ") + 2);
					}
				}

				sb.append("face = new Face(\"");
				sb.append(firstName);
				sb.append("\", \"");
				sb.append(lastName);
				sb.append("\", \"");
				sb.append(path);
				sb.append("\");");
				sb.append("<br>");
				if (!isGirls) {
					sb.append("boysFaceMap.put(face.getId(), face);<br>");
				} else {
					sb.append("girlsFaceMap.put(face.getId(), face);<br>");
				}
			}

			// Done with the file
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("code", sb.toString());

		return "help";
	}
}
