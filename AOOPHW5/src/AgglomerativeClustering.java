import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Yosef Schoen 506429330
 */

public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	//Pair is a struct for saving the 2 closest clusters for the main algorithm
	private class Pair {
		private Set<T> firstElement;
		private Set<T> secondElement;

		private double distance;


		private Pair() {
			firstElement = null;
			secondElement = null;
			distance = threshold + 1;
		}

		private Pair(Set<T> c1, Set<T> c2) {
			firstElement = c1;
			secondElement = c2;
			distance = minDist(c1, c2);
		}

		private double getDistance() {
			return distance;
		}
	}

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	public Set<Set<T>> clusterSet(Set<T> elements) {
		// TODO: Complete

		//put every element into its own cluster
		Set<Set<T>> clusters = initializeClusters(elements);

		while (clusters.size() != 1) {
			//will find the two closest clusters
			Pair closest = twoCloset(clusters);

			Set<T> c1 = closest.firstElement;
			Set<T> c2 = closest.secondElement;

			if (closest.distance > threshold) {
				return clusters;
			}

			else {
				clusters.remove(c1);
				clusters.remove(c2);
				clusters.add(union(c1, c2));
			}
		}

		return clusters;
	}

	public Set<T> union(Set<T> c1, Set<T> c2) {
		c1.addAll(c2);
		return c1;
	}


	public Set<Set<T>> initializeClusters(Set<T> elements) {
		Stream<T> stream = elements.stream();
		Set<Set<T>> clusters = stream.map(e -> { Set<T> set = new HashSet();
			set.add(e); return set;}).collect(Collectors.toCollection(HashSet::new));

		// same thing done iteratively
		/*for (T e:elements) {
			Set<T> cluster = new HashSet<>();
			cluster.add(e);
			clusters.add(cluster);
		}*/

		return clusters;
	}


	public Pair twoCloset(Set<Set<T>> clusters) {
		Supplier<Stream<Set<T>>> streamC1 = ()-> clusters.stream();
		Supplier<Stream<Set<T>>> streamC2 = ()-> clusters.stream();

		Pair closestPair = streamC1.get().map(c1 ->
				streamC2.get().map(c2 -> {
					Pair pair = new Pair();
					if(!c1.equals(c2)) {
						pair = new Pair(c1, c2);
					}

					return pair;
				})
						.min(Comparator.comparing(Pair::getDistance)).get()
		)
				.min(Comparator.comparing(Pair::getDistance)).get();

		//same thing done iteratively
		/*for (Set<T> c1:clusters) {
			for (Set<T> c2: clusters) {
				if(!c1.equals(c2)) {
					Pair currentPair = new Pair(c1, c2);
					if(currentPair.distance < closestPair.distance || closestPair.distance == threshold + 1){
						closestPair = currentPair;
					}
				}
			}
		}*/

		return closestPair;
	}

	public double minDist(Set<T> c1, Set<T> c2) {
		Supplier<Stream<T>> streamC1 = ()-> c1.stream();
		Supplier<Stream<T>> streamC2 = ()-> c2.stream();

		Double minDistance = streamC1.get().map(e1 ->
				streamC2.get().map(e2 -> e1.distance(e2))
						.min(Comparator.comparing(Double::doubleValue))
						.orElse(threshold + 1)
		).min(Comparator.comparing(Double::doubleValue)).orElse(threshold + 1);

		//same thing done iteratively
		/*for (T e1:c1) {
			for (T e2:c2) {
				if(!e1.equals(e2)) {
					double currentDist = e1.distance(e2);
					if (currentDist < minDistance || minDistance == -1) {
						minDistance = currentDist;
					}
				}
			}
		}*/

		return minDistance;
	}
}



