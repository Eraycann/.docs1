package com.project.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// @Entity Annotation ile tabloya'te maplenecek demek.
// @Table(name) yazılan name'ye göre veritabanında tablo oluşturulur.
// @Data, lombok @Data getter setter metotlarını otomatik generate eder.
@Entity
@Table(name="user")
@Data
public class User {

	@Id
	Long id;
	
	String userName;
	String password;
}
