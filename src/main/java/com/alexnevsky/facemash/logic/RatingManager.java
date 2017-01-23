package com.alexnevsky.facemash.logic;

import com.alexnevsky.facemash.storage.Base;

/**
 * User: Alex Nevsky
 * Date: 14.10.13
 */
public class RatingManager {

	public static void updateFaceRating(Long hotFaceId, Long notHotFaceId, String mode) {
		int ra;
		int rb;

		if ("girlsFacebook".equalsIgnoreCase(mode)) {
			ra = Base.getInstance().getGirlsFacebookFaceMap().get(hotFaceId).getRating();
			rb = Base.getInstance().getGirlsFacebookFaceMap().get(notHotFaceId).getRating();
		} else if ("boysFacebook".equalsIgnoreCase(mode)) {
			ra = Base.getInstance().getBoysFacebookFaceMap().get(hotFaceId).getRating();
			rb = Base.getInstance().getBoysFacebookFaceMap().get(notHotFaceId).getRating();
		}else if ("girls".equalsIgnoreCase(mode)) {
			ra = Base.getInstance().getGirlsFaceMap().get(hotFaceId).getRating();
			rb = Base.getInstance().getGirlsFaceMap().get(notHotFaceId).getRating();
		} else {
			ra = Base.getInstance().getBoysFaceMap().get(hotFaceId).getRating();
			rb = Base.getInstance().getBoysFaceMap().get(notHotFaceId).getRating();
		}

		int k = 15;
		double ea = 1 / (1 + Math.pow(10, ( (rb - ra) / 400)));
		double eb = 1 / (1 + Math.pow(10, ( (ra - rb) / 400)));

		ra += ( k * (1 - ea));
		rb += ( k * (0 - eb));

		if ("girlsFacebook".equalsIgnoreCase(mode)) {
			Base.getInstance().getGirlsFacebookFaceMap().get(hotFaceId).setRating(ra);
			Base.getInstance().getGirlsFacebookFaceMap().get(notHotFaceId).setRating(rb);
		} else if ("boysFacebook".equalsIgnoreCase(mode)) {
			Base.getInstance().getBoysFacebookFaceMap().get(hotFaceId).setRating(ra);
			Base.getInstance().getBoysFacebookFaceMap().get(notHotFaceId).setRating(rb);
		} else if ("girls".equalsIgnoreCase(mode)) {
			Base.getInstance().getGirlsFaceMap().get(hotFaceId).setRating(ra);
			Base.getInstance().getGirlsFaceMap().get(notHotFaceId).setRating(rb);
		} else {
			Base.getInstance().getBoysFaceMap().get(hotFaceId).setRating(ra);
			Base.getInstance().getBoysFaceMap().get(notHotFaceId).setRating(rb);
		}
	}
}
