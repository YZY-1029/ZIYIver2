package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Room;

// Spring JPA
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> { // Room: entity, Integer: @Id ㄉ型別
	// 預設會實現 CRUD
	// 自定義查詢
	// 1. 查詢 room_size 大於指定值ㄉ房間( 自動生成 SQL )
	List<Room> findByRoomSizeGreaterThan(Integer size);
		
	
	// 2. 查詢 roomSize 大於指定值ㄉ房間 (自行撰寫 T-SQL, 注意 : 欄位名稱要符合資料表中ㄉ的設定)
	@Query(value = "select room_id, room_name, room_size from room where room_size > :roomSize ", nativeQuery = true)
	List<Room> findRooms(Integer roomSize);
	
	
	// 3. 查詢 roomSize 大於指定值ㄉ房間 (自行撰寫 PQL, 注意 : 欄位名稱要符合 entity 中ㄉ的設定)
	@Query(value = "select r from Room r where r.roomSize > :roomSize ")
	List<Room> readRooms(Integer roomSize);
	
	
	
}
