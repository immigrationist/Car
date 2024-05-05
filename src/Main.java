import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to car app");
        while(choice != 4){
            System.out.println("1. Create a car" +
                    "\n2.Do actions with existing car" +
                    "\n3. Show all mileage/info" +
                    "\n4. Quit");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Car car = null;
                    System.out.println("Enter license plate");
                    String licensePlate = scanner.next();
                    System.out.println("Enter total gas capacity");
                    int totalGasCapacity = scanner.nextInt();
                    System.out.println("What type of car? 1 for Regular, 2 for Hybrid");
                    int type = scanner.nextInt();

                    if(type == 1){
                        car = new Car(licensePlate, totalGasCapacity);
                    }
                    else {
                        System.out.println("Enter total power");
                        int totalPower = scanner.nextInt();
                        car = new HybridCar(licensePlate, totalGasCapacity, totalPower);
                    }
                    cars.add(car);
                    break;
                case 2:
                    System.out.println("Enter license plate");
                    String enteredLicensePlate = scanner.next();
                    Car foundCar = null;

                    for(int pos = 0; pos < cars.size(); pos ++){
                        Car curCar = cars.get(pos);
                        if(curCar.getLicensePlate().equals(enteredLicensePlate)){
                            foundCar = curCar;
                            break;
                        }
                    }
                    if(foundCar == null){
                        System.out.println("No car was found");
                    }
                    else {
                        int option = 0;
                        while(option != 4){
                            System.out.println("1. Drive car" +
                                    "\n2. Check Gas" +
                                    "\n3. Check Mileage" +
                                    "\n4. Quit");
                            option = scanner.nextInt();

                            switch (option){
                                case 1:
                                    System.out.println("How many miles");
                                    int miles = scanner.nextInt();
                                    boolean success = foundCar.drive(miles);
                                    if(success)
                                        System.out.println("Miles driven successfully");
                                    else System.out.println("out of power");
                                    break;
                                case 2:
                                    System.out.println("Current gas is: " + foundCar.getGasAmount());
                                    break;
                                case 3:
                                    System.out.println("Current mileage is: " + foundCar.getMileage());
                                    break;
                                case 4:
                                    System.out.println("Quitting...");
                                    break;
                                default:
                            }
                        }
                    }

                break;
                case 3:
                    double average = 0.0;
                    for(int pos = 0; pos < cars.size(); pos++){
                        Car curCar = cars.get(pos);
                        System.out.println("License plate: " + curCar.getLicensePlate() +
                                "\nMileage: " + curCar.getMileage());
                        average += curCar.getMileage();
                        System.out.println("The average is: " + average / cars.size());
                    }
                    break;
                case 4:
                    System.out.println("Quitting");
                    break;
                default:
            }
        }
    }
}
