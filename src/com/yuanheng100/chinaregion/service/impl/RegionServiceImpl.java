package com.yuanheng100.chinaregion.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.yuanheng100.chinaregion.consts.Region;
import com.yuanheng100.chinaregion.service.IRegionService;

public class RegionServiceImpl implements IRegionService {

    private static LinkedHashMap<Integer, String> regionMap = Region.getInstance().getRegionMap();
    
    @Override
    public String getProvinceName(int code) {
        if (code / 100 == 0)
            code = code * 10000;
        else
        	code = code / 10000 * 10000;
        return regionMap.get(code);
    }
    
    @Override
    public String getCityName(int code) {
        if (code / 10000 == 0)
            code = code * 100;
        else 
        	code = code / 100 * 100;
        return regionMap.get(code);
    }

    @Override
    public String getDistrictOrCountyName(int code) {
        return regionMap.get(code);
    }

    @Override
    public Map<String, String> getProvinceList() {
        LinkedHashMap<String, String> provinceListMap = new LinkedHashMap<String, String>();
        Iterator<Entry<Integer, String>> it = regionMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
            Integer code = entry.getKey();
            if (code % 10000 == 0) { //判断是否是省代码
                provinceListMap.put(String.valueOf(code), entry.getValue());
            }
        }
        return provinceListMap;
    }
    
    @Override
    public Map<String, String> getCityList(int code) {
        if (code / 100 == 0) //判断是否是2位
            code = code * 10000;
        else
        	code = code / 10000 * 10000;
        LinkedHashMap<String, String> proviceListMap = new LinkedHashMap<String, String>();
        Iterator<Entry<Integer, String>> it = regionMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
            Integer c = entry.getKey();
            if ((c - code) > 0 && (c - code) < 10000 && (c % 100 == 0)) { //判断该省代码下的所有市
                proviceListMap.put(String.valueOf(c), entry.getValue());
            }
        }
        //直辖市
        if (proviceListMap == null || proviceListMap.isEmpty()) {
            proviceListMap.put(String.valueOf(code), getProvinceName(code));
        }
        return proviceListMap;
    }

    @Override
    public Map<String, String> getDistrictOrCountyList(int code) {
        int f = 100;
        if (code / 10000 == 0) //判断是否是4位
            code = code * 100;
        else
        	code = code / 100 * 100;
        if (code % 1000 == 0 && getCityName(code + 100) == null) { //区分北京市等没有省份的
            f = 10000;
        }
        LinkedHashMap<String, String> proviceListMap = new LinkedHashMap<String, String>();
        Iterator<Entry<Integer, String>> it = regionMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
            Integer c = entry.getKey();
            if ((c - code) > 0 && (c - code) < f && (c % 100 != 0)) {
                proviceListMap.put(String.valueOf(c), entry.getValue());
            }
        }
        return proviceListMap;
    }

	@Override
	public String getFullName(int code) {
		StringBuilder fullNameBuilder = new StringBuilder();
		String provinceName = getProvinceName(code);
		if(null == provinceName){
			return null;
		}else{
			fullNameBuilder.append(provinceName);
		}
		String cityName = getCityName(code);
		if(cityName!=null){
			fullNameBuilder.append(cityName);
		}
		String districtOrCountyName = getDistrictOrCountyName(code);
		if(districtOrCountyName!=null){
			fullNameBuilder.append(districtOrCountyName);
		}
		return fullNameBuilder.toString();
	}

}
