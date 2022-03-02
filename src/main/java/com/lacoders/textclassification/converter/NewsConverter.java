package com.lacoders.textclassification.converter;

import com.lacoders.textclassification.bean.dto.AddNewsDTO;
import com.lacoders.textclassification.bean.dto.UpdateNewsDTO;
import com.lacoders.textclassification.bean.vo.NewsDetailVO;
import com.lacoders.textclassification.dao.model.NewsPO;
import com.lacoders.textclassification.enums.NewsTypeEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * 新闻对象转换类
 */
public class NewsConverter {

    public static NewsPO convertAddDTO2PO(AddNewsDTO dto) throws ParseException {
        NewsPO newsPO = new NewsPO();
        newsPO.setNewsSrc(dto.getNewsSrc());
        newsPO.setNewsTitle(dto.getNewsTitle());
        newsPO.setNewsType(dto.getNewsType());
        newsPO.setNewsWriter(dto.getNewsWriter());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dto.getNewsTime());
        newsPO.setNewsTime(date);
        newsPO.setDeleted(dto.getDeleted());
        newsPO.setMaintext(dto.getMaintext());
        return newsPO;
    }

    public static NewsPO convertUpdateDTO2PO(UpdateNewsDTO dto) throws ParseException {
        NewsPO newsPO = new NewsPO();
        newsPO.setNewsId(dto.getNewsId());
        newsPO.setNewsSrc(dto.getNewsSrc());
        newsPO.setNewsTitle(dto.getNewsTitle());
        newsPO.setNewsType(dto.getNewsType());
        newsPO.setNewsWriter(dto.getNewsWriter());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dto.getNewsTime());
        newsPO.setNewsTime(date);
        newsPO.setDeleted(dto.getDeleted());
        newsPO.setMaintext(dto.getMaintext());
        return newsPO;
    }

    public static NewsDetailVO convertPO2DetailVO(NewsPO newsPO) {
        if (Objects.isNull(newsPO)) {
            return null;
        }
        NewsDetailVO newsDetailVO = new NewsDetailVO();
        newsDetailVO.setNewsId(newsPO.getNewsId());
        newsDetailVO.setNewsSrc(newsPO.getNewsSrc());
        newsDetailVO.setNewsTitle(newsPO.getNewsTitle());
        newsDetailVO.setNewsType(newsPO.getNewsType());
        newsDetailVO.setNewsTypeDesc(NewsTypeEnum.getDescByCode(newsPO.getNewsType()));
        newsDetailVO.setNewsWriter(newsPO.getNewsWriter());
        newsDetailVO.setNewsTime(newsPO.getNewsTime());
        newsDetailVO.setDeleted(newsPO.getDeleted());
        newsDetailVO.setMaintext(newsPO.getMaintext());
        return newsDetailVO;
    }
}
