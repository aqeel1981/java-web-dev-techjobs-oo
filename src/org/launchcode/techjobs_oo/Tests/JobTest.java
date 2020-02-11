package org.launchcode.techjobs_oo.Tests;

import org.launchcode.techjobs_oo.Job;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Before;
import java.util.Objects;
import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    private Job aJob;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    @Test
    public void testSettingJobId() {
        assertTrue(settingJobId(job1, job2));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assert (job3 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse (job3.equals(job4));
    }

    @Test
    public void testJobsForBlankLine(){
        assertFalse(testForBlankLine(job3));
    }

    @Test
    public void testJobsForFieldAndLines (){
        assertFalse(testForLabelAndSeparateLines(job3));
    }

    @Test
    public void testEmptyField (){
        assertFalse(testForEmptyField(job2));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobTest jobTest = (JobTest) o;
        return job3.equals(jobTest.job3) &&
                job4.equals(jobTest.job4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job3, job4);
    }

    public boolean settingJobId(Job aJob, Job bJob) {

        if(bJob.getId() - aJob.getId() == 1){
            return true;
        }else
            return false;
    }

    public boolean testForBlankLine (Job aJob){

        int hasBlankLine = 0;

        if(aJob.toString().contains("\n")) {
            hasBlankLine++;
        }

        return hasBlankLine == 0;
    }

    public boolean testForLabelAndSeparateLines (Job aJob){

        int checkInt = 0;

        if(aJob.toString().contains("ID:") && aJob.toString().contains("\n") &&
                aJob.toString().contains("Name:") && aJob.toString().contains("\n") && aJob.toString().contains("Employer:") &&
                aJob.toString().contains("\n") && aJob.toString().contains("Location:") && aJob.toString().contains("\n") &&
                aJob.toString().contains("Position Type:") && aJob.toString().contains("\n") && aJob.toString().contains("Core Competency:")) {

            checkInt++;
        }

        return checkInt == 0;
    }

    public boolean testForEmptyField(Job aJob){

        int  checker = 0;
        if(aJob.getId() == 0){
            checker++;
        }else if(aJob.getName() == null || aJob.getEmployer() == null || aJob.getLocation() == null || aJob.getPositionType() == null || aJob.getCoreCompetency() == null) {
            checker++;
        }

        return checker == 0;
    }
}




