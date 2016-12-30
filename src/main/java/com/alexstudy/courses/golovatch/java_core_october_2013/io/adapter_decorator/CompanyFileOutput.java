package golovatch.courses.io.adapter_decorator;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Alex on 9/19/2016.
 */
public class CompanyFileOutput {
    FileWriter out;

    CompanyFileOutput(FileWriter out) {
        this.out = out;
    }

    public void writeTest() throws IOException {
        out.write("test");
        out.flush();
        out.close();
    }

    public void writeCompany(Company company) throws IOException {
        out.write("<company>\n" +
                "<name>" + company.name + "</name>\n" +
                "<years>" + company.years + "</years>\n" +
                "<staff>\n");
        for (Employee employee : company.staff) {
            if (employee == null) continue;
            out.write("<employee>\n" +
                    "<name>" + employee.name + "</name>\n" +
                    "<age>" + employee.age + "<age>\n" +
                    "<position>" + employee.position + "</position>\n" +
                    "<married>" + employee.married + "</married>\n" +
                    "</employee>");
        }
        out.write("</staff>\n" +
                "</company>");
        out.flush();
        out.close();
    }
}
