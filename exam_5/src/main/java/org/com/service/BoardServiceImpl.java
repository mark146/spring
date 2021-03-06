package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.BoardEntity;
import org.com.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardEntity entity;
	
	@Transactional
	@Override
	public void regist(BoardVO vo) throws Exception {
		entity.create(vo);
		
		String[] files = vo.getFiles();
		System.out.println("files[0] = "+ files[0]);
		if(files == null) { return; }
		
		for(String fileName : files) {
			entity.addAttach(fileName);
		}
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(Integer bno) throws Exception {
		entity.updateViewCnt(bno);
		return entity.read(bno);
	}

	@Transactional
	@Override
	public void modify(BoardVO vo) throws Exception {
		entity.update(vo);
		
		Integer bno = vo.getBno();
		entity.deleteAttach(bno);
		
		String[] files = vo.getFiles();
		
		if(files == null) { return; }
		
		for(String fileName : files) {
			entity.replaceAttach(fileName, bno);
		}
	}

	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		entity.deleteAttach(bno);
		entity.delete(bno);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return entity.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return entity.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return entity.getAttach(bno);
	}
}