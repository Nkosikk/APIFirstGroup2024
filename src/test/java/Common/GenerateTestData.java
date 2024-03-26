package Common;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {

    static Faker faker = new Faker();

  public static String FirstName =faker.name().firstName();
  public String LastName =faker.name().lastName();
  public String PostalAdress =faker.address().zipCode();
    public static String jobTitle = faker.job().title();


  @Test
  public void test(){
      System.out.println(jobTitle);
  }
}
