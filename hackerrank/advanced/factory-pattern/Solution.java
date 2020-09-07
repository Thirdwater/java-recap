class FoodFactory {

    public Food getFood (String order) {
        switch (order) {
            case "cake":
                return new Cake();
            case "pizza":
                return new Pizza();
            default:
                // Invalid order
                return null;
        }
    }

}
