package com.alexnevsky.facemash.controller;

import com.alexnevsky.facemash.logic.FaceManager;
import com.alexnevsky.facemash.logic.FacebookFaceManager;
import com.alexnevsky.facemash.logic.RatingManager;
import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.utils.CryptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * User: Alex Nevsky
 * Date: 22.11.13
 */
@Controller
public class MobileController {

	public static boolean isDemo;

	@RequestMapping(value = "/updateFacesFromMobile", method = RequestMethod.POST)
	public void updateFacesFromAndroid(@RequestParam("hash") String hash,
	                                   @RequestParam("leftId") String leftId,
	                                   @RequestParam("rightId") String rightId,
	                                   @RequestParam("mode") String mode,
	                                   @RequestParam("leftOrRight") String leftOrRight) {
		if (hash.equals(leftId + CryptUtils.SOLT + rightId)) {
			if ("left".equalsIgnoreCase(leftOrRight)) {
				RatingManager.updateFaceRating(Long.valueOf(leftId), Long.valueOf(rightId), mode);
			} else {
				RatingManager.updateFaceRating(Long.valueOf(rightId), Long.valueOf(leftId), mode);
			}
		} // else somebody want to hack us
	}

	@RequestMapping(value = "/addFacebookUser", method = RequestMethod.POST)
	public void addFacebookUser(@RequestParam("id") String id) {
		FacebookFaceManager.addFacebookFace(id);
	}

	@RequestMapping(value = "/getFacebookUserRating", method = RequestMethod.GET)
	public String getFacebookUserRating(@RequestParam("id") String id, ModelMap model) {
		String code = "0";
		Map<Long, Face> girlsMap = FacebookFaceManager.getGirlsFaceMap();
		if (girlsMap.containsKey(Long.valueOf(id))) {
			code = String.valueOf(girlsMap.get(Long.valueOf(id)).getRating());
		} else {
			Map<Long, Face> boysMap = FacebookFaceManager.getBoysFaceMap();
			if (boysMap.containsKey(Long.valueOf(id))) {
				code = String.valueOf(boysMap.get(Long.valueOf(id)).getRating());
			}
		}

		model.addAttribute("code", code);

		return "help";
	}

	@RequestMapping(value = "/getShuffleFaceIdArray", method = RequestMethod.GET)
	public String getShuffleFaceIdArray(@RequestParam("mode") String mode, ModelMap model) {
		StringBuilder sb = new StringBuilder(1024);

		long[] faceIdArray;

		if ("girlsFacebook".equalsIgnoreCase(mode)) {
			faceIdArray = FacebookFaceManager.getShuffleGirlsFaceIdArray();
		} else if ("boysFacebook".equalsIgnoreCase(mode)) {
			faceIdArray = FacebookFaceManager.getShuffleBoysFaceIdArray();
		} else if ("girls".equalsIgnoreCase(mode)) {
			faceIdArray = FaceManager.getShuffleGirlsFaceIdArray();
		} else {
			faceIdArray = FaceManager.getShuffleBoysFaceIdArray();
		}

		for (long l : faceIdArray) {
			sb.append(l);
			sb.append(",");
		}

		model.addAttribute("code", sb.toString().trim().substring(0, sb.toString().length() - 1));

		return "help";
	}


	@RequestMapping(value = "/checkIsDemo", method = RequestMethod.GET)
	public String checkIsDemo(ModelMap model) {
		if (!isDemo) {
			model.addAttribute("code", "NO");
		} else {
			model.addAttribute("code", "YES");
		}

		return "help";
	}
}
