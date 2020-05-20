package com.fer.redis_cache.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MqttSubscribe")
public class MqttSubscribeModel {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id_seq;

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

    public Integer getId_seq() {
        return id_seq;
    }

    public void setId_seq(Integer id_seq) {
        this.id_seq = id_seq;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @PrePersist
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
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
