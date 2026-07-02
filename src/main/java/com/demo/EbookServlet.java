package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EbookServlet")
public class EbookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			// H2 Driver
			Class.forName("org.h2.Driver");

			// In-memory database
			Connection con = DriverManager.getConnection("jdbc:h2:mem:ebookdb", "sa", "");

			Statement st = con.createStatement();

			Map<String, String> queries = SqlLoader.loadQueries("sql/ebook.sql");

			// Create table
			st.execute(queries.get("create_ebook_table"));

			// Insert sample data
			st.execute(queries.get("insert_ebook_records"));

			// Query data
			ResultSet rs = st.executeQuery(queries.get("find_all_ebooks"));

			// HTML output
			out.print("<html><head>");
			out.print("<style>");
			out.print("body{font-family:Arial;background:#f4f6f9;padding:40px;text-align:center;}");
			out.print(
					"table{margin:auto;border-collapse:collapse;width:80%;background:white;box-shadow:0 4px 10px rgba(0,0,0,0.1);}");
			out.print("th,td{padding:14px;border:1px solid #ddd;}");
			out.print("th{background:#0078ff;color:white;}");
			out.print("tr:nth-child(even){background:#f2f2f2;}");
			out.print("h2{color:#333;}");
			out.print("</style>");
			out.print("</head>");
			out.print("<body style='font-family:Arial'>");
			out.print("<h2>Ebook Records</h2>");
			out.print("<table border='1' cellpadding='10'>");
			out.print("<tr>");
			out.print("<th>ID</th>");
			out.print("<th>Title</th>");
			out.print("<th>Author</th>");
			out.print("<th>Price</th>");
			out.print("<th>Quantity</th>");
			out.print("</tr>");

			while (rs.next()) {

				out.print("<tr>");
				out.print("<td>" + rs.getInt("id") + "</td>");
				out.print("<td>" + rs.getString("title") + "</td>");
				out.print("<td>" + rs.getString("author") + "</td>");
				out.print("<td>" + rs.getInt("price") + "</td>");
				out.print("<td>" + rs.getInt("quantity") + "</td>");
				out.print("</tr>");
			}

			out.print("</table>");
			out.print("</body></html>");

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			out.println("<h3>Error occurred while accessing database</h3>");
			e.printStackTrace(out);
		}
	}
}