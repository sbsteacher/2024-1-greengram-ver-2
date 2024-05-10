package com.green.greengram.feedcomment;

import com.green.greengram.feedcomment.model.FeedCommentDeleteReq;
import com.green.greengram.feedcomment.model.FeedCommentGetRes;
import com.green.greengram.feedcomment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FeedCommentService {

    private final FeedCommentMapper mapper;

    public long postFeedComment(FeedCommentPostReq p) {
        int affectedRows = mapper.insFeedComment(p);
        return p.getFeedCommentId();
    }

    public List<FeedCommentGetRes> getFeedComment(long feedId) {
        return mapper.selFeedCommentList(feedId);
    }

    public int deleteFeedComment(FeedCommentDeleteReq p) {
        return mapper.delFeedComment(p);
    }
}
