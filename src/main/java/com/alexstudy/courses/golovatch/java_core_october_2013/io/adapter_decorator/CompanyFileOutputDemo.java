package golovatch.courses.io.adapter_decorator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Alex on 9/19/2016.
 */
public class CompanyFileOutputDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\golovatch\\courses\\io\\adapter_decorator\\company.txt");
        Company company = new Company();
        CompanyFileOutput out = new CompanyFileOutput(new FileWriter(file));
        out.writeCompany(company);
    }
}
