package manager;

import model.CardPayment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentManager {

    public void addPayment(CardPayment payment) throws IOException {
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter("payments.txt", true))) {

            bw.write(payment.toFileString());
            bw.newLine();
        }
    }
}

