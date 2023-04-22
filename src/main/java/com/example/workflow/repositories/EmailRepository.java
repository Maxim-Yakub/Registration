package com.example.workflow.repositories;

import com.example.workflow.models.Email;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends ElasticsearchRepository<Email, String> {

    Email findByDomain(String domain);
}
