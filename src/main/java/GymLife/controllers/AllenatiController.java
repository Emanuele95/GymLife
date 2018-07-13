package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.SalvaEssRequest;
import GymLife.model.response.SalvaEssResponse;
import GymLife.model.request.SalvaAllenamentoRequest;
import GymLife.model.response.SalvaAllenamentoResponse;
import GymLife.model.request.AllenatiRequest;
import GymLife.model.response.AllenatiResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/allenati")
@RestController
public class AllenatiController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/massimalipersonali", method = RequestMethod.POST)
    @ResponseBody
    public AllenatiResponse massimalipersonali(@Valid @RequestBody AllenatiRequest utente, Errors errors) {

        AllenatiResponse response = new AllenatiResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.massimalipersonali(utente.getNome());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/salva_ess", method = RequestMethod.POST)
    @ResponseBody
    public SalvaEssResponse salva_ess(@Valid @RequestBody SalvaEssRequest ess, Errors errors) {

        SalvaEssResponse response = new SalvaEssResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            service.salva_ess(ess.getNome(), ess.getEsercizio(), ess.getPosizione(), ess.getGiornata(), ess.getScheda(), ess.getProprietario(), ess.getRipetizioni_riuscite(),
                    ess.getPeso_usato(), ess.getPeso_consigliato(), ess.getRipetizioni_originali());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/salva_allenamento", method = RequestMethod.POST)
    @ResponseBody
    public SalvaAllenamentoResponse salva_allenamento(@Valid @RequestBody SalvaAllenamentoRequest allenamento, Errors errors) {

        SalvaAllenamentoResponse response = new SalvaAllenamentoResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
             service.salva_allenamento(allenamento.getNome(), allenamento.getData(), allenamento.getInizio(), allenamento.getFine(), allenamento.getScheda(), allenamento.getGiornata(),
                allenamento.getProprietario(), allenamento.getNote(), allenamento.getIntensita(), allenamento.getModifica_stats());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

}
