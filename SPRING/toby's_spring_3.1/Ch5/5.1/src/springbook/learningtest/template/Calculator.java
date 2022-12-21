package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filepath) throws IOException {
        LineCallback<Integer> lineCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLineCallback(String line, Integer value) {
                return value += Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filepath, lineCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineCallback<Integer> lineCallback = new LineCallback<Integer>() {
            @Override
            public Integer doSomethingWithLineCallback(String line, Integer value) {
                return value *= Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filepath, lineCallback, 1);
    }

    public String concatenate(String filepath) throws IOException {
        LineCallback<String> lineCallback = new LineCallback<String>() {
            @Override
            public String doSomethingWithLineCallback(String line, String value) {
                return value += String.valueOf(line);
            }
        };

        return lineReadTemplate(filepath, lineCallback, "");
    }

    public <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            T res = initVal;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLineCallback(line, res);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
