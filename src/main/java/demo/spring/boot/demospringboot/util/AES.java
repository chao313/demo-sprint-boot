package demo.spring.boot.demospringboot.util;


import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AES {
    public static boolean initialized = false;

    /**
     * AES解密
     * @param content 密文
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchProviderException
     */
    public static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws InvalidAlgorithmParameterException {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void initialize(){
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }
    //生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception{
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

    public static void main(String[] a){
        Map map = new HashMap();
        try {
            byte[] resultByte  = AES.decrypt(Base64.decodeBase64("kIoNhDRHW78wiUVWYBxqwC4bFVlKuHcSQ987uB5jj2uVbFH6Y6vNrSqjxbb40zBZ5mW4+eUm05J0w2fzRnn8KyDuroLAedMDb7yTPqr6zFI3LSjH0Dtj3rPjGXcjKcecwOafeLqAWTOtfe6z2CAgG/fzg8MGioBUlYEBNdf5ToB4AMbMwh9HKGqDCF+BlJsIqlvglSbOVJY2hhS7PNIPeWkLUUeJItti8F8VWXA2aS3MUs/CBr10abi73mQC8qKw5P8A4+Jf9zLrzWtoxCc5gbYBkTLk3v2RNsyeOc8q+CJFfLHQRyJWS3k6KvxhuRFeFr3cm29aSLR9TNsYI9/oOsV/vgfKa3z9qEU/cNb2sgvb2lRaf/N9BYVh5grwsLBNXZxYHE/hQv/yzCyKg3x72nqrH81VGyEE10wv2yq7Sf+lpENjQViw5c56yDQXgC0jjRL+/DKnL1QH+qMeFkkQNaPPSZ+2KfIjk2lDYhMBXDk="),
                    Base64.decodeBase64("gwIym369r54f0c/5xJ7Yag=="),
                    Base64.decodeBase64("dZYs3GChyPKJ27cCJQ3Oqg=="));
            if(null != resultByte && resultByte.length > 0){
                String userInfo = new String(resultByte, "UTF-8");
                map.put("status", "1");
                map.put("msg", "解密成功");
                map.put("userInfo", userInfo);
            }else{
                map.put("status", "0");
                map.put("msg", "解密失败");
            }
        }catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        Gson gson = new Gson();
//        String decodeJSON = gson.toJson(map);
//        System.out.println(decodeJSON);
    }

}
