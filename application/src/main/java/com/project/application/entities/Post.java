package com.project.application.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
public class Post {
	@Id
	Long id;
	
	//Long userId; // oluşturma aşamasında lazım, sonrasında diil
	
	// @ManytoOne, birçok Post bir User'a bağlı
	// @ManyToOne(fetch = FetchType.LAZY), FetchType.LAZY ile post çekildiğinde ilgili user objesi direkt gelmeyecektir.
	// @JoinColumn, post tablosundaki user_id columnıyla User objectine bağlandığımızı söylemiş olduk.
	// @OnDelete(action = OnDeleteAction.CASCADE), bir user silindiğinde tüm postları silinmeli
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE) 
	@JsonIgnore
	User user;		
	// aslında bütün bir User'i Json olarak almak sakıncalı. 
	// bunun için request ve responses paketini kullancaz.
	
	String title;
	@Lob
	@Column(columnDefinition="text")
	String text;
}
