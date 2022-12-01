package com.example.rasprsist.repository;

import com.example.rasprsist.entity.SmartBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartBoxRepo extends JpaRepository<SmartBox, String> {
}
