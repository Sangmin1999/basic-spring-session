package com.sparta.basicspringsession.serviece;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiece {

    private final MemberRepository memberRepository;

@Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
    Member newMember = new Member(requestDto.getName());
    Member savedMember = memberRepository.save(newMember);

    return new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : members) {
            MemberSimpleResponseDto dto = new MemberSimpleResponseDto(member.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
    Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("없는 학생입니다."));

        return new MemberDetailResponseDto(member.getId(), member.getName());
    }
@Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto requestDto) {
    Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("없는 학생입니다."));

    member.update(requestDto.getName());

    return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NullPointerException("없는 학생입니다."));

        memberRepository.delete(member);
    }
}
