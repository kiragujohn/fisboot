
package com.njoroge.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.njoroge.fis.domain.City;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
