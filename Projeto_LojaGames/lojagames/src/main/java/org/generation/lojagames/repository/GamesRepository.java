package org.generation.lojagames.repository;

import java.util.List;

import org.generation.lojagames.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository <Games, Long> {
	
	public List<Games> findAllByQuantidadeContainingIgnoreCase (String Quantidade);
}
