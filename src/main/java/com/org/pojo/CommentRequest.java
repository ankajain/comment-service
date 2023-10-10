package com.org.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentRequest {
  private Long userId;
  private String content;
  private Long parentId;
}

