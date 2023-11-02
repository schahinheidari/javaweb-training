package javaweb;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "e2e", urlPatterns = {"/e2e"})
public class ExportToExcelServlet extends HttpServlet {

    Connection cn;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "Bikar0001@");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            resp.setContentType("application/vnd.ms-excel");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Product");
            Object[] datatypes = {"Name", "Model", "Factory"};

            int rowNum = 0;
            System.out.println("Creating excel");
            Row row = sheet.createRow(rowNum++);
            for (Object datatype : datatypes) {

                int colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue((String) datatype);
            }

            PreparedStatement ps = cn.prepareStatement("SELECT * FROM product");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(rowNum++);
                int colNum = 0;
                String name = rs.getString("name");
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(name);
                String model = rs.getString("model");
                Cell cell2 = row.createCell(colNum++);
                cell2.setCellValue(model);
                String factory = rs.getString("factory");
                Cell cell3 = row.createCell(colNum++);
                cell3.setCellValue(factory);
            }
            ps.close();
            workbook.write(resp.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();


            System.out.println("Done");
        }
    }
}
