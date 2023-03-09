package net.olimpium.lastlife;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    private String mode;
    public Hasher(@NotNull String mode){
        this.mode = mode;
    }
    public String hashBytes(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        return bytesToHex(messageDigest.digest(input));
    }
    public String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }
    private String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder(2*hash.length);
        for (int i = 0; i<hash.length; i++){
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1){
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
