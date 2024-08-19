public enum Status {
    NOT_DONE("Not done"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String value;

    Status(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
