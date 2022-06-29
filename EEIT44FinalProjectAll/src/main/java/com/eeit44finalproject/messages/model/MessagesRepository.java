package com.eeit44finalproject.messages.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface MessagesRepository extends JpaRepository<Messages, Integer> {

	//-------------Admin--------------------------Admin--------------------------Admin-------------
	
	@Query(value = "from Messages order by created")
	public List<Messages> queryAllMessagesAdmin();

	
	@Query(value = "select * from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)"
			+ "    order by created", nativeQuery=true)
	public List<Messages> findChatMessageBySenderIdAndRecevierIdAdmin(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	
	
	@Modifying
	@Query(value = "delete from messages where messageId = :messageId", nativeQuery=true)
	public void deleteByMessageIdAdmin(@Param(value = "messageId") String messageId);

	
	@Modifying
	@Query(value = "delete from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)", nativeQuery=true)
	public void deletedChatMessageBySenderIdAndRecevierIdAdmin(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	
	
	//-------------Company---------------------Company--------------------Company------------

	@Query(value = "from Messages where senderId=:senderId  or receiverId=:senderId order by created")
	public List<Messages> queryAllMessagesCompany(@Param(value = "senderId") String senderId);

	
	@Query(value = "select * from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)"
			+ "    order by created", nativeQuery=true)
	public List<Messages> findChatMessageByRecevierIdCompany(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	

	
	@Modifying
	@Query(value = "delete from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)", nativeQuery=true)
	public void deletedChatMessageByRecevierIdCompany(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}

