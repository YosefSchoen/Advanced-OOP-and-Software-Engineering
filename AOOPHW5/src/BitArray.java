import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;

	public BitArray(String str) {
		// TODO: Complete
		String [] strArr = str.split(",");
		Stream<String> stream = Arrays.stream(strArr);

		bits = stream
				.map(b -> (b.equals("true")))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public BitArray(boolean[] bits) {
		// TODO: Complete
		Stream<Boolean> stream = IntStream.range(0, bits.length)
				.mapToObj(b -> this.bits.set(b, bits[b]));

		this.bits = stream
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public double distance(BitArray other) {
		// TODO: Complete
		int distance;

		Stream<Boolean> stream = IntStream.range(0, other.bits.size())
				.mapToObj(i -> this.bits.get(i) != other.bits.get(i))
				.filter(t -> t == true);

		distance = stream.collect(Collectors.toCollection(ArrayList::new)).size();
		return distance;
	}

	@Override
	public String toString() {
		return bits.toString();
	}


	public static Set<BitArray> readBitArrays(String path) throws IOException {
		// TODO: Complete. If the file contains bitarrays of different lengths,
		//  retain only those of maximal length
		int maxArrSize;

		Stream<String> stream = Files.lines(Paths.get(path)); //stream source
		Set<BitArray> mySet = stream
				.map(b -> new BitArray(b)) //intermediate operation
				.collect(Collectors.toSet()); //terminal operation


		maxArrSize = mySet.stream()
				.mapToInt(b -> b.bits.size()).max().getAsInt();

		mySet.removeIf(b -> b.bits.size() < maxArrSize);
		return mySet;
	}
}
