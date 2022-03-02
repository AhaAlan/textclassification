package com.lacoders.textclassification.controller;


import com.lacoders.textclassification.bean.base.Result;
import com.lacoders.textclassification.bean.dto.AddCommentDTO;
import com.lacoders.textclassification.bean.dto.DeleteCommentDTO;
import com.lacoders.textclassification.bean.dto.UpdateCommentDTO;
import com.lacoders.textclassification.bean.vo.AddOrUpdateCommentVO;
import com.lacoders.textclassification.bean.vo.CommentDetailVO;
import com.lacoders.textclassification.converter.CommentConverter;
import com.lacoders.textclassification.dao.model.CommentPO;
import com.lacoders.textclassification.service.CommentOperateService;
import com.lacoders.textclassification.util.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Objects;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentOperateService commentOperateService;


    //新增评论 ， 实现评论功能
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public Result<AddOrUpdateCommentVO> addComment(@RequestBody AddCommentDTO addCommentDTO) throws ParseException {
        CommentPO commentPO = CommentConverter.convertAddDTO2PO(addCommentDTO);
        Integer commentId = commentOperateService.addComment(commentPO);
        AddOrUpdateCommentVO addOrUpdateCommentVO = new AddOrUpdateCommentVO();
        addOrUpdateCommentVO.setCommentId(commentId);
        addOrUpdateCommentVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateCommentVO);
    }

    //修改评论， 用户修改评论内容
    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    public Result<AddOrUpdateCommentVO> updateComment(@RequestBody UpdateCommentDTO updateCommentDTO) throws ParseException {
        if (Objects.isNull(updateCommentDTO.getCommentId())) {
            return ResultUtils.failResult(500,"编辑新闻主键id不可为空");
        }
        CommentPO commentPO = CommentConverter.convertUpdateDTO2PO(updateCommentDTO);
        Integer commentId = commentOperateService.updateComment(commentPO);
        AddOrUpdateCommentVO addOrUpdateCommentVO = new AddOrUpdateCommentVO();
        addOrUpdateCommentVO.setCommentId(commentId);
        addOrUpdateCommentVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateCommentVO);
    }

    //删除评论， 用户或管理员可以删除评论
    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public Result<AddOrUpdateCommentVO> deleteNews(@RequestBody DeleteCommentDTO dto) {
        if (Objects.isNull(dto.getCommentId())) {
            return ResultUtils.failResult(500,"删除新闻主键id不可为空");
        }
        Integer commentId = dto.getCommentId();
        CommentPO commentPO = buildDeletedCommentPO(commentId);
        commentOperateService.updateComment(commentPO);
        AddOrUpdateCommentVO addOrUpdateCommentVO = new AddOrUpdateCommentVO();
        addOrUpdateCommentVO.setCommentId(commentId);
        addOrUpdateCommentVO.setWhetherSuccess(Boolean.TRUE);
        return ResultUtils.successResult(addOrUpdateCommentVO);
    }


    //查找评论
    @RequestMapping(value = "/queryCommentDetail", method = RequestMethod.GET)
    public Result<CommentDetailVO> queryCommentDetail(@RequestParam("commentId") Integer commentId){
        if (Objects.isNull(commentId)) {
        return ResultUtils.failResult(500,"查看新闻详情主键id不可为空");
        }
        CommentPO commentPO = commentOperateService.queryDetailById(commentId);
        if (Objects.isNull(commentPO)) {
            return ResultUtils.successMsg(null, "不存在该评论");
        }
        return ResultUtils.successResult(CommentConverter.convertPO2DetailVO(commentPO));

    }

    //逻辑删除 物理上不删除
    private CommentPO buildDeletedCommentPO(Integer commentId) {
        CommentPO commentPO = new CommentPO();
        commentPO.setCommentId(commentId);
        commentPO.setDeleted(1);
        return commentPO;
    }


}
