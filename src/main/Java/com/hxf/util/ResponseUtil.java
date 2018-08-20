package com.hxf.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class ResponseUtil {
	public static void responseObj(Object obj, HttpServletResponse response) {
		try {

			PrintWriter writer = response.getWriter();
			writer.println(obj);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void responseJson(Object obj, HttpServletResponse response) {
		try {

			PrintWriter writer = response.getWriter();
			writer.println(JSONObject.toJSONString(obj));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
