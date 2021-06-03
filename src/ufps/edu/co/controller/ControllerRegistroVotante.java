package ufps.edu.co.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ufps.edu.co.dao.EleccionDao;
import ufps.edu.co.dao.TipoDocumentoDao;
import ufps.edu.co.dao.VotanteDao;
import ufps.edu.co.model.Eleccion;
import ufps.edu.co.model.TipoDocumento;
import ufps.edu.co.model.Votante;

/**
 * Servlet implementation class ControllerRegistroVotante
 */
@WebServlet({"/RegistrarVotante","/RegistrarVotante/*"})
public class ControllerRegistroVotante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TipoDocumentoDao tipoDocumento;
	EleccionDao elecciones; 
	VotanteDao votante;
    /**
     * Default constructor. 
     */
    public ControllerRegistroVotante() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		tipoDocumento = new TipoDocumentoDao();
		elecciones = new EleccionDao();
		votante = new VotanteDao();
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
				insertarUsuario(request, response);
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
				RegistarVotante(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("email");
		String documento = request.getParameter("documento");
		TipoDocumento tipo = tipoDocumento.buscarTipoDocumento(Integer.parseInt(request.getParameter("Tipodocumento")));
		Eleccion eleccion = elecciones.buscarEleccion(Integer.parseInt(request.getParameter("eleccion")));
		Votante v = new Votante(nombre,correo,documento,tipo,eleccion);
		votante.insertarVotante(v);
		response.sendRedirect("/SistemaVotacion/Index");
	}

	private void RegistarVotante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Eleccion> elecciones = this.elecciones.buscarTodasLasElecciones();
		List<TipoDocumento> tipoDocumento = this.tipoDocumento.buscarTodosTipoDocumento();
		
		request.setAttribute("elecciones", elecciones);
		request.setAttribute("tipoDocumento", tipoDocumento);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarVotante.jsp");
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
