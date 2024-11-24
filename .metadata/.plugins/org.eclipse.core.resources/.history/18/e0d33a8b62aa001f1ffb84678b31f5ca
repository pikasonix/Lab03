import javax.swing.JOptionPane;
public class caculator {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        strNotification += strNum2;

        double sum = num1+num2;
        double difference = num1-num2;
        double product = num1*num2;
        double quotient = (num2!=0) ? num1/num2 : Double.NaN; 

        String resultMessage = strNotification + 
            "\nSum: " + sum +
            "\nDifference: " + difference +
            "\nProduct: " + product +
            "\nQuotient: " + (num2 != 0 ? quotient : "Undefined");

        JOptionPane.showMessageDialog(null, resultMessage, "Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
