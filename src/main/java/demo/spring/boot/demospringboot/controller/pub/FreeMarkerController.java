package demo.spring.boot.demospringboot.controller.pub;


import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.service.Types;
import demo.spring.boot.demospringboot.mybatis.vo.PathAndPic;
import demo.spring.boot.demospringboot.util.QIngYunSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import demo.spring.boot.demospringboot.vo.PersonInstance;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FreeMarkerController {
    @Autowired
    PersonInstance personInstance;

    @Autowired
    private QIngYunSDK qIngYunSDK;

    @GetMapping(value = "/free-marker")
    public String freeMarker(Map<String, Object> map) {
        map.put("person", personInstance);
        return "freeMarker";
    }

//    @GetMapping(value = "/getBuckets")
//    public String getBuckets(Map<String, Object> map) {
//        try {
//            List<Types.BucketModel> buckets = qIngYunSDK.getBuckets();
//            map.put("buckets", buckets);
//            return "buckets";
//        } catch (QSException e) {
//            e.printStackTrace();
//            map.put("error", e.getMessage());
//            return "ERROR";
//        }
//    }

    @GetMapping(value = "/getObjects")
    public String getObjects(Map<String, Object> map,
                             @RequestParam(value = "filePath", required = false, defaultValue = "") String filePath,
                             @RequestParam(value = "BUCKET", required = true) String BUCKET,
                             @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit) {
        try {
            List<Types.KeyModel> objects = qIngYunSDK.getObjects(filePath, BUCKET, limit);
            map.put("objects", objects);
            return "objects";
        } catch (QSException e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            return "ERROR";
        }
    }

    @GetMapping(value = "/getBuckets")
    public String getBuckets(Map<String, Object> map,
                             @RequestParam(value = "sh", required = false, defaultValue = "ls") String sh) {
        try {
            List<String> buckets = qIngYunSDK.getResult(sh);
            List<String> filterBuckets = new ArrayList<>();
            for (String path : buckets) {
                filterBuckets.add(path);
            }
            map.put("buckets", filterBuckets);
            return "buckets";
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            return "ERROR";
        }
    }

    @GetMapping(value = "/getFirstDir")
    public String getFirstDir(Map<String, Object> map,
                              @RequestParam(value = "sh", required = false, defaultValue = "ls") String sh,
                              @RequestParam(value = "BUCKET", required = false, defaultValue = "") String BUCKET) {
        try {
            List<String> firstDir = qIngYunSDK.getResult(sh);
            List<String> filterFirstDir = new ArrayList<>();
            for (String path : firstDir) {
                String pathtmp = BUCKET + "/" + path.replaceAll("Directory\\s*", "");
                filterFirstDir.add(pathtmp);
            }
            map.put("firstDirs", filterFirstDir);
            map.put("BUCKET", BUCKET);
            return "firstDirs";
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            return "ERROR";
        }
    }

    @GetMapping(value = "/getOtherDir")
    public String getOtherDir(Map<String, Object> map,
                              @RequestParam(value = "sh", required = false, defaultValue = "ls") String sh,
                              @RequestParam(value = "BUCKET", required = false, defaultValue = "") String BUCKET) {
        try {
            if (sh.endsWith(".jpg") || sh.endsWith(".png")) {
                //如果是请求是图片->展示图片
                String path = sh.replaceAll("^ls\\s*/$", "");
                String url = qIngYunSDK.getPreviewUrl(sh.replaceAll("^ls\\s*[a-z|A-Z|-]*/", ""), BUCKET);
                map.put("path", path);
                map.put("url", url);
                return "Preview";
            } else {
                List<String> OtherObjects = qIngYunSDK.getResult(sh);
                List<String> filterOtherObjects = new ArrayList<>();
                List<PathAndPic> pathAndPics = new ArrayList<>();//存储对应关系
                for (String path : OtherObjects) {
                    String pathtmp = BUCKET + "/" + path.replaceAll("^.*\\s", "");
                    filterOtherObjects.add(pathtmp);
                    PathAndPic pathAndPic = new PathAndPic();
                    pathAndPic.setPath(pathtmp);
                    if(pathtmp.endsWith(".jpg") || pathtmp.endsWith(".png")){
                        String url = qIngYunSDK.getPreviewUrl(pathtmp.replaceAll("^\\s*[a-z|A-Z|-]*/", ""), BUCKET);
                        pathAndPic.setUrl(url);
                    }
                    pathAndPics.add(pathAndPic);//加入到list中
                }
                map.put("pathAndPics", pathAndPics);
                map.put("BUCKET", BUCKET);
                return "OtherObjectsAndPre";
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            return "ERROR";
        }
    }

    @GetMapping(value = "/executeSH")
    public String getObjects(Map<String, Object> map,
                             @RequestParam(value = "sh", required = false, defaultValue = "ls") String sh,
                             @RequestParam(value = "BUCKET", required = false, defaultValue = "") String BUCKET) {
        try {

            //1.当没有参数时 -> 默认为ls
            //  I.返回BUCKET
            //2.当有参数为BUCKET时 -> ls BUCKET
            //  I.BUCKET中的参数包含 / 所以必须去掉
            //  II.BUCKET中的参数包含 / 所以必须去掉
//                 ->BUCKET = BUCKET.replace("/", "");
//                 ->BUCKET = BUCKET.replace("/", "");

            //3.参数为地址，其中包含的有Directory，需要去掉
//                I.sh = sh.replace("Directory", "");//去除多余的字符
//                II.replace("Directory", "").trim());

            sh = sh.replace("Directory", "");//去除多余的字符
            sh = sh.replaceFirst("/", "");
            sh.replaceAll("\\s{1,}", " ");
            BUCKET = BUCKET.replace("/", "");
            List<String> paths = qIngYunSDK.getResult(sh);
            List<String> pathsResult = new ArrayList<>();
            for (String path : paths) {
                pathsResult.add(BUCKET.replace("/", "") + "/"
                        + path.replace("Directory", "").trim());
            }

            map.put("paths", pathsResult);
            map.put("BUCKET", BUCKET);
            return "paths";
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            return "ERROR";
        }
    }
}

