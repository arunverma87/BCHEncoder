import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class MainPage {

	static General genfunction = new General();

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static List<Boolean> randomelement = null;

	static int codelength = 0;
	static int datalength = 0;
	static int errorcorretionlength = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String userinput;
			int totalerrors = 0;
			do {

				System.out.print("Enter Code Length:");
				do {
					userinput = input.readLine().trim();
					try {
						codelength = Integer.parseInt(userinput);
					} catch (Exception excode) {
						System.out.println("Err : enter decimal value only");

					}
				} while (codelength == 0);

				System.out.print("Enter Data Length:");
				do {
					userinput = input.readLine().trim();
					try {
						datalength = Integer.parseInt(userinput);
						if (datalength > codelength) {

						}
					} catch (Exception excode) {
						System.out.println("Err : enter decimal value only");

					}
				} while (datalength == 0);

				System.out.print("Enter Error Correction Length:");
				do {
					userinput = input.readLine().trim();
					try {
						errorcorretionlength = Integer.parseInt(userinput);
					} catch (Exception excode) {
						System.out.println("Err : enter decimal value only");

					}
				} while (errorcorretionlength == 0);

				System.out.flush();
				System.out.print("Data string will be generated randomly for pattern(" + codelength + "," + datalength + ","
						+ errorcorretionlength + "). Press enter to continue.");
				System.out.flush();
				input.readLine().trim();

				//List<Integer> errors = new ArrayList<>();
				List<Boolean> enc = DoEncoding();

				System.out.println("Encoded String :");
				System.out.println(genfunction.ConvertBooleanArrayToString(enc, false));

				System.out.print("Enter no of errors to generate:");
				userinput = input.readLine().trim();

				totalerrors = Integer.parseInt(userinput);

				for (int i = 0; i < totalerrors; i++) {

					System.out.print((i + 1) + ": ");
					int bitnumber = Integer.parseInt(input.readLine().trim());
					enc.set(bitnumber - 1, (enc.get(bitnumber - 1) ^ true));
				}

				System.out.print("New Encoded String with error : ");
				System.out.println(genfunction.ConvertBooleanArrayToString(enc, false));

				System.out.print("Press enter to decode.");
				System.out.flush();
				input.readLine().trim();

				List<Boolean> dec = DoDecoding(enc);

				System.out.println("Decoded String :" + genfunction.ConvertBooleanArrayToString(dec, false));

				System.out.println("String Matched ? : " + String.valueOf(randomelement.equals(dec)).toUpperCase());

				System.out.println("Continue Program?(Enter q to quit.)");
				System.out.flush();
				userinput = input.readLine().trim();

			} while (!userinput.equals("q"));

			System.out.println("------------------------");

		} catch (Exception ex) {

		}

	}

	private static List<Boolean> DoEncoding() {

		List<Boolean> enc = null;
		try {
			RandomGenerator rg = new RandomGenerator(datalength);
			randomelement = rg.GenerateRandomVector();

			System.out.println("Random Element :" + genfunction.ConvertBooleanArrayToString(randomelement, false));

			if (randomelement != null) {
				BCHCoder bch = new BCHCoder(codelength, errorcorretionlength);
				enc = bch.DoEncoding(randomelement);
			}
		} catch (Exception ex) {
			System.err.println("Error occurred in Secure Encoder." + ex.toString());
			ex.printStackTrace();
		}
		return enc;

	}

	private static List<Boolean> DoDecoding(List<Boolean> data) {
		List<Boolean> dec = null;
		try {
			BCHCoder bch = new BCHCoder(codelength, datalength, errorcorretionlength);
			dec = bch.DoDecoding(data);
		} catch (Exception ex) {
			System.err.println("Error occurred in Secure decoder." + ex.toString());
			ex.printStackTrace();
		}
		return dec;

	}

}
