package com.example.demo.sample.hexagonal.application.port.in;

import com.example.demo.sample.hexagonal.domain.Member;

import java.util.List;

public interface MemberUsecase {
    List<Member> findAll();
    Member findById(Long id);
}
