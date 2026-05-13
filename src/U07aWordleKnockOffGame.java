import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class U07aWordleKnockOffGame {

    // Create a static method named checkLetter that returns a one-emoji String.
    // Requires 3 arguments: String secretWord, String letter, int indexLocation.
    public static String checkLetter(String secretWord, String letter, int indexLocation) {
        // If the letter is at indexLocation of the secretWord, return…
        // a single green ✅ Check Mark Button emoji
        if (secretWord.substring(indexLocation, indexLocation + 1).equals(letter)) {
            return "✅";
        } 
        // If the letter exists somewhere else in the secretWord, return…
        // a single 🔀 shuffle tracks button emoji.
        else if (secretWord.contains(letter)) {
            return "🔀";
        } 
        // Otherwise, return a single 🔳 White Square Button Emoji.
        else {
            return "🔳";
        }
        // checkLetter("coder", "c", 0) ⟶ "✅"
        // checkLetter("coder", "r", 2) ⟶ "🔀"
        // checkLetter("coder", "x", 4) ⟶ "🔳"
    }
    
    //  Create a static method named checkGuess that returns a 5-emoji hint String.
    //  Requires 2 arguments: String secretWord, String userGuess. Check each letter
    //  of userGuess. Each time you check a letter, you will get a single emoji.
    //  Return a hint string of 5 emojis.
    // checkGuess("coder", "clown") ⟶ "✅🔳🔀🔳🔳"
    // checkGuess("coder", "raced") ⟶ "🔀🔳🔀✅🔀"
    // checkGuess("coder", "cedar") ⟶ "✅🔀✅🔳✅"
    public static String checkGuess(String secretWord, String userGuess) {
        String hint = "";
        for (int i = 0; i < 5; i++) {
            String guessLetter = userGuess.substring(i, i + 1);
            String secretLetter = secretWord.substring(i, i + 1);
            if (guessLetter.equals(secretLetter)) {
                hint += "✅";
            } else if (secretWord.contains(guessLetter)) {
                hint += "🔀";
            } else {
                hint += "🔳";
            }
        }
        return hint;
    }
    
    
    //  Create a static method named randomSecret that returns a String.
    //  Requires 1 argument: String[ ] listOfWords. Randomly select one secret word
    //  from the listOfWords. If the array length is less than 1, then always return
    //  the word "error". If the secret word is not exactly 5 letters long, always return
    //  the word "sorry". Otherwise convert it to lowercase and return the secret word.
    public static String randomSecret(String [] listOfWords){
        // 1. Check if array length is less than 1
        if (listOfWords == null || listOfWords.length < 1) {
            return "error";
        }

        // 2. Randomly select one word
        int randomIndex = (int) (Math.random() * listOfWords.length);
        String secretWord = listOfWords[randomIndex];

        // 3. Check if the secret word is exactly 5 letters long
        if (secretWord == null || secretWord.length() != 5) {
            return "sorry";
        }

        // 4. Return lowercase
        return secretWord.toLowerCase();
    }
    
    // Create a static method named getWordArray that returns a String array that
    // contains all the 5-letter English words
    public static String[] getWordArray(){
        return new String[] {
            "apple", "mario", "luigi", "sonic", "mouse", "peach", "grade", "teach",
            "shrek", "snake", "wario", "which", "there", "their", "about", "would",
            "these", "other", "words", "could", "write", "first", "water", "after",
            "where", "right", "think", "three", "years", "place", "sound", "great",
            "again", "still", "every", "small", "found", "those", "never", "under",
            "might", "while", "house", "world", "below", "asked", "going", "large",
            "until", "along", "shall", "being", "often", "earth", "began", "since",
            "study", "night", "light", "pizza", "above", "paper", "mines", "craft"
        };
    }
    
      public static void main(String[] args) {
    // declare variables String[] word array, String secret word, String user guess, String hint string.
        String[] wordArray;
        String secretWord;
        String userGuess = "";
        String hintString;

        // create a String ArrayList to store hint history
        java.util.ArrayList<String> hintHistory = new java.util.ArrayList<>();

        // call the getWordArray method and save what it returns in wordArray variable
        wordArray = getWordArray();

        // call randomSecret(wordArray) and save what it returns in the secret word variable
        secretWord = randomSecret(wordArray);

        // do this… while the secret word does not equal the user guess
        do {
            // call getUserInput and save what it returns in the user guess variable
            userGuess = getUserInput();

            // call the checkGuess(secretWord, userGuess) and save the result as hintString
            hintString = checkGuess(secretWord, userGuess);

            // add the userGuess + " " + hintString to the hint history list
            hintHistory.add(userGuess + " " + hintString);

            // call the displayHints method and pass hint history as an argument
            displayHints(hintHistory);

        } while (!secretWord.equals(userGuess));

        // add "YOU GOT IT!!! The secret word was " + secretWord to the hint history
        hintHistory.add("YOU GOT IT!!! The secret word was " + secretWord);

        // call the displayHints method and pass hint history as an argument
        displayHints(hintHistory);
    }


      public static String getUserInput() {
        final String[] userInput = {null};
        JFrame frame = new JFrame("Word Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocation(100, 100);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel instructionLabel = new JLabel("Enter a 5-letter word:", SwingConstants.CENTER);
        panel.add(instructionLabel, BorderLayout.NORTH);
        JTextField guessField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        JPanel inputPanel = new JPanel();
        inputPanel.add(guessField);
        inputPanel.add(submitButton);
        panel.add(inputPanel, BorderLayout.CENTER);
        final Object lock = new Object();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guess = guessField.getText().trim().toLowerCase();
                if (guess.length() == 5) {
                    synchronized (lock) {
                        userInput[0] = guess;
                        lock.notify();
                    }
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Word must be exactly 5 letters long.");
                }
            }
        });
        frame.add(panel);
        frame.setVisible(true);
        synchronized (lock) {
            while (userInput[0] == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return userInput[0];
    }

    public static void displayHints(ArrayList<String> hintHistory) {
        JFrame frame = new JFrame("Word Game - Hints");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocation(100, 300);
        JTextArea hintArea = new JTextArea();
        hintArea.setEditable(false);
        for (String hint : hintHistory) {
            hintArea.append(hint + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(hintArea);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    
    
}