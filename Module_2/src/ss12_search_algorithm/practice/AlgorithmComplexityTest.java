package ss12_search_algorithm.practice;


import java.util.Scanner;

public class AlgorithmComplexityTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[255];                         //{1}
        for (int i = 0; i < inputString.length(); i++) {           //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = inputString.charAt(i);                     //{3}
            System.out.println(ascii);
            /* Tăng giá trị tần suất */
            frequentChar[ascii] += 1;                             //{4}
        }

        int max = 0;                                             //{5}
        char character = (char) 255; /* empty character */      //{6}
        for (int j = 0; j < 255; j++) {                         //{7}
            if (frequentChar[j] > max) {                        //{8}
                max = frequentChar[j];                          //{9}
                character = (char) j;                           //{10}
            }
        }

        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
    /* Ta sẽ có 2 trường hợp
    TH1: n <= 255
    Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {7} và bằng O(255)
    TH2: n> 255
    Khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh {2} và bằng O(n) */
}
