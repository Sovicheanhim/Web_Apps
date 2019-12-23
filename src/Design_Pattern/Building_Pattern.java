package Design_Pattern;

class Car{
    String brand, color, engineType;
    Car(String brand, String color, String engineType){
        this.color = color;
        this.brand = brand;
        this.engineType = engineType;
    }
    public String toString(){
        return color + " : " + brand + " : " + engineType;
    }
    public static class CarBuilder{
        String brand, color, engineType;
        public CarBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public CarBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public CarBuilder setEngineType(String engineType){
            this.engineType = engineType;
            return this;
        }

        public Car build(){
            Car c = new Car(brand, color, engineType);
            return c;
        }
    }
}

class Building_Pattern{
    public static void main(String[] args) {
        Car c = new Car.CarBuilder().setColor("Black").setBrand("Tesla").setEngineType("V8").build();
        System.out.println(c);
    }
}
