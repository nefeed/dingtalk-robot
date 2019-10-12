package com.nefeed.dingtalkrobot.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 网络请求工具类
 *
 * @author nefeed@163.com
 * @version $Id: HttpUtil.java, v 0.1 2019年10月11日 8:30 下午 章华隽 Exp $
 */
public class HttpUtil {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * 成功的请求返回码
     */
    private static final int RESPONSE_SUCCESS_CODE = 200;

    public static String get(String urlStr, Map<String, Object> params) throws IOException {
        StringBuilder httpUrl = new StringBuilder(urlStr);
        String result;

        if (CollectionUtils.isEmpty(params)) {
            httpUrl.append("?");
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                httpUrl.append(entry.getKey());
                httpUrl.append("=");
                httpUrl.append(entry.getValue().toString());
                httpUrl.append("&");
            }
            if (httpUrl.length() > 0) {
                httpUrl.deleteCharAt(httpUrl.lastIndexOf("&"));
            }
        }

        try {
            URL url = new URL(httpUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            connection.connect();
            if (connection.getResponseCode() != RESPONSE_SUCCESS_CODE) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + connection.getResponseCode());
            }
            result = getHttpResult(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("HTTP GET请求失败!", e);
            throw e;
        }
        return result;
    }

    public static String post(String urlStr, Map<String, Object> params) throws IOException {
        StringBuilder httpUrl = new StringBuilder(urlStr);
        String result;
        // 请求输出的字节流
        OutputStream out;

        try {
            URL url = new URL(httpUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            //指示应用程序要将数据写入URL连接,其值默认为false（是否传参）
            connection.setDoOutput(true);
            //httpURLConnection.setDoInput(true);

            connection.setUseCaches(false);
            //10秒连接超时
            connection.setConnectTimeout(10000);
            //10秒读取超时
            connection.setReadTimeout(10000);
            // 获取输出流
            out = connection.getOutputStream();
            //输出流里写入POST参数
            out.write(JSON.toJSONString(params).getBytes());
            out.flush();
            out.close();
            connection.connect();
            if (connection.getResponseCode() != RESPONSE_SUCCESS_CODE) {
                throw new RuntimeException("HTTP POST Request Failed with Error code : "
                        + connection.getResponseCode());
            }
            result = getHttpResult(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("HTTP POST请求失败!", e);
            throw e;
        }
        return result;
    }

    /**
     * 获取http请求的结果
     * @param in 请求返回的字节流
     * @return http请求的结果
     * @throws IOException io异常
     */
    private static String getHttpResult(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String strRead;
        StringBuilder sbf = new StringBuilder();
        while ((strRead = reader.readLine()) != null) {
            sbf.append(strRead);
            sbf.append("\r\n");
        }
        reader.close();
        return sbf.toString();
    }
}