package com.example.yazlab2.repositories;

import com.example.yazlab2.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    @Override
    Optional<News> findById(Integer newsID);



}
