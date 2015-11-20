package com.itmyhome.divideAndConquer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**   
 * @Title: TestIpUtil.java 
 * @Package com.itmyhome.divideAndConquer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2015年11月21日 上午12:07:07 
 * @version V1.0   
 */
public class TestIpUtil {

	public static void main(String[] args) throws Exception {
		String ip = "122.91.218.98";
		HttpClient httpclient = new DefaultHttpClient();  
        /* initialize the request method */  
        // prepare the request url  
        HttpPost httpPost = new HttpPost("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);  
        // prepare the request parameters  
        List<NameValuePair> params=new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("username","admin"));  
        params.add(new BasicNameValuePair("password","admin"));  
        // set the request entity  
        httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));  
          
        /* execute the request */  
        System.out.println("executing request " + httpPost.getURI());  
        HttpResponse response = httpclient.execute(httpPost);  
  
        /* check whether it has relocated */  
        int statusCode = response.getStatusLine().getStatusCode(); 
        Utils.printResponse(response);  
	}
}


