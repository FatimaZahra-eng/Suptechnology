package suptech.casa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import lombok.AllArgsConstructor;
import suptech.casa.model.Etudiant;
import suptech.casa.model.Filiere;
import suptech.casa.service.EtudiantService;
import suptech.casa.service.FiliereService;

@RestController
@AllArgsConstructor
public class FiliereController {
   final FiliereService filiereService;
   final EtudiantService etudiantService;

	@GetMapping("filieres")
	public List<Filiere> getAllFilieres() {
		return 	filiereService.getAllFilieres();
	}
	
	@PostMapping("filieres")
	public Filiere addFiliere(@RequestBody Filiere filiere) {
		return filiereService.addFiliere(filiere);
	}
	
	//Ajouter un nouvel étudiant à une filière
		@PostMapping("filieres/{nomfil}/etudiants")
		public Etudiant addEtudiantToFiliere(@RequestBody Etudiant etudiant,@PathVariable ("nomfil") String nomFil) {
			Filiere filiere = filiereService.getFiliereByNom(nomFil);
			if(filiere == null) return null;
			etudiant.setFiliere(filiere);
			return etudiantService.addEtudiant(etudiant);
		}
	
}
