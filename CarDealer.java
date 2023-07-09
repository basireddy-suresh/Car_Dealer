class CarDealer {
    private Car[] cars;
    private double rtoCost = 113990;
    private double insuranceCost = 47300;
    private double tcsCharges = 11000;
    private double additionalAccessoriesCost = 15000;
    private double maxDiscount = 30000;

    public CarDealer() {
        cars = new Car[7];
        cars[0] = new Car("Polo Trendline", 870000);
        cars[1] = new Car("Polo Highline", 1009000);
        cars[2] = new Car("Virtus Trendline", 1105000);
        cars[3] = new Car("Virtus Highline", 1308000);
        cars[4] = new Car("Taigun Trendline", 1489000);
        cars[5] = new Car("Taigun Highline", 1542000);
        cars[6] = new Car("Taigun Topline", 1771000);
    }

    public double calculateTotalCost(String carModel, boolean needInsurance, boolean needAdditionalAccessories, double dealerDiscount) {
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getModel().equals(carModel)) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("Invalid car model selection.");
            return 0;
        }

        double totalCost = selectedCar.getCost() + rtoCost + tcsCharges;

        if (needInsurance) {
            totalCost += insuranceCost;
        }

        if (needAdditionalAccessories) {
            totalCost += additionalAccessoriesCost;
        }

        if (dealerDiscount > 0 && (needInsurance || needAdditionalAccessories)) {
            if (dealerDiscount > maxDiscount) {
                dealerDiscount = maxDiscount;
            }
            totalCost -= dealerDiscount;
        } else if (dealerDiscount > 0) {
            System.out.println("Cannot apply dealer discount without opting for insurance or additional accessories.");
            return 0;
        }

        return totalCost;
    }
}
