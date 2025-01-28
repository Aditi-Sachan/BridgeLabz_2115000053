import java.util.HashSet;
import java.util.Set;

public class GenerateOTP {

    public static String generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    public static boolean areOTPsUnique(String[] otps) {
        Set<String> otpSet = new HashSet<>();
        for (String otp : otps) {
            if (!otpSet.add(otp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] otps = new String[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        boolean unique = areOTPsUnique(otps);

        System.out.println("Generated OTPs: ");
        for (String otp : otps) {
            System.out.println(otp);
        }

        System.out.println("Are all OTPs unique? " + unique);
    }
}


