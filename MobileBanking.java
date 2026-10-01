interface BasicSecurity {
    void login();
    void logout();
}
interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuthentication();
    void faceRecognition();
}
class BankingApplication implements AdvancedSecurity {
    @Override
    public void login() {
        System.out.println("User logged in successfully.");
    }
    @Override
    public void logout() {
        System.out.println("User logged out successfully.");
    }
    @Override
    public void fingerprintAuthentication() {
        System.out.println("Fingerprint authentication successful.");
    }
    @Override
    public void faceRecognition() {
        System.out.println("Face recognition successful.");
    }
}
public class MobileBanking {
    public static void main(String[] args) {
        BankingApplication bank = new BankingApplication();
        bank.login();
        bank.fingerprintAuthentication();
        bank.faceRecognition();
        bank.logout();
    }
}