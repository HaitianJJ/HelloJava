import java.text.NumberFormat;

public class Mortgage {
    private final byte percent = 100, monthsInYear = 12;
    private double princple, annualInterest;
    private int numberOfPayments;

    public Mortgage(double principal, double annualInterest, int numberOfPayments) {
        this.annualInterest = readNumber(annualInterest);
        this.princple = readNumber(principal);
        this.numberOfPayments = readNumber(numberOfPayments);
    }

    public void printMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.printf("\nMORTGAGE\n--------\nMonthly Payments: " + mortgageFormatted);
    }

    private double calculateMortgage() {
        double monthlyInterest = annualInterest / percent / monthsInYear;
        double mortgage = princple
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    private double readNumber(double value) {
        if (0 > value)
            throw new IllegalArgumentException("input must be greater than 0");
        else
            return value;
    }

    private int readNumber(int value) {
        if (0 > value)
            throw new IllegalArgumentException("input must be greater than 0");
        else
            return value;
    }

}
