package org.com.controller;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.BoardEntity;
import org.com.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardEntityTest {
	@Inject
	private BoardEntity entity;
	
	private static Logger logger = LoggerFactory.getLogger(BoardEntity.class);

//	@Test
//	public void testCreate() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("새로운 글을 넣습니다.");
//		vo.setContent("새로운 글을 넣습니다.");
//		vo.setWriter("user00");
//		entity.create(vo);
//	}
//	
//	@Test
//	public void testUpdate() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setBno(1);
//		vo.setTitle("수정된 글입니다.");
//		vo.setContent("수정 테스트");
//		entity.update(vo);
//	}
//	
//	@Test
//	public void testDelete() throws Exception {
//		entity.delete(1);
//	}
//	
//	@Test
//	public void testListPage() throws Exception {
//		int page = 2;
//		
//		List<BoardVO> list = entity.listPage(page);
//		
//		for (BoardVO vo : list) {
//			logger.info(vo.getBno() + ":" + vo.getTitle());
//		}
//	}
//	
//	@Test
//	public void testListCriteria() throws Exception {
//		Criteria cri = new Criteria();
//		cri.setPage(2);
//		cri.setPerPageNum(10);
//		
//		List<BoardVO> list = entity.listCriteria(cri);
//		
//		for (BoardVO vo : list) {
//			logger.info(vo.getBno() + ":" + vo.getTitle());
//		}
//	}
//	
//	@Test
//	public void testURI()throws Exception {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//				.path("/board/read")
//				.queryParam("bno", 12)
//				.queryParam("perPageNum", 10)
//				.build();
//		
//		logger.info("/board/read?bno=12&perPageNum=10");
//		logger.info(uriComponents.toString());
//	}
//
//	@Test
//	public void testURI2() throws Exception {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//				.path("/{module}/{page}")
//				.queryParam("bno", 12)
//				.queryParam("perPageNum", 10)
//				.build()
//				.expand("board","read")
//				.encode();
//		logger.info("/board/read?bno=12&perPageNum=10");
//		logger.info(uriComponents.toString());
//	}

	@Test
	public void testDynamic1() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("12");
		cri.setSearchType("t");
		logger.info("========================");
		
		List<BoardVO> list = entity.listSearch(cri);
		
		for (BoardVO vo : list) {
			logger.info(vo.getBno() + ": " + vo.getTitle());
		}
		
		logger.info("========================");
		
		logger.info("COUNT : " + entity.listSearchCount(cri));
	}
}