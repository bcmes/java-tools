package com.bcms.apache.myenum;

public enum MyEnumComplete {
    MONDAY("MON") {
        @Override
        void doSomething() {}
    },
    TUESDAY("TUE") {
        @Override
        void doSomething() {}
    };

    private final String abbreviation;

    MyEnumComplete(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    abstract void doSomething();

}
// DayOfWeek[] days = DayOfWeek.values(); // all days of the week
// System.out.println(DayOfWeek.MONDAY.name());    // prints "MONDAY"
// System.out.println(DayOfWeek.MONDAY.ordinal()); // prints "0" because MONDAY is the first constant in the DayOfWeek enum