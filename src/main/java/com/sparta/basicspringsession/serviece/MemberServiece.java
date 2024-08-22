package com.sparta.basicspringsession.serviece;

import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiece {

    private final MemberRepository memberRepository;
}
