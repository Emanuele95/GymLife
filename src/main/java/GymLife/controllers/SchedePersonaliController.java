package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.SalvaVotoRequest;
import GymLife.model.response.SalvaVotoResponse;
import GymLife.model.request.SchedePersonaliRequest;
import GymLife.model.response.SchedePersonaliResponse;
import GymLife.model.request.VotazioneRequest;
import GymLife.model.response.VotazioneResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/schede_personali")
@RestController
public class SchedePersonaliController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/schede_personali", method = RequestMethod.POST)
    @ResponseBody
    public SchedePersonaliResponse schede_personali(@Valid @RequestBody SchedePersonaliRequest scheda, Errors errors) {

        SchedePersonaliResponse response = new SchedePersonaliResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.schede_personali(scheda.getNome());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/votazione", method = RequestMethod.POST)
    @ResponseBody
    public VotazioneResponse votazione(@Valid @RequestBody VotazioneRequest voto, Errors errors) {

        VotazioneResponse response = new VotazioneResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.votazione(voto.getUser(), voto.getScheda(), voto.getProprietario());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
    
    @RequestMapping(value = "/salva_votazione", method = RequestMethod.POST)
    @ResponseBody
    public SalvaVotoResponse salva_votazione(@Valid @RequestBody SalvaVotoRequest voto, Errors errors) {

        SalvaVotoResponse response = new SalvaVotoResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
           service.salva_votazione(voto.getUser(), voto.getScheda(), voto.getProprietario(), voto.getVoto());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
}
