package cn.edu.dlpulyt.keshe.service;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @className: RedisController
 * @description:
 * @author: sh.Liu
 * @date: 2022-03-08 14:28
 */
@Service
public class RedisService {
    
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	/**
	* set redis: string??
	* @param key key
	* @param value value
	*/
	public void setString(String key, String value){
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set(key, value);
	}
	/**
	* get redis: string??
	* @param key key
	* @return
	*/
	public String getString(String key){
		return stringRedisTemplate.opsForValue().get(key);
	}
}