package com.green.greengram.user;

import com.green.greengram.common.model.ResultDto;
import com.green.greengram.user.model.SignInPostReq;
import com.green.greengram.user.model.SignInPostRes;
import com.green.greengram.user.model.SignUpPostReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "User 유저", description = "유저 CRUD, sign-in, sign-out")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입", description = "프로필 사진은 필수가 아님")
    public ResultDto<Integer> postUser(@RequestPart(required = false) MultipartFile pic
                                    , @RequestPart SignUpPostReq p) {
        log.info("pic: {}", pic);
        log.info("p: {}", p);
        int result = service.postSignUp(pic, p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 성공")
                .resultData(result)
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "인증처리", description = "")
    public ResultDto<SignInPostRes> postSignIn(@RequestBody SignInPostReq p) {
        log.info("p: {}", p);
        SignInPostRes result = service.postSignIn(p);

        return ResultDto.<SignInPostRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("인증 성공")
                .resultData(result)
                .build();
    }
}
