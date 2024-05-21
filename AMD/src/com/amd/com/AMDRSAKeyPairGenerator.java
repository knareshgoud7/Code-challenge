package com.amd.com;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AMDRSAKeyPairGenerator {


    public static void main(String[] args) {
        try {
            // Create a KeyPairGenerator for the RSA algorithm
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            
            // Initialize the KeyPairGenerator with a key size of 2048 bits
            keyPairGenerator.initialize(2048);
            
            // Generate the KeyPair
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            
            // Get the public and private keys
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // Encode the keys to Base64 to make them readable
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            
            // Print the keys
            System.out.println("Public Key:");
            System.out.println(publicKeyBase64);
            System.out.println("\nPrivate Key:");
            System.out.println(privateKeyBase64);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
