import java.util.HashMap;
import java.util.Map;

public class Helper {

  public static Map<Integer, Integer> dayOfYear;

  public static Map<Integer, Integer> dayOfRunYear;

  public static void setMap() {
    dayOfYear = new HashMap<>();
    dayOfRunYear = new HashMap<>();
    dayOfYear.put(2, 28);
    dayOfRunYear.put(2, 29);
    int[] day30 = {4, 6, 9, 11};
    int[] day31 = {1, 3, 5, 7, 8, 10, 12};
    for (int i : day31) {
      dayOfYear.put(i, 31);
      dayOfRunYear.put(i, 31);
    }
    for (int i : day30) {
      dayOfYear.put(i, 30);
      dayOfRunYear.put(i, 30);
    }
  }
  
  
  public static boolean isRunYear(int year) {
    if ((year % 4 == 0 && year % 100 != 0) ||
        (year % 400 == 0)) {
      return true;
    }
    return  false;
  }

  public static int countDaysBefore(int year, int month, int day) {
    int res = 0;
    for (int i = year + 1; i < 1970; i++) {
      if (isRunYear(i)) {
        res += 366;
      } else {
        res += 365;
      }
    }
    if (isRunYear(year)) {
      res += (366 - countDays(year, month, day));
    } else {
      res += (365 - countDays(year, month, day));
    }
    return res * -1;
  }

  public static int countDaysAfter(int year, int month, int day) {
    int res = 0;
    for (int i = 1970; i < year; i++) {
      if (isRunYear(i)) {
        res += 366;
      } else {
        res += 365;
      }
    }
    res += countDays(year, month, day);
    return res;
  }

  public static int countDays(int year, int month, int day) {
    int res = 0;
    for (int i = 1; i < month; i++) {
      if (isRunYear(year)) {
        res += dayOfRunYear.get(i);
      } else {
        res += dayOfYear.get(i);
      }
    }
    res += (day - 1);
    return res;
  }

  public static TmpDate getDateBefore(int days){
    int year = 1970;
    int month = 1;
    int day = 1;
    boolean findYear = false;
    int tmp = days;
    int curDays;
    Map<Integer, Integer> tmpMap;
    while (tmp < 0) {
      if (isRunYear(year - 1)) {
        curDays = 366;
        tmpMap = dayOfRunYear;
      } else {
        curDays = 365;
        tmpMap = dayOfYear;
      }

      if (isRunYear(year)) {
        tmpMap = dayOfRunYear;
      } else {
        tmpMap = dayOfYear;
      }

      if (tmp + curDays <= 0) {
        year--;
        tmp += curDays;
      } else {
        // 确定年份
        if (!findYear) {
          findYear = true;
          year--;
          month = 12;
        }
        // 确定月份
        if (tmp + tmpMap.get(month) < 0) {
          tmp += tmpMap.get(month);
          month--;
        } else {
          // 确定日期
          day = tmpMap.get(month) + tmp + 1;
          tmp -= tmp;
        }
      }
    }

    TmpDate tmpDate = new TmpDate(year, month, day);
    return tmpDate;
  }

  public static TmpDate getDateAfter(int days){
    int year = 1970;
    int month = 1;
    int day = 1;

    int tmp = days;
    int curDays;
    Map<Integer, Integer> tmpMap;
    while (tmp > 0) {
      if (isRunYear(year)) {
        curDays = 366;
        tmpMap = dayOfRunYear;
      } else {
        curDays = 365;
        tmpMap = dayOfYear;
      }

      if (tmp - curDays >= 0) {
        year++;
        tmp -= curDays;
      } else {
        if (tmp - tmpMap.get(month) >= 0) {
          tmp -= tmpMap.get(month);
          month++;
        } else {
          day += tmp;
          tmp -= day;
        }
      }
    }

    TmpDate tmpDate = new TmpDate(year, month, day);
    return tmpDate;
  }
}
