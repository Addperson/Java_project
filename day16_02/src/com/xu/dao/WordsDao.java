package com.xu.dao;

import java.util.List;

import com.xu.domain.WordsBean;

public interface WordsDao {
	
	//检测是否存在
	List<WordsBean> findWords(String word);
	

}
