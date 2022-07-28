package com.example.bbs_demo.service;

import com.example.bbs_demo.dto.BoardDTO;
import com.example.bbs_demo.dto.PageRequestDTO;
import com.example.bbs_demo.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testReqister(){

        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user66@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }

}