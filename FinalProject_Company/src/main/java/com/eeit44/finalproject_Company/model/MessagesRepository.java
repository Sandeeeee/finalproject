package com.eeit44.finalproject_Company.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessagesRepository extends JpaRepository<Messages, Integer> {

	
	@Query(value = "from Messages where senderId=:senderId  or receiverId=:senderId order by created")
	public List<Messages> queryAllMessages(@Param(value = "senderId") String senderId);

	
	@Query(value = "select * from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)"
			+ "    order by created", nativeQuery=true)
	public List<Messages> findChatMessageByRecevierId(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	

	
	@Modifying
	@Query(value = "delete from messages  "
			+ "where (senderId=:senderId and receiverId=:receiverId) "
			+ "or (senderId=:receiverId and receiverId=:senderId)", nativeQuery=true)
	public void deletedChatMessageByRecevierId(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}

