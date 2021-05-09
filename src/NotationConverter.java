import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotationConverter {

  public int toArabic(String romanNotation) throws InvalidValueException {
   int result = 0;
   String[] sepStr = null;

   if(Pattern.matches("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$", romanNotation) == true) {
   Pattern pattern = Pattern.compile("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
   Matcher matcher = pattern.matcher(romanNotation);
   StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
       matcher.appendReplacement(stringBuffer,
               matcher.group(1) + ',' + matcher.group(2) + ',' + matcher.group(3) + ',' + matcher.group(4)
       );
       matcher.appendTail(stringBuffer);
       sepStr = stringBuffer.toString().split(","); // разделяем число на разряды
     }


     int[] temp = new int[sepStr.length];
     for (int i = 0; i < sepStr.length ; i++) {
       temp[i] = numeralValue(sepStr[i]);
     }
     // складываем все числа
     for (int i = 0; i < temp.length; i++) {
       result += temp[i];
     }
   } else {
     throw new InvalidValueException("String must contain only valid roman numerals [I,V,X,L,C,D,M].");
   }

    return result;
  }
  // конвертируем рязряды римских чисел в арабское число
  public static int numeralValue(String ch) {

      switch (ch) {
        case "I":
          return 1;
        case "II":
          return 2;
        case "III":
          return 3;
        case "IV":
          return 4;
        case "V":
          return 5;
        case "VI":
          return 6;
        case "VII":
          return 7;
        case "VIII":
          return 8;
        case "IX":
          return 9;
        case "X":
          return 10;
        case "XX":
          return 20;
        case "XXX":
          return 30;
        case "XL":
          return 40;
        case "L":
          return 50;
        case "LX":
          return 60;
        case "LXX":
          return 70;
        case "LXXX":
          return 80;
        case "XC":
          return 90;
        case "C":
          return 100;
        case "CC":
          return 200;
        case "CCC":
          return 300;
        case "CD":
          return 400;
        case "D":
          return 500;
        case "DC":
          return 600;
        case "DCC":
          return 700;
        case "DCCC":
          return 800;
        case "CM":
          return 900;
        case "M":
          return 1000;
        case "MM":
          return 2000;
        case "MMM":
          return 3000;
      }
    return 0;
    }




}
