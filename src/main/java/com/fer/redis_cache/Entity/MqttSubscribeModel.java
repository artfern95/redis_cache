package com.fer.redis_cache.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MqttSubscribeModel {

    private Integer id;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime localDateTime;
    private String topic;
    private String message;
    private Integer Qos;

    //

    public MqttSubscribeModel() {
    }

    public MqttSubscribeModel(Integer id, LocalDateTime localDateTime, String topic, String message, Integer qos) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.topic = topic;
        this.message = message;
        Qos = qos;
    }

    //Getters y Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getQos() {
        return Qos;
    }

    public void setQos(Integer qos) {
        Qos = qos;
    }

    @Override
    public String toString() {
        return "MqttSubscribeModel{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                ", Qos=" + Qos +
                '}';
    }
}
