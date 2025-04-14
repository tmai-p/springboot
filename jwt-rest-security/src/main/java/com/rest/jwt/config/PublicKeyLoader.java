package com.rest.jwt.config;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PublicKeyLoader {

    public static RSAPublicKey loadPublicKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        String publicKeyContent = new String(Files.readAllBytes(Paths.get(new ClassPathResource(filePath).getURI())));
        // Remove header, footer, and newlines
        publicKeyContent = publicKeyContent.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\r\\n", "")
                .replaceAll("\\n", "");

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyContent);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    public static void main(String[] args) {
        try {
            RSAPublicKey publicKey = loadPublicKey("public.pem");
            System.out.println("Public Key loaded successfully: " + publicKey);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
