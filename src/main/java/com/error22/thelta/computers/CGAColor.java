package com.error22.thelta.computers;

public enum CGAColor {
	Black(0, 0, 0),
	Blue(0, 0, 170),
	Green(0, 170, 0),
	Cyan(0, 170, 170),
	Red(170, 0, 0),
	Magenta(170, 0, 170),
	Brown(170, 85, 0),
	LightGray(170, 170, 170),
	Gray(85, 85, 85),
	LightBlue(85, 85, 255),
	LightGreen(85, 255, 85),
	LightGyan(85, 255, 255),
	LightRed(255, 85, 85),
	LightMagenta(255, 85, 255),
	Yellow(255, 255, 85),
	White(255, 255, 255);

	private byte r, g, b;

	private CGAColor(int r, int g, int b) {
		this.r = (byte) r;
		this.g = (byte) g;
		this.b = (byte) b;
	}

	public byte getR() {
		return r;
	}

	public byte getG() {
		return g;
	}

	public byte getB() {
		return b;
	}

}
