package com.fer.redis_cache.Controller;

import com.fer.redis_cache.Entity.MqttSubscribeModel;
import com.fer.redis_cache.Repository.MqttSubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/subscribe")
public class MqttSubscribeController {

    @Autowired
    private MqttSubscribeRepository mqttSubscribeRepository;

    @Cacheable(value = "MqttSubscribeModel", key = "#id")
    @GetMapping("/{id}")
    public MqttSubscribeModel getSubscribesList (@PathVariable("id") Integer id){

        if(mqttSubscribeRepository.existsById(id)){

            return mqttSubscribeRepository.findById(id).get();
        }

        return null;
    }

    @CachePut(value = "MqttSubscribeModel", key = "#model.id_seq")
    @PutMapping
    public MqttSubscribeModel actulizar(@RequestBody MqttSubscribeModel model){

        return mqttSubscribeRepository.save(model);
    }

    @CacheEvict(value = "MqttSubscribeModel", allEntries = true)
    @DeleteMapping("{id}")
    public void borrar(@PathVariable("id") Integer id){

        mqttSubscribeRepository.deleteById(id);
    }

    @PostMapping
    public MqttSubscribeModel guardar(@RequestBody MqttSubscribeModel model){

        return mqttSubscribeRepository.save(model);
    }
}
