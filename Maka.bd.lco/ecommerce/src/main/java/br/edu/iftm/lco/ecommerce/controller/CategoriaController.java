package br.edu.iftm.lco.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.lco.ecommerce.dao.CategoriaDao;

import br.edu.iftm.lco.ecommerce.domain.Categoria;

@RestController
public class CategoriaController {

    @Autowired

    private CategoriaDao dao;

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)

    public List<Categoria> getCategorias() {

        return dao.getCategorias();

    }

}
