import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FrontEndTest {

    @Test
    public void test() throws Exception {
        String[] terminal_input = new String(Files.readAllBytes(Paths.get("../../../Testing/Test Files/R1/R1T1 INPUT.txt")), "UTF-8").split("[\r\n]+");
        runAndTest(Arrays.asList(terminal_input), Arrays.asList(""), "../../../Testing/Test Files/R1/R1T1 OUTPUT.txt");
    }

    // Functions below this point are credited to Steven Ding
    /**
     * Helper function to run the main function and verify the output
     * @param terminal_input A list of string as the terminal input to run the program
     * @param expected_terminal_tails A list of string expected at the tail of terminal output
     * @param expected_output_file A file that contains the expected content for the output file
     * @throws Exception
     */
    public void runAndTest(List<String> terminal_input, List<String> expected_terminal_tails,
                           String expected_output_file) throws Exception {

        // setup parameters for the program to run
        // create a temporary file
        File tmpFile1 = File.createTempFile("testTransactionSummaryFile", ".txt");
        File tmpFile2 = File.createTempFile("testValidAccountListFile", ".txt");
        String[] args = { tmpFile1.getAbsolutePath(), tmpFile2.getAbsolutePath() };

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
        String[] expected_output = new String(Files.readAllBytes(Paths.get(expected_output_file)), "UTF-8").split("[\r\n]+");

        for(int x = 0; x < printed_lines.length; x++) {
            System.out.println(printed_lines[x]);
            assertEquals(printed_lines[x], expected_output[x]);
        }

    }

    /**
     * Retrieve the absolute path of the files in the resources folder
     * @param relativePath The file's relative path in the resources folder (/test/resources)
     * @return the absolute path of the file in the resource folder.
     */
    String getFileFromResource(String relativePath) {
        return new File(this.getClass().getResource(relativePath).getFile()).getAbsolutePath();
    }
}