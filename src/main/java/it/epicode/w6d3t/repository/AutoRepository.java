package it.epicode.w6d3t.repository;

import it.epicode.w6d3t.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer>, PagingAndSortingRepository<Auto, Integer> {
}
