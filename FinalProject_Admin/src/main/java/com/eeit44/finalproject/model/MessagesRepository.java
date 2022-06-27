package com.eeit44.finalproject.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessagesRepository extends JpaRepository<Messages, Integer> {

	
	@Query(value = "from Messages order by created")
	public List<Messages> queryAllMessages();

	
	@Query(value = "select * from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)"
			+ "    order by created", nativeQuery=true)
	public List<Messages> findChatMessageBySenderIdAndRecevierId(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	
	
	@Modifying
	@Query(value = "delete from messages where messageId = :messageId", nativeQuery=true)
	public void deleteByMessageId(@Param(value = "messageId") String messageId);

	
	@Modifying
	@Query(value = "delete from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)", nativeQuery=true)
	public void deletedChatMessageBySenderIdAndRecevierId(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}

