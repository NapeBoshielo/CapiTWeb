package pages;

import co.za.capitecbank.testing.utilities.EmailOTP;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException, InterruptedException {

        String OTP = EmailOTP.GetOTP("/me/messages","Sandbox: Verify your identity in Salesforce","If you didn't recently log in","Verification Code:",7);

    }
}
