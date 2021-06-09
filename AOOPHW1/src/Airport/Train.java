package Airport;

//A class for our trains implements both Comparable and Movable
public class Train implements Comparable, Movable {

    //MAX Params labeled here
    public static final int PASSENGER_LIMIT = 500;
    public static final int STATION_LIMIT = 5;

    //properties of a train
    int licenceNumber;
    Location source, destination;  // Location is an Enum of Locations
    int numberOfStations;
    int currentStation;
    int maximalPassenger;

    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }

    //returns value of the train in a defined string format
    public String toString() {
        return String.format("{licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d}",
                licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    @Override //overrides movable.getType
    public String getType() { return "Train"; }

    @Override //overrides movable.getId
    public int getId() {
        return licenceNumber;
    }

    @Override //overrides movable.getSource
    public Location getSource() {
        return source;
    }

    @Override //overrides movable.getDestination
    public Location getDestination() {
        return destination;
    }

    @Override ////overrides movable.getCurrentLocation
    public String getCurrentLocation() {

        //getting the Enum value in string form
        String stationStr = String.valueOf(currentStation);

        //the Output String always starts like this
        String str = ". Currently in ";

        //if it at station zero it is in the starting location
        if(currentStation == 0) {
            str += source.name();
        }

        //other wise its somewhere in between
        else {
            str += "station " + stationStr + " between " + source + " and " + destination + ".";
        }

        return str;
    }

    @Override //overrides movable.move increments the station number and swaps start and end if it finishes route
    public void move() {
        currentStation = currentStation + 1;

        if(currentStation == numberOfStations) {
            Location temp = source;
            source = destination;
            destination = temp;

            currentStation = 0;
        }
    }

    @Override //overrides Comparable.compareTo  Trains are ordered by maximum number of passengers
    public int compareTo(Object o) {

        //assuming the two trains are the same will change result otherwise
        int result = 0;

        //checking i o is a train
        if(o instanceof Train) {
            int tempTrainMaxPass = ((Train) o).maximalPassenger;

            //our train is less then new train
            if (maximalPassenger < tempTrainMaxPass) {
                result = -1;
            }


            //our train is greater than new train
            else if(maximalPassenger > tempTrainMaxPass) {
                result = 1;
            }
        }

        return result;
    }
}
