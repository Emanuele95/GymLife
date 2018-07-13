package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.EserciziRequest;
import GymLife.model.response.EserciziResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RestController
public class EserciziController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/esercizi", method = RequestMethod.POST)
    @ResponseBody
    public EserciziResponse esercizi(@Valid @RequestBody EserciziRequest esercizi, Errors errors) {

        EserciziResponse response = new EserciziResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

     
        try {
            response = service.esercizi(esercizi.getMuscolo(), esercizi.getCorpo_libero(), esercizi.getDifficolta(), esercizi.getNome());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
}
