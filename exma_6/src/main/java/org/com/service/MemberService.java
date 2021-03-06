package org.com.service;

import java.util.*;
import org.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Transactional
	public void create(UserVO vo) {
		UserDetails user = new User(vo.getUid(), vo.getUpw(), Arrays.asList(new SimpleGrantedAuthority("USER")));
		logger.info("auth = "+user.getAuthorities());
		logger.info("username = "+user.getUsername());
		logger.info("password = "+user.getPassword());
	}
}