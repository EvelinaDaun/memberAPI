package com.example.memberapi.services;

import com.example.memberapi.entities.Member;

import java.util.List;

public interface MemberServiceInterface {

    List<Member> fetchAllMembers();
    Member fetchMemberById(int id);
    Member updateMember(int id, Member member);
    Member addNewMember(Member member);
    void deleteMemberById(int id);
}