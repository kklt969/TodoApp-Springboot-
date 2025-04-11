package com.webapp.webapp_kklt.todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends  JpaRepository<Todo, Integer>
{

    public  List<Todo> findByUsername(String username);

    @Query("SELECT t.done From todos t WHERE t.id = :id")
    public Boolean findDoneById(@Param("id") int id);

    @Modifying //this is an update, not a select
    @Transactional //Requrired because update query must be done inside a transaction. (Commit or rollback)
    @Query("UPDATE todos t SET t.done = :done WHERE t.id =:id") // the actual JPQL Update Statement
    public void setDoneById(@Param("id") int id,@Param("done") boolean done);

    public List<Todo>findByUsernameAndDoneTrue(String username);

    public List<Todo>findByUsernameAndDoneFalse(String username);

    public List<Todo> findByDescription(String description);

    public List<Todo> findByTargetDate(LocalDate targetDate);


}
