package com.example.memberapi.controllers;

import com.example.memberapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/deletemember", method = RequestMethod.GET)
    public String admin(Model model){
        model.addAttribute("members", memberService.fetchAllMembers());
        return "member-list";
    }

    @RequestMapping(value = "/admin/deletemember/{memberId}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable("memberId") int memberId, Model model){
        memberService.deleteMemberById(memberId);
        model.addAttribute("members", memberService.fetchAllMembers());
        return "redirect:/admin/deletemember";
    }
}