package com.todaktodak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.DiaryShare;


@Repository
public interface SocialDiaryRepository extends JpaRepository<DiaryShare, Long> {

	@Query(value = "SELECT * FROM tb_diary_share WHERE to_user = :email", nativeQuery = true)
	public List<DiaryShare> getReplyDiaryList(@Param("email") String email);
	
	@Query(value = "select * from tb_diary_share where to_user is null", nativeQuery = true)
	public List<DiaryShare> getRandomDiaryList();
	
	@Query(value = "select * from tb_diary_share where (to_user = :userA AND user_email = :userB) OR (to_user = :userB AND user_email = :userA)", nativeQuery = true)
	public List<DiaryShare> getDiaryRoomList(@Param("userA") String userA, @Param("userB") String userB);

	@Query(value = "insert into tb_diary_share (user_email, to_user, diary_content) values (:fromUser, :toUser, :content)", nativeQuery = true)
	public String sendDiary(@Param("toUser") String toUser, @Param("fromUser") String fromUser, @Param("content") String content);
	
	@Query(value = "insert into tb_diary_share (user_email, diary_content) values (:user, :content)", nativeQuery = true)
	public String openDiary(@Param("user") String user, @Param("content") String content);
}