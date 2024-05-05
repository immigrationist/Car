public  class Car
{
    private String licensePlate;
    private int mileage;
    private int totalGasCapacity;
    private int curGasAmount;
    private final int gallonsPerMile = 30;

    public Car(String initLicensePlate, int initTotalCapacity )
    {
        licensePlate = initLicensePlate;
        totalGasCapacity = initTotalCapacity;
        curGasAmount = totalGasCapacity;
        mileage = 0;

    }

    public boolean drive(int miles)
    {
        boolean outOfGas = false;
        int newMilesDriven = 0;
        int gasConsumption = gallonsPerMile * miles;

        if (gasConsumption > curGasAmount)
        {
            outOfGas = true;
            newMilesDriven = curGasAmount / gallonsPerMile;
            curGasAmount = 0;

        }
        else
        {
            curGasAmount = curGasAmount - gasConsumption;
            newMilesDriven = miles;
        }
        mileage = mileage + newMilesDriven;

        return !outOfGas;
    }

    public int getGasAmount()
    {
        return curGasAmount;
    }

    public int getMileage( )
    {
        return mileage;
    }

    public void setMileage(int newMileage )
    {
        if ( newMileage >= 0)
            mileage = newMileage;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }
    public int getCarID(){
        return 100;
    }
}
