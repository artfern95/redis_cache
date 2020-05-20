package com.fer.redis_cache.Repository;

import com.fer.redis_cache.Entity.MqttSubscribeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MqttSubscribeRepository extends JpaRepository<MqttSubscribeModel, Integer> {
}
