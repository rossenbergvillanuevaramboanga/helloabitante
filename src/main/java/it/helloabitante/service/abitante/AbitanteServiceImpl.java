package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}
	
	//Creare un metodo che mostri i dati 
	@Override
	public Abitante caricaSingolo(Long idAbitante) throws Exception{
		// TODO Auto-generated method stub
		return abitanteDAO.get(idAbitante);
	}

	@Override
	public void inserisciSingolo(Abitante abitante) throws Exception {
		// TODO Auto-generated method stub
		abitanteDAO.insert(abitante);
	}

	@Override
	public void eliminaSingolo(Abitante abitante) throws Exception {
		// TODO Auto-generated method stub
		abitanteDAO.delete(abitante);
		
	}

	@Override
	public List<Abitante> elencaTutti() throws Exception {
		// TODO Auto-generated method stub
		return abitanteDAO.list();
		
	}

	@Override
	public void aggiornaSingolo(Abitante abitante) throws Exception {
		// TODO Auto-generated method stub
		abitanteDAO.update(abitante);
		
	}


	
	

}
