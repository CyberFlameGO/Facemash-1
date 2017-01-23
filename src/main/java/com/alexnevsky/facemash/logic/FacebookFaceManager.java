package com.alexnevsky.facemash.logic;

import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.storage.Base;
import com.alexnevsky.facemash.utils.FacebookHelper;
import com.alexnevsky.facemash.utils.SortAndShuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

/**
 * User: Alex Nevsky
 * Date: 16.11.13
 */
public class FacebookFaceManager {

	public static void addFacebookFace(String facebookId) {
		String userData = FacebookHelper.getUserBasicData(facebookId);
		Face face = FacebookHelper.makeFaceFromBasicUserData(userData);

		if (face != null && face.getGender() != null) {
			Map<Long, Face> map;
			if (face.getGender().equalsIgnoreCase("female")) {
				map = Base.getInstance().getGirlsFacebookFaceMap();
			} else {
				map = Base.getInstance().getBoysFacebookFaceMap();
			}

			if (!map.containsKey(face.getId())) {
				map.put(face.getId(), face);
			} else {
				// update picture path
				Face oldFace = map.get(face.getId());
				oldFace.setPathToImage(face.getPathToImage());
			}
		}
	}

	public static long[] getShuffleGirlsFaceIdArray() {
		Map map = FacebookFaceManager.getGirlsFaceMap();

		Object[] idArray = map.keySet().toArray();

		// return max 1000 id
		int start;
		int end;

		if (idArray.length > 1000) {
			start = randInt(0, idArray.length - 1000);
			end = start + 1000;
		} else {
			start = 0;
			end = idArray.length;
		}

		long[] array = new long[idArray.length];
		int count = 0;
		for (Object obj : idArray) {
			array[count] = Long.valueOf(obj.toString());
			count += 1;
		}

		return SortAndShuffle.shuffleArray(Arrays.copyOfRange(array, start, end));
	}

	public static long[] getShuffleBoysFaceIdArray() {
		Map map = FacebookFaceManager.getBoysFaceMap();

		Object[] idArray = map.keySet().toArray();

		// return max 1000 id
		int start;
		int end;

		if (idArray.length > 1000) {
			start = randInt(0, idArray.length - 1000);
			end = start + 1000;
		} else {
			start = 0;
			end = idArray.length;
		}

		long[] array = new long[idArray.length];
		int count = 0;
		for (Object obj : idArray) {
			array[count] = Long.valueOf(obj.toString());
			count += 1;
		}

		return SortAndShuffle.shuffleArray(Arrays.copyOfRange(array, start, end));
	}

	public static Map<Long, Face> getGirlsFaceMap() {
		return Collections.unmodifiableMap(Base.getInstance().getGirlsFacebookFaceMap());
	}

	public static Map<Long, Face> getBoysFaceMap() {
		return Collections.unmodifiableMap(Base.getInstance().getBoysFacebookFaceMap());
	}

	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
