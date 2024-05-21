package com.amd.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AMDSHA256HashGenerator {

	public static void main(String[] args) {
		
		String filePath = "D:/AMDimagefile.JPG";
		
		if (filePath.equals(null)) {
			System.err.println("Usage: java FileHashGenerator <file path>");
			System.exit(1);
		}

		

		try {
			String hash = generateSHA256Hash(filePath);
			System.out.println("SHA-256 hash: " + hash);
		} catch (IOException | NoSuchAlgorithmException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static String generateSHA256Hash(String filePath) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		FileInputStream fis = new FileInputStream(filePath);
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		}

		fis.close();

		byte[] bytes = digest.digest();

		// Convert byte array into signum representation
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}
}
