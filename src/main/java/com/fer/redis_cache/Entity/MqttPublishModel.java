package com.fer.redis_cache.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MqttPublishModel {

    @NotNull
    private String topic;

    @NotNull
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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
