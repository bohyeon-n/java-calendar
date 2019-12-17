import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int num1, num2;
        Scanner myobj = new Scanner(System.in);
        System.out.println("숫자 두 개를 입력해주세요");
        String inputValue = myobj.nextLine();
        String [] splitedInputValue =  inputValue.split(" ");
        num1 = Integer.parseInt(splitedInputValue[0]);
        num2 = Integer.parseInt(splitedInputValue[1]);
        System.out.printf("두 수 의 합은 %d 입니다",  num1 + num2);
        myobj.close();
    }
}
c