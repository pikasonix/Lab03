package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class EquationSolver {
    public static void main(String[] args) {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Option:\n1. Linear equation (ax + b = 0)\n"
                        + "2. Linear system (a11 x1+a12 x2=b1, a21 x1+a22 x2=b2)\n"
                        + "3. Quadratic equation (ax^2 + bx + c = 0)"));
        switch(option) {
            case 1:
                linearEquation();
                break;
            case 2:
                linearSystem();
                break;
            case 3:
                quadraticEquation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error");
                break;
        }
    }

    // ax + b = 0
    private static void linearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));

        if (a==0 && b==0) JOptionPane.showMessageDialog(null, "All real numbers");
        else if (a==0) JOptionPane.showMessageDialog(null, "No solution");
        else {
            double x = -b/a;
            JOptionPane.showMessageDialog(null, "x = " + x);
        }
    }

    // a_11 x_1+a_12 x_2=b_1, a_21 x_1+a_22 x_2=b_2
    private static void linearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b1: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b2: "));

        double D = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;

        if (D==0) {
            if (D1==0 && D2==0) JOptionPane.showMessageDialog(null, "Infinite solution");
            else JOptionPane.showMessageDialog(null, "No solution");
        } else {
            double x1 = D1/D;
            double x2 = D2/D;
            JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
        }
    }

    // ax^2 + bx + c = 0
    private static void quadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a (a <> 0): "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter c: "));

        if (a==0) JOptionPane.showMessageDialog(null, "Choose option 1  to solve");
        else {
            double delta = b*b - 4*a*c;
            if (delta>0) {
                double x1 = (-b+Math.sqrt(delta)) /  (2*a);
                double x2 = (-b-Math.sqrt(delta)) / (2*a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            } else if (delta==0) {
                double x = -b/(2*a);
                JOptionPane.showMessageDialog(null, "x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        }
    }
}