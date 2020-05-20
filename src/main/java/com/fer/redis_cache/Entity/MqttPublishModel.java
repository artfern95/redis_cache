package com.fer.redis_cache.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "MqttPublish")
public class MqttPublishModel {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;

    private String topic;

    private String message;
    private Boolean retained;
    private Integer QoS = 0;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime fecha;

    //

    public MqttPublishModel() {
    }

    public MqttPublishModel(String topic, String message) {
        this.topic = topic;
        this.message = message;
        retained = false;
        QoS = 0;
    }

    public MqttPublishModel(String topic, String message, Boolean retained, Integer qoS) {
        this.topic = topic;
        this.message = message;
        this.retained = retained;
        QoS = qoS;
    }

    //Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getRetained() {
        return retained;
    }

    public void setRetained(Boolean retained) {
        this.retained = retained;
    }

    public Integer getQoS() {
        return QoS;
    }

    public void setQoS(Integer qoS) {
        QoS = qoS;
    }

    @PrePersist
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "MqttPublishModel{" +
                "topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                ", retained=" + retained +
                ", QoS=" + QoS +
                ", fecha=" + fecha +
                '}';
    }
}
