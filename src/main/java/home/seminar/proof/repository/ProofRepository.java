package home.seminar.proof.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import home.seminar.proof.domain.entity.Proof;

public interface ProofRepository extends JpaRepository<Proof, Long> {

	@Query("select p from Proof p where p.parentId is NULL or p.parentId = '' order by type asc")
	List<Proof> findAllRoot();
	
	List<Proof> findByParentIdOrderByTypeAsc(Long parentId);
	
	List<Proof> findByType(String type);
	
	@Query("select p from Proof p where p.title like ?1 or p.description like ?1 or createdBy like ?1 or filePath like ?1")
	List<Proof> findByAnything(String keyword);
	
	List<Proof> findByTitleLikeIgnoreCase(String title);
}
