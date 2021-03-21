package br.com.odilonfontes.desafio.associadoapi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "br.com.odilonfontes.desafio.associadoapi.service",
        "br.com.odilonfontes.desafio.associadoapi.web.rest"
})
public class UnitTests { }
