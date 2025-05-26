package com.github.flanchanowo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class PushNotification {

  public enum Priority {
    @JsonProperty("default")
    OK,
    @JsonProperty("high")
    ERROR,
    @JsonProperty("normal")
    NORMAL;
  }

  private List<String> to;

  private Map<String, Object> data;

  private String title;

  private String subtitle;

  private String body;

  private String sound;

  private Long ttl;

  private Long expiration;

  private Priority priority;

  private Long badge;

  private String channelId;

  public PushNotification(List<String> to, String title, String body) {
    this.to = to;
    this.title = title;
    this.body = body;
  }

  public PushNotification(PushNotification other) {
    this.to = other.to;
    this.data = other.data;
    this.title = other.title;
    this.subtitle = other.subtitle;
    this.body = other.body;
    this.sound = other.sound;
    this.ttl = other.ttl;
    this.expiration = other.expiration;
    this.priority = other.priority;
    this.badge = other.badge;
    this.channelId = other.channelId;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private List<String> to;
    private Map<String, Object> data;
    private String title;
    private String subtitle;
    private String body;
    private String sound;
    private Long ttl;
    private Long expiration;
    private Priority priority;
    private Long badge;
    private String channelId;

    public Builder to(List<String> to) {
      this.to = to;
      return this;
    }

    public Builder data(Map<String, Object> data) {
      this.data = data;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder subtitle(String subtitle) {
      this.subtitle = subtitle;
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Builder sound(String sound) {
      this.sound = sound;
      return this;
    }

    public Builder ttl(Long ttl) {
      this.ttl = ttl;
      return this;
    }

    public Builder expiration(Long expiration) {
      this.expiration = expiration;
      return this;
    }

    public Builder priority(Priority priority) {
      this.priority = priority;
      return this;
    }

    public Builder badge(Long badge) {
      this.badge = badge;
      return this;
    }

    public Builder channelId(String channelId) {
      this.channelId = channelId;
      return this;
    }

    public PushNotification build() {
      PushNotification notification = new PushNotification();
      notification.to = this.to;
      notification.data = this.data;
      notification.title = this.title;
      notification.subtitle = this.subtitle;
      notification.body = this.body;
      notification.sound = this.sound;
      notification.ttl = this.ttl;
      notification.expiration = this.expiration;
      notification.priority = this.priority;
      notification.badge = this.badge;
      notification.channelId = this.channelId;
      return notification;
    }
  }
  
}