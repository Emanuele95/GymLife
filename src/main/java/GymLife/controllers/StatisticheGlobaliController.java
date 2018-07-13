package GymLife.controllers;

import GymLife.model.request.AllenatiRequest;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.response.MiglioramentoResponse;
import GymLife.model.response.VotazioniResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/statistiche_globali")
@RestController
public class StatisticheGlobaliController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/miglioramento", method = RequestMethod.POST)
    @ResponseBody
    public MiglioramentoResponse miglioramento(@Valid @RequestBody AllenatiRequest utente, Errors errors) {

        MiglioramentoResponse response = new MiglioramentoResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.miglioramento();
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/votazioni", method = RequestMethod.POST)
    @ResponseBody
    public VotazioniResponse votazioni(@Valid @RequestBody AllenatiRequest utente, Errors errors) {

        VotazioniResponse response = new VotazioniResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.votazioni();
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

   
}
