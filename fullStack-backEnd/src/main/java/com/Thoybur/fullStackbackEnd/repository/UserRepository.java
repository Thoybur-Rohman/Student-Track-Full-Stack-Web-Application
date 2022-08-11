package com.Thoybur.fullStackbackEnd.repository;

import com.Thoybur.fullStackbackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{
}
