package data;

public enum Language {
    EN("Eng", "The mission of \"Meknark\" NGO"),
    HY("Հայ", "«Մեկնարկ» ՀԿ-ի առաքելությունը");

    private final String dropdownText;
    private final String expectedTitle;

    Language(String dropdownText, String expectedTitle) {
        this.dropdownText = dropdownText;
        this.expectedTitle = expectedTitle;
    }

    public String getDropdownText() { return dropdownText; }
    public String getExpectedTitle() { return expectedTitle; }
}
