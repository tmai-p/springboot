package com.rest.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/*
 * Remove the header and footer lines, and any new line characters
 */
@Component
public class KeyGen {

    @Value("classpath:public.pem")
    private Resource publicKeyFile;

    @Value("classpath:private.pem")
    private Resource privateKeyFile;

    @Bean
    public RSAPublicKey rsaPublicKey() throws Exception {
        String publicKeyContent = new String(Files.readAllBytes(Paths.get(publicKeyFile.getURI())))
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace("\n", "");

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyContent));
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    @Bean
    public RSAPrivateKey rsaPrivateKey() throws Exception {
        String privateKeyContent = new String(Files.readAllBytes(Paths.get(privateKeyFile.getURI())))
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replace("\n", "");

        // Decode the Base64 encoded content
        byte[] decoded = Base64.getDecoder().decode(privateKeyContent);

        // Generate the private key
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }
}
