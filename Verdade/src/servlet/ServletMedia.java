package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Media;

@WebServlet(name = "ServletMedia", urlPatterns = { "/ServletMedia" })
public class ServletMedia extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Calcular Media</title>");
			out.println("</head>");
			out.println("<body>");
			//out.println("<h3>Allan Fellipe Cruvinel Pereira Matutino</h3>");
			RequestDispatcher rd = null;
			try {

				
				
				

				String a = request.getParameter("p1");
				
				String b = request.getParameter("p2");
				
				String c = request.getParameter("tp");
				
				System.out.println("ae deu "+a+" "+b+" e "+c);
				float resultado;
				String figura = request.getParameter("figura");
				if(c.length()==0) {
					
					System.out.println("entrou aqui");
					Media media = new Media();
					media.calcularMedia(Float.parseFloat(a),Float.parseFloat(b));
					resultado = media.getMedia();
					rd = request.getRequestDispatcher("/exibeResultado.jsp");
					rd.include(request, response);
					out.println("<h1> " + resultado + "</h1>");
				}
				else {
					
					Media media = new Media();
					media.calcularMedia(Float.parseFloat(a),Float.parseFloat(b),Float.parseFloat(c));
					resultado = media.getMedia();
					rd = request.getRequestDispatcher("/exibeResultado.jsp");
					rd.include(request, response);
					out.println("<h1> " + resultado + "</h1>");
					
				}

			} catch (Exception e) {
				rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
				out.println("<h3>UM GRANDE ERRO!!!</h3>");
				out.println("<h4> coloque apenas numeros e PREENCHA PELO MENOS O PRIMEIRO E SEGUNDO CAMPO!!</h4>");
			}
			
		}

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}