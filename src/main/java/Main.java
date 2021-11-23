import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.exp;
import static java.lang.Math.log;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        boolean flag = true;
        while(flag){
            System.out.println("Choice number: 0.Exit, 1.(01_04), 2.(02_02) " +
                    "3.(03_05), 4.(01_06), 5.(02_04)");

            try{

                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        if (askForWillingnessToProvideVariables(scanner)) {

                            System.out.println("(decimalPercentage, time)\n\n" +
                                    "decimalPercentage (double : >0 && <1) - Percentage of reliability\n" +
                                    "time (int : >0) - Time of work");
                            double decimalPercentage = scanner.nextDouble();
                            int time = scanner.nextInt();
                            System.out.println(exercise_01_04(decimalPercentage, time));
                        } else
                            System.out.println(exercise_01_04());
                        break;
                    case 2:
                        if (askForWillingnessToProvideVariables(scanner)) {
                            System.out.println("(failureRateOfShaft, failureRateShield, numberOfItems, time)\n\n" +
                                    "failureRateOfShaft (double : >0 && <1) - Failure Rate of Shaft\n" +
                                    "failureRateShield (double : >0 && <1) - Failure Rate of Shield\n" +
                                    "numberOfItems (int : >0) - Number of Engines\n" +
                                    "time (int : >0) - How much time product is operating");
                            double failureRateOfShaft = scanner.nextDouble();
                            double failureRateShield = scanner.nextDouble();
                            int numberOfItems = scanner.nextInt();
                            int time = scanner.nextInt();
                            System.out.println(exercise_02_02(failureRateOfShaft, failureRateShield, numberOfItems, time));
                        } else
                            System.out.println(exercise_02_02());
                        break;
                    case 3:
                        if (askForWillingnessToProvideVariables(scanner)) {
                            System.out.println("(failureRatePerYear, count, years)\n\n" +
                                    "failureRatePerYear (double : >0 && <1)\n" +
                                    "count (int : >0) - Amount of units\n" +
                                    "years (years : >0) - Years of service");
                            double failureRatePerYear = scanner.nextDouble();
                            int count = scanner.nextInt();
                            int years = scanner.nextInt();
                            System.out.println(exercise_03_05(failureRatePerYear, count, years));
                        } else
                            System.out.println(exercise_03_05());
                        break;
                    case 4:
                        if (askForWillingnessToProvideVariables(scanner)) {
                            System.out.println("(MTBF, time)\n\n" +
                                    "MTBF (int : >0) - Mean Time Between Failure\n" +
                                    "time (int : >0) - Time equipment operates");
                            int MTBF = scanner.nextInt();
                            int time = scanner.nextInt();
                            System.out.println(exercise_01_06(MTBF, time));
                        } else
                            System.out.println(exercise_01_06());

                    case 5:
                    if (askForWillingnessToProvideVariables(scanner)) {
                            System.out.println("(double reliability, int time)\n\n" +
                                    "reliability (double : >0 && <1) - probability that a product will perform a required function\n" +
                                    "time (int : >0) - period of time");
                            double reliability = scanner.nextDouble();
                            int time = scanner.nextInt();
                            System.out.println(exercise_02_04(reliability, time));
                        } else
                            System.out.println(exercise_02_04());

                        break;
                    default:
                        System.out.println("Wrong number");
                }
            } catch (InputMismatchException e){
                System.out.println("You provided wrong type of variable");
                scanner.next();
            } catch (ValueOutOfTheRangeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Asks user of willingness to provide variables to next functions.
     *
     * @return boolean
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */
    public static boolean askForWillingnessToProvideVariables(Scanner scanner) {
        System.out.println("Do you want to provide variables? (y/n)");
        String variablesChoice = scanner.next();
        while (true){
            if (variablesChoice.equals("y") || variablesChoice.equals("yes"))
                return true;
            else if (variablesChoice.equals("n") || variablesChoice.equals("no"))
                return false;
            else{
                System.out.println("Enter yes or no.");
                variablesChoice = scanner.next();
            }

        }
    }

    /**
     * Calculates highest failure rate for a product that have reliability of {@code decimalPercentage}
     * at {@code time}
     * @param decimalPercentage (double) Percentage of reliability
     * @param time (int) Time of work
     * @return result
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */
    public static double exercise_01_04(double decimalPercentage, int time) throws ValueOutOfTheRangeException {
        if ((decimalPercentage < 0 || decimalPercentage > 1) || time < 0)
            throw new ValueOutOfTheRangeException();
        return -log(decimalPercentage) / time;
    }

    /**
     * Calculates highest failure rate for a product that have a reliability of
     * 98 percent at 5000 hours.
     *
     * @return result
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */
    public static double exercise_01_04(){ return -log(0.98) / 5000; }

    /**
     * Estimates the number of two products where amount of both is {@code numberOfItems} units
     * that must be replaced annually when
     * one product have failure of {@code failureRateOfShaft}
     * and second have failure rate {@code failureRateOfShield}
     * and each connection of two products operates {@code time} days
     *
     * @param failureRateOfShaft (double) Failure Rate of Shaft
     * @param failureRateShield (double) Failure Rate of Shield
     * @param numberOfItems (int) Number of Engines
     * @param time (int) How much time product is operating
     * @return String sentence which contain calculation
     *
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */
    public static String exercise_02_02(double failureRateOfShaft, double failureRateShield, int numberOfItems, int time) throws ValueOutOfTheRangeException {
        if ((failureRateShield < 0 || failureRateShield > 1) ||
                (failureRateOfShaft < 0 || failureRateOfShaft > 1) ||
                time < 0 || numberOfItems < 0)
            throw new ValueOutOfTheRangeException();
        double numberOfEngines = failureRateOfShaft * numberOfItems * time * 24;
        double numberOfShields = failureRateShield * numberOfItems * time * 24;
        if (numberOfEngines > numberOfItems)
            numberOfEngines = numberOfItems;
        if (numberOfShields > numberOfItems)
            numberOfShields = numberOfItems;
        return "numberOfEngines: " + (int) numberOfEngines + " numberOfShields: " + (int) numberOfShields;
    }

    /**
     * Estimates the number of two products where amount of both is 5000 units
     * that must be replaced annually when
     * one product have failure of 0.5 x 10^-7/hr
     * and second have failure rate of 2.5 x 10^-7/hr
     * and each connection of two products operates 350 days
     *
     * @return String sentence which contain calculation
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */
    public static String exercise_02_02(){
        double numberOfEngines = 0.00000005 * 5000 * 8400;
        double numberOfShields = 0.00000025 * 5000 * 8400;
        return "numberOfEngines: " + (int) numberOfEngines + " numberOfShields: " + (int) numberOfShields;
    }

    /**
     * a) Calculates how many products with amount of {@code count} units that have a failure rate of
     * {@code failureRatePerYear} per year will still be in service after {@code years} years.
     *
     * b) Calculates how many products will fail in Year {@code years}
     *
     * @param failureRatePerYear (double)
     * @param count (int) Amount of units
     * @param years (years) Years of service
     * @return String sentence which contain calculation
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static String exercise_03_05(double failureRatePerYear, int count, int years) throws ValueOutOfTheRangeException {
        if ((failureRatePerYear < 0 || failureRatePerYear > 1) || count < 0 || years < 0)
            throw new ValueOutOfTheRangeException();

        int countAfterYearsOfService = count;
        for (int i = 1; i<=years; i++)
            countAfterYearsOfService -= countAfterYearsOfService*failureRatePerYear;

        return "In service after " + years + " years: " + countAfterYearsOfService + "\n" +
                "Will fail: " + (count-countAfterYearsOfService);
    }

    /**
     * a) Calculates how many products with amount of 1000 units that have a failure rate of
     * 0,05 per year will still be in service after 5 years
     *
     * b) Calculates how many products will fail in Year 5
     *
     * @return String sentence which contain calculation
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static String exercise_03_05(){
        int countAfterYearsOfService = 1000;
        for (int i = 1; i<=10; i++)
            countAfterYearsOfService -= countAfterYearsOfService*0.05;
        return "In service after " + 5 + " years: " + countAfterYearsOfService + "\n" +
                "Will fail: " + (1000 - countAfterYearsOfService);
    }

    /**
     * * Deduces the probability that equipment will operate
     * for a period of {@code time} hours, where MTBF is {@code MTBF} hours
     *
     * @param MTBF (int) Mean Time Between Failure
     * @param time (int) time equipment operates
     * @return result
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static double exercise_01_06(int MTBF, int time) throws ValueOutOfTheRangeException {
        if (MTBF < 0 || time < 0)
            throw new ValueOutOfTheRangeException();
        double failureRate = (double) 1 / MTBF;
        return exp(-time * failureRate);
    }
    /**
     * Deduces the probability that equipment will operate
     * for a period of 500 hours, where MTBF is 1000 hours
     *
     * @return result
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static double exercise_01_06(){ return (double) Math.round(exp(-500 * 0.001)* 10000.0) / 10000; }

    /**
     * Estimates maximum permissible failure rate and minimum MTBF.
     * Device is required to have {@code reliability} over  {@code time} hours
     *
     * @param reliability (double) probability that a product will perform a required function
     * @param time (int) period of time
     * @return String sentence which contain calculation
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static String exercise_02_04(double reliability, int time) throws ValueOutOfTheRangeException {
        if ((reliability < 0 || reliability > 1) || time < 0)
            throw new ValueOutOfTheRangeException();
        double failureRate = (1 - reliability)/time;
        double MTBF = 1 / failureRate;
        return "Failure rate: " + failureRate + " ,  MTBF: " + MTBF;
    }

    /**
     * Estimates maximum permissible failure rate and minimum MTBF.
     * Device is required to have 95% reliability over 500 hours
     *
     * @return String sentence which contain calculation
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */

    public static String exercise_02_04(){
        double failureRate = (1 - 0.95)/500;
        double MTBF = 1 / failureRate;
        return "Failure rate: " + failureRate + " , MTBF: " + MTBF;
    }

    public void testMethod(){
        int x = 13;
        int y = x + 13;
        y += x;
        return;
    }

}
