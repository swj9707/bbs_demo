package com.example.bbs_demo.repository;

import com.example.bbs_demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
