package com.example.demo.sample.hexagonal.adapter.in;

import com.example.demo.sample.hexagonal.application.port.in.MemberUsecase;
import com.example.demo.sample.hexagonal.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final MemberUsecase memberUsecase;

    public MemberController(MemberUsecase memberUsecase) {
        this.memberUsecase = memberUsecase;
    }

    @GetMapping("/members")
    public List<Member> getMembers() {
        return memberUsecase.findAll();
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberUsecase.findById(id);
    }
}
