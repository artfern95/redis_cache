package com.fer.redis_cache.Repository;

import com.fer.redis_cache.Entity.MqttPublishModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MqttPublishRepository extends JpaRepository<MqttPublishModel,Integer> {
}
