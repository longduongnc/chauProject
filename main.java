import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize data structures
        Map<Integer, Location> locationMap = new HashMap<>();
        List<Road> roads = new ArrayList<>();

        // Ask for input file (you can replace this with actual file reading)
        System.out.println("Enter the input file: ");
        String inputFile = scanner.nextLine();

        // Simulate reading data from the input file and creating Location and Road objects
        // For demonstration, we'll create some sample data.
        // You should replace this with actual file parsing.

        // Create Location objects and store them in the locationMap
        Location location1 = new Location(1, 42.3601, -71.0589);
        Location location2 = new Location(2, 40.7128, -74.0060);
        locationMap.put(location1.getUID(), location1);
        locationMap.put(location2.getUID(), location2);

        // Create Road objects and add them to the roads list
        Road road1 = new Road(new int[]{1, 2}, 65, 50.0, "Highway A");
        Road road2 = new Road(new int[]{2, 1}, 55, 60.0, "Highway B");
        roads.add(road1);
        roads.add(road2);

        // Associate Road objects with their respective Location objects
        for (Road road : roads) {
            for (int locationUID : road.getUIDList()) {
                Location location = locationMap.get(locationUID);
                if (location != null) {
                    location.addRoad(road);
                }
            }
        }

        // Main loop
        int userInput;
        do {
            System.out.println("Enter a Location UID (0 to exit): ");
            userInput = scanner.nextInt();

            if (userInput != 0) {
                Location loc = locationMap.get(userInput);

                if (loc != null && loc.isValid()) {
                    List<Road> locationRoads = loc.getRoads();
                    for (Road road : locationRoads) {
                        System.out.println(road);
                    }
                } else {
                    System.out.println("Invalid Location UID or no roads found.");
                }
            }
        } while (userInput != 0);

        // Close the scanner
        scanner.close();
    }
}
