package com.torrento.Prueba.mvcTest.utils;

import java.util.Base64;

public class Base64EncoderDecoder {

	public static String encode(String url) {
		return Base64.getEncoder().encodeToString(url.getBytes());
	}

	public static String decode(byte[] codificato) {
		return new String(Base64.getDecoder().decode(codificato));
	}

}
