package com.example.demo.sample.hexagonal.application.service;

import com.example.demo.sample.hexagonal.application.port.in.MemberUsecase;
import com.example.demo.sample.hexagonal.application.port.out.MemberOutPort;
import com.example.demo.sample.hexagonal.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MemberService implements MemberUsecase {
    private final MemberOutPort memberOutPort;

    MemberService(MemberOutPort memberOutPort) {
        this.memberOutPort = memberOutPort;
    }

    @Override
    public List<Member> findAll() {
        return memberOutPort.findAll();
    }

    @Override
    public Member findById(Long id) {
        return memberOutPort.findById(id);
    }

}
