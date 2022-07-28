package com.example.bbs_demo.service;


import com.example.bbs_demo.dto.BoardDTO;
import com.example.bbs_demo.dto.PageRequestDTO;
import com.example.bbs_demo.dto.PageResultDTO;
import com.example.bbs_demo.entity.Board;
import com.example.bbs_demo.entity.Member;
import com.example.bbs_demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto){
        log.info(dto);

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO);
        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending())
        );
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long bno){
        Object result = boardRepository.getBoardByBno(bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

}
