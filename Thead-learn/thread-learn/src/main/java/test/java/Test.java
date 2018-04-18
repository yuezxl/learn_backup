package test.java;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class Test {
	 public static void main(String[] args) {
		String jsonStr = "{\"status\":0,\"error\":null,\"result\":\"{\\\"product\\\":{\\\"is_show_resetjoinnet\\\":true,\\\"p_description\\\":\\\"古北智能插座SPmini\\\",\\\"lancon\\\":\\\"0\\\",\\\"product_id\\\":20435,\\\"config_type\\\":1001,\\\"product_name\\\":\\\"古北智能插座（新）\\\",\\\"pro_type\\\":102010,\\\"share_flag\\\":1,\\\"template_type\\\":\\\"h5\\\",\\\"cid\\\":102010,\\\"protocol_version\\\":\\\"-1\\\",\\\"product_uuid\\\":\\\"WJGTXS\\\",\\\"type_desc\\\":\\\"\\\",\\\"p_img_url\\\":\\\"https://img30.360buyimg.com/smartcloud/s200x200_jfs/t2410/257/79103207/35595/9a3c0874/55ecfe77Ne0711f78.png\\\",\\\"type_name\\\":\\\"插座\\\"},\\\"shared_info\\\":{\\\"shared_count\\\":\\\"0\\\",\\\"isShared\\\":\\\"1\\\"},\\\"h5\\\":{\\\"url\\\":\\\"https://smarth5.3.cn/h5/20435/15/1480394578361/index.html\\\",\\\"version\\\":15},\\\"device\\\":{\\\"active_time\\\":\\\"2017-12-11 09:27:08\\\",\\\"device_name\\\":\\\"GuBeiChazuowrong\\\",\\\"status\\\":\\\"1\\\",\\\"device_id\\\":\\\"b4430dc4ec84\\\",\\\"access_key\\\":\\\"cc3d007398a2084366806db4198c01df\\\",\\\"feed_id\\\":151090801797064706,\\\"main_sub_type\\\":0},\\\"streams\\\":[{\\\"current_value\\\":\\\"0|0\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"充电保护\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"chargeprotect\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"当前功率\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"curpwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"循环任务\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"cyctsk\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"24H能耗值\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"daypwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"+0800-21060206-142816\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"设备时间\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"devtime\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"月功率\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"monpwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"小夜灯\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"ntlight\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"小夜灯周期任务\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"ntlightper\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"峰谷时间\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"peaktime\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"周期任务\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"pertsk\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"1\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"设置开关\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"[{\\\\\\\"0\\\\\\\":\\\\\\\"关\\\\\\\"},{\\\\\\\"1\\\\\\\":\\\\\\\"开\\\\\\\"}]\\\",\\\"stream_id\\\":\\\"pwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"防盗任务\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"randtsk\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"待机功率\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"standbypwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"延时任务\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"tmrtsk\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"周功率\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"wkpwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"支持年数\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"yrcnt\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"},{\\\"current_value\\\":\\\"\\\",\\\"stream_type\\\":0,\\\"stream_name\\\":\\\"年功率\\\",\\\"at\\\":\\\"\\\",\\\"value_des\\\":\\\"\\\",\\\"stream_id\\\":\\\"yrpwr\\\",\\\"units\\\":\\\"\\\",\\\"ptype\\\":\\\"string\\\"}],\\\"newdesc\\\":\\\"0\\\"}\"}";
		
		
		//String value = getCurrentValueBySteamId(jsonStr, "pwr");
		//System.out.println(value);
		
		getValue(jsonStr, "pwr");
	}
	 
	 public static String getCurrentValueBySteamId(String response, String streamId) {
		 JSONObject json = JSONObject.parseObject(response);
		 String resultStr = json.getString("result");
			JSONObject result = JSONObject.parseObject(resultStr);
			JSONArray streams = result.getJSONArray("streams");
			for(Object object : streams) {
				JSONObject jsonObject = (JSONObject) object;
				if(streamId.equals(jsonObject.getString("stream_id"))) {
					return jsonObject.getString("current_value");
				}
			}
			return null;
	 }
	 
	 public static String getValue(String resposne, String streamId) {
		 String str = (String) JSONPath.read(resposne, "$.result");
		 System.out.println(JSONPath.read(str, "$.streams"));
		 JSONPath.read(str, "$.streams[stream_id =='pwr']");
		 
		 //System.out.println(result);
		 return null;
	 }
}
