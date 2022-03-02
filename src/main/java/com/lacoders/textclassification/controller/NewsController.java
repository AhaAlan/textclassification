package com.lacoders.textclassification.controller;

import com.lacoders.textclassification.bean.base.Result;
import com.lacoders.textclassification.bean.dto.AddNewsDTO;
import com.lacoders.textclassification.bean.dto.DeleteNewsDTO;
import com.lacoders.textclassification.bean.dto.UpdateNewsDTO;
import com.lacoders.textclassification.bean.vo.AddOrUpdateNewsVO;
import com.lacoders.textclassification.bean.vo.NewsDetailVO;
import com.lacoders.textclassification.converter.NewsConverter;
import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.service.NewsOperateService;
import com.lacoders.textclassification.util.ResultUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Objects;


@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsOperateService newsOperateService;

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public Result<AddOrUpdateNewsVO> addNews(@RequestBody AddNewsDTO addNewsDTO) throws ParseException {
        NewsPO newsPO = NewsConverter.convertAddDTO2PO(addNewsDTO);
        Integer newsId = newsOperateService.addNews(newsPO);
        AddOrUpdateNewsVO addOrUpdateNewsVO = new AddOrUpdateNewsVO();
        addOrUpdateNewsVO.setNewsId(newsId);
        addOrUpdateNewsVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateNewsVO);
    }

    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    public Result<AddOrUpdateNewsVO> updateNews(@RequestBody UpdateNewsDTO updateNewsDTO) throws ParseException {
        if (Objects.isNull(updateNewsDTO.getNewsId())) {
            return ResultUtils.failResult(500,"编辑新闻主键id不可为空");
        }
        NewsPO newsPO = NewsConverter.convertUpdateDTO2PO(updateNewsDTO);
        Integer newsId = newsOperateService.updateNews(newsPO);
        AddOrUpdateNewsVO addOrUpdateNewsVO = new AddOrUpdateNewsVO();
        addOrUpdateNewsVO.setNewsId(newsId);
        addOrUpdateNewsVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateNewsVO);
    }

    @RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
    public Result<AddOrUpdateNewsVO> deleteNews(@RequestBody DeleteNewsDTO deleteNewsDTO) {
        if (Objects.isNull(deleteNewsDTO.getNewsId())) {
            return ResultUtils.failResult(500,"删除新闻主键id不可为空");
        }
        Integer newsId = deleteNewsDTO.getNewsId();
        NewsPO newsPO = buildDeletedNewsPO(newsId);
        newsOperateService.updateNews(newsPO);
        AddOrUpdateNewsVO addOrUpdateNewsVO = new AddOrUpdateNewsVO();
        addOrUpdateNewsVO.setNewsId(newsId);
        addOrUpdateNewsVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateNewsVO);
    }

    @RequestMapping(value = "/queryNewsDetail", method = RequestMethod.GET)
    public Result<NewsDetailVO> queryNewsDetail(@RequestParam("newsId") Integer newsId) {
        if (Objects.isNull(newsId)) {
            return ResultUtils.failResult(500,"查看新闻详情主键id不可为空");
        }
        NewsPO newsPO = newsOperateService.queryDetailById(newsId);
        if (Objects.isNull(newsPO)) {
            return ResultUtils.successMsg(null, "不存在该新闻");
        }
        return ResultUtils.successResult(NewsConverter.convertPO2DetailVO(newsPO));
    }


    private NewsPO buildDeletedNewsPO(Integer newsId) {
        NewsPO newsPO = new NewsPO();
        newsPO.setNewsId(newsId);
        newsPO.setDeleted(1);
        return newsPO;
    }

}
