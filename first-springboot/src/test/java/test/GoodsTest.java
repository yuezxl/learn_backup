package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;












import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

import test.entity.GoodsRecommemdEntity;



public class GoodsTest {
	public static void main(String[] args) throws HttpException, IOException{
		
		String url = "http://diviner.jd.com/diviner?p=619030&uuid=69021425&sku=&skus=&pin=euwfi&c1=&c2=&c3=&lid=1&lim=-1&sp=&hi=&fe=&fne=&ro=&ec=gbk";
		HttpClient httpClient = new HttpClient();
		
		/*CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "");
		httpGet.setHeader("Cookie", "pin=yue_zxl");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity(); 
		System.out.println(JSON.toJSONString(EntityUtils.toString(entity)));
		response.close();*/
		
		HttpMethod method = new GetMethod(url);
		method.setRequestHeader("Cookie", "pin=euwfi");
		method.setRequestHeader("User-Agent", "");
		httpClient.executeMethod(method);
		
		if(method.getStatusCode() == HttpStatus.SC_OK) {
			String response = method.getResponseBodyAsString();
			System.out.println(response);
			
			byte[] bytes = method.getResponseBody();
			String str = new String(bytes, "iso-8859-1");
			
			String str1 = new String(bytes, "gbk");
			
			System.out.println(str);
			System.out.println(str1);
			
			JSONObject jsonObject = JSONObject.fromObject(str1);
			Object data = jsonObject.get("data");
			if(data.equals(null)) {
				System.out.println("32432");
				return;
			}
			
			System.out.println(JSON.toJSONString(data));
			
			List<GoodsRecommemdEntity> goodsList = new ArrayList<GoodsRecommemdEntity>();
			JSONArray jsonArray = JSONArray.fromObject(data);
			for(Object object : jsonArray) {
				JSONObject jsonObjectTmp = JSONObject.fromObject(object);
				GoodsRecommemdEntity goodsRecommemdEntity = new GoodsRecommemdEntity();
				if(jsonObjectTmp.get("w").equals(null)) {
					goodsRecommemdEntity.setWeight(jsonObjectTmp.getInt("w"));
				}
				
				if(null != jsonObjectTmp.get("sku")) {
					goodsRecommemdEntity.setSku(jsonObjectTmp.getLong("sku"));
				}
				
				if(null != jsonObjectTmp.get("t")) {
					goodsRecommemdEntity.setTitle(jsonObjectTmp.getString("t"));
				}
				if(null != jsonObjectTmp.get("jp")) {
					goodsRecommemdEntity.setPrice(jsonObjectTmp.getDouble("jp"));
				}
				
				if(null != jsonObjectTmp.get("img")) {
					goodsRecommemdEntity.setImageUrl(jsonObjectTmp.getString("img"));
				}
				
				goodsList.add(goodsRecommemdEntity);
			}
			
			
			System.out.println("----- " + JSON.toJSONString(goodsList));
			
		}
	}
}
 