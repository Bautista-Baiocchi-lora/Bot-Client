package com.client.api.utils;


public class Time {
	public static boolean sleep(SleepCondition conn, int timeout) {
		long start = System.currentTimeMillis();
		while (!conn.isValid()) {
			if (start + timeout < System.currentTimeMillis()) {
				return false;
			}
			Time.sleep(50);
		}
		return true;
	}

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
