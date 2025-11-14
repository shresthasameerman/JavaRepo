public class throwThrowable {
    public static void main(String[] args) {
        throwThrowable person1 = new throwThrowable();
        try {
            person1.checkAge(60);
        } catch (Exception e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }

    public void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age is less than 18");
        } else {
            System.out.println("Age is valid: " + age);
        }
    }
}
