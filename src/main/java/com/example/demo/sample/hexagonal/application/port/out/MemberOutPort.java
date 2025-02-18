package com.example.demo.sample.hexagonal.application.port.out;

import com.example.demo.sample.hexagonal.domain.Member;

import java.util.List;

public interface MemberOutPort {
    List<Member> findAll();
    Member findById(Long id);
}
