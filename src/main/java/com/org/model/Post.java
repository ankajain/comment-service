package com.org.model;

import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

//  Auto generated Id
  private Long id= new Random().nextLong();
  private String content;
  // Other post properties
}
