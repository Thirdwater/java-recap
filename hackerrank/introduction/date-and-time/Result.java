class Result {

    private static Calendar calendar = Calendar.getInstance();

    public static String findDay (int month, int day, int year) {
        assert 2000 < year && year < 3000;

        int zeroBasedMonth = month - 1;
        calendar.set(year, zeroBasedMonth, day);
        // Calendar fields are still int instead of enum.
        String[] dayOfWeekArray = {
            "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        int dayOfWeekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return dayOfWeekArray[dayOfWeekIndex];
    }

}
