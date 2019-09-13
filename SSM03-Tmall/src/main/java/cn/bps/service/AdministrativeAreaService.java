package cn.bps.service;

import cn.bps.pojo.AdministrativeArea;

import java.util.List;
import java.util.Map;

public interface AdministrativeAreaService {

    List<AdministrativeArea> getProvinces();
    List<AdministrativeArea> getChildrenCities(String parentCode);
    Map<String,String> toTuple(List<AdministrativeArea> administrativeAreas);


}
