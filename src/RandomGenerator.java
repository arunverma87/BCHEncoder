import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

	private List<Boolean> randomvector;
	private int length;

	public RandomGenerator(int randomvectorlength) {
		randomvector = new ArrayList<>();
		length = randomvectorlength;
	}

	public List<Boolean> GenerateRandomVector() {
		try {
			int temp;
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				temp = random.nextInt() % 2;
				randomvector.add(temp == 0);
			}
			return randomvector;
		} catch (Exception Ex) {
			return null;
		}
	}
}
