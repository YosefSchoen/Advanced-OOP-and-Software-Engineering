import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDPoint implements Clusterable<TwoDPoint>{
	double x;
	double y;
	public TwoDPoint(String str){
		// TODO: Complete
		String [] strArr;
		strArr = str.split(",");
		this.x = Double.parseDouble(strArr[0]);
		this.y = Double.parseDouble(strArr[1].split("\t")[0]);
	}
	public TwoDPoint(double x, double y) {
		// TODO: Complete
		this.x = x;
		this.y = y;
	}
	@Override
	public double distance(TwoDPoint other) {
		// TODO: Complete
		double changeInX = Math.pow(this.x - other.x, 2);
		double changeInY = Math.pow(this.y - other.y, 2);
		double distance = Math.sqrt(changeInX + changeInY);
		return distance;
	}

	@Override
	public String toString() {
		return x+", "+y;
	}

	public static Set<TwoDPoint> readPoints(String path) throws IOException{
		// TODO: Complete
		Stream<String> stream = Files.lines(Paths.get(path)); //stream source
		Set<TwoDPoint> mySet = stream
				.map(p -> new TwoDPoint(p)) //Intermediate expression
						.collect(Collectors.toSet()); //terminal expression
		return mySet;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint)other;
		return (otherP.x == x && otherP.y == y);
	}
}
