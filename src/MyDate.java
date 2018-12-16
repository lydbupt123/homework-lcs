public class MyDate {

  private int days;

  private TmpDate getTmpDate(int days) {
    if (days < 0) {
      return Helper.getDateBefore(days);
    } else if (days > 0) {
      return  Helper.getDateAfter(days);
    } else {
      return new TmpDate(1970, 1, 1);
    }
  }

  // 检查输入是否合法
  private boolean checkInput(TmpDate tmpDate) {
    if (tmpDate.getYear() > 2099 ||
        tmpDate.getYear() < 1900) {
      System.out.println("超出范围");
      return false;
    }
    if (tmpDate.getMonth() > 12 ||
        tmpDate.getMonth() < 1) {
      System.out.println("月份输入有误");
      return false;
    }
    if (tmpDate.getDay() > 31 ||
        tmpDate.getDay() < 1) {
      System.out.println("日期输入有误");
      return false;
    }
    return true;
  }

  public MyDate(int days) {
    Helper.setMap();

    TmpDate date = getTmpDate(days);
    if (checkInput(date)) {
      this.days = days;
    } else {
      this.days = 0;
    }
  }

  public MyDate(int year, int month, int day) {
    Helper.setMap();

    TmpDate date = new TmpDate(year, month, day);
    if (!checkInput(date)) {
      this.days = 0;
    } else {
      // 合法按照规则构建对象
      if (year < 1970) {
        this.days = Helper.countDaysBefore(year, month, day);
      } else if (year > 1970) {
        this.days = Helper.countDaysAfter(year, month, day);
      } else {
        this.days = Helper.countDays(year, month, day);
      }
    }
  }

  public MyDate() {
    Helper.setMap();

    this.days = 0;
  }

  public int getDays() {
    return this.days;
  }

  public boolean equals(MyDate myDate) {
    if (this.days == myDate.getDays()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean lessThan(MyDate myDate) {
    if (myDate.getDays() - this.days > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean lessThanOrEquals(MyDate myDate) {
    if (myDate.getDays() - this.days >= 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean greaterThan(MyDate myDate) {
    if (myDate.getDays() - this.days < 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean greaterThanOrEquals(MyDate myDate) {
    if (myDate.getDays() - this.days <= 0) {
      return true;
    } else {
      return false;
    }
  }

  public int compareTo(MyDate myDate) {
    if (myDate.getDays() - this.days < 0) {
      return 1;
    } else if (myDate.getDays() - this.days > 0) {
      return -1;
    } else {
      return 0;
    }
  }

  public MyDate add(int days) {
    MyDate myDate = new MyDate(this.days + days);
    return myDate;
  }

  public MyDate subtract(int days) {
    MyDate myDate = new MyDate(this.days - days);
    return myDate;
  }

  public int subtract(MyDate myDate) {
    return this.days - myDate.getDays();
  }

  public String toString() {
    if (this.days < 0) {
      TmpDate tmpDate = Helper.getDateBefore(this.days);
      return String.format("%d-%02d-%02d",
        tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());
    } else if (this.days > 0) {
      TmpDate tmpDate = Helper.getDateAfter(this.days);
      return String.format("%d-%02d-%02d",
        tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());
    } else {
      return "1970-01-01";
    }
  }
}
