package com.lacoders.textclassification.dao.mapper;

import com.lacoders.textclassification.dao.model.NewsPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {


    int insert(NewsPO record);

    NewsPO selectById(Integer newsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Mon Feb 28 11:05:52 CST 2022
     */
    int updateByPrimaryKey(NewsPO record);

    int updateByIdSelective(NewsPO newsPO);
}