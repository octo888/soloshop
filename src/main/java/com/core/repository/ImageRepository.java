package com.core.repository;

import com.core.entity.Image;
import com.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
