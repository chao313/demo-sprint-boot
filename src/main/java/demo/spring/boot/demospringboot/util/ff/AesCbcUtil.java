package demo.spring.boot.demospringboot.util.ff;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;

/**
 * Created by lsh AES-128-CBC 加密方式 注： AES-128-CBC可以自己定义“密钥”和“偏移量“。 AES-128是jdk自动生成的“密钥”。
 */
public class AesCbcUtil {


    static {
        //BouncyCastle是一个开源的加解密解决方案，主页在http://www.bouncycastle.org/
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES解密
     *
     * @param data           //密文，被加密的数据
     * @param key            //秘钥
     * @param iv             //偏移量
     * @param encodingFormat //解密后的结果需要进行的编码
     */
    public static String decrypt(String data, String key, String iv, String encodingFormat) throws Exception {
//    initialize();

        //被加密的数据
        byte[] dataByte = Base64.decodeBase64(data);
        //加密秘钥
        byte[] keyByte = Base64.decodeBase64(key);
        //偏移量
        byte[] ivByte = Base64.decodeBase64(iv);


        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");

            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化

            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, encodingFormat);
                return result;
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) throws Exception {
        String session_key = "fFNu6sZtAB7lVS8RrhAyqQ==";
        String encryptedData = "Qo9EP7usnNUbNJiWBBF2j2eqeT02ym7sh5xKJoZuuSix2CLif1XOUcfm6NX4r4AQyxCPm/LcIhkI/34xpBYAoNyty0Ihr3+IDhou4gPi04SwKfSebFzZGCtYawKpgkVG4kh8VBlT3jIV0luAcDkAKBVT7X6dIyA/ErAqvMw+D2f4MyF5o7lTaYvTnnpSUTiAQnnV8O11kJ79X35jOO875H4ZcJfsDq/gOfnxuL+8GQFvxnnIGLd3nfj3v9gLEwMt64p3teamG9O3sJsUcu+67p3SirgW6oEbXmGSc+UislK3b57GMlMHnJmoNOMvQNpQ55MOrvx7affYwKmT4WapltjIpWmcWiOZIbkwDlnsK26xQuft0GW1HKOwgdeVPq6vD54x3JOMaPBMpoBtOPh5xq3xJ96gbqN/VwBxwL459deK79eFrwHzE/slHbwga1njHeb2PRS4xudqkcmBaTK/+P0VAF2b7c8e/yUCJs1uTLM=";
        String iv = "GvRw76DAkISraNI7F/dPbg==";

        String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");

        System.out.println(result);

    }
}
