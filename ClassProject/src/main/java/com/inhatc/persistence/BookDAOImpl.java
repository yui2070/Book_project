package com.inhatc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.inhatc.domain.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.inhatc.mapper.BookMapper";

	@Override
	public void create(BookVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(vo.getSum());
		System.out.println(vo.getOther());
		System.out.println(vo.getIn_out());
		System.out.println(vo.getClassify());
		System.out.println(vo.getSpend_type());
		
		session.insert(namespace+".create", vo);
	}

	@Override
	public BookVO read(Integer no) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", no);
	}

	@Override
	public void update(BookVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(Integer no) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", no);
		
	}

	@Override
	public List<BookVO> listAll(BookVO bookVO) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(bookVO.getFirst_date());
		System.out.println(bookVO.getLast_date());
		System.out.println(bookVO.getIn_out());
		System.out.println(bookVO.getClassify());
		System.out.println(bookVO.getSpend_type());
		
		return session.selectList(namespace+".listAll", bookVO);
	}

	@Override
	public List<BookVO> typelist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".typelist");
	}

	@Override
	public List<BookVO> classifylist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".classifylist");
	}

	@Override
	public List<BookVO> stypelist(BookVO bookVO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stypelist");
	}
	

}
