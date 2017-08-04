package cn.edu.hdu.webbf.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import cn.edu.hdu.webbf.model.netease.ag.FiveDayAGData;

/**
 * 测试，待完善
 * 
 * @ClassName: HttpRequestUtil
 * @Description: TODO
 * @author Pi Chen
 * @date 2016年8月11日 下午8:02:07
 */
public class HttpRequestUtil
{

    private Gson gson = new Gson();

    public static void main(String[] args)
    {
        new HttpRequestUtil().requestByGetMethod();
    }

    /**
     * GET方式
     */

    public void requestByGetMethod()
    {

        CloseableHttpClient httpClient = getHttpClient();
        try
        {

            HttpGet get = new HttpGet(
                "http://fa.163.com/interfaces/ngxcache/priceinfo/min/getDay5PriceList.do?partnerId=njs&goodsId=AG&"
                    + "v=" + System.currentTimeMillis());
            System.out.println("执行get请求:...." + get.getURI());
            CloseableHttpResponse httpResponse = null;

            httpResponse = httpClient.execute(get);
            try
            {

                HttpEntity entity = httpResponse.getEntity();
                if (null != entity)
                {
                    System.out.println("响应状态码:" + httpResponse.getStatusLine());

                    // System.out.println("响应内容:" +
                    // EntityUtils.toString(entity));
                    FiveDayAGData data = gson.fromJson(EntityUtils.toString(entity),
                        FiveDayAGData.class);
                    System.out.println(data.getVersion());

                }
            }
            finally
            {
                httpResponse.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                closeHttpClient(httpClient);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    /**
     * POST
     */

    public void requestByPostMethod()
    {
        CloseableHttpClient httpClient = getHttpClient();
        try
        {
            HttpPost post = new HttpPost("http://localhost/....");

            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("j_username", "admin"));
            list.add(new BasicNameValuePair("j_password", "admin"));

            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list, "UTF-8");
            post.setEntity(uefEntity);
            System.out.println("POST 请求...." + post.getURI());

            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try
            {
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity)
                {

                    System.out.println(EntityUtils.toString(uefEntity));

                }
            }
            finally
            {
                httpResponse.close();
            }

        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                closeHttpClient(httpClient);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    private CloseableHttpClient getHttpClient()
    {
        return HttpClients.createDefault();
    }

    private void closeHttpClient(CloseableHttpClient client) throws IOException
    {
        if (client != null)
        {
            client.close();
        }
    }
}