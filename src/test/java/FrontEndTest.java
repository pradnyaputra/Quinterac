import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrontEndTest {

    @Test
    public void R1T1() throws Exception {
        try {
            runAndTest("Testing/Test Files/R1/R1T1 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T1 OUTPUT.txt"),
                    fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    
    @Test
    public void R1T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T2 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }

    }

    @Test
    public void R1T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T3 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }

    }
    
    @Test
    public void R1T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T4 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R1T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T5 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R1T6() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T6 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T6 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T6 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R1T7() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T7 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T7 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T7 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R1T8() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R1/R1T8 INPUT.txt", fileToStringArray("Testing/Test Files/R1/R1T8 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R1/R1T8 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    

    @Test
    public void R2T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R2/R2T1 INPUT.txt", fileToStringArray("Testing/Test Files/R2/R2T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R2/R2T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R2T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R2/R2T2 INPUT.txt", fileToStringArray("Testing/Test Files/R2/R2T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R2/R2T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R2T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R2/R2T3 INPUT.txt", fileToStringArray("Testing/Test Files/R2/R2T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R2/R2T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R3T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T1 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R3T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T2 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R3T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T3 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R3T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T4 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R3T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T5 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R3T6() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R3/R3T6 INPUT.txt", fileToStringArray("Testing/Test Files/R3/R3T6 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R3/R3T6 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R4T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R4/R4T1 INPUT.txt", fileToStringArray("Testing/Test Files/R4/R4T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R4/R4T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R5T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R5/R5T1 INPUT.txt", fileToStringArray("Testing/Test Files/R5/R5T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R5/R5T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R5/R5T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    

    @Test
    public void R5T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R5/R5T2 INPUT.txt", fileToStringArray("Testing/Test Files/R5/R5T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R5/R5T2 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R5/R5T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    

    @Test
    public void R6T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R6/R6T1 INPUT.txt", fileToStringArray("Testing/Test Files/R6/R6T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R6/R6T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R6/R6T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R6T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R6/R6T2 INPUT.txt", fileToStringArray("Testing/Test Files/R6/R6T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R6/R6T2 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R6/R6T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));

        }
    }

    @Test
    public void R6T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R6/R6T3 INPUT.txt", fileToStringArray("Testing/Test Files/R6/R6T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R6/R6T3 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R6/R6T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));

        }
    }

    @Test
    public void R6T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R6/R6T4 INPUT.txt", fileToStringArray("Testing/Test Files/R6/R6T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R6/R6T4 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R6/R6T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));

        }
    }

    @Test
    public void R7T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R7/R7T1 INPUT.txt", fileToStringArray("Testing/Test Files/R7/R7T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R7/R7T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R7/R7T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));

        }
    }

    @Test
    public void R7T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R7/R7T2 INPUT.txt", fileToStringArray("Testing/Test Files/R7/R7T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R7/R7T2 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R7/R7T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R7T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R7/R7T3 INPUT.txt", fileToStringArray("Testing/Test Files/R7/R7T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R7/R7T3 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R7/R7T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R7T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R7/R7T4 INPUT.txt", fileToStringArray("Testing/Test Files/R7/R7T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R7/R7T4 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R7/R7T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R8T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R8/R8T1 INPUT.txt", fileToStringArray("Testing/Test Files/R8/R8T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R8/R8T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R8/R8T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R9T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T1 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T1 TSF.txt"));
        }
    }

    @Test
    public void R9T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T2 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T2 TSF.txt"));

        }
    }

    @Test
    public void R9T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T3 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T3 TSF.txt"));
        }
    }

    @Test
    public void R9T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T4 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T4 TSF.txt"));
        }
    }

    @Test
    public void R9T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T5 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T5 TSF.txt"));
        }
    }

    @Test
    public void R9T6() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T6 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T6 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T6 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T6 TSF.txt"));
        }
    }

    @Test
    public void R9T7() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R9/R9T7 INPUT.txt", fileToStringArray("Testing/Test Files/R9/R9T7 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R9/R9T7 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
            assertTrue(compareOutputFile("Testing/Test Files/R9/R9T7 TSF.txt"));
        }
    }
    

    @Test
    public void R10T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R10/R10T1 INPUT.txt", fileToStringArray("Testing/Test Files/R10/R10T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R10/R10T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R10T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R10/R10T2 INPUT.txt", fileToStringArray("Testing/Test Files/R10/R10T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R10/R10T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R11T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R11/R11T1 INPUT.txt", fileToStringArray("Testing/Test Files/R11/R11T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R11/R11T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R11T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R11/R11T2 INPUT.txt", fileToStringArray("Testing/Test Files/R11/R11T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R11/R11T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R11T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R11/R11T3 INPUT.txt", fileToStringArray("Testing/Test Files/R11/R11T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R11/R11T3 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R11/R11T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R12T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R12/R12T1 INPUT.txt", fileToStringArray("Testing/Test Files/R12/R12T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R12/R12T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R12T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R12/R12T2 INPUT.txt", fileToStringArray("Testing/Test Files/R12/R12T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R12/R12T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R13T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R13/R13T1 INPUT.txt", fileToStringArray("Testing/Test Files/R13/R13T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R13/R13T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R13T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R13/R13T2 INPUT.txt", fileToStringArray("Testing/Test Files/R13/R13T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R13/R13T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R14T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R14/R14T1 INPUT.txt", fileToStringArray("Testing/Test Files/R14/R14T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R14/R14T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R14/R14T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R14T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R14/R14T2 INPUT.txt", fileToStringArray("Testing/Test Files/R14/R14T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R14/R14T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R15T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R15/R15T1 INPUT.txt", fileToStringArray("Testing/Test Files/R15/R15T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R15/R15T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R15T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R15/R15T2 INPUT.txt", fileToStringArray("Testing/Test Files/R15/R15T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R15/R15T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R15T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R15/R15T3 INPUT.txt", fileToStringArray("Testing/Test Files/R15/R15T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R15/R15T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R15T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R15/R15T4 INPUT.txt", fileToStringArray("Testing/Test Files/R15/R15T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R15/R15T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R15T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R15/R15T5 INPUT.txt", fileToStringArray("Testing/Test Files/R15/R15T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R15/R15T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R16T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R16/R16T1 INPUT.txt", fileToStringArray("Testing/Test Files/R16/R16T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R16/R16T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    
    @Test
    public void R17T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T1 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T2 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T2 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T3 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T3 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T3 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T4 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T4 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T4 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T5 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T5 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T5 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T6() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T6 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T6 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T6 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T6 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T7() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T7 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T7 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T7 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T7 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T8() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T8 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T8 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T8 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T8 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T9() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T9 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T9 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T9 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T9 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R17T10() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R17/R17T10 INPUT.txt", fileToStringArray("Testing/Test Files/R17/R17T10 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R17/R17T10 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R17/R17T10 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R18T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R18/R18T1 INPUT.txt", fileToStringArray("Testing/Test Files/R18/R18T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R18/R18T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    

    @Test
    public void R19T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T1 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T1 VAL.txt");
        }
        catch (Exception NoSuchElementException){
        }
        assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
    }

    @Test
    public void R19T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T2 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T2 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T3 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T3 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T3 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T4() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T4 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T4 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T4 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T4 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T5() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T5 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T5 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T5 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T5 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T6() throws Exception {
        try {
            runAndTest("Testing/Test Files/R19/R19T6 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T6 OUTPUT.txt"),
                    fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T6 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T6 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T7() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T7 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T7 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T7 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T7 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T8() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T8 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T8 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T8 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T8 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T9() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T9 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T9 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T9 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T9 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R19T10() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R19/R19T10 INPUT.txt", fileToStringArray("Testing/Test Files/R19/R19T10 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "Testing/Test Files/R19/R19T10 VAL.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R19/R19T10 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R20T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R20/R20T1 INPUT.txt", fileToStringArray("Testing/Test Files/R20/R20T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R20/R20T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R21T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R21/R21T1 INPUT.txt", fileToStringArray("Testing/Test Files/R21/R21T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R21/R21T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R21T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R21/R21T2 INPUT.txt", fileToStringArray("Testing/Test Files/R21/R21T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R21/R21T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R22T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R22/R22T1 INPUT.txt", fileToStringArray("Testing/Test Files/R22/R22T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R22/R22T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R22T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R22/R22T2 INPUT.txt", fileToStringArray("Testing/Test Files/R22/R22T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R22/R22T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R22T3() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R22/R22T3 INPUT.txt", fileToStringArray("Testing/Test Files/R22/R22T3 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R22/R22T3 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    @Test
    public void R23T1() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R23/R23T1 INPUT.txt", fileToStringArray("Testing/Test Files/R23/R23T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R23/R23T1 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }

    @Test
    public void R23T2() throws Exception {
        try{
        runAndTest( "Testing/Test Files/R23/R23T2 INPUT.txt", fileToStringArray("Testing/Test Files/R23/R23T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"), "VALIDACCOUNTLIST.txt");
        }
        catch (Exception NoSuchElementException){
            assertTrue(compareOutputConsole("Testing/Test Files/R23/R23T2 OUTPUT.txt", "Testing/Test Files/consoleOut.txt"));
        }
    }
    
    public List<String> fileToStringArray(String filename) {
        List<String> newList = new ArrayList();

        Scanner file = null;
        try {
            file = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(0);
        }

        //while loop to read values line-by-line and add to list (reversing the order)
        while (file.hasNextLine()){
            String line = file.nextLine();
            newList.add(line);
        }

        file.close();

        return newList;
    }


    // Functions below this point are credited to Steven Ding

    /**
     * Helper function to run the main function and verify the output
     *
     * @param terminal_input          A list of string as the terminal input to run the program
     * @param expected_terminal_tails A list of string expected at the tail of terminal output
     * @param expected_output_list   A file that contains the expected content for the output file
     * @throws Exception
     */
    public void runAndTest(String terminal_input, List<String> expected_terminal_tails,
                           List<String> expected_output_list, String val_file_location) throws Exception {

        // setup parameters for the program to run
        // create a temporary file
        File tsf = new File("TRANSACTIONSUMMARYFILE.txt");
        File val = new File(val_file_location);

        String[] args = {tsf.getAbsolutePath(), val.getAbsolutePath(), terminal_input};

        // setup stdin & stdout:]
        PrintStream outContent = new PrintStream(new File("Testing/Test Files/consoleOut.txt"));
        //System.setOut(outContent);
        //ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
        // run the program
        FrontEndInjected.main(args);
    }

    //returns true if the output file matches the expected output file output
    public boolean compareOutputFile(String output){
        File outputFile = new File("transactionSummaryFile.txt");
        Scanner input1;
        Scanner input2;
        ArrayList<String> tsfArray = new ArrayList<String>();
        ArrayList<String> ExpectedTsfArray = new ArrayList<String>();

        try {
            input1 = new Scanner(outputFile);
            while (input1.hasNextLine() == true) {
                tsfArray.add(input1.nextLine());
            }
        } catch (Exception e) {
            System.out.println("didn't find file");
        }

        File expectedOutputFile = new File(output);
        try {
            input2 = new Scanner(expectedOutputFile);
            while (input2.hasNextLine() == true) {
                ExpectedTsfArray.add(input2.nextLine());
        }
        } catch (Exception e) {
            System.out.println("didn't find file");
        }

        if (tsfArray.get(tsfArray.size() - 1).equals(ExpectedTsfArray.get(ExpectedTsfArray.size() - 1))) {
            return true;
        } else {
            return false;
    }


}

    //returns true if the terminal output matches the expected output
    public boolean compareOutputConsole(String output, String consoleOutput) {
        File outputFile = new File(output);
        Scanner input1;
        Scanner input2;
        ArrayList<String> outputArr = new ArrayList<String>();
        ArrayList<String> consoleOutputArr = new ArrayList<String>();

        try {
            input1 = new Scanner(outputFile);
            while (input1.hasNextLine() == true) {
                outputArr.add(input1.nextLine());
            }
        } catch (Exception e) {
            System.out.println("didn't find file");
        }

        File consoleOutputFile = new File(consoleOutput);
        try {
            input2 = new Scanner(consoleOutputFile);
            while (input2.hasNextLine() == true) {
                consoleOutputArr.add(input2.nextLine());
            }
        } catch (Exception e) {
            System.out.println("didn't find file");
        }

        if (outputArr.get(outputArr.size() - 1).equals(consoleOutputArr.get(consoleOutputArr.size() - 1))) {
            return true;
        } else {
            return false;
        }


    }
}