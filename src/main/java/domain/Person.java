package domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

  private Long id;
  private String name;
  private Integer age;

}
