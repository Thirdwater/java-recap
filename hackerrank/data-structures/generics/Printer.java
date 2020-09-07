class Printer {

    public <Generic> void printArray (Generic[] array) {
        for (Generic item : array) {
            System.out.println(item);
        }
    }

}
