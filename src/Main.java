public class Main {
  public static void main(String[] args) {
    String str = "IMCMLXXXVII";
    NotationConverter conv = new NotationConverter();
    try {
      System.out.println(conv.toArabic(str));
    } catch (InvalidValueException e) {
      System.out.println(e.getMessage());
    }

//

  }
}
