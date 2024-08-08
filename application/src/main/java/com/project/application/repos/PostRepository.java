package com.project.application.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	// Bu bir JPA repositorynin sağladığı bir kalıptır.
	// findBy'dan sonra verilen Generic tiple (Post) findBy sonrası birleştirilebilir.
	// Misal Post elemanları text userId title id
	// findByText findByUserId findByTitle findById vs..
	// bunun gerisini direkt jpa halledecektir
	// Benim için parametrede verdiğim userId'ye sahip tüm postları dönecektir.
	// findByUserId(Long userId) metodu, userId parametresine sahip tüm Post nesnelerini döndürecektir.
	List<Post> findByUserId(Long userId);

}
