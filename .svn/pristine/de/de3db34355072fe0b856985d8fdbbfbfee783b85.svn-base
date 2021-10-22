package bd.nmam.bridge.business.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.bridge.config.BridgeConfig;

@RestController
@RequestMapping("test")
public class TestController {

	@RequestMapping("t1")
	public String t1(@RequestBody Map<String, Object> map) throws ClientProtocolException, IOException{
		System.out.println(BridgeConfig.getTargetIp() + ":" + BridgeConfig.getTargetPort());
		System.out.println(map);
		
		String url = "http://192.168.3.147:9020/timely/a1/b";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(BridgeConfig.getCONNECT_TIME_OUT())
				.setConnectionRequestTimeout(BridgeConfig.getCONNECT_REQUEST_TIME_OUT())
				.setSocketTimeout(BridgeConfig.getSOCKET_TIME_OUT()).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		httpPost.addHeader("Content-type", "application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");
		httpPost.addHeader("bd-token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmdhbml6YXRpb25JZCI6NSwic3ViIjoiYmQxIiwicm9sZUluZGV4IjoiMCIsInVzZXJJbmRleCI6IjgiLCJleHAiOjE2Mjk5NDAwNTEsImlhdCI6MTYyOTg1MzY1MSwiYWNjb3VudCI6ImJkMSJ9.U2pVvFryJgdkRvWygMe4Lxl8SATEah_-iOphWK30jDQ");
		httpPost.setEntity(new StringEntity(JSONObject.toJSONString(map)));
		CloseableHttpResponse res = httpClient.execute(httpPost);
		System.out.println(res);
		res.close();
		httpClient.close();
		return "";
	}
}
