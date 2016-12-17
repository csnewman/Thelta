package com.error22.thelta.computers;

public class CGAColor {
	private static final byte[] blackBytes = parseHexBytes("#000000");
	private static final byte[] blueBytes = parseHexBytes("#0000AA");
	private static final byte[] greenBytes = parseHexBytes("#00AA00");
	private static final byte[] cyanBytes = parseHexBytes("#00AAAA");
	private static final byte[] redBytes = parseHexBytes("#AA0000");
	private static final byte[] magentaBytes = parseHexBytes("#AA00AA");
	private static final byte[] brownBytes = parseHexBytes("#AA5500");
	private static final byte[] lightGrayBytes = parseHexBytes("#AAAAAA");
	private static final byte[] grayBytes = parseHexBytes("#555555");
	private static final byte[] lightBlueBytes = parseHexBytes("#5555FF");
	private static final byte[] lightGreenBytes = parseHexBytes("#55FF55");
	private static final byte[] lightCyanBytes = parseHexBytes("#55FFFF");
	private static final byte[] lightRedBytes = parseHexBytes("#FF5555");
	private static final byte[] lightMagentaBytes = parseHexBytes("#FF55FF");
	private static final byte[] yellowBytes = parseHexBytes("#FFFF55");
	private static final byte[] whiteBytes = parseHexBytes("#FFFFFF");
	
	private static final int[] blackInts = parseHexInts("#000000");
	private static final int[] blueInts = parseHexInts("#0000AA");
	private static final int[] greenInts = parseHexInts("#00AA00");
	private static final int[] cyanInts = parseHexInts("#00AAAA");
	private static final int[] redInts = parseHexInts("#AA0000");
	private static final int[] magentaInts = parseHexInts("#AA00AA");
	private static final int[] brownInts = parseHexInts("#AA5500");
	private static final int[] lightGrayInts = parseHexInts("#AAAAAA");
	private static final int[] grayInts = parseHexInts("#555555");
	private static final int[] lightBlueInts = parseHexInts("#5555FF");
	private static final int[] lightGreenInts = parseHexInts("#55FF55");
	private static final int[] lightCyanInts = parseHexInts("#55FFFF");
	private static final int[] lightRedInts = parseHexInts("#FF5555");
	private static final int[] lightMagentaInts = parseHexInts("#FF55FF");
	private static final int[] yellowInts = parseHexInts("#FFFF55");
	private static final int[] whiteInts = parseHexInts("#FFFFFF");
	
	private static int[] parseHexInts(String hex) {
		int r = Integer.valueOf(hex.substring(1, 3), 16);
		int g = Integer.valueOf(hex.substring(3, 5), 16);
		int b = Integer.valueOf(hex.substring(5, 7), 16);
		return new int[] { r, g, b };
	}
	
	private static byte[] parseHexBytes(String hex) {
		byte r = (byte) (int) Integer.valueOf(hex.substring(1, 3), 16);
		byte g = (byte) (int) Integer.valueOf(hex.substring(3, 5), 16);
		byte b = (byte) (int) Integer.valueOf(hex.substring(5, 7), 16);
		return new byte[] { r, g, b };
	}
	
	public static byte findColor(int r, int g, int b){
		for(int i = 0; i < 16; i++){
			int[] rgb = getColorIntsData((byte) i);
			if(rgb[0] == r && rgb[1] == g && rgb[2] == b){
				return (byte) i; 
			}
		}
		return -1;
	}
	
	public static int[] getColorIntsData(byte id){
		if(id == 0){
			return blackInts;
		}else if(id == 1){
			return blueInts;
		}else if(id == 2){
			return greenInts;
		}else if(id == 3){
			return cyanInts;
		}else if(id == 4){
			return redInts;
		}else if(id == 5){
			return magentaInts;
		}else if(id == 6){
			return brownInts;
		}else if(id == 7){
			return lightGrayInts;
		}else if(id == 8){
			return grayInts;
		}else if(id == 9){
			return lightBlueInts;
		}else if(id == 10){
			return lightGreenInts;
		}else if(id == 11){
			return lightCyanInts;
		}else if(id == 12){
			return lightRedInts;
		}else if(id == 13){
			return lightMagentaInts;
		}else if(id == 14){
			return yellowInts;
		}else if(id == 15){
			return whiteInts;
		}else{
			System.out.println("Unknown id "+id);
			return blackInts;
		}
	}
	
	public static byte[] getColorBytesData(byte id){
		if(id == 0){
			return blackBytes;
		}else if(id == 1){
			return blueBytes;
		}else if(id == 2){
			return greenBytes;
		}else if(id == 3){
			return cyanBytes;
		}else if(id == 4){
			return redBytes;
		}else if(id == 5){
			return magentaBytes;
		}else if(id == 6){
			return brownBytes;
		}else if(id == 7){
			return lightGrayBytes;
		}else if(id == 8){
			return grayBytes;
		}else if(id == 9){
			return lightBlueBytes;
		}else if(id == 10){
			return lightGreenBytes;
		}else if(id == 11){
			return lightCyanBytes;
		}else if(id == 12){
			return lightRedBytes;
		}else if(id == 13){
			return lightMagentaBytes;
		}else if(id == 14){
			return yellowBytes;
		}else if(id == 15){
			return whiteBytes;
		}else{
			System.out.println("Unknown id "+id);
			return blackBytes;
		}
	}
	
	public static byte getColorId(String name){
		if(name.equalsIgnoreCase("black")){
			return 0;
		}else if(name.equalsIgnoreCase("blue")){
			return 1;
		}else if(name.equalsIgnoreCase("green")){
			return 2;
		}else if(name.equalsIgnoreCase("cyan")){
			return 3;
		}else if(name.equalsIgnoreCase("red")){
			return 4;
		}else if(name.equalsIgnoreCase("magenta")){
			return 5;
		}else if(name.equalsIgnoreCase("brown")){
			return 6;
		}else if(name.equalsIgnoreCase("lightgray")){
			return 7;
		}else if(name.equalsIgnoreCase("gray")){
			return 8;
		}else if(name.equalsIgnoreCase("lightblue")){
			return 9;
		}else if(name.equalsIgnoreCase("lightgreen")){
			return 10;
		}else if(name.equalsIgnoreCase("lightcyan")){
			return 11;
		}else if(name.equalsIgnoreCase("lightred")){
			return 12;
		}else if(name.equalsIgnoreCase("lightmagenta")){
			return 13;
		}else if(name.equalsIgnoreCase("yellow")){
			return 14;
		}else if(name.equalsIgnoreCase("white")){
			return 15;
		}else{
			System.out.println("Unkown name "+name);
			return 0;
		}
	}
}
