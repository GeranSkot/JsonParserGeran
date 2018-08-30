package by.intexsoft.json.parser;

//class JSONObject {
//  String getObject(String jsonString, String key) {
//    int index = 0;
//    key = "\"" + key + "\":";
//    System.out.println(key);
//    if ((index = jsonString.indexOf(key)) != -1) {
//      index += key.length();
//      int startIndex = index;
//      int countA = 0, countB = 0;
//      if (jsonString.charAt(index) == '[') {
//        countA++;
//        index++;
//        while (jsonString.charAt(index) != ']' && countA >= 0 && countB >= 0) {
//          switch (jsonString.charAt(index)) {
//            case '[':
//              countA++;
//              break;
//            case ']':
//              countA--;
//              break;
//            case '{':
//              countB++;
//              break;
//            case '}':
//              countB--;
//              break;
//          }
//          index++;
//        }
//        index++;
//      } else if (jsonString.charAt(index) == '{') {
//        index++;
//        while (jsonString.charAt(index) != '}' && countA >= 0) {
//          switch (jsonString.charAt(index)) {
//            case '[':
//              countA++;
//              break;
//            case ']':
//              countA--;
//              break;
//          }
//          index++;
//        }
//        index++;
//      } else {
//        while (jsonString.charAt(index) != ',' && jsonString.charAt(index) != '}') {
//          index++;
//        }
//      }
//      String val = jsonString.substring(startIndex, index);
//      return val;
//    } else {
//      return "-1";
//    }
//  }
//}
