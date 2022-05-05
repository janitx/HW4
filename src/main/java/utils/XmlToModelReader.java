package utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.FilterProductModel;

import java.io.*;

public final class XmlToModelReader {

    private XmlToModelReader() {
    }

    public static FilterProductModel read(String path) {

        FilterProductModel model = null;

        try {
            File file = new File(path);
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(file));
            model = xmlMapper.readValue(xml, FilterProductModel.class);
        } catch (FileNotFoundException f) {
            System.err.printf("FileNotFoundException = %s%n", f.getMessage());
        } catch (IOException i) {
            System.err.printf("IOException = %s%n", i.getMessage());
        }

        return model;
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();

        return sb.toString();
    }


}
