package edu.ynmd.cms.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class BaseImgTools {
    public static boolean saveImgByStr(String path,String basestr){


        try {
            byte[] decodedBytesb = Base64.getDecoder().decode(basestr);
            FileUtils.writeByteArrayToFile(new File(path), decodedBytesb);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }

    public static String imageToBase64Str(String filepath){

        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File(filepath));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            return encodedString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
