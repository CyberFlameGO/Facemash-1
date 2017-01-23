package com.alexnevsky.facemash.controller;

import com.alexnevsky.facemash.logic.FacebookFaceManager;
import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.utils.FacebookHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * User: Alex Nevsky
 * Date: 15.01.14
 */
@Controller
public class FaceController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		return "signin";
	}

	@RequestMapping(value = "/myFace", method = RequestMethod.GET)
	public String myFace() {
		return "show-face";
	}

	@RequestMapping(value = "/registerFace", method = RequestMethod.POST)
	public String registerFace(@RequestParam("facebookUrl") String facebookUrl, ModelMap model) {

		if (facebookUrl.length() > 200 || facebookUrl.length() < 10) {
			model.addAttribute("message", "Oops! Please fill the green form with right data!");
			return "signin";
		}

		String idString = null;
		if (facebookUrl.contains("facebook.com/") && facebookUrl.contains("profile.php?id=") && facebookUrl.contains("&")) {
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
			FacebookFaceManager.addFacebookFace(idString);

			Face face = FacebookHelper.makeFaceFromBasicUserData(FacebookHelper.getUserBasicData(idString));

			if (face != null) {
				model.addAttribute("message", "Glad to see you in the Game, " + face.getFirstName() + "!");
			} else {
				model.addAttribute("message", "Error! Can't process user by this link!");
				return "face";
			}

			Map<Long, Face> faceMap;
			if ("female".equalsIgnoreCase(face.getGender())) {
				faceMap = FacebookFaceManager.getGirlsFaceMap();
			} else {
				faceMap = FacebookFaceManager.getBoysFaceMap();
			}
			model.addAttribute("face", faceMap.get(face.getId()));
		}

		return "face";
	}

	@RequestMapping(value = "/showFace", method = RequestMethod.POST)
	public String showFace(@RequestParam("facebookUrl") String facebookUrl, ModelMap model) {

		if (facebookUrl.length() > 200 || facebookUrl.length() < 10) {
			model.addAttribute("message", "Oops! Please fill the green form with right data!");
			return "show-face";
		}

		String idString = null;
		if (facebookUrl.contains("facebook.com/") && facebookUrl.contains("profile.php?id=") && facebookUrl.contains("&")) {
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
			Face face = FacebookHelper.makeFaceFromBasicUserData(FacebookHelper.getUserBasicData(idString));

			Map<Long, Face> faceMap;
			if ("female".equalsIgnoreCase(face.getGender())) {
				faceMap = FacebookFaceManager.getGirlsFaceMap();
			} else {
				faceMap = FacebookFaceManager.getBoysFaceMap();
			}

			face = faceMap.get(face.getId());

			if (face != null) {
				model.addAttribute("message", "Glad to see you in the Game, " + face.getFirstName() + "!");
			} else {
				model.addAttribute("message", "Oops! User does not found! Please Sign In!");
				return "face";
			}

			model.addAttribute("face", face);
		} else {
			model.addAttribute("message", "Oops! Wrong link to facebook profile!");
		}

		return "face";
	}
}
