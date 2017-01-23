package com.alexnevsky.facemash.logic;

import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.storage.Base;
import com.alexnevsky.facemash.utils.SortAndShuffle;

import java.util.Collections;
import java.util.Map;

/**
 * User: Alex Nevsky
 * Date: 08.10.13
 */
public class FaceManager {

	public static long[] getShuffleGirlsFaceIdArray() {
		return SortAndShuffle.shuffleArray(Base.getInstance().getGirlsFaceIdArray());
	}

	public static long[] getShuffleBoysFaceIdArray() {
		return SortAndShuffle.shuffleArray(Base.getInstance().getBoysFaceIdArray());
	}

	public static Map<Long, Face> getGirlsFaceMap() {
		return Collections.unmodifiableMap(Base.getInstance().getGirlsFaceMap());
	}

	public static Map<Long, Face> getBoysFaceMap() {
		return Collections.unmodifiableMap(Base.getInstance().getBoysFaceMap());
	}
}
