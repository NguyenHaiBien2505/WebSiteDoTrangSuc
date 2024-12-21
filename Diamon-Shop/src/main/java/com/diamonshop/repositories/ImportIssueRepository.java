package com.diamonshop.repositories;

import com.diamonshop.entities.ImportIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportIssueRepository extends JpaRepository<ImportIssue, Integer> {

    List<ImportIssue> findAllByStatus(String status);
}
