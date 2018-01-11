//package demo.spring.boot.demospringboot.util;
//
//import org.apache.tomcat.util.codec.binary.Base64;
//
//public class WXBizDataCrypt {
//    private String appid;
//    private String sessionKey;
//
//    /**
//     * 构造函数
//     *
//     * @param sessionKey string 用户在小程序登录后获取的会话密钥
//     * @param appid      string 小程序的appid
//     */
//    public WXBizDataCrypt(String appid, String sessionKey) {
//        this.appid = appid;
//        this.sessionKey = sessionKey;
//    }
//
//    /**
//     * 检验数据的真实性，并且获取解密后的明文.
//     * @param encryptedData string 加密的用户数据
//     * @param iv string 与用户数据一同返回的初始向量
//     * @param data string 解密后的原文
//
//     * @return int 成功0，失败返回对应的错误码
//     */
//    public Integer decryptData( String encryptedData,String iv,String data )
//    {
//        if(this.sessionKey.length()!=24){
//            return WXEnum.IllegalAesKey;
//        }
//
//        byte[] aesKey = Base64.decodeBase64(this.sessionKey);
//
//        if(iv.length()!=24){
//            return WXEnum.IllegalIv;
//        }
//        byte[] aesIV = Base64.decodeBase64( iv);
//
//        byte[] aesCipher=Base64.decodeBase64(encryptedData);
//
//        $result=openssl_decrypt( $aesCipher, "AES-128-CBC", $aesKey, 1, $aesIV);
//
//        $dataObj=json_decode( $result );
//        if( $dataObj  == NULL )
//        {
//            return ErrorCode::$IllegalBuffer;
//        }
//        if( $dataObj->watermark->appid != $this->appid )
//        {
//            return ErrorCode::$IllegalBuffer;
//        }
//        $data = $result;
//        return ErrorCode::$OK;
//    }
//}
