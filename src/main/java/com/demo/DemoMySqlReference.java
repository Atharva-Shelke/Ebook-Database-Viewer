// Original MySQL JDBC implementation retained for reference.
package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/Demo" })
public class DemoMySqlReference extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		try {
			final String dbDriver = "com.mysql.jdbc.Driver";
			final String dbURL = "jdbc:mysql://localhost:3306/";
			final String dbName = "ebookshop";
			final String dbUsername = "root";
			final String dbPassword = "";
			Class.forName(dbDriver);
			final Connection con = DriverManager.getConnection(String.valueOf(dbURL) + dbName, dbUsername, dbPassword);
			final String query = "select * from ebook";
			final Statement st = con.createStatement();
			final ResultSet rs = st.executeQuery(query);
			final PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<html><head><style>table, th, td {border: 1px solid black;}</style></head><body>");
			out.print("<table style='text-align:center'>");
			out.print("<thead><tr>");
			out.print("<th>id</th>");
			out.print("<th>Book Title</th>");
			out.print("<th>Book Author</th>");
			out.print("<th>Price</th>");
			out.print("<th>Quantity</th></tr></thead>");
			out.print("<tbody>");
			while (rs.next()) {
				final int id = rs.getInt("id");
				final String title = rs.getString("Book Title");
				final String author = rs.getString("Book Author");
				final int price = rs.getInt("Price");
				final int quantity = rs.getInt("Quantity");
				out.println("<tr><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + price
						+ "</td><td>" + quantity + "</td></tr>");
			}
			out.print("</tbody></table></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}