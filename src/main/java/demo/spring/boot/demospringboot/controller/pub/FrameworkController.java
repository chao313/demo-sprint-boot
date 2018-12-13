package demo.spring.boot.demospringboot.controller.pub;

import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.service.Types;
import demo.spring.boot.demospringboot.util.QIngYunSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.spring.boot.demospringboot.framework.Code;
import demo.spring.boot.demospringboot.framework.Response;

import java.util.List;

/**
 * 2018/10/17    Created by   chao
 */
@RestController
@RequestMapping("/framework")
public class FrameworkController {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QIngYunSDK qIngYunSDK;

    @GetMapping("/response")
    public Response framework() {
        Response<Boolean> response = new Response<>();
        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            logger.info("SUCCESS:{}", true);
            response.setContent(true);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("SUCCESS:{}", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/getBuckets")
    public Response getBuckets() {
        Response<List<Types.BucketModel>> response = new Response<>();

        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            logger.info("SUCCESS:{}", true);
            List<Types.BucketModel> buckets = qIngYunSDK.getBuckets();
            response.setContent(buckets);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("FAIL:{}", e.getMessage(), e);
        }
        return response;

    }

    @GetMapping("/executeSH")
    public Response shBuckets() {
        Response<List<String>> response = new Response<>();

        try {
            response.setCode(Code.System.OK);
            response.setMsg(Code.System.SERVER_SUCCESS_MSG);
            logger.info("SUCCESS:{}", true);
            List<String> buckets = qIngYunSDK.getResult("ls");
            response.setContent(buckets);
        } catch (Exception e) {
            response.setCode(Code.System.FAIL);
            response.setMsg(e.toString());
            response.addException(e);
            logger.info("FAIL:{}", e.getMessage(), e);
        }
        return response;

    }
}
