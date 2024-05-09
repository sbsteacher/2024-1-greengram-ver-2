package com.green.greengram.feedcomment;

import com.green.greengram.feedcomment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@Service
public class FeedCommentService {

    private final FeedCommentMapper mapper;


    public long postFeedComment(FeedCommentPostReq p) {
        int affectedRows = mapper.insFeedComment(p);
        return p.getFeedCommentId();
    }

}
