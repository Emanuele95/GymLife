package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.ConsigliaSchedaRequest;
import GymLife.model.request.SalvaSchedaRequest;
import GymLife.model.response.ConsigliaSchedaResponse;
import GymLife.model.response.SalvaSchedaResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/consiglia_scheda")
@RestController
public class ConsigliaSchedaController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/consigliascheda", method = RequestMethod.POST)
    @ResponseBody
    public ConsigliaSchedaResponse consigliascheda(@Valid @RequestBody ConsigliaSchedaRequest scheda, Errors errors) {

        ConsigliaSchedaResponse response = new ConsigliaSchedaResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.consigliascheda(scheda.getRegime(), scheda.getN_giorni(), scheda.getDifficolta());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/salva_scheda", method = RequestMethod.POST)
    @ResponseBody
    public SalvaSchedaResponse salva_scheda(@Valid @RequestBody SalvaSchedaRequest schedarequest, Errors errors) {

        SalvaSchedaResponse response = new SalvaSchedaResponse();
        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");
            return response;
        }

        int scheda = schedarequest.getScheda();
        String id_utilizzatore = schedarequest.getId_utilizzatore();
        String proprietario = schedarequest.getProprietario();
        int visibile = schedarequest.getVisibile();

        try {
            service.salva_scheda(scheda, id_utilizzatore, proprietario, visibile);
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("Scheda già salvata; La puoi vedere e usare nella sezione Schede Personali");
            return response;
        }
        response.setEsito(true);
        response.setDescrizione("Scheda Salvata; La puoi vedere e usare nella sezione Schede Personali");

        return response;
    }
    
   
}
