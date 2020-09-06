class MyRegex {

    private String range0to199 = "[0-1]?\\d{1,2}";
    private String range200to249 = "2[0-4]\\d";
    private String range250to255 = "25[0-5]";
    private String digitRange = String.format("(%s|%s|%s)",
            range0to199, range200to249, range250to255);

    public String pattern = String.format("^%1$s\\.%1$s\\.%1$s\\.%1$s", digitRange);

}
