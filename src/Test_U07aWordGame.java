import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Test_U07aWordGame {
@Test
public void randomSecret_test() {
  String[] arr1 = {"codeR","Coder","cOdEr"};
  String[] arr2 = new String[0];
  String[] arr3 = {"java","byte","code"};
  assertEquals("coder", U07aWordleKnockOffGame.randomSecret( arr1 ));
  assertEquals("error", U07aWordleKnockOffGame.randomSecret( arr2 ));
  assertEquals("sorry", U07aWordleKnockOffGame.randomSecret( arr3 ));

}

@Test
public void checkGuess_test() {

  assertEquals("✅🔳🔀🔳🔳", U07aWordleKnockOffGame.checkGuess("coder", "clown"));
  assertEquals("🔀🔳🔀✅🔀", U07aWordleKnockOffGame.checkGuess("coder", "raced"));
  assertEquals("✅🔀✅🔳✅", U07aWordleKnockOffGame.checkGuess("coder", "cedar"));

}

@Test
public void checkLetter_test() {

  assertEquals("✅", U07aWordleKnockOffGame.checkLetter("coder", "c", 0));
  assertEquals("🔀", U07aWordleKnockOffGame.checkLetter("coder", "r",2));
  assertEquals("🔳", U07aWordleKnockOffGame.checkLetter("coder", "x", 4));

}
}