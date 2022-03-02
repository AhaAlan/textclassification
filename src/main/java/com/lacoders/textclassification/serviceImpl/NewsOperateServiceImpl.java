package com.lacoders.textclassification.serviceImpl;

import com.lacoders.textclassification.dao.mapper.NewsMapper;
import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.service.NewsOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class NewsOperateServiceImpl implements NewsOperateService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public Integer addNews(NewsPO newsPO) {
        newsMapper.insert(newsPO);
        return newsPO.getNewsId();
    }

    @Override
    public Integer updateNews(NewsPO newsPO) {
        newsMapper.updateByIdSelective(newsPO);
        return newsPO.getNewsId();
    }

    @Override
    public NewsPO queryDetailById(Integer newsId) {
        return newsMapper.selectById(newsId);
    }
}
