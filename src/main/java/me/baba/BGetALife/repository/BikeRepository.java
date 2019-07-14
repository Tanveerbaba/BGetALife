package me.baba.BGetALife.repository;

import me.baba.BGetALife.model.Bike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface BikeRepository extends CrudRepository<Bike, Long> {
    List<Bike> findByBrand(@Param("brand") String brand);

    List<Bike> findByColor(String color);

    List<Bike> findByYear(int year);

    List<Bike> findByBrandAndModel(String brand, String model);

    List<Bike> findByBrandOrColor(String brand, String color);

    // TO FETCH BIKES BY BRAND AND SORT BY YEAR
    List<Bike> findByBrandOrderByYearAsc(String brand);

    // FETCH BIKES BY BRAND USING SQL
//    @Query("select b from Bike b where b.brand = ?1")
//    List<Bike> findByBrand(String brand);

    // FETCH BIKES USING LIKE EXPRESSION OF SQL
    @Query("select b from Bike b where b.brand like %?1")
    List<Bike> findByBrandEndsWith(String brand);

}
