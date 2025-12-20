package creational.builder;

public class Car {
    private String model;
    private String company;
    private int price;
    private int seatCapacity;
    private int fuelCapacity;
    private boolean sunRoof;
    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.company = builder.company;
        this.price = builder.price;
        this.seatCapacity = builder.seatCapacity;
        this.fuelCapacity = builder.fuelCapacity;
        this.sunRoof = builder.sunRoof;
    }

    @Override
    public String toString() {
        return "Model : " + this.model + "\n Company : " + this.company + "\n Price : " + this.price
        + "\n SeatCapacity : " + this.seatCapacity + "\n FuelCapacity : " + this.fuelCapacity + "\n Sunroof : "
                + this.sunRoof;
    }

    public static class CarBuilder {
        private String model;
        private String company;
        private int price;
        private int seatCapacity = 4; //default value
        private int fuelCapacity = 30; //default value
        private boolean sunRoof = false; //default value

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public CarBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public CarBuilder setSeatCapacity(int capacity) {
            this.seatCapacity = capacity;
            return this;
        }

        public CarBuilder setFuelCapacity(int capacity) {
            this.fuelCapacity = capacity;
            return this;
        }

        public CarBuilder setSunRoof(boolean sunRoof) {
            this.sunRoof = sunRoof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
