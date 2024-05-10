package com.green.greengram.feedcomment;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.feed.model.FeedPostRes;
import com.green.greengram.feedcomment.model.FeedCommentDeleteReq;
import com.green.greengram.feedcomment.model.FeedCommentGetRes;
import com.green.greengram.feedcomment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    public ResultDto<Long> postFeedComment(@RequestBody FeedCommentPostReq p) {
        long feedCommentId = service.postFeedComment(p);
        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(feedCommentId)
                .build();
    }

    @GetMapping
    public ResultDto<List<FeedCommentGetRes>> getFeedComment(@RequestParam(name="feed_id") long feedId) {
        List<FeedCommentGetRes> list = service.getFeedComment(feedId); //4~N

        return ResultDto.<List<FeedCommentGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(String.format("rows: %,d", list.size()))
                .resultData(list)
                .build();
    }

    @DeleteMapping
    public ResultDto<Integer> deleteFeedComment(@ParameterObject @ModelAttribute FeedCommentDeleteReq p) {
        int result = service.deleteFeedComment(p); //0: 삭제 실패, 1: 삭제 성공

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(result == 0 ? "댓글을 삭제할 수 없습니다." : "댓글을 삭제하였습니다.")
                .resultData(result)
                .build();
    }
}
