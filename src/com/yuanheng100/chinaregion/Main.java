package com.yuanheng100.chinaregion;

import java.util.Map;
import java.util.Map.Entry;

import com.yuanheng100.chinaregion.service.IRegionService;
import com.yuanheng100.chinaregion.service.impl.RegionServiceImpl;

public class Main {
	
	private static IRegionService regionService = new RegionServiceImpl();

	public static void main(String[] args) {
		//根据2位、6位代码获取省名
		System.out.println("-------------------根据2位、6位代码获取省名-------------------");
		System.out.println("110101对应的省份为："+getProvinceName(110101));
		System.out.println("11对应的省份为："+getProvinceName(11));
		System.out.println();
		System.out.println("130102对应的省份为："+getProvinceName(130102));
		System.out.println("13对应的省份为："+getProvinceName(13));
		//根据4位或6位代码，取得市名
		System.out.println("-------------------根据4位或6位代码，取得市名-------------------");
		System.out.println("110101对应的市为："+getCityName(110101));
		System.out.println("1101对应的市为："+getCityName(1101));
		System.out.println();
		System.out.println("130102对应的市为："+getCityName(130102));
		System.out.println("1301对应的市为："+getCityName(1301));
		//根据6位代码，取得区/县名
		System.out.println("-------------------根据6位代码，取得区/县名-------------------");
		System.out.println("110101对应的地区为："+getDistrictOrCountyName(110101));
		System.out.println("130102对应的地区为："+getDistrictOrCountyName(130102));
		//取得全国所有省/直辖市/自治区的列表
		System.out.println("-------------------取得全国所有省/直辖市/自治区的列表-------------------");
		Map<String, String> provinceList = getProvinceList();
		for (Entry<String, String> entry : provinceList.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		//根据2位或6位省代码，取得某省下所有市的列表
		System.out.println("-------------------根据2位或6位代码，取得所在省下所有市的列表-------------------");
		Map<String, String> cityList = getCityList(110101);
		for (Entry<String, String> entry : cityList.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println();
		cityList = getCityList(130102);
		for (Entry<String, String> entry : cityList.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		//根据4位或6位代码，取得所在市下所有区/县的列表
		System.out.println("-------------------根据4位或6位代码，取得所在市下所有区/县的列表-------------------");
		Map<String, String> districtOrCountyList = getDistrictOrCountyList(110101);
		for (Entry<String, String> entry : districtOrCountyList.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println();
		districtOrCountyList = getDistrictOrCountyList(130102);
		for (Entry<String, String> entry : districtOrCountyList.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		//根据6位代码，取得地区全称
		System.out.println("-------------------根据6位代码，取得地区全称-------------------");
		System.out.println("110101对应的地区全称为："+getFullName(110101));
		System.out.println("130102对应的地区全称为："+getFullName(130102));
		
	}
	
	//根据2位、6位代码获取省
	public static String getProvinceName(Integer code){
		return regionService.getProvinceName(code);
	}
	
	//根据4位或6位代码，取得市名
	public static String getCityName(Integer code){
		return regionService.getCityName(code);
	}
	
	//根据6位代码，取得区/县名
	public static String getDistrictOrCountyName(Integer code){
		return regionService.getDistrictOrCountyName(code);
	}
	
	//取得全国所有省/直辖市/自治区的列表
	public static Map<String,String> getProvinceList(){
		return regionService.getProvinceList();
	}
	
	//根据2位或6位省代码，取得某省下所有市的列表
	public static Map<String,String> getCityList(int code){
		return regionService.getCityList(code);
	}
	
	//根据4位或6位市代码，取得某市下所有区/县的列表
	public static Map<String,String> getDistrictOrCountyList(int code){
		return regionService.getDistrictOrCountyList(code);
	}
	
	//根据6位代码，取得地区全称
	public static String getFullName(int code){
		return regionService.getFullName(code);
	}
}
