package uk.ac.aber.cs21120.wedding.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;
import uk.ac.aber.cs21120.wedding.interfaces.IRules;
import uk.ac.aber.cs21120.wedding.interfaces.ISolver;
import uk.ac.aber.cs21120.wedding.solution.Plan;
import uk.ac.aber.cs21120.wedding.solution.Rules;
import uk.ac.aber.cs21120.wedding.solution.Solver;

public class ExtraTests {

    @Test
    public void testsolver(){
        String[] guests = {"A","B","C","D","E","F"};
        IRules r = new Rules();
        IPlan p = new Plan(2,3);
        r.addMustBeApart("A","B");
        r.addMustBeApart("C","D");
        r.addMustBeTogether("A","D");
        ISolver s = new Solver(guests,p,r);
        Assertions.assertEquals(true, s.solve());
    }

    /**
     * Check that the function correctly identifies a together rule and returns the correct boolean value
     */
    @Test
    public void testdoesTogetherExist(){
        IRules r = new Rules();
        //Add rules
        r.addMustBeTogether("A","C");
        Assertions.assertEquals(true, ((Rules) r).doesTogetherExist("A", "C"));
        Assertions.assertEquals(false, ((Rules) r).doesTogetherExist("A", "B"));
    }

    /**
     * Check that the function correctly identifies an apart rule and returns the correct boolean value
     */
    @Test
    public void testdoesApartExist(){
        IRules r = new Rules();
        //Add rules
        r.addMustBeApart("A","C");
        Assertions.assertEquals(true, ((Rules) r).doesApartExist("A", "C"));
        Assertions.assertEquals(false, ((Rules) r).doesApartExist("A", "B"));
    }
}
