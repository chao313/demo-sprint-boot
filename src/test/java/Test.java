import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import demo.spring.boot.demospringboot.mybatis.vo.Cart;

public class Test {

    private static Logger LOGGER = LoggerFactory.getLogger(Test.class);
    public static void main (String[] a) throws IOException {
        Cart cart = new Cart();
        cart.setPrice("1");
        Cart[] carts = {cart};
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] bytes = new byte[2048];
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(carts);
        oos.flush();
        bytes = bos.toByteArray ();
        oos.close();
        bos.close();

        //----------
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Cart[] carts2 = (Cart[])obj;
        LOGGER.info("carts2[0]:{}",carts2[0]);

    }

    @org.junit.Test
    public void testJson(){
        Cart cart = new Cart();
        cart.setPrice("1");
        Cart[] carts = {cart};
        JSONArray object = JSONArray.fromObject(carts);
        String objectString = object.toString();
        LOGGER.info("object:{}",objectString);
        JSONArray json = JSONArray.fromObject(objectString);//userStr是json字符串
        Cart[] carts1 = (Cart[]) JSONArray.toArray(json,Cart.class);
        LOGGER.info("carts1:{}",carts1[0]);

    }
}
