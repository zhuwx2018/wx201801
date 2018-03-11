package com.wx.common;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *<p>Title: TokenCache</p>
 *<p>Description:用Guava进行缓存Token </p>
 * @author zhugf
 * @date 2018年3月4日
 */
public class TokenCache {
	
	public static final Logger logger = LoggerFactory.getLogger(TokenCache.class);
	
	public static LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
			.initialCapacity(1000)
			.maximumSize(10000)
			.expireAfterAccess(30, TimeUnit.SECONDS)
			.build(new CacheLoader<String, String>(){
				//实现默认返回，但key没有命中时返回空"null"直接返回null会报错
				@Override
				public String load(String arg0) throws Exception {
					return "null";
				}
				
			});
	
	public static void setKey(String key, String value){
		loadingCache.put(key, value);
	}
	
	public static String getKey(String key){
		String value = null;
		try {
			value = loadingCache.get(key);
			if(value.equals("null")){
				return null;
			}
		} catch (ExecutionException e) {
			logger.error("获取缓存Token出错",e);
		}
		return value;
	}

}
