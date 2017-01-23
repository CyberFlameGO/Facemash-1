package com.alexnevsky.facemash.controller;

import com.alexnevsky.facemash.logic.FaceManager;
import com.alexnevsky.facemash.logic.FacebookFaceManager;
import com.alexnevsky.facemash.logic.RatingManager;
import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.utils.SortAndShuffle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * User: Alex Nevsky
 * Date: 04.10.13
 */
@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMain(@RequestParam(value = "mode", required = false) String mode, ModelMap model) {
		if (mode == null) {
			mode = "girls";
		}
		model.addAttribute("mode", mode);

		long[] shuffleFaceIdArray;
		Map<Long, Face> faceMap;
		if ("girlsFacebook".equalsIgnoreCase(mode)) {
			shuffleFaceIdArray = FacebookFaceManager.getShuffleGirlsFaceIdArray();
			faceMap = FacebookFaceManager.getGirlsFaceMap();
		} else if ("boysFacebook".equalsIgnoreCase(mode)) {
			shuffleFaceIdArray = FacebookFaceManager.getShuffleBoysFaceIdArray();
			faceMap = FacebookFaceManager.getBoysFaceMap();
		} else if ("girls".equalsIgnoreCase(mode)) {
			shuffleFaceIdArray = FaceManager.getShuffleGirlsFaceIdArray();
			faceMap = FaceManager.getGirlsFaceMap();
		} else {
			shuffleFaceIdArray = FaceManager.getShuffleBoysFaceIdArray();
			faceMap = FaceManager.getBoysFaceMap();
		}

		if (shuffleFaceIdArray.length > 1) {
			Long leftFaceId = Long.valueOf(shuffleFaceIdArray[0]);
			Long rightFaceId = Long.valueOf(shuffleFaceIdArray[1]);

			Face leftFace = faceMap.get(leftFaceId);
			Face rightFace = faceMap.get(rightFaceId);

			model.addAttribute("leftFace", leftFace);
			model.addAttribute("rightFace", rightFace);

			model.addAttribute("leftFaceRating", leftFace.getRating());
			model.addAttribute("rightFaceRating", rightFace.getRating());

			model.addAttribute("faceIdArrayToNextPage", Arrays.copyOfRange(shuffleFaceIdArray, 2,
					shuffleFaceIdArray.length));
		}

		return "index";
	}

	@RequestMapping(value = "/left", method = RequestMethod.GET)
	public String redirectFromLeft() {
		return "redirect:/";
	}

	@RequestMapping(value = "/left", method = RequestMethod.POST)
	public String leftFace(@RequestParam("faceIdArrayToNextPage") long[] faceIdArrayToNextPage,
	                       @RequestParam("leftId") long leftId,
	                       @RequestParam("rightId") long rightId,
	                       @RequestParam("mode") String mode,
	                       ModelMap model) {
		prepareNextFaces(faceIdArrayToNextPage, leftId, rightId, mode, model, "left");

		return "index";
	}

	@RequestMapping(value = "/right", method = RequestMethod.GET)
	public String redirectFromRight() {
		return "redirect:/";
	}

	@RequestMapping(value = "/right", method = RequestMethod.POST)
	public String rightFace(@RequestParam("faceIdArrayToNextPage") long[] faceIdArrayToNextPage,
	                        @RequestParam("leftId") long leftId,
	                        @RequestParam("rightId") long rightId,
	                        @RequestParam("mode") String mode,
	                        ModelMap model) {
		prepareNextFaces(faceIdArrayToNextPage, leftId, rightId, mode, model, "right");

		return "index";
	}

	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String redirectFromNext(@RequestParam(value = "mode", required = false) String mode) {
		if (mode != null) {
			return "redirect:/?mode=" + mode;
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String showTop(ModelMap model) {
		Face[] girlsFaces = SortAndShuffle.getGirlsTop();
		Face[] boysFaces = SortAndShuffle.getBoysTop();

		model.addAttribute("girlsTop", girlsFaces);
		model.addAttribute("maxGirlsRating", girlsFaces[0].getRating());

		model.addAttribute("boysTop", boysFaces);
		model.addAttribute("maxBoysRating", boysFaces[0].getRating());

		return "top";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String showAbout() {
		return "about";
	}

	private void prepareNextFaces(long[] faceIdArrayToNextPage,
	                              long leftId,
	                              long rightId,
	                              String mode,
	                              ModelMap model,
	                              String leftOrRight) {
		if (mode == null) {
			mode = "girlsFacebook";
		}
		model.addAttribute("mode", mode);

		if ("left".equalsIgnoreCase(leftOrRight)) {
			RatingManager.updateFaceRating(Long.valueOf(leftId), Long.valueOf(rightId), mode);
		} else {
			RatingManager.updateFaceRating(Long.valueOf(rightId), Long.valueOf(leftId), mode);
		}

		Map<Long, Face> faceMap;
		if ("girlsFacebook".equalsIgnoreCase(mode)) {
			faceMap = FacebookFaceManager.getGirlsFaceMap();
		} else if ("boysFacebook".equalsIgnoreCase(mode)) {
			faceMap = FacebookFaceManager.getBoysFaceMap();
		} else if ("girls".equalsIgnoreCase(mode)) {
			faceMap = FaceManager.getGirlsFaceMap();
		} else {
			faceMap = FaceManager.getBoysFaceMap();
		}

		List<Long> nextList = new ArrayList<Long>();
		for (long l : faceIdArrayToNextPage) {
			if (l > 0) {
				nextList.add(l);
			}
		}

		long[] newFaceIdArrayToNextPage = new long[nextList.size()];
		for (int i = 0; i < nextList.size(); ++i) {
			newFaceIdArrayToNextPage[i] = nextList.get(i);
		}

		Long leftFaceId = Long.valueOf(newFaceIdArrayToNextPage[0]);
		Long rightFaceId = Long.valueOf(newFaceIdArrayToNextPage[1]);

		model.addAttribute("leftFace", faceMap.get(leftFaceId));
		model.addAttribute("rightFace", faceMap.get(rightFaceId));

		faceIdArrayToNextPage = Arrays.copyOfRange(newFaceIdArrayToNextPage, 2, newFaceIdArrayToNextPage.length);
		model.addAttribute("faceIdArrayToNextPage", faceIdArrayToNextPage);

		if (faceIdArrayToNextPage.length < 2) {
			if ("girlsFacebook".equalsIgnoreCase(mode)) {
				model.addAttribute("faceIdArrayToNextPage", FacebookFaceManager.getShuffleGirlsFaceIdArray());
			} else if ("boysFacebook".equalsIgnoreCase(mode)) {
				model.addAttribute("faceIdArrayToNextPage", FacebookFaceManager.getShuffleBoysFaceIdArray());
			} else if ("girls".equalsIgnoreCase(mode)) {
				model.addAttribute("faceIdArrayToNextPage", FaceManager.getShuffleGirlsFaceIdArray());
			} else {
				model.addAttribute("faceIdArrayToNextPage", FaceManager.getShuffleBoysFaceIdArray());
			}
			model.addAttribute("message", "Okay, well done! Choose one more to start the next round!");
		}
	}
}
