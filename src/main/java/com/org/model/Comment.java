package com.org.model;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {

  public Comment(Post post, User user, String content, Comment parentComment){
    this.id=new Random().nextLong();
    this.post= post;
    this.user=user;
    this.content= content;
    this.parentComment=parentComment;
  }

  public Comment(Post post, User user, String content){
    this.id=new Random().nextLong();
    this.post= post;
    this.user=user;
    this.content= content;
  }

  //  AutoIncrement Id
  private Long id= new Random().nextLong();

  private Post post;
  private User user;
  private String content;
  private Comment parentComment;
  private Set<User> likes;
  private Set<User> disLikes;

  private Date createdAt;
  private Date updatedAt;


}
