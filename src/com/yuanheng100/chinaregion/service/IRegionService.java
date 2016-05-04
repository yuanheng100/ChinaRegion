package com.yuanheng100.chinaregion.service;

import java.util.Map;

/**
 * 行政区划服务接口<br>
 * 数据来源：国家统计局  http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/
 * @author baisong
 *
 */
public interface IRegionService
{

	/**
	 * 根据2位或6位代码，取得省名
	 * @param code
	 * @return
	 */
	public String getProvinceName(int code);
	
	/**
	 * 根据4位或6位代码，取得市名
	 * @param code
	 * @return
	 */
	public String getCityName(int code);
	
	/**
	 * 根据6位代码，取得区/县名
	 * @param code
	 * @return
	 */
	public String getDistrictOrCountyName(int code);
	
	/**
	 * 取得全国所有省/直辖市/自治区的列表
	 * @return
	 */
	public Map<String, String> getProvinceList();
	
	/**
	 * 根据2位或6位省代码，取得某省下所有市的列表
	 * @param code
	 * @return
	 */
	public Map<String, String> getCityList(int code);
	
	/**
	 * 根据4位或6位市代码，取得某市下所有区/县的列表
	 * @param code
	 * @return
	 */
	public Map<String, String> getDistrictOrCountyList(int code);
	
	/**
	 * 根据6位代码，取得地区全称
	 * @param code
	 * @return
	 */
	public String getFullName(int code);
}
