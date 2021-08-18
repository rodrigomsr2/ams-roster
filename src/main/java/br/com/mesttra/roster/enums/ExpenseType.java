package br.com.mesttra.roster.enums;

public enum ExpenseType {

    SALARY("SALARY"), OTHER("OTHER");

    private String value;

    private ExpenseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
