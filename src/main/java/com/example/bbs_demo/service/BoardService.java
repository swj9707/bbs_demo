package com.example.bbs_demo.service;

import com.example.bbs_demo.dto.BoardDTO;
import com.example.bbs_demo.dto.PageRequestDTO;
import com.example.bbs_demo.dto.PageResultDTO;
import com.example.bbs_demo.entity.Board;
import com.example.bbs_demo.entity.Member;
import org.springframework.data.domain.PageRequest;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }
}
