package com.sag.fin.wealthmgmt.util;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class random {
	public static String randomID() {
		int randomNum = ThreadLocalRandom.current().nextInt(256, 423545);
		return String.valueOf(randomNum);
	}


}
