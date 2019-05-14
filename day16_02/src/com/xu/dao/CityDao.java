package com.xu.dao;

import java.util.List;

import com.xu.domain.CityBean;

public interface CityDao {

	List<CityBean> findCity(int pid);
}
