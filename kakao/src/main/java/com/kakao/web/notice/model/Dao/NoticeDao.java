package com.kakao.web.notice.model.Dao;

import java.util.List;

import com.kakao.web.notice.model.Dto.NoticeDto;
 
public interface NoticeDao {
	public List<NoticeDto> getNoticeAll();
	public int insertNotice(NoticeDto noticeDto);
	public NoticeDto getNoticeDto(int notice_code);
	public int updateNotice(NoticeDto noticeDto);
	public int deleteNotice(int notice_code);
}