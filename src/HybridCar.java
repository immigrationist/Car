public class HybridCar extends Car{
    private int totalPower;
    private int currentPower;
    private final int powerUnitsPerMile = 50;
    private int mileage;

    public HybridCar(String licensePlate, int totalGasCapacity,
                     int totalPowerCharge){
        super(licensePlate, totalGasCapacity);
        totalPower = totalPowerCharge;
    }

    public boolean drive(int miles){
        Boolean outOfPower = false;
        int newMilesDriven = 0;
        int powerUsage = powerUnitsPerMile * miles; // tells you how much power you need

        if(powerUsage <= currentPower){
            newMilesDriven = miles;
            currentPower -= powerUsage;
        }
        else {
            newMilesDriven = currentPower / powerUnitsPerMile;
            currentPower = 0;
            int remainingMiles = miles - newMilesDriven;
            outOfPower = super.drive(remainingMiles);
        }
        mileage += newMilesDriven;

        return !outOfPower;
    }
    public int getTotalPower(){return totalPower;}

    public void setTotalPower(int totalPower){
        if(totalPower >= 0){
            this.totalPower = totalPower;
        }
    }
}
