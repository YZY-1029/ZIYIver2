package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 Entity name: User
Table name: users
+---------+-----------+---------------+------+-------+--------+------+
| user_id | username  | password_hash | salt | email | active | role |
+---------+-----------+---------------+------+-------+--------+------+
|   1     |  john     |   Qwd1234...  | $ED..| A@com |  true  | admin|
|   2     |  mary     |   Qwd5678...  | $AW..| B@com |  false | user |
+---------+-----------+---------------+------+-------+--------+------+
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity     // 代表這是一個實體類與吃料表對應 ( 會自動建立資料表 )
@Table(name = "users") // 可選: 手動建立資料表名   // ecil 的 User 會自動對應到茲表中的 users 
// 因為在資料表中的 user 是保留名所以取 users
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成id
	@Column(name = "user_id")  // 預設的資料表中ㄉ資料欄位名稱 
	private Integer userId; // 使用者 ID
	
	@Column(name = "username", unique = true, nullable = false, length = 50)   // 定義資料表ㄉ結構
	private String username;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Column(name = "salt", nullable = false)
	private String salt;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "role")
	private String role;
	
}
