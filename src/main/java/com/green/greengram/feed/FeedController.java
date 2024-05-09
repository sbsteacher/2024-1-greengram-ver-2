package com.green.greengram.feed;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.feed.model.FeedGetReq;
import com.green.greengram.feed.model.FeedGetRes;
import com.green.greengram.feed.model.FeedPostReq;
import com.green.greengram.feed.model.FeedPostRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed")
@Tag(name = "Feed 피드", description = "Feed CRUD")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "Feed 등록", description = "")
    public ResultDto<FeedPostRes> postFeed(@RequestPart List<MultipartFile> pics, @RequestPart FeedPostReq p) {
        FeedPostRes result = service.postFeed(pics, p);

        return ResultDto.<FeedPostRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(summary = "Feed 리스트", description = "loginUserId는 로그인한 사용자의 pk")
    public ResultDto<List<FeedGetRes>> getFeed(@ParameterObject @ModelAttribute FeedGetReq p) {
        List<FeedGetRes> result = service.getFeed(p);

        return ResultDto.<List<FeedGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
}
