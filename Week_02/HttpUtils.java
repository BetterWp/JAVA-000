package java0.nio01;

import com.arronlong.httpclientutil.HttpClientUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * @Description: HttpClientUtils
 * @Date: 2020/10/28 18:04
 * @Author: wp
 **/
public class HttpUtils {

    public static final String url ="http://localhost:8803";
    public static final int success  = 200;

    public String callGet(String url) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()){
            return Objects.requireNonNull(response.body()).string();
        }
        return null;
    }

    public String get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == success){
            return EntityUtils.toString(response.getEntity());
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        HttpUtils httpUtils = new HttpUtils();
        String res = httpUtils.get(url);
        String response = httpUtils.callGet(url);
        if (res == null || response == null) {
            throw new RuntimeException("调用失败");
        }
        System.out.println(res);
        System.out.println(response);
    }
}
