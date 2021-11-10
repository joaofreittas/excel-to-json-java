package application;

import usecase.ConversorExcetToJsonUseCase;

public class Application {

  public static void main(String[] args) {
    ConversorExcetToJsonUseCase converter = new ConversorExcetToJsonUseCase();
    String json = converter.execute();
    System.out.println(json);

  }
}
