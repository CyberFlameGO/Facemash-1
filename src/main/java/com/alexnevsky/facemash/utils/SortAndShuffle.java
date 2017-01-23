package com.alexnevsky.facemash.utils;

import com.alexnevsky.facemash.model.Face;
import com.alexnevsky.facemash.storage.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * User: Alex Nevsky
 * Date: 08.10.13
 */
public class SortAndShuffle {

	private static final int TOP_TOTAL = 100;

	// Implementing Fisher–Yates shuffle
	public static long[] shuffleArray(long[] array) {
		Random rnd = new Random();
		for (int i = array.length - 1; i > 0; --i) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			long a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
		return array;
	}

	public static Face[] getGirlsFacebookTop() {
		List<Face> faceList = new ArrayList<Face>(Base.getInstance().getGirlsFacebookFaceMap().values());
		Collections.sort(faceList);

		int faceListSize = faceList.size();
		Face[] faces;
		if (faceListSize > TOP_TOTAL) {
			faces = new Face[TOP_TOTAL];
		} else {
			faces = new Face[faceListSize];
		}
		for (int i = 0; i < TOP_TOTAL && i < faceListSize; ++i) {
			faces[i] = faceList.get(i);
		}
		return faces;
	}

	public static Face[] getBoysFacebookTop() {
		List<Face> faceList = new ArrayList<Face>(Base.getInstance().getBoysFacebookFaceMap().values());
		Collections.sort(faceList);

		int faceListSize = faceList.size();
		Face[] faces;
		if (faceListSize > TOP_TOTAL) {
			faces = new Face[TOP_TOTAL];
		} else {
			faces = new Face[faceListSize];
		}
		for (int i = 0; i < TOP_TOTAL && i < faceListSize; ++i) {
			faces[i] = faceList.get(i);
		}
		return faces;
	}

	public static Face[] getGirlsTop() {
		List<Face> faceList = new ArrayList<Face>(Base.getInstance().getGirlsFaceMap().values());
		Collections.sort(faceList);

		int faceListSize = faceList.size();
		Face[] faces;
		if (faceListSize > TOP_TOTAL) {
			faces = new Face[TOP_TOTAL];
		} else {
			faces = new Face[faceListSize];
		}
		for (int i = 0; i < TOP_TOTAL && i < faceListSize; ++i) {
			faces[i] = faceList.get(i);
		}
		return faces;
	}

	public static Face[] getBoysTop() {
		List<Face> faceList = new ArrayList<Face>(Base.getInstance().getBoysFaceMap().values());
		Collections.sort(faceList);

		int faceListSize = faceList.size();
		Face[] faces;
		if (faceListSize > TOP_TOTAL) {
			faces = new Face[TOP_TOTAL];
		} else {
			faces = new Face[faceListSize];
		}
		for (int i = 0; i < TOP_TOTAL && i < faceListSize; ++i) {
			faces[i] = faceList.get(i);
		}
		return faces;
	}
}
