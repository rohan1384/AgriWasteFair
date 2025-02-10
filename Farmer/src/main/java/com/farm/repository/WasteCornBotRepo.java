package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farm.entity.WasteCornBot;


public interface WasteCornBotRepo extends JpaRepository<WasteCornBot, Long> {
}