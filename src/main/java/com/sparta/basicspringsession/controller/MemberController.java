package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.serviece.MemberServiece;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiece memberServiece;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberServiece.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        return ResponseEntity.ok(memberServiece.getMembers());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberServiece.getMember(memberId));
    }

    @PutMapping("/mebers/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return ResponseEntity.ok(memberServiece.updateMember(memberId, requestDto));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberServiece.deleteMember(memberId);
    }
}
