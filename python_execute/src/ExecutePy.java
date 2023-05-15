import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutePy {

    public static void main(String[] args) throws IOException {

        String[] cmd = new String[3];
        cmd[0] = "python";
        cmd[1] = "D:/study/git/newStudy/python_test/start_script.py";
        cmd[2] = "script";
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(cmd);


        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
