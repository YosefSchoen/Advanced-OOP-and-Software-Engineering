package Airport;

//Plan is another class which implements Movable and Comparable
//Most of the structure is the same as train
//Only areas of serious difference will be commented here
public class Plane implements Movable, Comparable{
    public static final int HEIGHT_LIMIT = 1500;
    int licenceNumber;
    Location source, destination;
    int maximalHeight;

    public Plane(int id, Location src, Location dst, int maxHeight) {
        licenceNumber = id;
        source = src;
        destination = dst;
        maximalHeight = maxHeight;
    }

    @Override
    public String toString() {
        return String.format("{licence = %d, source = %s, destination = %s, maxHeight = %d}", licenceNumber, source, destination, maximalHeight);
    }

    @Override
    public String getType() { return "Plane"; }

    @Override
    public int getId() {
        return licenceNumber;
    }

    @Override
    public Location getSource() {
        return source;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public String getCurrentLocation() {
        String str = ". Currently in " + source.name();
        return str;
    }

    @Override //unlike Trains, Plains do not have stations once they make a move they get to there destination and swap
    public void move() {
        Location temp = source;
        source = destination;
        destination = temp;
    }

    @Override //unlike Trains, Planes are ordered by there max height
    public int compareTo(Object o) {
        int result = 0;
        if(o instanceof Plane) {

            int tempPlaneMaxHeight = ((Plane) o).maximalHeight;
            if (maximalHeight < tempPlaneMaxHeight) {
                result = -1;
            }

            else if(maximalHeight > tempPlaneMaxHeight) {
                result = 1;
            }
        }

        return result;
    }
}
