package demo.spring.boot.demospringboot.util;

import com.qingstor.sdk.config.EvnContext;
import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.service.Bucket;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qingstor.sdk.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class QIngYunSDK {

    private static Logger LOGGER = LoggerFactory.getLogger(QIngYunSDK.class);
    @Value(value = "${qingyun.APP_KEY}")
    public String APP_KEY;
    @Value(value = "${qingyun.ACCESS_KEY}")
    public String ACCESS_KEY;
    @Value(value = "${qingyun.ZONE}")
    public String ZONE;
    @Value(value = "${qingyun.CMD}")
    public String CMD;


    /**
     * 获取文件预览路径
     */
    public String getPreviewUrl(String fileName, String BUCKET) {
        EvnContext evn = new EvnContext(APP_KEY, ACCESS_KEY);
        QingStor storService = new QingStor(evn, ZONE);
        Bucket bucket = storService.getBucket(BUCKET, ZONE);
        long expiresTime = new Date().getTime() / 1000 + 1000; // 1000秒后过期
        String objectUrl = "";
        try {
            objectUrl = bucket.GetObjectSignatureUrl(fileName, expiresTime);
        } catch (QSException e) {
            LOGGER.error("getPreviewUrl failed cause " + e.toString(), e);
        }
        return objectUrl;
    }

    /**
     *
     */
    public List<Types.KeyModel> getObjects(String fileName, String BUCKET, Integer limit) throws QSException {
        EvnContext evn = new EvnContext(APP_KEY, ACCESS_KEY);
        QingStor qingStor = new QingStor(evn, ZONE);
        Bucket bucket = qingStor.getBucket(BUCKET, ZONE);
        Bucket.ListObjectsInput input = new Bucket.ListObjectsInput(); //查询条件
        input.setPrefix(fileName); //设置前缀
        input.setLimit(limit);
        return bucket.listObjects(input).getKeys();
    }

    /**
     * 判断文件是否存在
     */
    public List<Types.BucketModel> getBuckets() throws QSException {
        EvnContext evn = new EvnContext(APP_KEY, ACCESS_KEY);
        QingStor qingStor = new QingStor(evn, ZONE);
        QingStor.ListBucketsOutput listBucketsOutput = qingStor.listBuckets(null);
        return listBucketsOutput.getBuckets();
    }

    /**
     * 模板方法+泛型 -> 处理逻辑延迟到调用者
     *
     * @param sh
     * @param callBack
     * @param <T>
     * @return
     */
    public <T> T executeLinuxCmd(String sh, CallBack<T> callBack) {
        String cmd = CMD + " " + sh;
        LOGGER.info("sh is :{}", cmd);
        Runtime run = Runtime.getRuntime();
        InputStream in = null;
        T result = null;
        try {
            Process process = run.exec(cmd);
            in = process.getInputStream();
            result = callBack.deal(in);
            in.close();
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 把字节转为List
     *
     * @param sh
     * @return
     * @throws IOException
     */
    public List<String> getResult(String sh){
        return this.executeLinuxCmd(sh, in -> {
            Reader reader = new InputStreamReader(in);
            LineNumberReader lineNumberReader
                    = new LineNumberReader(reader);
            List<String> list = new ArrayList<>();
            String line;
            while ((null != (line = lineNumberReader.readLine()))) {
                list.add(line);
            }
            lineNumberReader.close();
            return list;
        });
    }

//    /**
//     * 把字节转为List 分页
//     *
//     * @param sh
//     * @return
//     * @throws IOException
//     */
//    public List<String> getResult(String sh, Integer start, Integer end) throws IOException {
//        InputStream in = this.executeLinuxCmd(sh);
//        Reader reader = new InputStreamReader(in);
//        LineNumberReader lineNumberReader
//                = new LineNumberReader(reader);
//        lineNumberReader.setLineNumber(start);
//        List<String> list = new ArrayList<>();
//        for (int i = start; i < end; i++) {
//            list.add(lineNumberReader.readLine());
//        }
//        return list;
//    }


//    public String executeLinuxCmd(String sh) {
////        String cmd = CMD + " ls gkyhxt-lyg/enterPicture/20181213/苏G83796/20181213020503456c7p8a7/";
//        String cmd = CMD + " " + sh;
//        LOGGER.info("sh is :{}", cmd);
//        Runtime run = Runtime.getRuntime();
//        try {
//            Process process = run.exec(cmd);
//            InputStream in = process.getInputStream();
//            StringBuffer out = new StringBuffer();
//            byte[] b = new byte[8192];
//            for (int n; (n = in.read(b)) != -1; ) {
//                out.append(new String(b, 0, n));
//            }
//            LOGGER.info("sh result is :{}", out.toString());
//            in.close();
//            process.destroy();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
