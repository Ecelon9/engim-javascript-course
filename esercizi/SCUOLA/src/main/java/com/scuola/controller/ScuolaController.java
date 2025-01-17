package com.scuola.controller;

import com.scuola.model.Scuola;
import com.scuola.repository.ScuolaRepository;
import com.scuola.repository.impl.ScuolaRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scuola") //indirizzo controller scuola
public class ScuolaController implements ScuolaRepository
{
    @Override
    @GetMapping(value = "/selezionaScuole")
    public List<Scuola> selezionaScuole()
    {
        return ScuolaRepositoryImpl.selezionaScuole();
    }

    @PostMapping (value = "/inserisciScuola")
    public Scuola inserisciScuola(@RequestBody Scuola scuola)
    {
        Scuola s = ScuolaRepositoryImpl.inserisciScuola(scuola);
        System.out.println("Scuola " + s.getCodiceMeccanografico() + " Inserita");
        return s;
    }

    @Override
    @PutMapping(value = "/modificaScuola")
    public Scuola modificaScuola(@RequestBody  Scuola scuola,
                                 @RequestParam("vecchioCodiceMeccanografico") String vecchioCodiceMeccanografico)
    {
        System.out.println("La scuola con: " + vecchioCodiceMeccanografico + " è modificata");
        return ScuolaRepositoryImpl.modificaScuola(scuola, vecchioCodiceMeccanografico);
    }

    @Override
    public Boolean eliminaScuola(String codiceMeccanografico) {
        return null;
    }
}
