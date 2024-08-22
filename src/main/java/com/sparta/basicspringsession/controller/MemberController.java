package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.serviece.MemberServiece;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiece memberServiece;
}
