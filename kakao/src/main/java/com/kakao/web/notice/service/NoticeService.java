package com.kakao.web.notice.service;

import java.util.List;

import com.kakao.web.notice.model.Dto.NoticeDto;

public interface NoticeService {
	public List<NoticeDto> getNoticeListAll();
	public List<NoticeDto> getNoticeList(String pageNum);
	public int[] getNoticePages(String pageNum); 
	public int insertNotice (NoticeDto noticeDto);
	public NoticeDto getNoticeDto(String code);
	public int updateNotice(NoticeDto noticeDto);
	public int deleteNotice(String code);
}
