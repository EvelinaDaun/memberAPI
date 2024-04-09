package com.example.memberapi.services;

import com.example.memberapi.entities.Member;
import com.example.memberapi.exceptions.ResourceNotFoundException;
import com.example.memberapi.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> fetchAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member fetchMemberById(int id) {
        if(memberRepository.existsById(id)){
            Optional<Member> existingMember = memberRepository.findById(id);
            if(existingMember.isPresent()){
                return existingMember.get();
            }
        }
        throw new ResourceNotFoundException("Member", "id", id);
    }

    @Override
    public Member updateMember(int id, Member member) {
        memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("member", "id", id));
        return memberRepository.save(member);
    }

    @Override
    public Member addNewMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("member", "id", id));
        memberRepository.deleteById(id);
    }
}