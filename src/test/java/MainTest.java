import CertificationExercises.Main;
import CertificationExercises.ValueOutOfTheRangeException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MainTest {

    // EXER 01 04

    @Test
    public void exercise_01_04ShouldReturnCorrectOutputWhenUsedWithInputsDeclaredInExercise(){
        assertEquals(4.040541463503893E-6, Main.exercise_01_04(), 0.1E-21);
    }

    @Test
    public void exercise_01_04ShouldReturnCorrectValueWhenVariablesAreInTheirRanges() throws ValueOutOfTheRangeException {
        assertEquals(5.1293294387550576E-5, Main.exercise_01_04(0.95,1000), 0.1E-21);
    }

    @Test(expected = ValueOutOfTheRangeException.class)
    public void exercise_01_04ShouldThrowOutOfTheRangeExceptionWhenDecimalPercentageIsNotInRangeFrom0to1() throws ValueOutOfTheRangeException {
        Main.exercise_01_04(-0.95,1000);
    }

    @Test(expected = ValueOutOfTheRangeException.class)
    public void exercise_01_04ShouldThrowValueOutOfTheRangeExceptionWhenTimeIsSmallerThan1() throws ValueOutOfTheRangeException {
        Main.exercise_01_04(0.95,-1000);
    }

    // EXER 02 04

    @Test
    public void exercise_02_04ShouldReturnCorrectOutputWhenUsedWithInputsDeclaredInExercise(){
        assertEquals("Failure rate: 1.0000000000000009E-4 , MTBF: 9999.99999999999", Main.exercise_02_04());
    }

    @Test
    public void exercise_02_04ShouldReturnCorrectOutputWhenEveryProvidedVariableIsInTheirRange() throws ValueOutOfTheRangeException {
        assertEquals("Failure rate: 0.005 ,  MTBF: 200.0", Main.exercise_02_04(0.5,100));
    }

    @Test (expected = ValueOutOfTheRangeException.class)
    public void exercise_02_04ShouldThrowValueOutOfTheRangeExceptionWhenAnyProvidedVariableIsNotInItsRange() throws ValueOutOfTheRangeException {
        Main.exercise_02_04(0.5,-100);
    }

    // EXER 01 06

    @Test
    public void exercise_01_06ShouldReturnCorrectOutputWhenUsedWithInputsDeclaredInExercise(){
        assertEquals(0.6065, Main.exercise_01_06(), 0.0001);
    }

    @Test
    public void exercise_01_06ShouldReturnCorrectOutputWhenEveryProvidedVariableIsInTheirRange() throws ValueOutOfTheRangeException {
        assertEquals(0.6065, Main.exercise_01_06(), 0.0001);
    }

    @Test (expected = ValueOutOfTheRangeException.class)
    public void exercise_01_06ShouldThrowOutOfTheRangeExceptionWhenAnyProvidedVariableIsNotInItsRange() throws ValueOutOfTheRangeException {
        Main.exercise_01_06(-1,4);
    }


    // EXER 03 05

    @Test
    public void exercise_03_05ShouldReturnCorrectOutputWhenUsedWithInputsDeclaredInExercise(){
        assertEquals(Main.exercise_03_05(), "In service after 5 years: 595\nWill fail: 405");
    }

    @Test
    public void exercise_03_05ShouldReturnCorrectOutputWhenEveryProvidedVariableIsInTheirRange() throws ValueOutOfTheRangeException {
        assertEquals(Main.exercise_03_05(0.1, 100, 10), "In service after 10 years: 32\nWill fail: 68");
    }

    @Test (expected = ValueOutOfTheRangeException.class)
    public void exercise_03_05ShouldThrowOutOfTheRangeExceptionWhenAnyProvidedVariableIsNotInItsRange() throws ValueOutOfTheRangeException {
        Main.exercise_03_05(0.1, -100, 10);
    }

    // EXER 02 02

    @Test
    public void exercise_02_02ShouldReturnCorrectOutputWhenUsedWithInputsDeclaredInExercise(){
        assertEquals(Main.exercise_02_02(), "numberOfEngines: 2 numberOfShields: 10");
    }

    @Test
    public void exercise_02_02ShouldReturnCorrectOutputWhenEveryProvidedVariableIsInTheirRange() throws ValueOutOfTheRangeException {
        assertEquals(Main.exercise_02_02(0.0000005, 0.00000010, 100, 180),
                "numberOfEngines: 0 numberOfShields: 0");
    }

    @Test (expected = ValueOutOfTheRangeException.class)
    public void exercise_02_02ShouldThrowOutOfTheRangeExceptionWhenAnyProvidedVariableIsNotInItsRange() throws ValueOutOfTheRangeException {
        Main.exercise_02_02(0.5, 0.1, -1, 180);
    }
}
