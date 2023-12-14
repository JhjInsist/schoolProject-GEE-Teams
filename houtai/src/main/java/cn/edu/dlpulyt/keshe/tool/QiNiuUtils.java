package cn.edu.dlpulyt.keshe.tool;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class QiNiuUtils {
    public static String baseUrl = "http://s5k6kneq0.hb-bkt.clouddn.com/";

    public static SimpleDateFormat sdf = new SimpleDateFormat("/yyyy-MM-dd/");

    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    //设置好账号的ACCESS_KEY和SECRET_KEY
    public static  String ACCESS_KEY = "ZiKXZe9jeSeyXgF-vdpKFCDrelNIyCJIw64T5YK6"; //这两个登录七牛 账号里面可以找到
    public static String SECRET_KEY = "DqImFSbPRgOJ22ssyjkHnn-ZSfTc0HKC5cxNJmst";

    //要上传的空间
    public static String bucketname = "gee-team"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置私有）
    //上传到七牛后保存的文件名
    public static String filePackage = "resource";

    //密钥配置
    public static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    public static UploadManager uploadManager = new UploadManager(new Configuration());


    /**
     * 简单上传，使用默认策略，只需要设置上传的空间名就可以了
     *
     * @param fileName 文件上传至七牛云空间的名称
     * @return
     */
    public static String getUpToken(String fileName) {
        //return auth.uploadToken(bucketname);
        //<bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
        //如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
        //第三个参数是token的过期时间
        return auth.uploadToken(bucketname, fileName, 3600, new StringMap().put("insertOnly", 0));
    }


    /**
     * 普通上传
     *
     * @param filePath 文件路径
     * @param fileName 文件上传至七牛云空间的名称
     * @throws IOException
     */
    public static void upload(String filePath, String fileName) {
        try {
            //调用put方法上传
            Response res = uploadManager.put(filePath, fileName, getUpToken(fileName));
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过input流上传
     * MultipartFile 上传的文件
     * @throws IOException
     */
    public static Response upload(MultipartFile file ) {
        Response res = null;
        String fileName = file.getOriginalFilename();
        InputStream is = null;
        fileName = filePackage+ sdf.format(new Date())+sdf2.format(new Date())+ UUID.randomUUID()+ fileName;
        try {
            is = file.getInputStream();

            //调用put方法上传
            String token = getUpToken(fileName);
            res = uploadManager.put(is, fileName, token,null,null);
            //打印返回的信息
            return res;
        } catch (QiniuException e) {
            res = e.response;
            // 请求失败时打印的异常的信息
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }



    /**
     * 获取下载文件路径，即：donwloadUrl
     *
     * @return
     */
    public static String getDownloadUrl(String targetUrl) {
        String downloadUrl = auth.privateDownloadUrl(targetUrl);
        return downloadUrl;
    }


    /**
     * 文件下载
     *
     * @param targetUrl
     */
    public static InputStream download(String targetUrl) {
        //获取downloadUrl
        String downloadUrl = getDownloadUrl(baseUrl+targetUrl);

        return doDownload(downloadUrl);

    }


    /**
     * 通过发送http get 请求获取文件资源
     *
     * @param url
     * @param filepath
     * @return
     */
    private static InputStream doDownload(String url) {
        OkHttpClient client = new OkHttpClient();
        System.out.println(url);
        Request req = new Request.Builder().url(url).build();
        okhttp3.Response resp = null;
        InputStream is = null;
        try {
            resp = client.newCall(req).execute();
            System.out.println(resp.isSuccessful());
            if (resp.isSuccessful()) {
                ResponseBody body = resp.body();
                is = body.byteStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unexpected code " + resp);
        }
        // 保持流打开
        return is;
    }

    /**
     * 读取字节输入流内容
     *
     * @param is
     * @return
     */
    public static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024 * 2];
        int len = 0;
        try {
            while ((len = is.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }

    public static void main(String args[]) throws IOException {
        String fileName = "xiao.jpg";
        //上传文件的路径
        String FilePath = "C:\\Users\\ChenXiao\\Pictures\\Saved Pictures\\xiao.jpg";  //本地要上传文件路径
        // new QiniuUtil().upload(FilePath,fileName);

        //构造私有空间的需要生成的下载的链接；
        //格式： http://私有空间绑定的域名/空间下的文件名
        String targetUrl = "http://私有空间绑定的域名/下载文件名称.后缀";
        new QiNiuUtils().download(targetUrl);
    }

}