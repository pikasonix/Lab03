package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION ? "Yes" : "No"));
		System.exit(0);
	}
}

// ---Only Yes/No---
// import javax.swing.JOptionPane;
// public class ChoosingOption {
//    public static void main(String[] args) {
//        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket?", "Select an Option", JOptionPane.YES_NO_OPTION);
//        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
//        System.exit(0);
//    }
// }

//---I do/I don't---
// import javax.swing.JOptionPane;
// public class ChoosingOption {
// 	public static void main(String[] args) {
// 		Object[] options = {"I do", "I don't"};
// 	    int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Select an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
// 	    JOptionPane.showMessageDialog(null, "You've chosen: " + (option==0 ? "I do" : "I don't"));
// 		System.exit(0);
// 	}
// }