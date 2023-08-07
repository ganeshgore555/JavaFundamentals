package com.main;

import java.util.Arrays;

public class ByteEncoding {

	public static void main(String[] args) {
		byte[] encode = {0b01010101,0b01010101,0b01110101,0b01010000,0b01110101,0b01010001,0b01010101,0b01011111};
		
		byte[] decode = new byte[encode.length];
		
		byte mask = 1;
		byte msb = (byte) (1 << 7);
		for(int i = 1; i < 8; i++) {
			if((encode[0] & mask) != 0) {
				decode[i] = (byte) (encode[i] | msb);
			}else {
				decode[i] = encode[i];
			}
			mask = (byte) (mask << 1);
		}
		System.out.println(Arrays.toString(decode));
	}

}
