import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gameDemo {
    /*
    To guess the number with the lowest algorithm complexity I use for this demo the BinarySearch method.
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        int guessedNumber = searchUsersNumber(numbers, 0, numbers.size() - 1);
        if(guessedNumber == -1){
            System.out.println("You cheated! Bye");
        }
        else {
            System.out.println("Number found - " + guessedNumber);
        }
    }
    static int searchUsersNumber(List<Integer> numbers, int start, int end){
        int midIdx = (start + end) / 2;
        int guess = numbers.get(midIdx);
        System.out.println("Does your number equals " + guess + "?");
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            input = sc.nextLine();
            if(input.equals(">") || input.equals("<") || input.equals("=")){
                break;
            }
            System.out.println("Entered value is invalid!");
        }
        if(midIdx == end && (input.equals(">") || input.equals("<"))){
            return -1;
        }
        if(midIdx == start && input.equals("<")){
            return -1;
        }
        if(midIdx == start && input.equals(">")){
            return numbers.get(midIdx + 1);
        }
        if(midIdx == end - 1 && input.equals(">")){
            return numbers.get(end);
        }
        if(input.equals(">")){
            return searchUsersNumber(numbers, midIdx + 1, end);
        }

        if(input.equals("<")){
            return searchUsersNumber(numbers, start, midIdx - 1);
        }
        return guess;
    }
}
