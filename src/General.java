import java.util.ArrayList;
import java.util.List;

public class General {

	public List<Float> ConvertStringtoFloatArray(String vector) {
		// System.out.println(vector);
		String[] strVector = vector.split("	");
		List<Float> converted = new ArrayList<>();
		for (int i = 0; i < strVector.length; i++) {
			converted.add(Float.parseFloat(strVector[i]));
		}
		return converted;
	}

	public String ConvertFloatArraytoString(List<Float> vector,
			boolean withdelimeter) {
		String ltemp = "";
		for (int i = 0; i < vector.size(); i++) {
			if (withdelimeter)
				ltemp += vector.get(i).toString() + "	";
			else
				ltemp += vector.get(i).toString();
		}
		if (ltemp != "")
			if (withdelimeter)
				return ltemp.substring(0, ltemp.length() - 2);
			else
				return ltemp;
		else
			return "";
	}

	public List<Integer> ConvertStringtoIntArray(String vector) {
		// System.out.println(vector);
		String[] strVector = vector.split("	");
		List<Integer> converted = new ArrayList<>();
		for (int i = 0; i < strVector.length; i++) {
			converted.add(Integer.parseInt(strVector[i]));
		}
		return converted;
	}

	public String ConvertIntArraytoString(List<Integer> vector,
			boolean withdelimeter) {
		String ltemp = "";
		for (int i = 0; i < vector.size(); i++) {
			if (withdelimeter)
				ltemp += vector.get(i).toString() + "	";
			else
				ltemp += vector.get(i).toString();
		}
		if (ltemp != "")
			if (withdelimeter)
				return ltemp.substring(0, ltemp.length() - 1);
			else
				return ltemp;
		else
			return "";
	}

	public List<Boolean> ConvertStringtoBooleanArray(String vector) {
		String[] strVector = vector.split("	");
		List<Boolean> converted = new ArrayList<>();
		for (int i = 0; i < strVector.length; i++) {
			converted.add(strVector[i].equalsIgnoreCase("1") ? true : false);
		}
		return converted;
	}

	public String ConvertBooleanArrayToString(List<Boolean> vector,
			boolean withdelimeter) {
		String ltemp = "";
		for (int i = 0; i < vector.size(); i++) {
			if (withdelimeter)
				ltemp += (vector.get(i) == true ? "1" : "0") + "	";
			else
				ltemp += (vector.get(i) == true ? "1" : "0");
		}
		if (ltemp != "")
			if (withdelimeter)
				return ltemp.substring(0, ltemp.length() - 1);
			else
				return ltemp;
		else
			return "";
	}
}
