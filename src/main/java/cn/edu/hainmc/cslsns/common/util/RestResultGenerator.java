package cn.edu.hainmc.cslsns.common.util;

import cn.edu.hainmc.cslsns.common.enums.ResponseErrorEnum;
import cn.edu.hainmc.cslsns.common.bean.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResultGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

	public static <T> ResponseResult<T> genResponseResult(T data, ResponseErrorEnum responseErrorEnum) {

		ResponseResult<T> result = ResponseResult.newInstance();
		result.setCodeInfo(responseErrorEnum);
		result.setData(data);		
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
		}
		return result;
	}

	/**
	 * 生成响应成功的(不带正文)的结果
	 *
	 * @param message
	 *            成功提示信息
	 * @return ResponseResult
	 */

	/*
	 * @SuppressWarnings("rawtypes") public static ResponseResult genResult(String
	 * message) {
	 * 
	 * ResponseResult responseResult = ResponseResult.newInstance();
	 * responseResult.setSuccess(true); responseResult.setMessage(message);
	 * 
	 * return responseResult; }
	 */
	/**
	 * 生成响应成功(带正文)的结果
	 *
	 * @param data
	 *            结果正文
	 * @param message
	 *            成功提示信息
	 * @return ResponseResult<T>
	 */
	/*
	 * public static <T> ResponseResult<T> genResult(T data, String message) {
	 * 
	 * ResponseResult<T> result = ResponseResult.newInstance();
	 * //result.setSuccess(true); result.setData(data); result.setMessage(message);
	 * 
	 * if (LOGGER.isDebugEnabled()) { LOGGER.debug("--------> result:{}",
	 * JacksonMapper.toJsonString(result)); } return result; }
	 */

	/**
	 * 生成响应失败的结果
	 *
	 * @param message
	 *            自定义错误信息
	 * @return ResponseResult
	 */
	/*
	 * @SuppressWarnings("rawtypes") public static ResponseResult
	 * genErrorResult(String message) {
	 * 
	 * ResponseResult result = ResponseResult.newInstance();
	 * //result.setState(false); result.setCode(code); result.setMessage(message);
	 * 
	 * if (LOGGER.isDebugEnabled()) { LOGGER.debug("--------> result:{}",
	 * JacksonMapper.toJsonString(result)); } return result; }
	 */

	/**
	 * 生成响应失败(带errorCode)的结果
	 *
	 * @param responseErrorEnum
	 *            失败信息
	 * @return ResponseResult
	 */
	/*
	 * @SuppressWarnings("rawtypes") public static ResponseResult
	 * genErrorResult(ResponseErrorEnum responseErrorEnum) {
	 * 
	 * ResponseResult result = ResponseResult.newInstance();
	 * result.setSuccess(false); result.setErrorInfo(responseErrorEnum);
	 * 
	 * if (LOGGER.isDebugEnabled()) { LOGGER.debug("--------> result:{}",
	 * JacksonMapper.toJsonString(result)); } return result; }
	 */

}
