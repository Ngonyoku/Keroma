package ke.co.ngonyoku.keroma.Keroma.repository;

import ke.co.ngonyoku.keroma.Keroma.model.Category;
import ke.co.ngonyoku.keroma.Keroma.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByName(String name);

    List<MenuItem> findByPrice(double price);

    @Query("SELECT m FROM MenuItem m JOIN m.categories c WHERE c.name = :categoryName")
    List<MenuItem> findByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT m FROM MenuItem m JOIN m.categories c WHERE c.id = :categoryId")
    List<MenuItem> findByCategoryId(@Param("categoryId") Long categoryId);

//    List<MenuItem> findByCategory(Category category);
}
