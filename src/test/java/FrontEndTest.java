import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FrontEndTest {

    @Test
    public void PROF_EXAMPLE() throws Exception {
        runAndTest(Arrays.asList("327"), Arrays.asList("Hello 327", "file written!"),
                fileToStringArray("/R2/expected.txt"));
    }

    @Test
    public void R1T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));

    }

    @Test
    public void R1T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T5() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T5 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T6() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T6 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T6 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T7() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T7 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T7 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R1T8() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R1/R1T8 INPUT.txt"), fileToStringArray("Testing/Test Files/R1/R1T8 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R2T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R2/R2T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R2/R2T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R2T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R2/R2T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R2/R2T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R2T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R2/R2T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R2/R2T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T5() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T5 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T5 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R3T6() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R3/R3T6 INPUT.txt"), fileToStringArray("Testing/Test Files/R3/R3T6 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R4T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R4/R4T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R4/R4T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R5T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R5/R5T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R5/R5T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R5T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R5/R5T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R5/R5T2 2OUTPUT"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R6T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R6/R6T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R6/R6T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R6T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R6/R6T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R6/R6T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R6T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R6/R6T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R6/R6T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R6T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R6/R6T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R6/R6T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R7T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R7/R7T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R7/R7T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R7T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R7/R7T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R7/R7T2 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R7T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R7/R7T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R7/R7T3 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R7T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R7/R7T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R7/R7T4 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R8T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R8/R8T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R8/R8T1 OUTPUT.txt"),
                fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R16T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R16/R16T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R16/R16T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T3 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T4 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T5() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T5 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T5 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T6() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T6 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T6 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T7() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T7 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T7 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T8() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T8 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T8 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T9() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T9 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T9 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R17T10() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R17/R17T10 INPUT.txt"), fileToStringArray("Testing/Test Files/R17/R17T10 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R18T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R18/R18T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R18/R18T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T1() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T1 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T1 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T2() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T2 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T2 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T3() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T3 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T3 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T4() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T4 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T4 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T5() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T5 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T5 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T6() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T6 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T6 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T7() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T7 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T7 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T8() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T8 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T8 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T9() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T9 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T9 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
    }

    @Test
    public void R19T10() throws Exception {
        runAndTest(fileToStringArray( "Testing/Test Files/R19/R19T10 INPUT.txt"), fileToStringArray("Testing/Test Files/R19/R19T10 OUTPUT.txt"),
            fileToStringArray("Testing/Test Files/BLANKOUTPUTFILE.txt"));
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
    public void runAndTest(List<String> terminal_input, List<String> expected_terminal_tails,
                           List<String> expected_output_list) throws Exception {

        // setup parameters for the program to run
        // create a temporary file
        File tmpFile1 = File.createTempFile("testTransactionSummaryFile", ".txt");
        File tmpFile2 = File.createTempFile("testValidAccountListFile", ".txt");
        String[] args = {tmpFile1.getAbsolutePath(), tmpFile2.getAbsolutePath()};

        // setup user input
        String userInput = String.join(System.lineSeparator(), terminal_input);
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // setup stdin & stdout:
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        // run the program
        FrontEnd.main(args);

        // capture terminal outputs:
        String[] printed_lines = outContent.toString().split("[\r\n]+");
        String[] expected_output = new String[expected_output_list.size()];
        expected_output = expected_output_list.toArray(expected_output);

        for (int x = 0; x < printed_lines.length; x++) {
            System.out.println(printed_lines[x]);
            assertEquals(printed_lines[x], expected_output[x]);
        }

    }

    /**
     * Retrieve the absolute path of the files in the resources folder
     *
     * @param relativePath The file's relative path in the resources folder (/test/resources)
     * @return the absolute path of the file in the resource folder.
     */

    //String getFileFromResource(String relativePath) {
    //   return new File(this.getClass().getResource(relativePath).getFile()).getAbsolutePath();
    //}
}