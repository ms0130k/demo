package com.example.demo.sample.hexagonal.adapter.out.repository;

import com.example.demo.sample.hexagonal.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}