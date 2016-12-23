package com.error22.thelta.virtualsystem;

import com.google.common.primitives.UnsignedLongs;

public class ALU {

	public static byte addBytes(byte a, byte b) {
		return (byte) ((a + b) & 0xFF);
	}

	public static int ubyteToInt(byte value) {
		return value & 0xFF;
	}

	public static String ubyteToString(byte value) {
		return Integer.toString(ubyteToInt(value));
	}

	public static short addShorts(short a, short b) {
		return (short) ((a + b) & 0xffff);
	}

	public static String sbyteToString(byte value) {
		return Byte.toString(value);
	}

	public static int ushortToInt(short value) {
		return value & 0xffff;
	}

	public static String ushortToString(short value) {
		return Integer.toString(ushortToInt(value));
	}

	public static String sshortToString(short value) {
		return Short.toString(value);
	}

	public static int addInts(int a, int b) {
		return (a + b) & 0xffffffff;
	}

	public static int subInts(int a, int b) {
		return (a - b) & 0xffffffff;
	}

	public static int timesInts(int a, int b) {
		return (int) (a * b) & 0xffffffff;
	}

	public static int divideUInts(int a, int b) {
		return ((int) (uintToLong(a) / uintToLong(b))) & 0xffffffff;
	}

	public static int modUInts(int a, int b) {
		return ((int) (uintToLong(a) % uintToLong(b))) & 0xffffffff;
	}

	public static long uintToLong(int value) {
		return value & 0xffffffffL;
	}

	public static long intToLong(int value) {
		return value;
	}

	public static String uintToString(int value) {
		return Long.toString(uintToLong(value));
	}

	public static String sintToString(int value) {
		return Integer.toString(value);
	}

	public static long addLongs(long a, long b) {
		return a + b;
	}

	public static String ulongToString(long value) {
		return UnsignedLongs.toString(value);
	}

	public static String slongToString(long value) {
		return Long.toString(value);
	}

}
