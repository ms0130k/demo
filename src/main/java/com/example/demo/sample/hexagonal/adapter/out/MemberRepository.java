package com.example.demo.sample.hexagonal.adapter.out;

import com.example.demo.sample.hexagonal.adapter.out.repository.MemberJpaRepository;
import com.example.demo.sample.hexagonal.application.port.out.MemberOutPort;
import com.example.demo.sample.hexagonal.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository implements MemberOutPort {
    private final MemberJpaRepository memberJpaRepository;

    public MemberRepository(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberJpaRepository.findAll();
    }

    @Override
    public Member findById(Long id) {
        Member member = memberJpaRepository.findById(id).orElse(null);
        return member;
    }
}
