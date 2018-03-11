package com.wx.controller.explore;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wx.common.ServerResponse;
import com.wx.model.explore.JKFqzVo;
import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;
@Controller
@RequestMapping("/interface/")
public class InterfaceExplore {
	@RequestMapping("fqz")
	public @ResponseBody ServerResponse<JKFqzVo> fqzInterface(){
		RequestModel model = new RequestModel();
		model.setGwUrl("https://way.jd.com/huiyutech/label");
		model.setAppkey("6168838ff72b79918845685c7d89cc7a");
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userid","13012345678"); //访问参数
		model.setQueryParams(queryMap);
		WxApiCall call = new WxApiCall();
		call.setModel(model);
		String jsonStr = call.request();
		JKFqzVo vo = JSONObject.parseObject(jsonStr, JKFqzVo.class);
		System.out.println(jsonStr);
		ServerResponse.createBySuccess(jsonStr);
		return ServerResponse.createBySuccess(vo);
	}
	@RequestMapping("httpsend")
	public @ResponseBody String httpSend() throws ParseException, UnsupportedEncodingException, IOException{
		HttpClient httpClient = HttpClients.createDefault();
		//封装请求参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("userid","13012345678"));
		params.add(new BasicNameValuePair("appkey","6168838ff72b79918845685c7d89cc7a"));
		
		String str = EntityUtils.toString(new UrlEncodedFormEntity(params,"utf-8"));
		System.out.println(str);
		HttpGet httpGet = new HttpGet("https://way.jd.com/huiyutech/label"+"?"+str);
		PoolingHttpClientConnectionManager phccm = new PoolingHttpClientConnectionManager();
//		phccm.
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		HttpEntity httpEntity = httpResponse.getEntity();
		return EntityUtils.toString(httpEntity);
	}
}
