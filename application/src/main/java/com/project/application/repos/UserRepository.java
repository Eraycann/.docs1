package com.project.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.application.entities.User;

/**
 * UserRepository arayüzü, JPA (Java Persistence API) kullanarak veri erişim işlemlerini
 * kolaylaştırmak için kullanılır. Bu arayüz, User entity'si için CRUD (Create, Read, Update, Delete)
 * işlemlerini gerçekleştirebilecek çeşitli metodları sağlar.
 * 
 * JpaRepository<User, Long> arayüzünden türetildiğinden, aşağıdaki işlevleri sağlar:
 * 
 * - User nesnelerini veritabanına kaydetme ve güncelleme
 * - User nesnelerini veritabanından silme
 * - User nesnelerini veritabanından sorgulama
 * 
 * JpaRepository, temel CRUD işlemlerinin yanı sıra, çeşitli sorgu yöntemleri ve sayfalama özellikleri de sunar.
 * Bu arayüzü uygulamak, User entity'si ile veritabanı etkileşimini daha basit ve hızlı bir şekilde yönetmeyi sağlar.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
