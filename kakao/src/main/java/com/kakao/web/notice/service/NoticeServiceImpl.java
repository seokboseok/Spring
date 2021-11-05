package com.kakao.web.notice.service;

import java.util.ArrayList;
import java.util.List;

import com.kakao.web.notice.model.Dao.NoticeDao;
import com.kakao.web.notice.model.Dao.NoticeDaoImpl;
import com.kakao.web.notice.model.Dto.NoticeDto;

public class NoticeServiceImpl implements  NoticeService{
	private NoticeDao noticeDao;
	private int noticeTotalCount;
	
	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}
	
	@Override
	public List<NoticeDto> getNoticeListAll() {
		List<NoticeDto> noticeListAll = noticeDao.getNoticeAll();
		noticeTotalCount = noticeListAll.size();
		
		return noticeListAll;
	}
	
	@Override
	public List<NoticeDto> getNoticeList(String pageNum) {
		List<NoticeDto> noticeListAll = getNoticeListAll();//전체 리스트
		
		List<NoticeDto> noticeList = new ArrayList<NoticeDto>();//비어있는 리스트
		
		int page = Integer.parseInt(pageNum);
		
		int startIndex = (page - 1) * 20;
		int endIndex = page * 20;
		
		for(int i = startIndex; i < endIndex && i < noticeTotalCount; i++) {
			noticeList.add(noticeListAll.get(i));
		}
		
		return noticeList;
	}
	
	@Override
	public int[] getNoticePages(String pageNum) {
		int page = Integer.parseInt(pageNum);
		
		int totalPage = noticeTotalCount%20 == 0 ? noticeTotalCount/20 : noticeTotalCount/20 + 1;
		int startPage = page%5 == 0 ? page - 4 : page - (page%5) + 1;
		int endPage = startPage + 4 <= totalPage ? startPage + 4 : totalPage;
		
		int[] pages = {totalPage, startPage, endPage};
		
		return pages;
	}


	public int insertNotice(NoticeDto noticeDto) {
		int result= noticeDao.insertNotice(noticeDto);
		if(result!=2) {	
			return 0;
		}
		return 1;
	}

	@Override
	public NoticeDto getNoticeDto(String code) {
		int notice_code=Integer.parseInt(code);
		return noticeDao.getNoticeDto(notice_code);
	}

	@Override
	public int updateNotice(NoticeDto noticeDto) {
		int result= noticeDao.updateNotice(noticeDto);
		if(result==2) {
			System.out.println("정상적으로 처리 되었습니다");
			result=1;
		}else {
			System.out.println("notice수정 오류 ");
			result=0;
		}
		return result;
	}

	@Override
	public int deleteNotice(String code) {
		int notice_code=Integer.parseInt(code);
		int result= noticeDao.deleteNotice(notice_code);
		if(result==2) {
			System.out.println("삭제완료");
			result=1;
		}else {
			System.out.println("삭제 실패");
			result=0;
		}
		return result;
	}
}