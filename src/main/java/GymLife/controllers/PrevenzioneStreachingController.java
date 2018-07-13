package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.PrevenzioneStreachingRequest;
import GymLife.model.response.PrevenzioneStreachingResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RestController
public class PrevenzioneStreachingController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/fisioterapia", method = RequestMethod.POST)
    @ResponseBody
    public PrevenzioneStreachingResponse fisioterapia(@Valid @RequestBody PrevenzioneStreachingRequest esercizi, Errors errors) {

        PrevenzioneStreachingResponse response = new PrevenzioneStreachingResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

     
        try {
            response = service.fisioterapia(esercizi.getMuscolo(), esercizi.getCorpo_libero(), esercizi.getDifficolta(), esercizi.getNome());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
}
