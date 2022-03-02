package com.lacoders.textclassification;

import com.alibaba.fastjson.JSON;
import com.lacoders.textclassification.bean.base.Result;
import com.lacoders.textclassification.bean.dto.AddNewsDTO;
import com.lacoders.textclassification.bean.dto.DeleteNewsDTO;
import com.lacoders.textclassification.bean.dto.UpdateNewsDTO;
import com.lacoders.textclassification.bean.vo.AddOrUpdateNewsVO;
import com.lacoders.textclassification.bean.vo.NewsDetailVO;
import com.lacoders.textclassification.controller.NewsController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

/**
 * @author liyitian
 * @version $Id: NewsTest.java, v 0.1 2022年02月28日 下午1:57 liyitian Exp $$
 */
 class NewsTest extends TextclassificationApplicationTests{

    @Resource
    private NewsController newsController;

    @Test
    public void testAddNews() throws ParseException {
        AddNewsDTO addNewsDTO = new AddNewsDTO();
        addNewsDTO.setNewsSrc("来源");
        addNewsDTO.setNewsTitle("今天是一个大标题2");
        addNewsDTO.setNewsType("时事新闻");
        addNewsDTO.setNewsWriter("佚名");
        addNewsDTO.setNewsTime("2022-02-28 14:30:30");
        addNewsDTO.setDeleted(0);
        addNewsDTO.setMaintext("1235新闻内容");
        Result<AddOrUpdateNewsVO> result = newsController.addNews(addNewsDTO);
        Assert.assertNotNull(result);
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testUpdateNews() throws ParseException {
        UpdateNewsDTO updateNewsDTO = new UpdateNewsDTO();
        updateNewsDTO.setNewsId(1);
        updateNewsDTO.setNewsSrc("来源2");
        updateNewsDTO.setNewsTitle("今天游戏大标题");
        updateNewsDTO.setNewsType("GAME");
        updateNewsDTO.setNewsWriter("佚名");
        updateNewsDTO.setNewsTime("2022-02-28 14:30:60");
        updateNewsDTO.setDeleted(0);
        updateNewsDTO.setMaintext("1235新闻内容");
        Result<AddOrUpdateNewsVO> result = newsController.updateNews(updateNewsDTO);
        Assert.assertNotNull(result);
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testNewsDetail() {
        Result<NewsDetailVO> result = newsController.queryNewsDetail(1);
        Assert.assertNotNull(result);
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testNewsDelete() {
        DeleteNewsDTO deleteNewsDTO = new DeleteNewsDTO();
        deleteNewsDTO.setNewsId(3);
        Result<AddOrUpdateNewsVO> result = newsController.deleteNews(deleteNewsDTO);
        Assert.assertNotNull(result);
        System.out.println("result = " + JSON.toJSONString(result));
    }
}
