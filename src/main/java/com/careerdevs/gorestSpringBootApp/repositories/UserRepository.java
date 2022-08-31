package com.careerdevs.gorestSpringBootApp.repositories;

import com.careerdevs.gorestSpringBootApp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
