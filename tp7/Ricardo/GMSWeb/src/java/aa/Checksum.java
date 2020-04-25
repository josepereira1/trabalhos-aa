package aa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksum {

    public static String getFileChecksum(byte[] arr, MessageDigest shaDigest) {

        shaDigest.reset();

        //Read file data and update in message digest
        shaDigest.update(arr, 0, arr.length);

        //Get the hash's bytes
        byte[] bytes = shaDigest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<bytes.length; i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }
}
