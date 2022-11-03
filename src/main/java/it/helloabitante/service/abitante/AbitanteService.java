package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);
	
	//gets
	public Abitante caricaSingolo(Long idAbitante) throws Exception;

	public void inserisciSingolo(Abitante abitante) throws Exception;

	public void eliminaSingolo(Abitante abitante) throws Exception;
	
	public List<Abitante> elencaTutti() throws Exception;

	public void aggiornaSingolo(Abitante abitante) throws Exception;
}
