package com.alexnevsky.facemash.controller;

import com.alexnevsky.facemash.storage.Base;
import com.alexnevsky.facemash.utils.Constants;
import com.alexnevsky.facemash.utils.DirectoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

/**
 * User: Alex Nevsky
 * Date: 22.11.13
 */
@Controller
public class AdminController {

	private static String PASSWORD = "";

	@RequestMapping(value = "/alex", method = RequestMethod.GET)
	public String alexGet() {
		return "login";
	}

	@RequestMapping(value = "/say", method = RequestMethod.POST)
	public String alexPost(@RequestParam("message") String message, ModelMap model) {
		if (PASSWORD.equals(message)) {
			model.addAttribute("password", PASSWORD);

			return "alex";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/alexBase", method = RequestMethod.POST)
	public String alexBase(@RequestParam("password") String password,
	                         @RequestParam("base") String base,
	                         ModelMap model) {
		if (PASSWORD.equals(password)) {
			model.addAttribute("password", PASSWORD);

			String code = "Hi there... ";

			if ("save".equals(base)) {
				DirectoryUtil.createDir(Constants.FACEMASH_SERVER_STATIC_DIR);

				File file = new File(Constants.FACEMASH_SERVER_BASE_PATH);
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
						code += e.toString();
					}
				}

				try {
					FileOutputStream fileOut = new FileOutputStream(Constants.FACEMASH_SERVER_BASE_PATH);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);

					out.writeObject(Base.getInstance());

					out.close();
					fileOut.close();

					code += "Base saved.";
				} catch (IOException e) {
					e.printStackTrace();
					code += e.toString();
				}
			} else if ("load".equals(base)) {
				try {
					FileInputStream fileIn = new FileInputStream(Constants.FACEMASH_SERVER_BASE_PATH);
					ObjectInputStream in = new ObjectInputStream(fileIn);

					Base.getInstance().loadBase((Base)in.readObject());

					in.close();
					fileIn.close();

					code += "Base loaded.";
				} catch (IOException e) {
					e.printStackTrace();
					code += e.toString();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					code += e.toString();
				}
			}

			model.addAttribute("code", code);

			return "alex";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/alexRemove", method = RequestMethod.POST)
	public String alexRemove(@RequestParam("password") String password,
	                       @RequestParam("facebookUrl") String facebookUrl,
	                       ModelMap model) {
		if (PASSWORD.equals(password)) {
			model.addAttribute("password", PASSWORD);

			if (facebookUrl.length() > 200 || facebookUrl.length() < 10) {
				model.addAttribute("message", "Oops! Please fill the green form with right data!");
			}

			String idString = null;
			if (facebookUrl.contains("facebook.com/") && facebookUrl.contains("profile.php?id=") && facebookUrl
					.contains("&")) {
				idString = facebookUrl.substring(facebookUrl.indexOf("profile.php?id="), facebookUrl.indexOf("&"));
				idString = idString.substring(idString.indexOf("=") + 1);
			} else if (facebookUrl.contains("facebook.com/") && facebookUrl.contains("profile.php?id=")) {
				idString = facebookUrl.substring(facebookUrl.indexOf("profile.php?id="));
				idString = idString.substring(idString.indexOf("=") + 1);
			} else if (facebookUrl.contains("facebook.com/") && facebookUrl.contains("?")) {
				idString = facebookUrl.substring(facebookUrl.indexOf("facebook.com/"));
				idString = idString.substring(idString.indexOf(".com/"));
				idString = idString.substring(idString.indexOf("/") + 1, idString.indexOf("?"));
			}  else if (facebookUrl.contains("facebook.com/")) {
				idString = facebookUrl.substring(facebookUrl.indexOf("facebook.com/"));
				idString = idString.substring(idString.indexOf("/") + 1);
			}

			if (idString != null) {
				if (Base.getInstance().getGirlsFacebookFaceMap().remove(new Long(idString)) != null) {
					model.addAttribute("code", "Girl with " + idString + " removed from the Game!");
				} else if (Base.getInstance().getBoysFacebookFaceMap().remove(new Long(idString)) != null) {
					model.addAttribute("code", "Boy with " + idString + " removed from the Game!");
				}
			} else {
				model.addAttribute("code", "Oops! Wrong url!");
			}

			return "alex";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/alexDemo", method = RequestMethod.POST)
	public String alexDemo(@RequestParam("password") String password,
	                       @RequestParam("isDemo") String isDemo,
	                       ModelMap model) {
		if (PASSWORD.equals(password)) {
			model.addAttribute("password", PASSWORD);

			String code = "Hi there... ";

			if ("YES".equals(isDemo)) {
				MobileController.isDemo = true;
				code = "isDemo set to true";
			} else if ("NO".equals(isDemo)) {
				MobileController.isDemo = false;
				code = "isDemo set to false";
			}

			model.addAttribute("code", code);

			return "alex";
		} else {
			return "redirect:/";
		}
	}
}
