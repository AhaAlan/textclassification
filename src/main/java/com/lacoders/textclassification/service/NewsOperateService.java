package com.lacoders.textclassification.service;

import com.lacoders.textclassification.dao.model.NewsPO;

public interface NewsOperateService {

    Integer addNews(NewsPO newsPO);

    Integer updateNews(NewsPO newsPO);

    NewsPO queryDetailById(Integer newsId);
}