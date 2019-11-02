package com.trilogy.cloudgamestorelevelupservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trilogy.cloudgamestorelevelupservice.dao.LevelUpDao;
import com.trilogy.cloudgamestorelevelupservice.model.LevelUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ServiceLayer {

    private LevelUpDao levelUpDao;

    @Autowired
    ServiceLayer(LevelUpDao levelUpDao) {this.levelUpDao = levelUpDao;}

    /*************************************************
     * Level Up Service API
     *************************************************/

    /**
     * Saves level up to database
     * @param levelUp
     * @return
     */
    @Transactional
    public LevelUp saveLevelUp(LevelUp levelUp) {

        return levelUpDao.addLevelUp(levelUp);
    }

    /**
     * Retrieves one level up when passed a valid Level Up ID
     * @param levelUpId
     * @return
     */
//    @HystrixCommand
//    @Cacheable
    public LevelUp fetchLevelUp(int levelUpId) {
        return levelUpDao.getLevelUp(levelUpId);
    }

    /**
     * Retrieves all level ups from the database
     * @return
     */

//    @Cacheable
    public List<LevelUp> fetchAllLevelUp() {
        return levelUpDao.getAllLevelUps();
    }

    /**
     * Updates an existing level up entry when passed a valid level up object
     * @param levelUp
     */

//    @CacheEvict(key = "#post.fetchLevelUp()")
    public void updateLevelUp(LevelUp levelUp) {
        levelUpDao.updateLevelUp(levelUp);
    }

    /**
     * Deletes a level up entry from database when passed a valid level up ID
     * @param levelUpId
     */
    public void deleteLevelUp(int levelUpId) {
        levelUpDao.deleteLevelUp(levelUpId);
    }

    /**
     * Retrieves one level up when passed a valid Level Up ID
     * @param customerId
     * @return
     */

//    @Cacheable
//    @HystrixCommand
    public LevelUp fetchLevelUpByCustomerId(int customerId) {
        return levelUpDao.getLevelUpByCustomerId(customerId);
    }

}
