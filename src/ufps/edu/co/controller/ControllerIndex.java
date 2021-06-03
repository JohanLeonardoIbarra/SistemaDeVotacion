package ufps.edu.co.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ufps.edu.co.dao.CandidatoDao;
import ufps.edu.co.dao.EleccionDao;
import ufps.edu.co.model.Candidato;
import ufps.edu.co.model.Eleccion;

/**
 * Servlet implementation class ControllerIndex
 */
@WebServlet({"/Index","/Index/*"})
public class ControllerIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EleccionDao elecciones;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		elecciones = new EleccionDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String[] opt =  request.getRequestURI().split("/");
		String action =  request.getContextPath();
		if (opt.length>3){
		 action = opt[3];
		}		
		try {
			switch (action) {
			case "new":
				//showNewForm(request, response);
				break;
			case "insert":
				//insertarUsuario(request, response);
				break;
			case "delete":
				//eliminarUsuario(request, response);
				break;
			case "edit":
				//showEditForm(request, response);
				break;
			case "update":
				//editarUsuario(request, response);
				break;
			default:
				indexDefault(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void indexDefault(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
		List<Eleccion> elecciones = this.elecciones.buscarTodasLasElecciones();

		request.setAttribute("elecciones", elecciones);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NewFile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
