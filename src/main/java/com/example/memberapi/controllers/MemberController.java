package com.example.memberapi.controllers;

import com.example.memberapi.entities.Member;
import com.example.memberapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/admin/members")
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.fetchAllMembers());
    }

    @GetMapping("/admin/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable ("id") int id){
        return ResponseEntity.ok(memberService.fetchMemberById(id));
    }

    @PutMapping("/admin/updatemember/{id}")
    public ResponseEntity<Member> updateMemberById(@PathVariable("id") int id, @RequestBody Member member){
        return new ResponseEntity<>(memberService.updateMember(id, member), HttpStatus.OK);
    }

    @PostMapping("/admin/addmember")
    public ResponseEntity<Member> addMember(@RequestBody Member member){
        return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable ("id") int id){
        memberService.deleteMemberById(id);
        return new ResponseEntity<>("Member deleted.", HttpStatus.OK);
    }
}